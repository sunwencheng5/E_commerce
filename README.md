markdown
# E_commerce

基于 Spring Boot 的电商平台后端服务，提供商品管理、订单管理、用户管理等核心 API 接口。

## 技术栈

- **Java** 17+
- **Spring Boot** 2.x
- **MyBatis** / MyBatis-Plus（ORM 框架）
- **MySQL** 数据库
- **Maven** 构建工具

## 快速开始

### 1. 克隆项目

git clone https://github.com/sunwencheng5/E_commerce.git

cd E_commerce
2. 导入数据库
bash

# 执行 SQL 目录下的建表脚本

mysql -u root -p < SQL/xxx.sql
3. 修改配置文件
编辑 src/main/resources/application.yml 或 application.properties，配置数据库连接信息：

yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/你的数据库名?useSSL=false&serverTimezone=UTC
    username: 你的用户名
    password: 你的密码
    
4. 启动项目
bash

# 使用 Maven Wrapper 启动
./mvnw spring-boot:run

# 或打包后运行
./mvnw clean package
java -jar target/E_commerce-*.jar
5. 测试接口
项目启动后默认端口为 8080，可使用 Postman 或 curl 工具进行接口测试。

API 接口概览
模块	说明
商品管理	商品增删改查、分类浏览
订单管理	下单、订单查询、状态更新
用户管理	注册、登录、个人信息管理
购物车	添加/删除商品、结算
具体接口路径请参考 controller 包下的代码注释。

环境要求
JDK 17 及以上

MySQL 5.7 及以上

Maven 3.6 及以上（或使用项目自带的 Maven Wrapper）

贡献
欢迎提交 Issue 和 Pull Request。

License
暂无

text

---

## 使用方法

1. 将上述内容完整复制
2. 在项目根目录下创建 `README.md` 文件
3. 提交并推送：

```bash
git add README.md
git commit -m "docs: 添加 README 文档"
git push origin master
