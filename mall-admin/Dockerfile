FROM openjdk:17-jdk-slim

WORKDIR /app

# 复制jar包
COPY target/*.jar app.jar

# 设置时区
ENV TZ=Asia/Shanghai

# 暴露端口
EXPOSE 8085

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"] 