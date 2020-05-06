package com.demo.userratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={ "com.demo"})
public class UserRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRatingServiceApplication.class, args);
	}

}
