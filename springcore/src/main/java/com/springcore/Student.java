package com.springcore;

public class Student {
	private int studentId;
	private String studentName;
	private String studentAddress;
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the studentAddress
	 */
	public String getStudentAddress() {
		return studentAddress;
	}
	/**
	 * @param studentAddress the studentAddress to set
	 */
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ "]";
	}
	/**
	 * @param studentId
	 * @param studentName
	 * @param studentAddress
	 */
	public Student(int studentId, String studentName, String studentAddress) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}
	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
