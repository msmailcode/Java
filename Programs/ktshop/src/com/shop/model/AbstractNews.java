package com.shop.model;

import java.util.Date;

/**
 * AbstractNews entity provides the base persistence definition of the News
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNews implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String author;
	private String newstype;
	private String pic;
	private String content;
	private Integer recommend;
	private String cc;
	private Date publicdatetime;
	private Integer visit;

	// Constructors

	/** default constructor */
	public AbstractNews() {
	}

	/** full constructor */
	public AbstractNews(String title, String author, String newstype,
			String pic, String content, Integer recommend, String cc,
			Date publicdatetime, Integer visit) {
		this.title = title;
		this.author = author;
		this.newstype = newstype;
		this.pic = pic;
		this.content = content;
		this.recommend = recommend;
		this.cc = cc;
		this.publicdatetime = publicdatetime;
		this.visit = visit;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNewstype() {
		return this.newstype;
	}

	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public Integer getRecommend() {
		return this.recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public Date getPublicdatetime() {
		return this.publicdatetime;
	}

	public void setPublicdatetime(Date date) {
		this.publicdatetime = (Date) date;
	}

	public Integer getVisit() {
		return this.visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}

}