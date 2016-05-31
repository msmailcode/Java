package com.shop.service;

import java.util.List;

import com.shop.dao.AdDao;
import com.shop.model.Ad;
import com.shop.page.PageBean;

public class AdServiceImpl implements AdService {
	private AdDao adDao;

	public void addAd(Ad ad) {
		adDao.addAd(ad);

	}


	public void setAdDao(AdDao AdDao) {
		this.adDao = AdDao;
	}

	public AdDao getAdDao() {
		return adDao;
	}


	public Ad getAd(Integer id) {
	    return adDao.getAd(id);
	}

	public PageBean query(String fieldname, String value, int pageSize, int page) {
		 String hql="";
			if(fieldname==null||fieldname.equals("")||value==null||value.equals("")){
				
			 hql="from Ad Ad order by Ad.id desc";	}
			 else{
			 hql="from Ad Ad where Ad."+fieldname+" = '"+value+"'"+"order by Ad.id desc";}
			 
			int totalRows = adDao.getTotalRows(hql); 
			int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
			final int startRow = PageBean.startRowSet(pageSize, page);  
			final int currentPage = PageBean.countCurrentPage(page);
			List<Ad> list = adDao.query(hql, startRow, pageSize);
			PageBean  pageBean = new PageBean(); 
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalRows(totalRows);
	        pageBean.setTotalPages(totalPages);
	        pageBean.setList11(list);
	        pageBean.init();
	        
			return  pageBean;
	}


	public void modifyAd(Ad ad) {
		adDao.modifyAd(ad);
		
	}


	public void delteteAd(Integer id) {
		 adDao.deleteAd(id);	
		
	}
}
