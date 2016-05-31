package com.shop.model;

/**
 * AbstractSmalltype entity provides the base persistence definition of the
 * Smalltype entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSmalltype implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer smalltypeid;
	private Integer bigtypeid;
	private String smalltypename;

	// Constructors

	/** default constructor */
	public AbstractSmalltype() {
	}

	/** full constructor */
	public AbstractSmalltype(Integer bigtypeid, String smalltypename) {
		this.bigtypeid = bigtypeid;
		this.smalltypename = smalltypename;
	}

	// Property accessors

	public Integer getSmalltypeid() {
		return this.smalltypeid;
	}

	public void setSmalltypeid(Integer smalltypeid) {
		this.smalltypeid = smalltypeid;
	}

	public Integer getBigtypeid() {
		return this.bigtypeid;
	}

	public void setBigtypeid(Integer bigtypeid) {
		this.bigtypeid = bigtypeid;
	}

	public String getSmalltypename() {
		return this.smalltypename;
	}

	public void setSmalltypename(String smalltypename) {
		this.smalltypename = smalltypename;
	}

}