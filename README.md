# apihistorico

Microservicio encargado de registrar y gestionar el historial de incendios de la **Plataforma de Prevención de Incendios** — Municipalidad Valle del Sol.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5
- Spring Data JPA + Hibernate
- PostgreSQL 18
- Maven

---

## Requisitos previos

- Java 21 instalado
- PostgreSQL corriendo en puerto 5432
- Base de datos `incendio` creada con usuario `incendio`
- Maven instalado

---

## Configuración

Editar `src/main/resources/application.properties`:

```properties
spring.application.name=apihistorico
server.port=8082
spring.datasource.url=jdbc:postgresql://localhost:5432/incendio
spring.datasource.username=incendio
spring.datasource.password=123
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
```

---

## Instalación y ejecución

```bash
# Clonar el repositorio
git clone https://github.com/VicenteAndres03/Incendios.git

# Entrar a la carpeta
cd apihistorico

# Compilar
mvn clean install

# Ejecutar
mvn spring-boot:run
```

El servicio quedará disponible en `http://localhost:8082`

---

## Endpoints disponibles

### Obtener todo el historial
```
GET http://localhost:8082/apihistorico/historial
```
Respuesta de ejemplo:
```json
[
  {
    "id": 1,
    "tipoIncendio": "Forestal",
    "nivelGravedad": "ALTO",
    "areaAfectada": 2.5,
    "latitud": -33.444,
    "longitud": -70.642,
    "fechaInicio": "2026-06-14T10:00:00",
    "fechaCierre": "2026-06-14T12:00:00",
    "correoUsuario": "usuario@test.com"
  }
]
```

### Registrar historial
```
POST http://localhost:8082/apihistorico/guardar
```
Body:
```json
{
  "tipoIncendio": "Forestal",
  "nivelGravedad": "ALTO",
  "areaAfectada": 2.5,
  "latitud": -33.444,
  "longitud": -70.642,
  "fechaInicio": "2026-06-14T10:00:00",
  "fechaCierre": "2026-06-14T12:00:00",
  "correoUsuario": "usuario@test.com"
}
```

### Obtener historial por usuario
```
GET http://localhost:8082/apihistorico/historial/usuario/{correo}
```

---

## Ejecución de pruebas

```bash
mvn test
```

---

## Estructura del proyecto

```
apihistorico/
├── src/
│   ├── main/
│   │   ├── java/apihistorico/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```
