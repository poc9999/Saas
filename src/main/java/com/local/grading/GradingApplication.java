package com.local.grading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.local.grading.mapper")
public class GradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradingApplication.class, args);
	}

}
