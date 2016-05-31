package com.shop.service;

import java.util.List;

import com.shop.model.Order;
import com.shop.page.PageBean;

public interface OrderService {
void addOrder(Order order);
List<Order> getOrder();
PageBean getOrder2(String fieldname,String value,int pageSize, int page);

}
