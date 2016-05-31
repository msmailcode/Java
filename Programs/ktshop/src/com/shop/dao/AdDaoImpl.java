package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.shop.model.Ad;

public class AdDaoImpl  extends HibernateDaoSupport implements AdDao {

	public void addAd(Ad ad) {
		this.getHibernateTemplate().save(ad);
	}

	@SuppressWarnings("unchecked")
	public List<Ad> query(final String hql, final int startRow, final int pageSize) {
	    List<Ad> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
	        public Object doInHibernate(Session session)throws HibernateException, SQLException {
	             Query query = session.createQuery(hql);
	             query.setFirstResult(startRow);
	             query.setMaxResults(pageSize);
	             List<Ad> list = query.list();           
	             return list;
	             }});
	    return list;
	}
	public Ad getAd(Integer id) {
		return this.getHibernateTemplate().get(Ad.class, new Integer(id));
	}

	public int getTotalRows(String hql) {
	    return this.getHibernateTemplate().find(hql).size();
	}

	public void modifyAd(Ad ad) {
		this.getHibernateTemplate().update(ad);		
	}

	public void deleteAd(Integer id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Ad.class, new Integer(id)));		
	}
	
}
