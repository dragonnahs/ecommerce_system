FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar

ENV TZ=Asia/Shanghai

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"] 