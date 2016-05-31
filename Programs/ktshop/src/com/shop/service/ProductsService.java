package com.shop.service;

import java.util.List;

import com.shop.model.Products;
import com.shop.page.PageBean;

public interface ProductsService {
	void addProducts(Products products);
	List<Products> getProducts();
	PageBean getProducts2(String fieldname,String value,int pageSize, int page);
	Products getProduct(Integer id);
	void modifyProduct(Products products);
	void delteteProduct (Integer id);
	PageBean listTypeProducts(String smallcategory, int pageSize, int page);
	PageBean listTypeProducts2(String bigcategory, int pageSize, int page);
	PageBean getProducts8(String fieldname, String value, int pageSize, int page);
	PageBean getProducts9(String fieldname, String value, int pageSize, int page);
}
