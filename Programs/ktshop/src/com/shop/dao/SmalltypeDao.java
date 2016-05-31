package com.shop.dao;

import java.util.List;

import com.shop.model.Smalltype;

public interface SmalltypeDao {
	void addSmalltype(Smalltype smalltype);
	  List<Smalltype> getSmalltypes();
	  List<Smalltype> query(final String hql);
}
