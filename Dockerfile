FROM openjdk:8
ADD target/urman.jar urman.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "urman.jar"]