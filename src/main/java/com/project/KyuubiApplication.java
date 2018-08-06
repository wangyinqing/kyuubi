package com.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.project.mybatis.mapper")
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class KyuubiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyuubiApplication.class, args);
	}
}
