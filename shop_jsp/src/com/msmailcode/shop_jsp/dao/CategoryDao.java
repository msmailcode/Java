package com.msmailcode.shop_jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
create table category
(
id int primary key auto_increment not null,
pid int not null, 
name varchar(255) not null, 
description varchar(255) not null,
grade int not null
)charset=utf8;
 */
public class CategoryDao extends BaseDao {
	public boolean addCategory(int pid,String name,String description,int grade){
		String sql = "INSERT INTO product (pid,name,description,grade) values(?,?,?,?)";
		List<Object> params =new ArrayList<Object>();
		params.add(pid);
		params.add(name);
		params.add(description);
		params.add(grade);
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
	
	public Map<String,Object> getCategory(int id){
		String sql = "SELECT * FROM product WHERE id = ?";
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
	
	public List<Map<String, Object>> getTopCategories(){
		String sql = "SELECT * FROM category WHERE grade = 1";
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
	
	public List<Map<String, Object>> getSubCategories(int pid){
		String sql = "SELECT * FROM category WHERE pid = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(pid);
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
	
	public boolean updateCategory(int id,Map<String,Object> map){
		String sql = "UPDATE category SET ";
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
