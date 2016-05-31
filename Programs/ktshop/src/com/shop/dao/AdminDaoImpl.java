package com.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.model.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	
	public Admin Login(Admin admin) {


	    @SuppressWarnings("unchecked")
		List<Admin> list = getHibernateTemplate().find(
	        "from Admin a where a.adminname='"
	        + admin.getAdminname() 
	        + "' and a.password = '" 
	        + admin.getPassword()
	        + "'");

	   if (list != null && list.size() == 1) {
	          return list.get(0);
	   } else {
	         return null;
	   }
	}
}
