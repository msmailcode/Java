package com.shop.service;

import java.util.List;

import com.shop.dao.NoticeDao;
import com.shop.model.Notice;
import com.shop.page.PageBean;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDao noticeDao;

	public void addnotice(Notice notice) {
		noticeDao.addnotice(notice);

	}


	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}


	public Notice getNotice(Integer id) {
	    return noticeDao.getNotice(id);
	}

	public PageBean query(String fieldname, String value, int pageSize, int page) {
		 String hql="";
			if(fieldname==null||fieldname.equals("")||value==null||value.equals("")){
				
			 hql="from Notice Notice order by Notice.id desc";	}
			 else{
			 hql="from Notice Notice where Notice."+fieldname+" = '"+value+"'"+"order by Notice.id desc";}
			 
			int totalRows = noticeDao.getTotalRows(hql); 
			int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
			final int startRow = PageBean.startRowSet(pageSize, page);  
			final int currentPage = PageBean.countCurrentPage(page);
			List<Notice> list = noticeDao.query(hql, startRow, pageSize);
			PageBean  pageBean = new PageBean(); 
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalRows(totalRows);
	        pageBean.setTotalPages(totalPages);
	        pageBean.setList10(list);
	        pageBean.init();
	        
			return  pageBean;
	}



}
