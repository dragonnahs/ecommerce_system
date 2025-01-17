# 部署文档

## 环境要求
- Docker 20.10+
- Docker Compose 2.0+
- Jenkins 2.375+
- JDK 17
- Maven 3.8+
- SonarQube 9.0+

## Jenkins配置
1. 安装必要插件：
   - Pipeline
   - Docker Pipeline
   - SonarQube Scanner
   - SSH Agent
   - Email Extension

2. 配置凭证：
   - Docker Registry凭证
   - 生产服务器SSH凭证
   - SonarQube凭证

3. 配置Jenkins Pipeline：
   - 新建Pipeline项目
   - 配置Git仓库地址
   - 选择Jenkinsfile方式
   - 配置构建触发器（如代码提交自动触发）

## 自动化部署流程
1. 开发人员提交代码到Git仓库
2. Jenkins自动触发构建
3. 执行单元测试和代码质量分析
4. 构建Docker镜像
5. 推送镜像到私有仓库
6. 通过SSH连接生产服务器
7. 拉取最新镜像并重启服务

## 手动部署步骤
1. 构建项目：
```bash
mvn clean package -DskipTests
```

2. 构建Docker镜像：
```bash
docker-compose build
```

3. 启动服务：
```bash
docker-compose up -d
```

4. 查看服务状态：
```bash
docker-compose ps
```

5. 查看服务日志：
```bash
docker-compose logs -f
```

## 环境变量配置
需要在生产环境配置以下环境变量：
- MYSQL_USERNAME：数据库用户名
- MYSQL_PASSWORD：数据库密码
- JWT_SECRET：JWT密钥

## 注意事项
1. 生产环境必须使用HTTPS
2. 定期备份数据库
3. 监控服务器资源使用情况
4. 配置日志收集和监控告警 