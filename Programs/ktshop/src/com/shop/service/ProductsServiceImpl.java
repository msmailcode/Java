package com.shop.service;

import java.util.List;

import com.shop.dao.ProductsDao;
import com.shop.model.Products;
import com.shop.page.PageBean;

public class ProductsServiceImpl implements ProductsService {
	private ProductsDao productsDao;

	public ProductsDao getProductsDao() {
		return productsDao;
	}	

	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}

	public void addProducts(Products products) {
		
		productsDao.addProducts(products);

	}

	public List<Products> getProducts() {
		return productsDao.getProducts();

	}

		public void delteteProduct(Integer id) {
		    productsDao.deleteProduct(id);		
		}

		public Products getProduct(Integer id) {
			return productsDao.getProduct(id);
		}

		public void modifyProduct(Products products) {
	
			productsDao.modifyProduct(products);
		}

		public PageBean getProducts2(String fieldname,String value,int pageSize, int page) {
			 String hql="";
			if(fieldname==null||fieldname.equals("")||value==null||value.equals("")){
				
			 hql="from Products products order by products.regdatetime desc";	}
			 else{
			 hql="from Products products where products."+fieldname+" = '"+value+"'"+" order by products.regdatetime desc";}
			 
			int totalRows = productsDao.getTotalRows(hql); 
			int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
			final int startRow = PageBean.startRowSet(pageSize, page);  
			final int currentPage = PageBean.countCurrentPage(page);
			List<Products> list = (List<Products>) productsDao.query(hql, startRow, pageSize);
			PageBean  pageBean = new PageBean(); 
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalRows(totalRows);
	        pageBean.setTotalPages(totalPages);
	        pageBean.setList2(list);
	        pageBean.init();
	        
			return  pageBean;

		}

		public PageBean listTypeProducts(String smallcategory,int pageSize, int page) {
			 String hql = "from Products products where products.smallcategory= "+"'"+smallcategory+"'"+"order by products.id asc";
			 
			int totalRows = productsDao.getTotalRows(hql); 
			int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
			final int startRow = PageBean.startRowSet(pageSize, page);  
			final int currentPage = PageBean.countCurrentPage(page);
			List<Products> list = (List<Products>) productsDao.query(hql, startRow, pageSize);
			PageBean  pageBean = new PageBean(); 
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalRows(totalRows);
	        pageBean.setTotalPages(totalPages);
	        pageBean.setList5(list);
	        pageBean.init();
	        
			return  pageBean;

		}

		public PageBean listTypeProducts2(String bigcategory,int pageSize, int page) {
			 String hql = "from Products products where products.bigcategory= "+"'"+bigcategory+"'"+"order by products.id asc";
			 
			int totalRows = productsDao.getTotalRows(hql); 
			int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
			final int startRow = PageBean.startRowSet(pageSize, page);  
			final int currentPage = PageBean.countCurrentPage(page);
			List<Products> list = (List<Products>) productsDao.query(hql, startRow, pageSize);
			PageBean  pageBean = new PageBean(); 
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalRows(totalRows);
	        pageBean.setTotalPages(totalPages);
	        pageBean.setList7(list);
	        pageBean.init();
	        
			return  pageBean;

		}
		
		public PageBean getProducts8(String fieldname,String value,int pageSize, int page) {
			 String hql="";
			if(fieldname==null||fieldname.equals("")||value==null||value.equals("")){
				
			 hql="from Products products where  products.recommend='1' order by products.regdatetime desc";	}
			 else{
			 hql="from Products products where products."+fieldname+" = '"+value+"'"+" order by products.regdatetime desc";}
			 
			int totalRows = productsDao.getTotalRows(hql); 
			int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
			final int startRow = PageBean.startRowSet(pageSize, page);  
			final int currentPage = PageBean.countCurrentPage(page);
			List<Products> list = (List<Products>) productsDao.query(hql, startRow, pageSize);
			PageBean  pageBean = new PageBean(); 
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalRows(totalRows);
	        pageBean.setTotalPages(totalPages);
	        pageBean.setList8(list);
	        pageBean.init();
	        
			return  pageBean;

		}
		
		public PageBean getProducts9(String fieldname,String value,int pageSize, int page) {
			 String hql="";
			if(fieldname==null||fieldname.equals("")||value==null||value.equals("")){
				
			 hql="from Products products order by products.regdatetime desc";	}
			 else{
			 hql="from Products products where products."+fieldname+" = '"+value+"'"+" order by products.regdatetime desc";}
			 
			int totalRows = productsDao.getTotalRows(hql); 
			int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
			final int startRow = PageBean.startRowSet(pageSize, page);  
			final int currentPage = PageBean.countCurrentPage(page);
			List<Products> list = (List<Products>) productsDao.query(hql, startRow, pageSize);
			PageBean  pageBean = new PageBean(); 
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalRows(totalRows);
	        pageBean.setTotalPages(totalPages);
	        pageBean.setList9(list);
	        pageBean.init();
	        
			return  pageBean;

		}
	

}

