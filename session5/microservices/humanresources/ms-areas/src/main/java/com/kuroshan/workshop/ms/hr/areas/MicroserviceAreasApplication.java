package com.kuroshan.workshop.ms.hr.areas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceAreasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAreasApplication.class, args);
	}

}
