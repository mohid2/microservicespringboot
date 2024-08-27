FROM openjdk:17-jdk-slim-buster

LABEL authors="mohmm"


# Crea un directorio para la aplicación
RUN mkdir /app

# Establece /app como el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de la aplicación al directorio de trabajo
COPY ./target/config-service-0.0.1-SNAPSHOT.jar /app/config-service-0.0.1-SNAPSHOT.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "config-service-0.0.1-SNAPSHOT.jar"]