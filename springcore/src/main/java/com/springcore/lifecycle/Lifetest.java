package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lifetest {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/lifecycle/lifeconfig.xml");
//		Samosa samosa = (Samosa) context.getBean("s1");
//		System.out.println(samosa);

		// destroy Method calls

//		System.out.println("++++++++++++++");
//
//		Pepsi pepsi = (Pepsi) context.getBean("p1");
//		System.out.println(pepsi);
		context.registerShutdownHook();
		Example eg = (Example) context.getBean("e1");
		System.out.println(eg);
	
	}

}
