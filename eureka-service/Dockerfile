FROM openjdk:17-jdk-slim-buster

LABEL authors="mohmm"


# Crea un directorio para la aplicación
RUN mkdir /app

# Establece /app como el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de la aplicación al directorio de trabajo
COPY ./target/eureka-service-0.0.1-SNAPSHOT.jar /app/eureka-service-0.0.1-SNAPSHOT.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "eureka-service-0.0.1-SNAPSHOT.jar"]