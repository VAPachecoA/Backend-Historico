apihistorico
Microservicio encargado de registrar y gestionar el historial de incendios del sistema de Prevención de Incendios de la Municipalidad Valle del Sol.
Tecnologías

Java 21
Spring Boot 3.5
Spring Data JPA + Hibernate
PostgreSQL
Maven

Requisitos previos

Java 21 instalado
PostgreSQL corriendo con la base de datos incendio creada
Maven instalado

Configuración
Editar el archivo src/main/resources/application.properties con los datos de tu base de datos:
spring.application.name=apihistorico
server.port=8082
spring.datasource.url=jdbc:postgresql://localhost:5432/incendio
spring.datasource.username=incendio
spring.datasource.password=123
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
Instalación y ejecución
mvn clean install
mvn spring-boot:run
El servicio quedará disponible en http://localhost:8082
Endpoints disponibles
MétodoEndpointDescripciónGET/apihistorico/historialObtener todo el historialPOST/apihistorico/guardarRegistrar nuevo historialGET/apihistorico/historial/usuario/{correo}Obtener historial por usuario
Ejecución de pruebas
mvn test
