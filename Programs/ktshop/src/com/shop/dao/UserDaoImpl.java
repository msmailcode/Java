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

			
/***���� Userʵ��* @paramUser ��Ҫ�����Userʵ��*/
public void addUser(User User){
	this.getHibernateTemplate().save(User);
	}

/***ɾ�� Userʵ��* @param User��Ҫɾ����Userʵ��*/
public void delete(User User){
	this.getHibernateTemplate().delete(User);
	}
/***�����û������� User* @paramname �û���*@return �û�����Ӧ��ȫ���û�*/
@SuppressWarnings("unchecked")
public List<User> findByUser(String username){
return  this.getHibernateTemplate().find("from User u where u.username='"+ username + "'");
}
/***����ȫ���� User ʵ��*@return ȫ���� User ʵ��*/

@SuppressWarnings("unchecked")
public List<User> getUsers(){
    return this.getHibernateTemplate().find("from User");
}

/**ʳ���� Userʵ��* @paramid ��Ҫ����Userʵ��������ֵ*@return ���ؼ��ص� User ʵ��*/
public User getUser(Integer id) {
	return this.getHibernateTemplate().get(User.class, new Integer(id));
}

/***�޸� Userʵ��* @paramUser ��Ҫ�޸ĵ�Userʵ��*/
public void modifyUser(User user) {
	this.getHibernateTemplate().update(user);
	
}


/***ɾ�� Userʵ��* @param id ��Ҫɾ����User id*/
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
    
 




	