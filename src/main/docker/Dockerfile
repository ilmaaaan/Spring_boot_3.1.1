FROM openjdk:24-ea-23-jdk-bullseye
LABEL authors="daraorlova"
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]