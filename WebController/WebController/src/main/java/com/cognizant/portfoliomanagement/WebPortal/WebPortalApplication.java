package com.cognizant.portfoliomanagement.WebPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author saumy
 *
 */
@SpringBootApplication
@EnableFeignClients
public class WebPortalApplication{

	public static void main(String[] args) {
		SpringApplication.run(WebPortalApplication.class, args);
	}

}
