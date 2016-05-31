package com.shop.model;

import java.util.Date;

/**
 * AbstractProducts entity provides the base persistence definition of the
 * Products entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProducts implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productname;
	private String bigcategory;
	private String smallcategory;
	private String pic;
	private Double price;
	private String introduce;
	private String parameter;
	private Integer recommend;
	private Date regdatetime;

	// Constructors

	/** default constructor */
	public AbstractProducts() {
	}

	/** full constructor */
	public AbstractProducts(String productname, String bigcategory,
			String smallcategory, String pic, Double price, String introduce,
			String parameter, Integer recommend, Date regdatetime) {
		this.productname = productname;
		this.bigcategory = bigcategory;
		this.smallcategory = smallcategory;
		this.pic = pic;
		this.price = price;
		this.introduce = introduce;
		this.parameter = parameter;
		this.recommend = recommend;
		this.regdatetime = regdatetime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getBigcategory() {
		return this.bigcategory;
	}

	public void setBigcategory(String bigcategory) {
		this.bigcategory = bigcategory;
	}

	public String getSmallcategory() {
		return this.smallcategory;
	}

	public void setSmallcategory(String smallcategory) {
		this.smallcategory = smallcategory;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getParameter() {
		return this.parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public Integer getRecommend() {
		return this.recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Date getRegdatetime() {
		return this.regdatetime;
	}

	public void setRegdatetime(Date date) {
		this.regdatetime = (Date) date;
	}

}