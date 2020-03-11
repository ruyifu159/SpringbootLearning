package org.demo.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@ComponentScan(basePackages="org.demo")
@MapperScan("org.demo.user.mapper")
@EnableSwagger2
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);     
    }
}
