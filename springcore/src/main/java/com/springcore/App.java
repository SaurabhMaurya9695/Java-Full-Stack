package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		// 1- we are defining the path to IOC which beans we have to take now;
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/config.xml");

		// 2 - taken out beans from config.xml;
		Student student1 = (Student) context.getBean("student1"); // type casting is important

		// 3 - after getting simply print this;
		System.out.println(student1);

	}
}
