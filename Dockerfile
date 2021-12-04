FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN --mount=type=cache,target=/root/.m2  mvn clean package -Dmaven.test.skip


FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]