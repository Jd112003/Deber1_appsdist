FROM quay.io/wildfly/wildfly:37.0.0.Final-jdk17

# Copy your WAR into WildFly deployments
COPY target/rest-app.war /opt/jboss/wildfly/standalone/deployments/rest-app.war

EXPOSE 8080