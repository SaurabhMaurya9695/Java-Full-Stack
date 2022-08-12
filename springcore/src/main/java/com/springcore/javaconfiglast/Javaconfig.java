package com.springcore.javaconfiglast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//by using this tag we are defining this file as xml;

//@ComponentScan(basePackages = "com.springcore.javaconfiglast")
public class Javaconfig {

	//declaring a bean for samosa ;
	@Bean
	public Samosa getSamosa() {
		Samosa samosa = new Samosa();
		return samosa;
	}
	
	// declaring a bean;
	@Bean
	public Student getStudent() {
		// creating a bean
		Student student = new Student(getSamosa());
		return student;
	}

}
