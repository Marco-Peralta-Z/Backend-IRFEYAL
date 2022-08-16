FROM openjdk:11-jdk-slim
COPY "./target/Backend-IRFEYAL-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8084
ENTRYPOINT ["java","-jar","app.jar"]