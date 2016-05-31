package com.shop.model;

import java.sql.Timestamp;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */
public class Notice extends AbstractNotice implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public Notice() {
	}

	/** full constructor */
	public Notice(String title, String author, String noticetype, String pic,
			String content, Integer recommend, String cc,
			Timestamp publicdatetime, Integer visit) {
		super(title, author, noticetype, pic, content, recommend, cc,
				publicdatetime, visit);
	}

}
