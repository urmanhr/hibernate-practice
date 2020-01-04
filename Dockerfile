FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/urmanhr/hibernate-practice.git (1)

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/hibernate-practice /app (2)
RUN mvn install (3)

FROM openjdk:8
WORKDIR /app
COPY --from=1 /app/target/urman.jar /app (4)
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "urman.jar"]