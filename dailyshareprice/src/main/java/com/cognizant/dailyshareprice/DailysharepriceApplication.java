package com.cognizant.dailyshareprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DailysharepriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailysharepriceApplication.class, args);
	}

}
