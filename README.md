# guazi

瓜子快递项目


# 技术栈

前端：
- HTML、CSS 和 JavaScript 用于构建页面和交互
- Bootstrap 和 Layui 用于页面布局和样式
- jQuery 用于简化 JavaScript 代码
- Layer插件用于显示消息

后端
- 服务器端使用 MySQL 数据库
- Tomcat 服务器
- Servlet 和 JSP 技术来处理和显示数据

## 运行环境

java 环境
- jdk1.8.0_202

Tomcat 版本
- apache-tomcat-9.0.52

Mysql 版本
-  5.7.44

## jar包

因为没有使用 maven 管理 Jar 包 所以需要自己下载并引入

**web/WEB-INF/lib**

- mysql-connector-java-5.1.37-bin.jar（用于连接数据库的包）
- druid-1.0.9.jar（连接池）
- gson-2.8.2.jar（json格式转换）
- aliyun-java-sdk-core-4.1.0.jar（阿里云 用来发短信的包）
- commons-codec-1.12.jar（调用微信接口使用的包）
- json.jar（调用微信接口使用的包）

## 数据库配置

src/druid.properties


## 微信接口调用

**第一步**

mp.weixin.qq.com/设置与开发/基本配置/，获取appid和secret，并修改：

src\com\duyi\wxconfig/SignatureUtil类 88 行 appid

src\com\duyi\wxconfig/TokenUtil类 34 行 appid

src\com\duyi\wxconfig/TokenUtil类 35 行 secret

**第二步**

mp.weixin.qq.com/设置与开发/公众号设置/功能设置

配置JS接口安全域名

**第三步**

mp.weixin.qq.com/设置与开发/基本配置/

配置ip白名单
