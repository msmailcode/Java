package com.shop.dao;

import java.util.List;

import com.shop.model.Order;

public interface OrderDao {
void addOrder(Order order);
List<Order> getOrder();
List<Order> query(final String hql,final int startRow,final int pageSize);
int getTotalRows(String hql);

}
