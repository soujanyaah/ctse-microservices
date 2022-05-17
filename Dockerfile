# define base docker image

FROM openjdk:8
LABEL maintainer="IT19123400"
ADD target/order-0.0.1-SNAPSHOT.jar abc-order.jar
ENTRYPOINT ["java", "-jar", "abc-order.jar"]