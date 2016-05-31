package com.shop.service;
import java.util.List;
import com.shop.model.User;
import com.shop.page.PageBean;
public interface UserService {
	void addUser(User user);
	List<User> getUsers();
	User getUser(Integer id);
	void modifyUser(User user);
	void delteteUser (Integer id);
	List<User> getUsers2();
	List<User> getUser2(int i, int page);
	PageBean getUser3(String fieldname,String value,int pageSize, int page);
	public boolean isLogin(String username,String password);
	public User Login(User user); 
	public List<User> findByUser(String username);

}
