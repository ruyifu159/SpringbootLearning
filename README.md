# SpringbootLearning
springboot学习, 学习使用maven构建工具逐步搭建spring boot项目.

## 环境说明
OS - win7  
Java - 1.8.0_241 x64  
maven - Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)  
sts -  4.5.1.RELEASE  

## 项目说明
- demo 
    - demo-app          业务应用服务
    - eureka-server     服务注册中心
      -  配置集成swagger2 api
      -  配置集成devtools
      -  配置集成mybatis  (连接达梦数据库)
      -  配置集成ThymeLeaf
      -  配置集成hystri
      -  配置集成eureka client
      
## 构建运行
启动命令: >mvn spring-boot:run

## 服务说明
eureka注册中心地址: http://localhost:8761/  
swagger open api接口说明: http://localhost:8081/swagger-ui.html    (突然出现一个问题,待修复)  
测试使用eureka client远程调用服务: http://localhost:8081/testEureka  
测试使用rest远程调用hystrix断路器集成: http://localhost:8081/hello  
备注:  
maven仓库没有DmJdbcDriver17.jarr包因此无法在线获取依赖, 需通过如下命令安装到本地maven仓库中：  
mvn install:install-file -DgroupId=com.dm -DartifactId=DmJdbcDriver -Dversio  
n=1.7.0 -Dpackaging=jar -Dfile=D:\DmJdbcDriver17.jar  

## 参考资料:
- [Spring Boot Reference Documentation.](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/html/)
- [Spring Cloud Netflix.](https://cloud.spring.io/spring-cloud-netflix/reference/html/)
- [Springfox Reference Documentation.](http://springfox.github.io/springfox/docs/current/)
