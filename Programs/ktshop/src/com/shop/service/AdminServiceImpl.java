package com.shop.service;

import com.shop.dao.AdminDao;
import com.shop.model.Admin;

public class AdminServiceImpl implements AdminService {
private AdminDao adminDao;

	public AdminDao getAdminDao() {
	return adminDao;
}

public void setAdminDao(AdminDao adminDao) {
	this.adminDao = adminDao;
}

	public Admin Login(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.Login(admin);
	}


}
