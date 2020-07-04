FROM openjdk:8
VOLUME "/tmp"
EXPOSE 8761
ADD ./target/ms-employees-1.0.0.jar ms-employees.jar
ENTRYPOINT ["java", "-Duser.timezone=GMT", "-jar", "ms-employees.jar"]
