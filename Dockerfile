FROM maven:3.8.4-openjdk-17
WORKDIR /opt/app
COPY . .
RUN mvn clean install
CMD ["java", "-jar", "target/security-1.jar"]