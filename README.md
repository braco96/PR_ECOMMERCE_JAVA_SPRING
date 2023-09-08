# Ecommerce

Proyecto de comercio electrónico construido con **Spring Boot 3** aplicando **arquitectura hexagonal**. El objetivo es disponer de una base sólida y pedagógica para separar claramente **dominio**, **aplicación** e **infraestructura**, y cubrir un flujo completo: catálogo de productos, inventario, carrito, órdenes y autenticación/autorización.

## Tecnologías y librerías

- **Java 17**, **Maven**
- **Spring Boot 3**, **Spring Web**, **Spring Data JPA (Hibernate)**, **Spring Validation**
- **Spring Security** (autenticación, autorización, sesión)
- **PostgreSQL**
- **Thymeleaf** + **Bootstrap** (vistas)
- **MapStruct** (mapeo entity ⇆ domain)
- **Lombok** (boilerplate)
- Gestión de ficheros estáticos / carga de imágenes

## Arquitectura (resumen)

- **domain/**: modelos y puertos (interfaces) del dominio.
- **application/**: casos de uso/servicios que orquestan el dominio.
- **infrastructure/**: adaptadores (web, persistencia, seguridad), entidades JPA y mappers.

## Funcionalidades principales

- **Gestión de productos (CRUD)** con subida y visualización de **imágenes**.
- **Inventario/Stock** con entradas y salidas.
- **Carrito de compras** y **flujo de órdenes**.
- **Usuarios**: auto-registro, login, logout; **roles** de administrador/usuario.
- **Validaciones** de datos y mensajes de error en vistas.
- Vistas diferenciadas para **administrador** y **usuario**.

## Secciones del desarrollo

### Sección 1: Configurar el entorno de trabajo
- Instalación (JDK, PostgreSQL, IntelliJ), configuración de Maven y creación del proyecto con Spring Initializr.
- Estructura aplicando arquitectura hexagonal.
- Conexión a base de datos, configuración de MapStruct y Lombok.
- Plantillas de vistas base.

### Sección 2: Entidades y persistencia para productos
- Modelos de dominio `Product`, `User` y `UserType`.
- Repositorios y servicios de aplicación.
- Entidades JPA `ProductEntity`, `UserEntity` y `CrudRepository`/implementación.
- Configuración de beans y mapeadores (`ProductMapper`, `UserMapper`).

### Sección 3: Vistas de administración de productos
- Home de administración con **fragments** (header/footer/menú).
- Vista de creación y edición de producto; envío al `ProductController`.
- Guardar producto en BD y listado para administrador.
- Edición/actualización, validaciones y eliminación.
- Mostrar productos en la home de admin.

### Sección 4: Manejo de imágenes
- Servicio para **subir imágenes** al servidor.
- Servir recursos estáticos en Spring Boot.
- Mostrar imágenes de productos en vistas.

### Sección 5: Gestión de inventario
- Dominio y entidad de **Stock**.
- Repositorio, servicio y mapper.
- Vistas para mostrar y crear stock.
- Entradas/salidas y añadir unidades.

### Sección 6: Vista de usuario y carrito
- Fragments para usuario.
- Home de usuario y **detalle de producto**.
- Entidades para productos comprados y mapeadores.
- Servicios de **Order** y **OrderDetail**.
- **Carrito**: añadir, listar y quitar productos.
- Resumen y **guardado de orden**, validaciones.

### Sección 7: Autenticación y autorización
- Auto-registro de usuario y validaciones.
- Vistas de login y mensajes de error.
- Servicio de login y manejo de sesión.
- Fragment específico para usuario logueado.
- Búsqueda de usuario con Spring Security.
- Configuración de **autenticación/autorización**, logout.
- Variables de sesión y mejoras de presentación.

### Sección 8: Funcionalidades finales de usuario y admin
- Órdenes por usuario: controlador, detalle y vista.
- Mejoras de navegabilidad y UI de usuario logueado.
- Redirecciones personalizadas post-login.

## Requisitos

- **Java 17**
- **PostgreSQL**
- **Maven 3** (o el wrapper `./mvnw`)

## Configuración

Ejemplo `src/main/resources/application-dev.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommercedb
spring.datasource.username=ecommerce
spring.datasource.password=ecommerce
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.web.resources.static-locations=file:uploads/images/,classpath:/static/
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
