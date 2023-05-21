FROM openjdk:17


COPY target/tasbackend-0.0.1.jar tasbackend-0.0.1.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","tasbackend-0.0.1.jar"]

