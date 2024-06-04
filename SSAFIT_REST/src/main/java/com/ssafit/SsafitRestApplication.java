package com.ssafit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SsafitRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SsafitRestApplication.class, args);
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}

	}

}
