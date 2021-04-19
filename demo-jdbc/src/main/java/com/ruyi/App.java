package com.ruyi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@EnableSwagger2
@Lazy(false)  // 禁用懒加载
@SpringBootApplication 
public class App 
{
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(App.class);

	// 监听应用退出
	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 42;
	}

	public static void main( String[] args )
	{
		SpringApplication application = new SpringApplication(App.class);
		application.setBannerMode(Banner.Mode.LOG);  // 设置spring启动banner
		application.run(args); 
	}
}
