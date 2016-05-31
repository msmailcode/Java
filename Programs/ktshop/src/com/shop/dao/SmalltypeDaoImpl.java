package com.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.model.Smalltype;

public class SmalltypeDaoImpl extends HibernateDaoSupport implements SmalltypeDao {

	public void addSmalltype(Smalltype smalltype) {
		this.getHibernateTemplate().save(smalltype);

	}

	@SuppressWarnings("unchecked")
	public List<Smalltype> getSmalltypes() {
		 return this.getHibernateTemplate().find("from Smalltype");
	}



	@SuppressWarnings("unchecked")
	public List<Smalltype> query(final String hql) {
		 return this.getHibernateTemplate().find(hql);
	}


}
