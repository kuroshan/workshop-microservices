FROM openjdk:8
VOLUME "/tmp"
EXPOSE 8080
ADD ./target/ms-areas-0.0.1-SNAPSHOT.jar ms-areas.jar
ENTRYPOINT ["java", "-Duser.timezone=GMT", "-jar", "ms-areas.jar"]
