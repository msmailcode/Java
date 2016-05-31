package javabean;

public class OrderDetail {
	
	private int id;
	private int bookid;
	private int orderid;
	private int number;
	private float totalprice;
	public OrderDetail(int id, int bookid, int orderid, int number, float totalprice) {
		this.id = id;
		this.bookid = bookid;
		this.orderid = orderid;
		this.number = number;
		this.totalprice = totalprice;
	}
	public OrderDetail() {
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
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
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
}
