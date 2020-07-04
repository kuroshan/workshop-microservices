FROM openjdk:8
VOLUME "/tmp"
EXPOSE 8761
ADD ./target/ms-users-0.0.1-SNAPSHOT.jar ms-users.jar
ENTRYPOINT ["java", "-jar", "ms-users.jar"]
