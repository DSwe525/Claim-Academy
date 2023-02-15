package com.cribs.cribs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cribs")
public class CribsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CribsApplication.class, args);
	}

}
