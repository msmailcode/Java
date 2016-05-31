package com.shop.model;

import java.util.HashSet;
import java.util.Set;


/**
 * AbstractBigtype entity provides the base persistence definition of the
 * Bigtype entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBigtype implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bigtypeid;
	private String bigtypename;
	private Set<Smalltype> smalltypes = new HashSet<Smalltype>(0);


	// Constructors

	/** default constructor */
	public AbstractBigtype() {
	}

	/** full constructor */
	public AbstractBigtype(String bigtypename) {
		this.bigtypename = bigtypename;
	}

	// Property accessors

	public Integer getBigtypeid() {
		return this.bigtypeid;
	}

	public void setBigtypeid(Integer bigtypeid) {
		this.bigtypeid = bigtypeid;
	}

	public String getBigtypename() {
		return this.bigtypename;
	}

	public void setBigtypename(String bigtypename) {
		this.bigtypename = bigtypename;
	}

	public Set<Smalltype> getSmalltypes() {
		return smalltypes;
	}

	public void setSmalltypes(Set<Smalltype> smalltypes) {
		this.smalltypes = smalltypes;
	}

}