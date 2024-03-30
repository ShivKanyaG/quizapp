FROM openjdk:17-oracle

COPY target/quizApp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "/app.jar"]