package com.shop.dao;

import java.util.List;

import com.shop.model.News;

public interface NewsDao {
	void addnews(News news);
	List<News> query(final String hql,final int startRow,final int pageSize);
	public int getTotalRows(String hql); 
	News getNew(Integer id);
	

}
