package javabean;

public class Cart {
	
	private int bookid;
	private String name;
	private float price;
	private float saleprice;
	private int number;
	private float total;
	public Cart() {
	}
	public Cart(int bookid, String name, float price, float saleprice, int number, float total) {
		this.bookid = bookid;
		this.name = name;
		this.price = price;
		this.saleprice = saleprice;
		this.number = number;
		this.total = total;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
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
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
