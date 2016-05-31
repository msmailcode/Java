package com.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.model.Bigtype;

public class BigtypeDaoImpl extends HibernateDaoSupport implements BigtypeDao {

	public void addBigtype(Bigtype bigtype) {
		this.getHibernateTemplate().save(bigtype);

	}

	@SuppressWarnings("unchecked")
	public List<Bigtype> getBigtypes() {
		 return this.getHibernateTemplate().find("from Bigtype Bigtype order by Bigtype.id asc");
	}

	@SuppressWarnings("unchecked")
	public List<Bigtype> getAll() {
		String hql="FROM Bigtype AS bigtype";
		List<Bigtype> all=super.getSession().createQuery(hql).list();
		return all;
	}

}
