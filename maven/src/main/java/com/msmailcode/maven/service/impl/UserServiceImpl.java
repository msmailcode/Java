package com.msmailcode.maven.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.msmailcode.maven.dao.UserDao;
import com.msmailcode.maven.pojo.User;
import com.msmailcode.maven.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	   @Resource  
	    private UserDao userDao;  
	    public User getUserById(int userId) {  
	        return this.userDao.selectByPrimaryKey(userId);  
	    }  

}
