package com.shop.service;

import java.util.List;

import com.shop.dao.SmalltypeDao;
import com.shop.model.Smalltype;

public class SmalltypeServiceImpl implements SmalltypeService{
	private SmalltypeDao smalltypeDao;
	public void addSmalltype(Smalltype smalltype) {
		smalltypeDao.addSmalltype(smalltype);

	}

	public List<Smalltype> getSmalltypes() {
		return (List<Smalltype>) smalltypeDao.getSmalltypes();
	}

	public void setSmalltypeDao(SmalltypeDao smalltypeDao) {
		this.smalltypeDao = smalltypeDao;
	}

	public SmalltypeDao getSmalltypeDao() {
		return smalltypeDao;
	}

	public List<Smalltype> query(int id) {
		 String hql = "from Smalltype as s where s.bigtypeid="+id;
		 return (List<Smalltype>) smalltypeDao.query(hql);	  
	
		

		
	}
	


	

	
}
