package com.msmailcode.shop_jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 create table product
(
id int primary key auto_increment not null,
name varchar(255) not null,
description varchar(255) not null,
price double not null,
categoryid int references catetory(id),
stock int not null default 0,
sales int not null default 0,
createtime timestamp not null default CURRENT_TIMESTAMP
)charset=utf8;
 */
public class ProductDao extends BaseDao{
	public boolean addProduct(String name,String description,double price,int categoryId,int stock){
		String sql = "INSERT INTO product (name,description,price,categoryid,stock) values(?,?,?,?,?)";
		List<Object> params =new ArrayList<Object>();
		params.add(name);
		params.add(description);
		params.add(price);
		params.add(categoryId);
		params.add(stock);
		boolean flag = false;
		try {
			flag = db.execute(sql,params);
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			db.close();
		}
		return flag;
	}
	
	public boolean updateProduct(int id,Map<String,Object> map){
		String sql = "UPDATE product SET ";
		List<Object> params =new ArrayList<Object>();
		for(Map.Entry<String,Object> entry : map.entrySet()){
			sql += entry.getKey() + " = ? , ";
			params.add(entry.getValue());
		}
		sql = sql.substring(0,sql.length()-2);
		sql += "WHERE id = ?";
		params.add(id);
		boolean flag = false;
		try {
			flag = db.execute(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return flag;
	}
	
	public boolean updateProducts(int id,int minus){
		List<Object> params =new ArrayList<Object>();
		String sql = "UPDATE product SET stock = stock-? WHERE id = ?";
		params.add(minus);
		params.add(id);
		boolean flag = false;
		try {
			flag = db.execute(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return flag;
	}
	
	public double getPrice(int id){
		String sql = "SELECT price FROM product WHERE id = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(id);
		double price = 0;
		try {
			price = (double) db.queryResult(sql, params).get("price");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}		
		return price;
	}
}
