package com.cab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CabSearchingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabSearchingApplication.class, args);
	}

}
