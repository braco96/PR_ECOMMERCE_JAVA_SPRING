README.md
Nuevo
+144
-0

# Ecommerce

Proyecto de ejemplo de comercio electrónico construido con Spring Boot siguiendo una arquitectura hexagonal. El objetivo es servir como base educativa para comprender la separación en capas de dominio, aplicación e infraestructura.

## Requisitos
- Java 17
- PostgreSQL
- Maven 3 o el *wrapper* incluido (`./mvnw`)

## Sección 1: Configurar el entorno de trabajo
- Instalar y configurar el JDK de Java (11 min)
- Perfil del instructor (0 min)
- Instalar PostgreSQL y PgAdmin (7 min)
- Descargar e instalar IntelliJ IDEA (4 min)
- Configurar Maven (8 min)
- Crear el proyecto en Spring Initializr (5 min)
- Introducción a la arquitectura hexagonal (6 min)
- Importar el proyecto en IntelliJ IDEA (5 min)
- Estructurar el proyecto aplicando arquitectura hexagonal (6 min)
- Configuración para conectar la aplicación a una base de datos (10 min)
- Configurar MapStruct (7 min)
- Configurar Lombok (8 min)
- Código del proyecto (1 min)
- Plantillas de vistas (1 min)

## Sección 2: Crear las entidades para la gestión de productos
- Crear la clase de dominio `Product`, `User` y la enumeración `UserType` (10 min)
- Crear la interfaz `ProductRepository` y la clase `ProductService` (11 min)
- Crear las clases `ProductEntity`, `UserEntity` con anotaciones JPA (14 min)
- Crear la interfaz `ProductCrudRepository` y su implementación (9 min)
- Crear la clase de configuración para la gestión de beans (6 min)
- Crear la interfaz para `ProductMapper` y `UserMapper` (14 min)
- Implementar la clase `ProductRepositoryImpl` (11 min)
- Código del proyecto (1 min)

## Sección 3: Crear las vistas para la gestión de productos por el administrador
- Añadir la *home* al sitio (12 min)
- Crear el fragmento para el *header* y el *footer* del administrador (6 min)
- Mostrar la *home* para el administrador e incluir los fragmentos (7 min)
- Añadir el menú de opciones al *header* del administrador (5 min)
- Integrar y mostrar la vista para la creación de un producto (13 min)
- Enviar la información del producto desde la vista al `ProductController` (13 min)
- Guardar el producto en la base de datos (11 min)
- Integrar la vista para mostrar los productos al administrador (6 min)
- Mostrar la información del producto para el administrador (13 min)
- Obtener un producto para modificar (11 min)
- Integrar la vista para editar un producto (14 min)
- Implementar la funcionalidad para actualizar el producto (4 min)
- Validación para guardar o actualizar un producto (7 min)
- Implementar la funcionalidad para eliminar el producto (7 min)
- Mostrar los productos para el administrador en la *home* (7 min)
- Código del proyecto (1 min)

## Sección 4: Manejo de imágenes con Spring
- Crear la clase de servicio para subir la imagen del producto al servidor (13 min)
- Cómo servir recursos estáticos en Spring Boot (4 min)
- Implementar la carga de la imagen del producto (11 min)
- Mostrar la imagen de los productos en la *home* del administrador (7 min)
- Código del proyecto (1 min)

## Sección 5: Gestión de inventario
- Crear la clase de dominio y entidad para el inventario (8 min)
- Crear el repositorio y la clase de servicio (6 min)
- Crear el *mapper* para la clase `Stock` (6 min)
- Crear la interfaz `StockCrudRepository` y la clase de implementación (8 min)
- Integrar la vista *show* para mostrar el stock (9 min)
- Obtener el stock para mostrarlo e integrar la vista para crear el stock (12 min)
- Gestionar la salida y entrada de stock (10 min)
- Implementar la funcionalidad para añadir unidades al stock (12 min)
- Código del proyecto (1 min)

