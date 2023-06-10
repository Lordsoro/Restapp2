package com.example.AtlAcademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.AtlAcademy.models")
public class AtlAcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtlAcademyApplication.class, args);
	}

}
