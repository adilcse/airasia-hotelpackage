# download maven image from Docker Hub
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

# author who maintains this file
MAINTAINER airasia.com

# copy and packing source code in docker image
WORKDIR /build/
COPY pom.xml /build/
RUN mvn dependency:go-offline

COPY src /build/src/
RUN mvn -DskipTests package

# download openjdk image
FROM openjdk:8-jre-alpine

# run jar file in docker container
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]