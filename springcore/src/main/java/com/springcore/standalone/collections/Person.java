package com.springcore.standalone.collections;

import java.util.List;
 
public class Person {
	private List<String> friend;

	@Override
	public String toString() {
		return "Person [friend=" + friend + "]";
	}

	public List<String> getFriend() {
		return friend;
	}

	public void setFriend(List<String> friend) {
		this.friend = friend;
	}
}
