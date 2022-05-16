# define base docker image

FROM openjdk:8
LABEL maintainer="IT19107110"
ADD target/product-0.0.1-SNAPSHOT.jar ABC-Product.jar
ENTRYPOINT ["java", "-jar", "ABC-Product.jar"]