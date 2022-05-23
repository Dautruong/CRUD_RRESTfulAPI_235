package com.app.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartServer {
	public static void main(String[] args) {
		System.out.println("Start Server...");
		SpringApplication.run(StartServer.class, args);
	}
}
 