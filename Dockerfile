FROM maven:3.8.1-openjdk-17 AS MAVEN

MAINTAINER BOTTOMHALF

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:17-oracle
WORKDIR /app
EXPOSE 8090

COPY --from=MAVEN /build/target/library-server.jar /app/

ENTRYPOINT ["java", "-jar", "library-server.jar"]