# SpringbootLearning
springboot学习, 学习使用maven构建工具逐步搭建spring boot项目.

## 环境说明
OS - win7  
Java - 1.8.0_241 x64  
maven - Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)  
sts -  4.5.1.RELEASE  
达梦数据库 - 7.6.0.197(Build 2019.09.16)   
备注：maven仓库全局配置阿里云镜像仓库：https://maven.aliyun.com/mvn/view（解决国内下载依赖jar包速度慢的问题）
在maven安装目录/conf/settings.xml中的mirrors标签下添加需要的镜像服务，格式如下：
```
<mirror>
      <id>aliyun-jcenter</id>
      <mirrorOf>*</mirrorOf>
      <name>aliyun jcenter</name>
      <url>https://maven.aliyun.com/repository/jcenter</url>
</mirror>
```

## 项目说明
- demo 
    - eureka-server     服务注册中心
    - demo-app          业务应用服务
      -  配置集成swagger2 api
      -  配置集成devtools
      -  配置集成mybatis  
      -  配置集成ThymeLeaf
      -  配置集成hystrix
      -  配置集成eureka client
      -  配置集成security JWT
      
## 构建运行
启动命令: >mvn spring-boot:run

## 服务说明
eureka注册中心地址: http://localhost:8761/  
swagger open api接口说明: http://localhost:8081/swagger-ui.html     
测试使用eureka client远程调用服务: http://localhost:8081/common/testEureka  
测试使用rest远程调用hystrix断路器集成: http://localhost:8081/common/hello  
测试数据库访问的服务接口: http://localhost:8081/user/showUser  
备注:  
maven仓库没有DmJdbcDriver17.jarr包因此无法在线获取依赖, 需通过如下命令安装到本地maven仓库中：  
mvn install:install-file -DgroupId=com.dm -DartifactId=DmJdbcDriver -Dversio  
n=1.7.0 -Dpackaging=jar -Dfile=D:\DmJdbcDriver17.jar  

## 问题列表
- [如何配置不需要用户验证、鉴权的请求？](https://github.com/ruyifu159/SpringbootLearning/issues/2)

## 参考资料:
- [Spring Boot Reference Documentation.](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/html/)
- [Spring Cloud Netflix.](https://cloud.spring.io/spring-cloud-netflix/reference/html/)
- [Springfox Reference Documentation.](http://springfox.github.io/springfox/docs/current/)
- [Springboot+Spring-Security+JWT+Redis实现restful Api的权限管理以及token管理（超详细用爱发电版）](https://www.jianshu.com/p/29b12ccbc215)
