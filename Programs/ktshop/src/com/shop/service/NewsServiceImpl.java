package com.shop.service;

import java.util.List;

import com.shop.dao.NewsDao;
import com.shop.model.News;
import com.shop.page.PageBean;

public  class NewsServiceImpl implements NewsService {
	private NewsDao newsDao;

	public void addnews(News news) {
		newsDao.addnews(news);

	}


	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}


	public News getNew(Integer id) {
	    return newsDao.getNew(id);
	}

	public PageBean query(String fieldname, String value, int pageSize, int page) {
		 String hql="";
			if(fieldname==null||fieldname.equals("")||value==null||value.equals("")){
				
			 hql="from News News order by News.id desc";	}
			 else{
			 hql="from News News where News."+fieldname+" = '"+value+"'"+"order by News.id desc";}
			 
			int totalRows = newsDao.getTotalRows(hql); 
			int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
			final int startRow = PageBean.startRowSet(pageSize, page);  
			final int currentPage = PageBean.countCurrentPage(page);
			List<News> list = newsDao.query(hql, startRow, pageSize);
			PageBean  pageBean = new PageBean(); 
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalRows(totalRows);
	        pageBean.setTotalPages(totalPages);
	        pageBean.setList4(list);
	        pageBean.init();
	        
			return  pageBean;
	}

}
