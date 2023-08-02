# springboot-urule
基于URule-2.1.5开源版本集成SpringBoot-2.0，基于内置源码的集成，方便直接二次开发。

因为开源版本的springboot模块只是进行了最基本的集成，文件仓库默认还是存储在磁盘，现在希望基于最新版的SpringBoot-2.0和URule-2.1.5进行集成，并支持数据库存储资源库等，和权限控制等。

同时加之在使用SpringBoot 2.0的时候踩过一些坑，最终顺利完成和各种不同数据源的集成，希望对刚解除或者正好也有集成URule项目做二次开发的朋友少走一些弯路，后续有空会逐步去完善一些东西。

# 后端
## edas-rule-server
Urule服务配置端
## edas-rule-client
开放Urule调用接口服务
## 运行
1.修改edas-rule-server里面application.properties数据库配置，在数据库创建空的库。urule会自动创建表

2.运行edas-rule-server的EdasRuleServerApplication启动类

3.打开浏览器访问 http://localhost:8090/urule/ 试试吧

4.如果需要测试调用服务，运行edas-rule-client的EdasRuleClientApplication启动类

5.edas-rule-server页面创建知识包等,edas/user_package

6.使用Http请求的工具类，如Postman 调用http://localhost:8787/rule/ageRule + 传参

# 前端 
urule-console-js模块为Urule前端源码部分！温馨提醒：urule采用react技术开发，如果要改造 找懂react的人弄吧 哈哈！
## 前端构建
1.执行npm install

2.打包 npm run start 

3.将打包后的website/js目录下的js脚本 替换 edas-rule-server/src/main/resources/urule-asserts/js
目录下的即可完成前端更新