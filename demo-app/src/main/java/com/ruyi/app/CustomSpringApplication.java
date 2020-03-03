package com.ruyi.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomSpringApplication extends SpringApplication {

	private static final Logger LOG = LoggerFactory.getLogger(CustomSpringApplication.class);
	
	@Override
	protected void logStartupInfo(boolean isRoot) {
		LOG.info("================application startup================="); 
		
		super.logStartupInfo(isRoot);
	}

}
