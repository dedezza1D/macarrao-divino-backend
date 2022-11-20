FROM openjdk:11
EXPOSE 8080
WORKDIR /src
ADD target/*.jar /src/api-docker.jar
ENTRYPOINT ["java", "-jar","api-docker.jar"]
