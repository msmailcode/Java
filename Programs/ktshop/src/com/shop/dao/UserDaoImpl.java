package com.shop.dao;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.model.User;
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

			
/***保存 User实例* @paramUser 需要保存的User实例*/
public void addUser(User User){
	this.getHibernateTemplate().save(User);
	}

/***删除 User实例* @param User需要删除的User实例*/
public void delete(User User){
	this.getHibernateTemplate().delete(User);
	}
/***根据用户名查找 User* @paramname 用户名*@return 用户名对应的全部用户*/
@SuppressWarnings("unchecked")
public List<User> findByUser(String username){
return  this.getHibernateTemplate().find("from User u where u.username='"+ username + "'");
}
/***返回全部的 User 实例*@return 全部的 User 实例*/

@SuppressWarnings("unchecked")
public List<User> getUsers(){
    return this.getHibernateTemplate().find("from User");
}

/**食加载 User实例* @paramid 需要加载User实例的主键值*@return 返回加载的 User 实例*/
public User getUser(Integer id) {
	return this.getHibernateTemplate().get(User.class, new Integer(id));
}

/***修改 User实例* @paramUser 需要修改的User实例*/
public void modifyUser(User user) {
	this.getHibernateTemplate().update(user);
	
}


/***删除 User实例* @param id 需要删除的User id*/
public void deleteUser(Integer id) {
	this.getHibernateTemplate().delete(this.getHibernateTemplate().get(User.class, new Integer(id)));
	
}

@SuppressWarnings("unchecked")
public List<User> query(final String hql, final int startRow,final int pageSize) {
    List<User> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
        public Object doInHibernate(Session session)throws HibernateException, SQLException {
             Query query = session.createQuery(hql);
             query.setFirstResult(startRow);
             query.setMaxResults(pageSize);
             List<User> list = query.list();           
             return list;
             }});
    return list;
}

public int getTotalRows(String hql) {
    return this.getHibernateTemplate().find(hql).size();
}

@SuppressWarnings("unchecked")
public User Login(User user) {


    List<User> list = getHibernateTemplate().find(
        "from User u where u.username='"
        + user.getUsername() 
        + "' and u.password = '" 
        + user.getPassword()
        + "'");

   if (list != null && list.size() == 1) {
          return (User) list.get(0);
   } else {
         return null;
   }
}

public User find(String username, String password) {
	// TODO Auto-generated method stub
	return null;
}




}
    
 




	