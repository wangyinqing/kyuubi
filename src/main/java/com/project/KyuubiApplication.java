package com.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.mybatis.mapper")
public class KyuubiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyuubiApplication.class, args);
	}
}
