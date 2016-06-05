package com.msmailcode.javawebshop.dao.user;

import com.msmailcode.javawebshop.dao.BaseDao;
import com.msmailcode.javawebshop.model.user.User;

public interface UserDao extends BaseDao<User> {
	public User login(String username, String password);
	public boolean isUnique(String username);
}
