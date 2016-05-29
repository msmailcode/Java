package com.msmailcode.shop_jsp.dao;

import java.sql.Connection;
import com.msmailcode.shop_jsp.util.DB;



public class BaseDao {
	protected DB db;
	protected Connection conn;
	public BaseDao(){
		db = new DB();
		conn = db.getConnection();
	}
}