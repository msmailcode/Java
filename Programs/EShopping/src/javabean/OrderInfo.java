package javabean;

public class OrderInfo {
	
	private int id;
	private String name;
	private float price;
	private float saleprice;
	private int number;
	private float totalprice;
	public OrderInfo(int id, String name, float price, float saleprice, int number, float totalprice) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.saleprice = saleprice;
		this.number = number;
		this.totalprice = totalprice;
	}
	public OrderInfo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(float saleprice) {
		this.saleprice = saleprice;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
}
