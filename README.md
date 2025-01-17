<!--
 * @Author: shanlonglong danlonglong@weimiao.cn
 * @Date: 2025-01-17 18:32:34
 * @LastEditors: shanlonglong danlonglong@weimiao.cn
 * @LastEditTime: 2025-01-17 18:39:30
 * @FilePath: \ecommerce-system\README.md
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
# Mall商城系统

## 项目介绍
Mall商城是一个基于Spring Boot + MyBatis-Plus构建的微服务电商系统。

## 系统架构
系统采用微服务架构，主要包含以下模块：
- mall-common：公共模块，包含通用工具类和配置
- mall-product：商品管理系统
- mall-order：订单管理系统
- mall-user：用户管理系统
- mall-payment：支付系统
- mall-marketing：营销和促销系统
- mall-admin：后台管理系统

## 技术选型
- 基础框架：Spring Boot 3.2.0
- 微服务框架：Spring Cloud 2023.0.0
- ORM框架：MyBatis-Plus 3.5.5
- 数据库：MySQL 8.0
- 认证授权：Spring Security + JWT
- 远程调用：OpenFeign

## 开发环境
- JDK 17
- Maven 3.8+
- MySQL 8.0
- IDEA 2023.1+

## 项目结构
```bash
mall-parent
├── mall-common -- 公共模块
├── mall-product -- 商品管理系统
├── mall-order -- 订单管理系统
├── mall-user -- 用户管理系统
├── mall-payment -- 支付系统
├── mall-marketing -- 营销和促销系统
├── mall-admin -- 后台管理系统
└── sql -- 数据库脚本
├── schema -- 建表语句
└── data -- 测试数据

```

## 快速开始

### 1. 环境准备
- 安装JDK 17
- 安装Maven 3.8+
- 安装MySQL 8.0

### 2. 初始化数据库
```bash
# 创建数据库
create database mall_product;
create database mall_order;
create database mall_admin;

# 执行SQL脚本
# 执行schema目录下的建表语句
source sql/schema/mall_product.sql
source sql/schema/mall_order.sql
source sql/schema/mall_admin.sql

# 可选：导入测试数据
source sql/data/mall_product_test.sql
source sql/data/mall_order_test.sql
source sql/data/mall_admin_test.sql
```

### 3. 修改配置
修改各个服务的application.yml中的数据库连接信息：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mall_xxx?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: your_username
    password: your_password
```

### 4. 启动服务
按顺序启动以下服务：
1. mall-product
2. mall-order
3. mall-admin

### 5. 接口测试
商品管理接口：
```bash
# 查询商品列表
GET http://localhost:8085/admin/product/list?pageNum=1&pageSize=10&keyword=iPhone

# 查询商品详情
GET http://localhost:8085/admin/product/detail/1
```

订单管理接口：
```bash
# 查询订单列表
GET http://localhost:8082/order/list?userId=1&pageNum=1&pageSize=10

# 查询订单详情
GET http://localhost:8082/order/detail/202401010001
```

## 项目文档
- [数据库设计文档](./docs/database.md)
- [接口文档](./docs/api.md)
- [部署文档](./docs/deploy.md)

## 开发规范
1. 代码规范遵循阿里巴巴Java开发手册
2. 接口返回统一使用R对象封装
3. 异常统一处理
4. 注释规范，类和方法必须添加注释

## 贡献指南
1. Fork 本仓库
2. 新建 feature_xxx 分支
3. 提交代码
4. 新建 Pull Request

## 版本历史
- v1.0.0：基础架构搭建，实现商品和订单基本功能

## 许可证
[MIT](./LICENSE)