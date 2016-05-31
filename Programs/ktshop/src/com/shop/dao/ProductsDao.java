package com.shop.dao;

import java.util.List;

import com.shop.model.Products;

public interface ProductsDao {
	void addProducts(Products products);
	List<Products> getProducts();
	List<Products> query(final String hql,final int startRow,final int pageSize);
	public int getTotalRows(String hql); 
	Products getProduct(Integer id);
	void deleteProduct(Integer id);
	void modifyProduct(Products products);
	
}
