FROM amazoncorretto:11-alpine-jdk
MAINTAINER fabiano.gaetano@gmail.com
COPY target/docker-book-microservice-1.0.0.jar book-microservice.jar
ENTRYPOINT ["java","-jar","/book-microservice.jar"]