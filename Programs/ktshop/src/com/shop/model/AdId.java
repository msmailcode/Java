package com.shop.model;

import java.sql.Timestamp;

/**
 * AdId entity. @author MyEclipse Persistence Tools
 */
public class AdId extends AbstractAdId implements java.io.Serializable {
	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public AdId() {
	}

	/** minimal constructor */
	public AdId(Integer id) {
		super(id);
	}

	/** full constructor */
	public AdId(Integer id, String title, String pic, String remark,String url,
			Timestamp inputdatetime) {
		super(id, title, pic, remark,url, inputdatetime);
	}

}
