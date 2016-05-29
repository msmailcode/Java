package com.msmailcode.shop_jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 create table salesorder
(
id int primary key auto_increment not null,
userid int not null,
addrress varchar(255) not null,
phone varchar(20) not null,
ordertime timestamp not null default CURRENT_TIMESTAMP,
status tinyint(1) not null default 0
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
}
