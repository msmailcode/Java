package com.shop.model;

import java.sql.Timestamp;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
public class Order extends AbstractOrder implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Order() {
	}

	public Order(String username, Integer productid, Integer quantity,
			Double totalprice, String payment,String postway, Timestamp orderdatetime,
			Integer ifpay, Integer ifsent) {
		super(username, productid, quantity, totalprice, payment,postway,
				orderdatetime, ifpay, ifsent);
		// TODO Auto-generated constructor stub
	}

}
