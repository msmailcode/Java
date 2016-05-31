package com.shop.dao;
import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import com.shop.model.HibernateSessionFactory;
import com.shop.model.User;
public  class UserDaoImpl2 implements UserDao{
Session session = HibernateSessionFactory.getSession();
Transaction tx = session.beginTransaction();
		
public void addUser(User user) {
  try{	    
	  tx.begin();
  	  session.save(user);
	  tx.commit();						
	}
	catch(Exception e){
          e.printStackTrace();
	}
	}

@SuppressWarnings("unchecked")
public List<User> getUsers() {
	// TODO Auto-generated method stub
	Query q=session.createQuery("from User");
    tx.commit();	
    List<User> list=q.list();
    return (List<User>) list;
}

public User getUser(Integer id) {
	User user=(User)session.get(User.class,(Serializable) id);
	return  user;
}

public void modifyUser(User user) {
	tx.begin();
	session.update(user);
	tx.commit();		
	
}

public void deleteUser(Integer id) {
try{
	User user=(User)session.get(User.class,(Serializable) id);
	tx.begin();
	session.delete(user);
	tx.commit();				
	}
	catch(Exception e){
	      e.printStackTrace();
	}
	}


@SuppressWarnings("unchecked")
public User find(String username,String password) { 
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction();
	tx.begin();
	  String sql = "FROM User AS u WHERE u.username = ? AND u.password = ?"; 
	  Query q = session.createQuery(sql); 
	  q.setString(0, username); 
	  q.setString(1, password);   
	  List<User> list = q.list(); 
	  tx.commit();	
	  session.close(); 
	  if (list.size()==0){ 
	   return null; 
	  }else{ 
	   return list.get(0); 
	  } 
}

public List<User> find2(String username, Integer password) {
	// TODO Auto-generated method stub
	return null;
}

public User Login(User user) {
	// TODO Auto-generated method stub
	return null;
}

public int getTotalRows(String hql) {
	// TODO Auto-generated method stub
	return 0;
}

public List<User> query(String hql, int startRow, int pageSize) {
	// TODO Auto-generated method stub
	return null;
}

public List<User> findByUser(String name) {
	// TODO Auto-generated method stub
	return null;
}


}
	





