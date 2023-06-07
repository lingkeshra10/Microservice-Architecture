package com.lingkesh.microservice.logsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages = "com.lingkesh.microservice.logsservice.*")
public class LogsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogsserviceApplication.class, args);
	}

}

