package com.msmailcode.shop_jsp.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.msmailcode.shop_jsp.util.Regex;

/*
 create table user 
(
id int not null primary key auto_increment,
username varchar(40) not null,
password char(40) not null,
email varchar(40) not null,
phone varchar(20) not null,
address varchar(255) not null,
createdate timestamp not null default CURRENT_TIMESTAMP,
lastlogin timestamp not null default CURRENT_TIMESTAMP
)charset=utf8;
 */
public class UserDao extends BaseDao{
	public boolean registerUser(String username,String password,String email,String phone,String address){
		if(!Regex.checkEmail(email)){
			return false;
		} else if (!Regex.checkMobile(phone)){
			return false;
		}
		String sql = "INSERT INTO user (username,password,email,phone,address) values(?,?,?,?,?)";
		List<Object> params =new ArrayList<Object>();
		params.add(username);
		params.add(DigestUtils.sha1Hex(password));
		params.add(email);
		params.add(phone);
		params.add(address);
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
	
	//is valid user => return id; is not valid user => return 0
	public int isValidUser(String username,String password){
		String sql = "SELECT id,password FROM user WHERE username = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(username);
		int flag = 0;
		try {
			Map<String,Object> result = db.queryResult(sql, params);
			String pwd = (String)result.get("password");
			if(password.equals(pwd)){
				flag = (int) result.get("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return flag;
	}
	
	public void updateLogin(String username){
		String sql = "UPDATE user SET lastlogin = ? WHERE username = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(new Timestamp(System.currentTimeMillis()));
		params.add(username);
		try {
			db.execute(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}
	
	public boolean updateUser(String username,Map<String,Object> map){
		String sql = "UPDATE user SET ";
		List<Object> params =new ArrayList<Object>();
		for(Map.Entry<String,Object> entry : map.entrySet()){
			sql += entry.getKey() + " = ? , ";
			params.add(entry.getValue());
		}
		sql = sql.substring(0,sql.length()-2);
		sql += "WHERE username = ?";
		params.add(username);
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
	
	public String getPhone(int id){
		String sql = "SELECT phone FROM user WHERE id = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(id);
		String phone = null;
		try {
			phone = (String) db.queryResult(sql, params).get("phone");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}		
		return phone;
	}
	
	public String getAddress(int id){
		String sql = "SELECT address FROM user WHERE id = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(id);
		String address = null;
		try {
			address = (String) db.queryResult(sql, params).get("address");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}		
		return address;
	}

}