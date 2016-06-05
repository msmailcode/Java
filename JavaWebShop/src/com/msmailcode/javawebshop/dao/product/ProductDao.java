package com.msmailcode.javawebshop.dao.product;

import java.util.List;

import com.msmailcode.javawebshop.dao.BaseDao;
import com.msmailcode.javawebshop.model.product.ProductInfo;

public interface ProductDao extends BaseDao<ProductInfo>{
	public List<ProductInfo> findCommend();
	public List<ProductInfo> findClickcount();
	public List<ProductInfo> findSellCount();
}
