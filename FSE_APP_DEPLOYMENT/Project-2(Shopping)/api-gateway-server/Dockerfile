FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} apigatewayserver.jar
ENTRYPOINT ["java","-jar","./apigatewayserver.jar"]
EXPOSE 9094