FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/cc-producer-service.jar cc-producer-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/cc-producer-service.jar"]