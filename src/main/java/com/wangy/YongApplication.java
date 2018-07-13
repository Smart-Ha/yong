package com.wangy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class YongApplication {

	public static void main(String[] args) {
		SpringApplication.run(YongApplication.class, args);
	}
}
