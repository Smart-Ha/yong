package com.wangy;

import com.wangy.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
@ImportResource(locations={"classpath:spring/kaptcha.xml"})
public class YongApplication {

	public static void main(String[] args) {
		SpringContextUtil.addProperties(getGlobalConf());
		System.out.println(SpringContextUtil.getProperty("app.name"));
		SpringApplication.run(YongApplication.class, args);
	}

	public static Properties getGlobalConf(){
		String path = "/conf.properties";
		InputStream is = YongApplication.class.getResourceAsStream(path);
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}


//	@Bean
//	VelocityEngine velocityEngine() throws IOException {
//		Properties properties = new Properties();
//		properties.load(this.getClass().getResourceAsStream("/velocity.properties"));
//		return new VelocityEngine(properties);
//	}
}
