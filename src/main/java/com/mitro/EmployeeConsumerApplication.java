package com.mitro;

import com.mitro.controller.ConsumerControllerClient;
import com.mitro.service.GreetingsService;
import com.mitro.stream.GreetingsStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class EmployeeConsumerApplication {

	public static void main(String[] args) throws RestClientException, IOException {

		ApplicationContext ctx = SpringApplication.run(EmployeeConsumerApplication.class, args);

		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
		GreetingsService greetingsService = ctx.getBean(GreetingsService.class);
		greetingsService.receiveGreetings();
	}

	@Bean
	public  ConsumerControllerClient  consumerControllerClient() {
		return  new ConsumerControllerClient();
	}

	@Bean
	public GreetingsService greetingsService() {
		return new GreetingsService();
	}
}
