package com.msmailcode.shop_jsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 create table salesitem 
(
id int primary key auto_increment not null,
productid int not null, 
uniprice double not null, 
productcount int not null,
orderid int not null
)charset=utf8;
 */
public class SalesitemDao extends BaseDao {
	public boolean addItem(int pid,int pcount,int oid){
		double price = new ProductDao().getPrice(pid);
		String sql = "INSERT INTO salesitem (productid,uniprice,productcount,orderid) values(?,?,?,?)";
		List<Object> params =new ArrayList<Object>();
		params.add(pid);
		params.add(price * pcount);
		params.add(pcount);
		params.add(oid);
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
	
	public List<Map<String,Object>> getItems(int oid){
		String sql = "SELECT productid,prdoctcount FROM salesitem WHERE orderid = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(oid);
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
