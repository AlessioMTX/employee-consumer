package com.mitro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class EmployeeConsumerApplication implements ApplicationListener<ApplicationEnvironmentPreparedEvent>{

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(EmployeeConsumerApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
		ConfigurableEnvironment environment = applicationEnvironmentPreparedEvent.getEnvironment();
		Properties properties = new Properties();
		properties.put("","");
		environment.getPropertySources().addFirst(new PropertiesPropertySource("myProps", properties));
	}
}
