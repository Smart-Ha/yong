package com.wangy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class,MongoDataAutoConfiguration.class})
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
