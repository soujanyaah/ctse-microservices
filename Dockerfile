# define base docker image

FROM openjdk:8
LABEL maintainer="IT19047102"
ADD target/delivery-0.0.1-SNAPSHOT.jar abc-delivery.jar
ENTRYPOINT ["java", "-jar", "abc-delivery.jar"]