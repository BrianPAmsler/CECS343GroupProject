package com.cecs.restaurantautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantautomationApplication {
	public static void main(String[] args) {
		// Initialize singleton
		RestaurantManager.getInstance();
		
		SpringApplication.run(RestaurantautomationApplication.class, args);
	}
}
