package com.qingyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qingyuan.base.mapper")
public class ObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjectApplication.class, args);
	}

}
