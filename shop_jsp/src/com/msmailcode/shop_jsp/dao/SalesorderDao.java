package com.msmailcode.shop_jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 create table salesorder
(
id int primary key auto_increment not null,
userid int not null,
addrress varchar(255) not null,
phone varchar(20) not null,
ordertime timestamp not null default CURRENT_TIMESTAMP,
is_payed tinyint(1) not null default 0,
is_shipped tinyint(1) not null default 0
)charset=utf8;
 */
public class SalesorderDao extends BaseDao {
	public boolean generateOrder(int uid){
		String sql = "INSERT INTO salesorder (userid,address,phone) values(?,?,?)";
		List<Object> params =new ArrayList<Object>();
		UserDao user= new UserDao();
		String address = user.getAddress(uid);
		String phone = user.getPhone(uid);
		params.add(uid);
		params.add(address);
		params.add(phone);
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
	
	public boolean generateOrder(int uid,String address,String phone){
		String sql = "INSERT INTO salesorder (userid,address,phone) values(?,?,?)";
		List<Object> params =new ArrayList<Object>();
		params.add(uid);
		params.add(address);
		params.add(phone);
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
	
	public boolean payOrder(int uid){
		String sql = "UPDATE salesorder SET is_payed = 1 WHERE userid = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(uid);
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
	
	public List<Map<String, Object>> getUnshippedOrders(){
		String sql = "SELECT id,address,phone,ordertime FROM salesorder WHERE is_payed = 1 and is_shipped = 0 ";
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
}
