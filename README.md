# springboot-urule
基于URule-2.1.5开源版本集成SpringBoot-2.0，基于内置源码的集成，方便直接二次开发。

## 运行环境
1. Ubuntu20.04
2. MySQL 8.0.33
3. Java 11

# 部署方式1 

1. 修改edas-rule-server里面application.properties数据库配置，在数据库创建空的库。urule会自动创建表
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://{Your IP}:3306/{Database}?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8&autoReconnect=true
spring.datasource.username={UserName}
spring.datasource.password={PassWord}
```
2. 运行

```shell
cd urule-demo
mvn package
#或者
mvn install
```

3. 打开浏览器访问 http://{Your IP}:8090/urule/ 试试吧

4. 测试之前需要创建相应的知识包，规则等，edas-rule-server页面创建知识包等,edas/user_package

5. 如果需要测试调用服务，使用Http请求的工具类，如Postman 调用http://{Your IP}:8787/rule/ageRule + 传参

# 前端 
urule-console-js模块为Urule前端源码部分！温馨提醒：urule采用react技术开发，如果要改造 找懂react的人弄吧 哈哈！
## 前端构建
1.执行npm install

2.打包 npm run start 

3.将打包后的website/js目录下的js脚本 替换 edas-rule-server/src/main/resources/urule-asserts/js
目录下的即可完成前端更新


