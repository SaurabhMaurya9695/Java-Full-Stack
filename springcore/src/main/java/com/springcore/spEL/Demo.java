package com.springcore.spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("demoobj")
public class Demo {
	
	@Value("#{5+7+8}")
	private int x;
	
	@Value("#{5*7*8*0}")
	private int y ;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + "]";
	}
	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
