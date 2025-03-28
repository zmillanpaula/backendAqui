# Usar imagen base de Java 17
FROM openjdk:17-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Construir el .jar con Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Exponer el puerto donde corre Spring Boot
EXPOSE 8080

# Ejecutar la app
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]