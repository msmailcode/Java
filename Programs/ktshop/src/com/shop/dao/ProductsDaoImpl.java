package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.model.Products;

public class ProductsDaoImpl extends HibernateDaoSupport implements ProductsDao {

	public void addProducts(Products products) {
		this.getHibernateTemplate().save(products);
	}

	@SuppressWarnings("unchecked")
	public List<Products> getProducts() {
	    return this.getHibernateTemplate().find("from Products");

	}
	
	@SuppressWarnings("unchecked")
	public List<Products> query(final String hql, final int startRow,final int pageSize) {
	    List<Products> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
	        public Object doInHibernate(Session session)throws HibernateException, SQLException {
	             Query query = session.createQuery(hql);
	             query.setFirstResult(startRow);
	             query.setMaxResults(pageSize);
	             List<Products> list = query.list();           
	             return list;
	             }});
	    return list;
	}
	
	public int getTotalRows(String hql) {
	    return this.getHibernateTemplate().find(hql).size();
	}
	
	public Products getProduct(Integer id) {
		return this.getHibernateTemplate().get(Products.class, new Integer(id));
	}

	public void deleteProduct(Integer id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Products.class, new Integer(id)));
		
	}

	public void modifyProduct(Products products) {
		this.getHibernateTemplate().update(products);
		
	}

}
