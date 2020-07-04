FROM openjdk:8
VOLUME "/tmp"
EXPOSE 8761
ADD ./target/security-server-0.0.1-SNAPSHOT.jar security-server.jar
ENTRYPOINT ["java", "-jar", "security-server.jar"]
