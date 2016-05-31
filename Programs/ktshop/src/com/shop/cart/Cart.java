package com.shop.cart;

public class Cart implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productid;
	private String productname;
	private Double price;
	private int quantity;
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductname() {
		return productname;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice() {
		return price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}

	public void addQuantity() {
		++quantity;
		}


}
