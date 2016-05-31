package com.shop.model;

import java.util.Date;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */
public class Ad extends AbstractAd implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String pic;
	private String url;
	private String remark;
	private Date inputdatetime;

	/** default constructor */
	public Ad() {
	}

	/** full constructor */
	public Ad(Integer id, String title, String pic, String remark,
			Date inputdatetime) {
		super();
	}

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

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getInputdatetime() {
		return this.inputdatetime;
	}

	public void setInputdatetime(Date date) {
		this.inputdatetime = (Date) date;
	}
}
