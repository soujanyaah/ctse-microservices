# define base docker image

FROM openjdk:8
LABEL maintainer="IT19107110"
ADD target/product-0.0.1-SNAPSHOT.jar abc-product.jar
ENTRYPOINT ["java", "-jar", "abc-product.jar"]