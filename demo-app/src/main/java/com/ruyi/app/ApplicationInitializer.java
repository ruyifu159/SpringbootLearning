package com.ruyi.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class ApplicationInitializer extends ContextRefreshedEvent {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationInitializer.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8476789123173794383L;

	public ApplicationInitializer(ApplicationContext source) {
		super(source);
		LOG.info("================== Context Refreshed. ===================");
	}

}
