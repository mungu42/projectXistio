FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG PORT=8080
COPY ${JAR_FILE} app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java","-Dserver.port=8080","-jar","/app.jar"]