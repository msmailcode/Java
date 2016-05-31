package com.shop.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractOrder entity provides the base persistence definition of the Order
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private Integer productid;
	private Integer quantity;
	private Double totalprice;
	private String payment;
	private String postway;
	private Date orderdatetime;
	private Integer ifpay;
	private Integer ifsent;

	// Constructors

	/** default constructor */
	public AbstractOrder() {
	}

	/** full constructor */
	public AbstractOrder(String username, Integer productid, Integer quantity,
			Double totalprice, String payment, String postway,
			Timestamp orderdatetime, Integer ifpay, Integer ifsent) {
		this.username = username;
		this.productid = productid;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.payment = payment;
		this.postway = postway;
		this.orderdatetime = orderdatetime;
		this.ifpay = ifpay;
		this.ifsent = ifsent;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPostway() {
		return this.postway;
	}

	public void setPostway(String postway) {
		this.postway = postway;
	}

	public Date getOrderdatetime() {
		return this.orderdatetime;
	}

	public void setOrderdatetime(Date orderdatetime) {
		this.orderdatetime = orderdatetime;
	}

	public Integer getIfpay() {
		return this.ifpay;
	}

	public void setIfpay(Integer ifpay) {
		this.ifpay = ifpay;
	}

	public Integer getIfsent() {
		return this.ifsent;
	}

	public void setIfsent(Integer ifsent) {
		this.ifsent = ifsent;
	}

}