package org.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication 
public class App 
{
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	SpringApplication application = new SpringApplication(App.class);
		application.setBannerMode(Banner.Mode.LOG);  // 设置spring启动banner
		application.run(args);   
    }
}
