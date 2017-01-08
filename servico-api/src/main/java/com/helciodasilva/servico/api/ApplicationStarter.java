package com.helciodasilva.servico.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.helciodasilva")
public class ApplicationStarter {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationStarter.class, args);
	}
}