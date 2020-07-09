FROM openjdk:8
VOLUME "/tmp"
EXPOSE 8080
ENV SPRING_DATASOURCE_URL jdbc:oracle:thin:@//database-oracle:1521/XE
ENV SPRING_DATASOURCE_USERNAME hr
ENV SPRING_DATASOURCE_PASSWORD hrpw
ADD ./target/ms-areas-0.0.1-SNAPSHOT.jar ms-areas.jar
ENTRYPOINT ["java", "-Duser.timezone=GMT", "-jar", "ms-areas.jar"]
