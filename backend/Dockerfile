FROM gradle:7.2.0 AS builder
COPY . /app
WORKDIR /app
RUN gradlew fatJar

FROM openjdk:17-jdk-slim
COPY --from=builder /app/build/libs/backend-1.0-standalone.jar .
CMD ["java", "-DFCGI_PORT=1487", "-jar", "backend-1.0-standalone.jar"]