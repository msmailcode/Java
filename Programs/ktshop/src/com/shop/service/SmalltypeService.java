package com.shop.service;

import java.util.List;

import com.shop.model.Smalltype;

public interface SmalltypeService {
	void addSmalltype(Smalltype smalltype);
	  List<Smalltype> getSmalltypes();
	  List<Smalltype> query(int id);
}
