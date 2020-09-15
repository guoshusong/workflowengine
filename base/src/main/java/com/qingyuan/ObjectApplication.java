package com.qingyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjectApplication.class, args);
	}

}
