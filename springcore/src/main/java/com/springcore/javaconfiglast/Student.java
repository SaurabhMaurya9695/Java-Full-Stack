package com.springcore.javaconfiglast;

public class Student {

	public Student(Samosa samosa) {
		super();
		this.samosa = samosa;
	}

	public Samosa getSamosa() {
		return samosa;
	}

	public void setSamosa(Samosa samosa) {
		this.samosa = samosa;
	}

	private Samosa samosa;

	public void study() {
		this.samosa.display();
		System.out.println("we are reading a book now");
//		return;
	}

}
