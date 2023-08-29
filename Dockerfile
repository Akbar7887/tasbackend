FROM openjdk:17
EXPOSE 8089

COPY target/tasbackend-0.0.1.jar tasbackend-0.0.1.jar



ENTRYPOINT ["java","-jar","tasbackend-0.0.1.jar"]

