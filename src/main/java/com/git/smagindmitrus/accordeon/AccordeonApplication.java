package com.git.smagindmitrus.accordeon;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AccordeonApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AccordeonApplication.class, args);
	}

}
