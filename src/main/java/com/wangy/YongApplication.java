package com.wangy;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class YongApplication {

	public static void main(String[] args) {
		SpringApplication.run(YongApplication.class, args);
	}


//	@Bean
//	VelocityEngine velocityEngine() throws IOException {
//		Properties properties = new Properties();
//		properties.load(this.getClass().getResourceAsStream("/velocity.properties"));
//		return new VelocityEngine(properties);
//	}
}
