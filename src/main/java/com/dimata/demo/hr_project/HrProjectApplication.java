package com.dimata.demo.hr_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
public class HrProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrProjectApplication.class, args);
	}

}
