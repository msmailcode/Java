package com.shop.service;

import java.util.List;

import com.shop.dao.BigtypeDao;
import com.shop.model.Bigtype;

public class BigtypeServiceImpl implements BigtypeService, BigtypeDao {
	private BigtypeDao bigtypeDao;

	public void addBigtype(Bigtype bigtype) {
		bigtypeDao.addBigtype(bigtype);

	}

	public List<Bigtype> getBigtypes() {
		return (List<Bigtype>) bigtypeDao.getBigtypes();
	}
	public List<Bigtype> getAll() {
	
		List<Bigtype> all=bigtypeDao.getAll();
		return all;
	}

	public void setBigtypeDao(BigtypeDao bigtypeDao) {
		this.bigtypeDao = bigtypeDao;
	}

	public BigtypeDao getBigtypeDao() {
		return bigtypeDao;
	}

}
