package com.helciodasilva.servico.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.helciodasilva")
@EnableFeignClients
public class ApplicationStarter{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationStarter.class, args);
	}

}