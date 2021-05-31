package com.g6.onlineeyecare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.g6.onlineeyecare")
public class OnlineEyeClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineEyeClinicApplication.class, args);
	}

}
