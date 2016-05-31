package com.shop.model;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Integer id, String username, String password, Integer sex,
			String education, String job, String friends, String picture,
			String message, String hobby, Timestamp regdatetime) {
		super();
	}

}
