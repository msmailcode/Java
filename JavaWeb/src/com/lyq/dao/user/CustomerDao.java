package com.msmailcode.javawebshop.dao.user;

import com.msmailcode.javawebshop.dao.BaseDao;
import com.msmailcode.javawebshop.model.user.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	public Customer login(String username, String password);
	public boolean isUnique(String username);
}
