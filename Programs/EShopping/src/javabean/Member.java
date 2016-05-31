package javabean;

import java.util.Hashtable;

public class Member {
	private int id;
	private String userName;
	private String Name;
	private String sex;
	private String passWord;
	private String card;
	private String Email;
	private String address;
	private String regtime;
	private int state;
	private Hashtable map =new Hashtable();
	
	public Hashtable getMap() {
		return map;
	}
	public void setMap(Hashtable map) {
		this.map = map;
	}
	public Member() {
	}
	public Member(int id, String userName, String name, String sex, String passWord, String card, String email, String address, String regtime, int state) {
		this.id = id;
		this.userName = userName;
		Name = name;
		this.sex = sex;
		this.passWord = passWord;
		this.card = card;
		Email = email;
		this.address = address;
		this.regtime = regtime;
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
