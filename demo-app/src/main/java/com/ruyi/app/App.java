package com.ruyi.app;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@EnableSwagger2
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker 
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Lazy(false)  // 禁用懒加载
@MapperScan("com.ruyi.user.mapper")
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
	
	/*
	 * kafka例子
	 */
    @KafkaListener(id = "myId", topics = "topic1")
    public void listen(String in) {
        System.out.println("========" + in);
    }
    
    @KafkaListener(id = "myId2", topics = "topic1")
    public void onMessage1(ConsumerRecord<?, ?> record) {
        System.out.println("++++" + record.topic() + " - " + record.partition() + " - " + record.value());
    }
}
