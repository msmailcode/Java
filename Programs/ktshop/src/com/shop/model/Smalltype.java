package com.shop.model;

/**
 * Smalltype entity. @author MyEclipse Persistence Tools
 */
public class Smalltype extends AbstractSmalltype implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public Smalltype() {
	}

	/** full constructor */
	public Smalltype(Integer bigtypeid, String smalltypename) {
		super(bigtypeid, smalltypename);
	}

}
