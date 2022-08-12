package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) throws Exception {
		// 1 - load our xml file

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		// 2 - get the bean
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * // 3 - value to be inserted via construct Student student = new
		 * Student(25565, "Yash", "Lucknow");
		 * 
		 * // 4 - insert in db int r = studentDao.insert(student);
		 * System.out.println("done" + r);
		 */

		// for menu driven program;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag) {
			System.out.println("Press 1 for add new student");
			System.out.println("Press 2 for get all student");
			System.out.println("Press 3 for get detail of single student");
			System.out.println("Press 4 for delete a student");
			System.out.println("Press 5 for update student");
			System.out.println("Press 6 for exit");
			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1: // add a student
					System.out.println("enter user id :");
					int x = Integer.parseInt(br.readLine());

					System.out.println("enter user name");
					String name = br.readLine();

					System.out.println("enter user city");
					String city = br.readLine();

					// Calling the function
					Student student = new Student(x, name, city);
					int r = studentDao.insert(student);
					System.out.println("done" + r);
					System.out.println("***********************");
					System.out.println();

					break;

				case 2:
					List<Student> list = studentDao.getAllStudents();
					for (Student s : list) {
						System.out.println("Name : " + s.getStudentName());
						System.out.println("Id : " + s.getStudentId());
						System.out.println("City : " + s.getStudentCity());
						System.out.println("___________________________");
					}
					System.out.println("***********************");

					break;
				case 3: // get single student data
					break;
				case 4: // delete a student;
					break;
				case 5: // update a student;
					break;
				case 6: // exit
					flag = false;
					break;
				}
			}

			catch (Exception e) {
				System.out.println("invalid input");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("thanks for using me ! ..........");
	}
}
