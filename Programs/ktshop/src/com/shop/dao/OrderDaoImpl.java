package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shop.model.Order;
import com.shop.model.Products;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {
public void addOrder(Order order) {
		this.getHibernateTemplate().save(order);
	}

@SuppressWarnings("unchecked")
public List<Order> getOrder() {
	  return this.getHibernateTemplate().find("from order");
}

public List<Order> query(final String hql, final int startRow, final int pageSize) {
	  @SuppressWarnings("unchecked")
	List<Order> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
	        public Object doInHibernate(Session session)throws HibernateException, SQLException {
	             Query query = session.createQuery(hql);
	             query.setFirstResult(startRow);
	             query.setMaxResults(pageSize);
	             List<Products> list = query.list();           
	             return list;
	             }});
	    return list;
}

public int getTotalRows(String hql) {
    return this.getHibernateTemplate().find(hql).size();
}

}
