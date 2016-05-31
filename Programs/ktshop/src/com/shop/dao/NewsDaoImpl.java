package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.model.News;

public class NewsDaoImpl  extends HibernateDaoSupport implements NewsDao {

	public void addnews(News news) {
		this.getHibernateTemplate().save(news);

	}

	@SuppressWarnings("unchecked")
	public List<News> query(final String hql, final int startRow, final int pageSize) {
	    List<News> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
	        public Object doInHibernate(Session session)throws HibernateException, SQLException {
	             Query query = session.createQuery(hql);
	             query.setFirstResult(startRow);
	             query.setMaxResults(pageSize);
	             List<News> list = query.list();           
	             return list;
	             }});
	    return list;
	}
	public News getNew(Integer id) {
		return this.getHibernateTemplate().get(News.class, new Integer(id));
	}

	public int getTotalRows(String hql) {
	    return this.getHibernateTemplate().find(hql).size();
	}



}
