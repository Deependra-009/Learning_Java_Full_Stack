FROM openjdk:17-jdk-alpine
WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENTRYPOINT ["java","-jar","app.jar"]