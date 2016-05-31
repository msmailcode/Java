package com.shop.service;
import java.util.List;

import com.shop.dao.UserDao;
import com.shop.dao.UserDaoImpl2;
import com.shop.model.User;
import com.shop.page.PageBean;
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserDao getUserDao() {
		 return userDao;
		 }
		 public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		 }
	public void addUser(User user) {
		userDao.addUser(user);
		 }


	public List<User> getUsers2(int pageSize,int page) {
		return null;
	
	}
	public List<User> getUsers() {
        
		return (List<User>) userDao.getUsers();
	}

	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	public void modifyUser(User user) {
		userDao.modifyUser(user);		
	}
	
	public void delteteUser(Integer id) {
	    userDao.deleteUser(id);		
	}
	public List<User> getUser2(int i, int page) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<User> getUsers2() {
		// TODO Auto-generated method stub
		return null;
	}
	public PageBean getUser3(String fieldname,String value,int pageSize, int page) {
		 String hql="";
		if(fieldname==null||fieldname.equals("")||value==null||value.equals("")){
			
		 hql="from User user order by user.id asc";	}
		 else{
		 hql="from User user where user."+fieldname+" = '"+value+"'"+"order by user.id asc";}
		 
		int totalRows = userDao.getTotalRows(hql); 
		int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
		final int startRow = PageBean.startRowSet(pageSize, page);  
		final int currentPage = PageBean.countCurrentPage(page);
		List<User> list = (List<User>) userDao.query(hql, startRow, pageSize);
		PageBean  pageBean = new PageBean(); 
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalRows(totalRows);
        pageBean.setTotalPages(totalPages);
        pageBean.setList(list);
        pageBean.init();
        
		return  pageBean;

	}
	
	    //用户名密码是否正确 
	    public boolean isLogin(String username,String password){ 
	    	 boolean isLogin = false; 
	    	 UserDao userDao=new UserDaoImpl2();
	   //User u = usrDao.find(username, password); 	    	 
User u = userDao.find(username,password);
		 if (u != null) 
		    { 
		    isLogin = true; 
		    }
		return isLogin; 

	
	    }
		public User Login(User user) {
			return userDao.Login(user);
		}
		public List<User> findByUser(String username) {
			return userDao.findByUser(username);
		}
	
			
}


