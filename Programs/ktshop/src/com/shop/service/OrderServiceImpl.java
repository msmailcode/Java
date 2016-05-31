package com.shop.service;

import java.util.List;

import com.shop.dao.OrderDao;
import com.shop.model.Order;
import com.shop.page.PageBean;

public class OrderServiceImpl implements OrderService {
private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void addOrder(Order order) {
		
		orderDao.addOrder(order);

	}

	public List<Order> getOrder() {
		return orderDao.getOrder();
	}

	public PageBean getOrder2(String fieldname, String value, int pageSize,
			int page) {
		String hql="";
		if(fieldname==null||fieldname.equals("")||value==null||value.equals("")){
			
		 hql="from Order Order order by Order.id";	}
		 else{
		 hql="from Order Order where Order."+fieldname+" = '"+value+"'"+"order by Order.id";}
		 
		int totalRows = orderDao.getTotalRows(hql); 
		int totalPages =PageBean.countTotalPages(pageSize, totalRows);    
		final int startRow = PageBean.startRowSet(pageSize, page);  
		final int currentPage = PageBean.countCurrentPage(page);
		List<Order> list = (List<Order>) orderDao.query(hql, startRow, pageSize);
		PageBean  pageBean = new PageBean(); 
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalRows(totalRows);
        pageBean.setTotalPages(totalPages);
        pageBean.setList6(list);
        pageBean.init();
        
		return  pageBean;
	}

	

}
