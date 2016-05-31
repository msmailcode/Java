package com.shop.model;

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
public class News extends AbstractNews implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String title, String author, String newstype, String pic,Integer recommend,
			String content, String cc, Timestamp publicdatetime, Integer visit) {
		super();
	}

}
