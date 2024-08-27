FROM openjdk:17-jdk-slim-buster

LABEL authors="mohmm"


# Crea un directorio para la aplicación
RUN mkdir /app

# Establece /app como el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de la aplicación al directorio de trabajo
COPY ./target/car-service-0.0.1-SNAPSHOT.jar /app/car-service-0.0.1-SNAPSHOT.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "car-service-0.0.1-SNAPSHOT.jar"]