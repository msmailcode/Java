package com.shop.service;

import java.util.List;

import com.shop.model.Bigtype;

public interface BigtypeService {
	void addBigtype(Bigtype bigtype);
	  List<Bigtype> getBigtypes();
	List<Bigtype> getAll();

}
