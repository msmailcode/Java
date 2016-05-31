package com.shop.model;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
public class Admin extends AbstractAdmin implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String adminname, String password) {
		super(adminname, password);
	}

}
