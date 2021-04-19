package org.demo.cors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
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
