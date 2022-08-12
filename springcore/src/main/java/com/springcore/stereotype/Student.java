package com.springcore.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component ("studentobj")// by default bean is created by using this keyword;
public class Student {

	@Value("Saurabh") // by default value is taken in StudentName;
	private String studentName;

	@Value("Lucknow")
	private String city;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", city=" + city + "]";
	}

	public String getCity() {
		return city;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCity(String city) {
		this.city = city;
	}
}
