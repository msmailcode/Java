package com.shop.dao;

import java.util.List;

import com.shop.model.Notice;

public interface NoticeDao {
	void addnotice(Notice notice);
	List<Notice> query(final String hql,final int startRow,final int pageSize);
	public int getTotalRows(String hql); 
	Notice getNotice(Integer id);
	

}
