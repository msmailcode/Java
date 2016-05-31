package javabean;

import java.util.Date;

public class People {
	private int id;
	private String userName;
	private int age;
	private Date birthDay;
	private double sal;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public People(int id, String userName, int age) {
		this.id = id;
		this.userName = userName;
		this.age = age;
	}
	public People() {
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public People(int id, String userName, int age, Date birthDay, double sal) {
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.birthDay = birthDay;
		this.sal = sal;
	}
	
}
