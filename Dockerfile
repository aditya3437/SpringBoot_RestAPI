FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:go-offline -Dmaven.repo.local=/app/.m2/repository
COPY src ./src
RUN mvn -B package -DskipTests
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar springboot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "springboot-0.0.1-SNAPSHOT.jar"]