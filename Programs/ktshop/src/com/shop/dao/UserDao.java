package com.shop.dao;
import java.util.List;

import com.shop.model.User;
public interface UserDao {
	void addUser(User user);
	  List<User> getUsers();
	  User getUser(Integer id);
void modifyUser(User user);
void deleteUser(Integer id);
List<User> query(final String hql,final int startRow,final int pageSize);
public int getTotalRows(String hql); 
public User Login(User user);
User find(String username, String password); 
public List<User> findByUser(String username);
}
