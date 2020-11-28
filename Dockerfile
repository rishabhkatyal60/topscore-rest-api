FROM maven:3.6-adoptopenjdk-11 as maven
ARG JAR_FILE=target/topscore-rest-api-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} ./topscore-rest-api-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","./topscore-rest-api-1.0-SNAPSHOT.jar"]

##Command to Build Docker image and run
#docker build -t topscore-rest-api .
#docker run -p 8080:8080 topscore-rest-api

