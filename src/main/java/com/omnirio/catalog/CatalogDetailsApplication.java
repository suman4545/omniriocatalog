package com.omnirio.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CatalogDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogDetailsApplication.class, args);
	}

}
