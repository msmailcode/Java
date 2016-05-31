package com.shop.dao;

import java.util.List;

import com.shop.model.Ad;

public interface AdDao {
	void addAd(Ad ad);
	List<Ad> query(final String hql,final int startRow,final int pageSize);
	public int getTotalRows(String hql); 
	Ad getAd(Integer id);
	void modifyAd(Ad ad);
	void deleteAd(Integer id);
	

}
