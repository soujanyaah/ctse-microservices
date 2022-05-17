# define base docker image

FROM openjdk:8
LABEL maintainer="IT19119786"
ADD target/user-0.0.1-SNAPSHOT.jar abc-user.jar
ENTRYPOINT ["java", "-jar", "abc-user.jar"]