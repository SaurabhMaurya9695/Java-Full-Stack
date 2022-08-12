package com.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Citest {

	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("com/springcore/ci/ciconfig.xml");
		Person personobj = (Person) context.getBean("person");
		System.out.println(personobj);

	}

}
