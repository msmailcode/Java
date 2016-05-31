package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.model.Notice;

public class NoticeDaoImpl  extends HibernateDaoSupport implements NoticeDao {

	public void addnotice(Notice notice) {
		this.getHibernateTemplate().save(notice);

	}

	@SuppressWarnings("unchecked")
	public List<Notice> query(final String hql, final int startRow, final int pageSize) {
	    List<Notice> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
	        public Object doInHibernate(Session session)throws HibernateException, SQLException {
	             Query query = session.createQuery(hql);
	             query.setFirstResult(startRow);
	             query.setMaxResults(5);
	             List<Notice> list = query.list();           
	             return list;
	             }});
	    return list;
	}
	public Notice getNotice(Integer id) {
		return this.getHibernateTemplate().get(Notice.class, new Integer(id));
	}

	public int getTotalRows(String hql) {
	    return this.getHibernateTemplate().find(hql).size();
	}



}
