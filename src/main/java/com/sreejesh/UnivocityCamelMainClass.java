package com.sreejesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ImportResource;

import lombok.Data;

@Data
@SpringBootApplication
//@ImportResource("classpath:META-INF/spring/applicationContext.xml") 
public class UnivocityCamelMainClass {
	


	public static void main(String[] args) {
		SpringApplication.run(UnivocityCamelMainClass.class, args);

	}



}
