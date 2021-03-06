package com.sist.spring;

public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	
	// [생성자] - 1) 매개변수가 없는 생성자 
	// - app.xml에서 
	public Sawon(){}
	
	// [생성자] - 2) 매개변수가 있는 생성자 
	
	public Sawon(int sabun, String name, String dept) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}

	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void display()
	{
		System.out.println("Sawon: display() Call...");
	}
	
}
