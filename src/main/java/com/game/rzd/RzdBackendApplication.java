package com.game.rzd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RzdBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RzdBackendApplication.class, args);
	}

}
