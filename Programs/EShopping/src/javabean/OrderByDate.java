package javabean;

public class OrderByDate {

	private int typeid;
	private int number;
	public OrderByDate(int typeid, int number) {
		super();
		this.typeid = typeid;
		this.number = number;
	}
	public OrderByDate() {
		super();
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
	
}
