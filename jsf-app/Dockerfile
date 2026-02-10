# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Deploy to WildFly
FROM quay.io/wildfly/wildfly:37.0.0.Final-jdk17
COPY --from=builder /app/target/jsf-app.war /opt/jboss/wildfly/standalone/deployments/jsf-app.war
EXPOSE 8080
