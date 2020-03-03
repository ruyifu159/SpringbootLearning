package com.ruyi.app;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
@ComponentScan
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker 
@Lazy(false)  // 禁用懒加载
@MapperScan("com.ruyi.user.mapper")
public class App 
{
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(App.class);

	@ApiOperation(value = "接口的功能介绍",notes = "提示接口使用者注意事项",httpMethod = "GET")
	@ApiImplicitParam(dataType = "string",name = "name",value = "姓名",required = true)
	@RequestMapping("/")
	String home() {
		return "Hello World!22";
	}

	@ApiOperation(value = "test swagger2接口的功能介绍",notes = "xxx",httpMethod = "GET")
	@ApiImplicitParam(dataType = "string",name = "name",value = "",required = false)
	@RequestMapping("/test")
	String test() {
		return "Test Swagger2!";
	}

	@Autowired
	private EurekaClient discoveryClient;

	@RequestMapping("/testEureka")
	public String ServiceUrl() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("hello-service", false);

		return instance.getHomePageUrl();
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello")
	@HystrixCommand(fallbackMethod = "helloFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
	})
	public String hello() {
		return restTemplate.getForObject("http://spring-boot-webmvc", String.class);
	}

	public String helloFallback() {
		return "Hello Fallback";
	}

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
