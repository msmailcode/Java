package com.shop.model;

import java.sql.Timestamp;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */
public class Products extends AbstractProducts implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public Products() {
	}

	/** full constructor */
	public Products(Integer id, String productname, String bigcategory,
			String smallcategory, String pic, Double price, Integer recommend,
			String introduce, Timestamp regdatetime) {
		super();
	}

}
