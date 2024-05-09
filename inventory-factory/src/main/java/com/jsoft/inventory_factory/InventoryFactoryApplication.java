package com.jsoft.inventory_factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryFactoryApplication.class, args);
	}

}
