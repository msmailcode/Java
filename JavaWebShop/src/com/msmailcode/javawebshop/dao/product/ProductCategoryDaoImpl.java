package com.msmailcode.javawebshop.dao.product;

import org.springframework.stereotype.Repository;

import com.msmailcode.javawebshop.dao.DaoSupport;
import com.msmailcode.javawebshop.model.product.ProductCategory;
@Repository("productCategoryDao")
public class ProductCategoryDaoImpl extends DaoSupport<ProductCategory> implements ProductCategoryDao {

}
