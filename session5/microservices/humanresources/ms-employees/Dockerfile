FROM openjdk:8
VOLUME "/tmp"
EXPOSE 8080
ENV SPRING_DATASOURCE_URL jdbc:oracle:thin:@//database-oracle:1521/XE
ENV SPRING_DATASOURCE_USERNAME hr
ENV SPRING_DATASOURCE_PASSWORD hrpw
ADD ./target/ms-employees-1.0.0.jar ms-employees.jar
ENTRYPOINT ["java", "-Duser.timezone=GMT", "-jar", "ms-employees.jar"]
