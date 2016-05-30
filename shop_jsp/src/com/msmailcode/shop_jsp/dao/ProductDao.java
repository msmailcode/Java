package com.msmailcode.shop_jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
sales int not null default 0,
createtime timestamp not null default CURRENT_TIMESTAMP,
is_offshelve tinyint(1) not null default 0
)charset=utf8;
 */
public class ProductDao extends BaseDao{
	public static final String PRICE = "price";
	public static final String SALES = "sales";
	public static final String TIME = "createtime";
	
	public boolean addProduct(String name,String description,double price,int categoryId){
		String sql = "INSERT INTO product (name,description,price,categoryid) values(?,?,?,?)";
		List<Object> params =new ArrayList<Object>();
		params.add(name);
		params.add(description);
		params.add(price);
		params.add(categoryId);
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
	
	public String getName(int id){
		String sql = "SELECT name FROM product WHERE id = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(id);
		String name = "";
		try {
			name = (String) db.queryResult(sql, params).get("name");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}		
		return name;
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
	
	public Map<String,Object> getProduct(int id){
		String sql = "SELECT name,description,price,categoryid,sales FROM product WHERE id = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(id);
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			result = db.queryResult(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}		
		return result;
	}
	
	public List<Map<String, Object>> getProducts(int cid){
		String sql = "SELECT * FROM product WHERE categoryid = ? AND is_offshelve = 0 ORDER BY createtime DESC";
		List<Object> params =new ArrayList<Object>();
		params.add(cid);
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		try {
			results = db.queryResults(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return results;
	}
	
	//order=true => ORDER BY DESC
	public List<Map<String, Object>> getProducts(int cid,String column,boolean order){
		String sql = "SELECT * FROM product WHERE categoryid = ? AND is_offshelve = 0 ORDER BY ? ?";
		List<Object> params =new ArrayList<Object>();
		params.add(cid);
		params.add(column);
		params.add(order==true?"DESC":"ASC");
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		try {
			results = db.queryResults(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return results;
	}
	
	public List<Map<String, Object>> getLatest(){
		String sql = "SELECT * FROM product ORDER BY createtime DESC LIMIT 0,3";
		List<Object> params =new ArrayList<Object>();
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		try {
			results = db.queryResults(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return results;
	}
	
	public List<Map<String, Object>> getHot(){
		String sql = "SELECT * FROM product ORDER BY sales DESC LIMIT 0,3";
		List<Object> params =new ArrayList<Object>();
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		try {
			results = db.queryResults(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return results;
	}
	
	public boolean offShelve(int id){
		String sql = "UPDATE product SET is_offshelve = 1 WHERE id = ?";
		List<Object> params =new ArrayList<Object>();
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
	
	public boolean salesProduct(int id){
		String sql = "UPDATE product SET sales = sales + 1 WHERE id = ?";
		List<Object> params =new ArrayList<Object>();
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
	
	public boolean updateAttribute(int id,Map<String,Object> map){
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
	
}
