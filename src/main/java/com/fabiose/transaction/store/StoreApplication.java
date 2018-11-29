package com.fabiose.transaction.store;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		SpringApplication.run(StoreApplication.class, args);
	}
	
}
