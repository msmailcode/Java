package com.shop.model;

import java.sql.Timestamp;

/**
 * AbstractAdId entity provides the base persistence definition of the AdId
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String pic;
	private String url;
	private String remark;
	private Timestamp inputdatetime;

	// Constructors

	/** default constructor */
	public AbstractAdId() {
	}

	/** minimal constructor */
	public AbstractAdId(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractAdId(Integer id, String title, String pic, String url,
			String remark, Timestamp inputdatetime) {
		this.id = id;
		this.title = title;
		this.pic = pic;
		this.url = url;
		this.remark = remark;
		this.inputdatetime = inputdatetime;
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

	public Timestamp getInputdatetime() {
		return this.inputdatetime;
	}

	public void setInputdatetime(Timestamp inputdatetime) {
		this.inputdatetime = inputdatetime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractAdId))
			return false;
		AbstractAdId castOther = (AbstractAdId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getTitle() == castOther.getTitle()) || (this
						.getTitle() != null && castOther.getTitle() != null && this
						.getTitle().equals(castOther.getTitle())))
				&& ((this.getPic() == castOther.getPic()) || (this.getPic() != null
						&& castOther.getPic() != null && this.getPic().equals(
						castOther.getPic())))
				&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
						&& castOther.getUrl() != null && this.getUrl().equals(
						castOther.getUrl())))
				&& ((this.getRemark() == castOther.getRemark()) || (this
						.getRemark() != null && castOther.getRemark() != null && this
						.getRemark().equals(castOther.getRemark())))
				&& ((this.getInputdatetime() == castOther.getInputdatetime()) || (this
						.getInputdatetime() != null
						&& castOther.getInputdatetime() != null && this
						.getInputdatetime()
						.equals(castOther.getInputdatetime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getTitle() == null ? 0 : this.getTitle().hashCode());
		result = 37 * result
				+ (getPic() == null ? 0 : this.getPic().hashCode());
		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		result = 37 * result
				+ (getRemark() == null ? 0 : this.getRemark().hashCode());
		result = 37
				* result
				+ (getInputdatetime() == null ? 0 : this.getInputdatetime()
						.hashCode());
		return result;
	}

}