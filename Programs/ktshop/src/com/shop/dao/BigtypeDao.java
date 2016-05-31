package com.shop.dao;

import java.util.List;

import com.shop.model.Bigtype;

public interface BigtypeDao {
	void addBigtype(Bigtype Bigtype);
	  List<Bigtype> getBigtypes();
	List<Bigtype> getAll();

}
