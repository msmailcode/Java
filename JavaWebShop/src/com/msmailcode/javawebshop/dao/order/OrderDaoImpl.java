package com.msmailcode.javawebshop.dao.order;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.msmailcode.javawebshop.dao.DaoSupport;
import com.msmailcode.javawebshop.model.order.Order;
@Repository("orderDao")
@Transactional
public class OrderDaoImpl extends DaoSupport<Order> implements OrderDao {


	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Order findByCustomer(int customerId) {
		String where = "where customer.id = ?";
		Object[] queryParams = {customerId};
		List<Order> list = find(-1, -1, where, queryParams).getList();
		return list.get(0);
	}

}
