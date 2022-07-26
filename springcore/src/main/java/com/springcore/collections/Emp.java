package com.springcore.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Emp {
	private String name;
	/**
	 * 
	 */
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param phones
	 * @param addresses
	 * @param courses
	 */
	public Emp(String name, List<String> phones, Set<String> addresses, Map<String, String> courses) {
		super();
		this.name = name;
		this.phones = phones;
		this.addresses = addresses;
		this.courses = courses;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the phones
	 */
	public List<String> getPhones() {
		return phones;
	}
	/**
	 * @param phones the phones to set
	 */
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	/**
	 * @return the addresses
	 */
	public Set<String> getAddresses() {
		return addresses;
	}
	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}
	/**
	 * @return the courses
	 */
	public Map<String, String> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}
	private List<String> phones;
	private Set<String> addresses;
	private Map<String, String> courses;
	
}
