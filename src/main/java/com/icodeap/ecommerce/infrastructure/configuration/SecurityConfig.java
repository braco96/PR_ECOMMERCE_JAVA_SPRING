package com.icodeap.ecommerce.infrastructure.configuration;

import com.icodeap.ecommerce.infrastructure.service.LoginHandler;
import com.icodeap.ecommerce.infrastructure.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // permite @PreAuthorize, etc.
public class SecurityConfig {

    private final UserDetailServiceImpl userDetailService;
    private final LoginHandler loginHandler;

    public SecurityConfig(UserDetailServiceImpl userDetailService, LoginHandler loginHandler) {
        this.userDetailService = userDetailService;
        this.loginHandler = loginHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** Autenticación usando tus usuarios de BD (UserDetailServiceImpl) */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /** Reglas de seguridad */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desactivado para formularios simples/dev. Valora activarlo en prod.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/error",
                                "/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN") // requiere ROLE_ADMIN
                        .requestMatchers("/user/**").hasRole("USER")   // requiere ROLE_USER
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(loginHandler)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/close")
                        .permitAll()
                );

        return http.build();
    }

    /**
     * Usuarios en memoria SOLO para desarrollo:
     * Actívalo con: spring.profiles.active=dev
     * admin/admin123 → ROLE_ADMIN
     * user/user123   → ROLE_USER
     */
    @Bean
    @Profile("dev")
    public UserDetailsService users(PasswordEncoder encoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN") // genera autoridad "ROLE_ADMIN"
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("user123"))
                .roles("USER") // genera autoridad "ROLE_USER"
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
