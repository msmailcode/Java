package com.msmailcode.javawebshop.dao.order;

import com.msmailcode.javawebshop.dao.BaseDao;
import com.msmailcode.javawebshop.model.order.Order;

public interface OrderDao extends BaseDao<Order> {
	public Order findByCustomer(int customerId);
}