## Sección 6: Vista de usuario y carrito de compras
- Crear el fragmento para el *header* y el *footer* del usuario (6 min)
- Mostrar los productos en la *home* del usuario y ver los detalles de producto (9 min)
- Implementar la funcionalidad para ver los detalles de producto (15 min)
- Crear las entidades de dominio para guardar los productos comprados (12 min)
- Crear las entidades de infraestructura para guardar los productos comprados (9 min)
- Crear los *mapper* `OrderProductMapper` y `OrderMapper` (10 min)
- Crear los *mapper* para convertir de `OrderProductEntity` a `OrderProduct` (4 min)
- Crear las interfaces y clases de servicio para la `Order` (9 min)
- Crear las interfaces y clases de servicio para el detalle de la `Order` (15 min)
- Crear la clase de servicio para las funcionalidades del carrito de compras (14 min)
- Crear la funcionalidad para añadir productos al carrito de compras (15 min)
- Crear la funcionalidad para mostrar el carrito de compras (15 min)
- Implementar la funcionalidad de quitar un producto del carrito de compras (4 min)
- Crear las interfaces y clases de servicio para gestionar los usuarios (10 min)
- Implementar la funcionalidad para ver el resumen de la orden (14 min)
- Implementar la funcionalidad para guardar la orden (14 min)
- Validar la funcionalidad guardar orden (9 min)
- Código del proyecto (1 min)

## Sección 7: Autenticación y autorización de usuarios
- Mostrar la vista para el auto‑registro de un usuario (10 min)
- Implementar la funcionalidad para el auto‑registro de usuario (10 min)
- Validación a nivel de *backend* con la librería *validation* (14 min)
- Mostrar los mensajes de error en la vista (16 min)
- Mostrar la vista *login* de usuario (4 min)
- Implementar la clase de servicio para el *login* de usuario (8 min)
- Funcionalidad para la autenticación temporal y manejo de sesión de usuario (14 min)
- Implementar un fragmento diferente para usuario logueado (3 min)
- Implementar la búsqueda de un usuario mediante Spring Security (10 min)
- Implementar la autenticación y autorización de usuario mediante Spring Security (12 min)
- Añadir la encriptación de la clave al realizar el auto registro (22 min)
- Implementar la funcionalidad de *logout* (11 min)
- Añadir la variable de sesión para las búsquedas quemadas (6 min)
- Mejoras en la declaración de la variable `HttpSession` (6 min)
- Añadir validación para presentar el menú para el usuario logueado (10 min)
- Mejoras en la presentación del menú para el usuario logueado (7 min)
- Código del proyecto (1 min)

## Sección 8: Funcionalidades de usuario y administrador
- Implementar la funcionalidad para obtener las órdenes por usuario (10 min)
- Crear el controlador para mostrar la vista con las órdenes por usuario (5 min)
- Obtener los detalles de la orden para la presentación (7 min)
- Mostrar las órdenes en la vista (3 min)
- Mejoras en la navegabilidad y la interfaz de usuario logueado (9 min)
- Manejo personalizado de redirección de URLs después del *login* (12 min)
- Código del proyecto (1 min)

## Funcionalidades principales del proyecto
- Gestión de productos con CRUD completo.
- Carga y visualización de imágenes de productos.
- Manejo de inventario y stock.
- Carrito de compras y flujo de órdenes.
- Registro, autenticación y autorización de usuarios mediante Spring Security.
- Vistas diferenciadas para administrador y usuario final.

## Cómo ejecutar
```bash
./mvnw spring-boot:run
```

## Pruebas
```bash
./mvnw test
```

## Estructura del proyecto
- `src/main/java`: código fuente de la aplicación (dominio, aplicación e infraestructura)
- `src/main/resources`: recursos como plantillas y archivos estáticos
- `src/test/java`: pruebas unitarias

## Licencia
Este proyecto se distribuye bajo la licencia MIT.