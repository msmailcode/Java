package com.shop.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport; 

import com.shop.model.User;
public  class UserDaoImpl3 extends HibernateDaoSupport implements UserDao{
public void addUser(User user) {
  try{
		
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
	setHibernateTemplate(new HibernateTemplate(sessionFactory));
	getHibernateTemplate().saveOrUpdate(user);					
	}
	catch(Exception e){
      e.printStackTrace();
	}

	}
public User Login(User user) {
	// TODO Auto-generated method stub
	return null;
}
public void deleteUser(Integer id) {
	// TODO Auto-generated method stub
	
}
public int getTotalRows(String hql) {
	// TODO Auto-generated method stub
	return 0;
}
public User getUser(Integer id) {
	// TODO Auto-generated method stub
	return null;
}
public List<User> getUsers() {
	// TODO Auto-generated method stub
	return null;
}
public void modifyUser(User user) {
	// TODO Auto-generated method stub
	
}
public List<User> query(String hql, int startRow, int pageSize) {
	// TODO Auto-generated method stub
	return null;
}
public User find(String username, String password) {
	// TODO Auto-generated method stub
	return null;
}
public List<User> findByUser(String name) {
	// TODO Auto-generated method stub
	return null;
}


	
}
	





