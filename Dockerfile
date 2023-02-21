FROM openjdk:17


COPY target/tasbackend-0.0.1.jar tasbackend-0.0.1.jar

EXPOSE 8089

ENTRYPOINT ["java","-jar","tasbackend-0.0.1.jar"]

