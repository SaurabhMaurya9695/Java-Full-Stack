package com.springcore.lifecycle;

public class Samosa {
	private double price;

	public Samosa(double price) {
		super();
		this.price = price;
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}

	public Samosa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Setting the price");
		this.price = price;
	}

	// left cycle method
	public void init() {
		System.out.println("Inside Init");
	}

	public void destroy() {
		System.out.println("Inside Destroy Method");
	}
}
