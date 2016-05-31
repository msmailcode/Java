package com.shop.model;

/**
 * AbstractAd entity provides the base persistence definition of the Ad entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractAd implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;

	// Constructors

	/** default constructor */
	public AbstractAd() {
	}

	/** full constructor */
	public AbstractAd(Integer id) {
		this.id = id;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}