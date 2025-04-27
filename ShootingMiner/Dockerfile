FROM gradle:8.3.0-jdk21-alpine AS builder
WORKDIR /app
COPY build.gradle settings.gradle gradle.properties ./
COPY gradle ./gradle
RUN gradle dependencies --no-daemon
COPY src ./src
RUN gradle clean build -x test --no-daemon

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
ARG JAR_PATH=build/libs/*.jar
COPY --from=builder /app/${JAR_PATH} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
