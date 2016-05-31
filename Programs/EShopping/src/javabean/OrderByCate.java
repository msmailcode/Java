package javabean;

public class OrderByCate {
	
	private int id;
	private String typeName;
	private int number;
	public OrderByCate(int id, String typeName, int number) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.number = number;
	}
	public OrderByCate() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
