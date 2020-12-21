package com.mayikt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@MapperScan("com.mayikt.mapper")
public class MayiktSpringbootStrategyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MayiktSpringbootStrategyApplication.class, args);
	}

}
