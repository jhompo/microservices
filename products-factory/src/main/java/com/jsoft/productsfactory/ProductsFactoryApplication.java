package com.jsoft.productsfactory;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductsFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsFactoryApplication.class, args);
	}

	/*@Bean
	public FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
		return new FlywayMigrationInitializer(flyway);
	}*/
}
