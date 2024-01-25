package com.lingkesh.microservice.logsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lingkesh.microservice.logsservice.*")
public class LogServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(LogServiceApplication.class, args);
	}
}
