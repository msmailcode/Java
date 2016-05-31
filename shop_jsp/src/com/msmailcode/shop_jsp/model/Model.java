package com.msmailcode.shop_jsp.model;

import java.util.List;
import java.util.Map;

import com.msmailcode.shop_jsp.dao.CategoryDao;
import com.msmailcode.shop_jsp.dao.ProductDao;
import com.msmailcode.shop_jsp.dao.SalesitemDao;
import com.msmailcode.shop_jsp.dao.SalesorderDao;
import com.msmailcode.shop_jsp.dao.UserDao;

public class Model {
	private CategoryDao category = new CategoryDao();
	private ProductDao product = new ProductDao();
	private SalesitemDao item = new SalesitemDao();
	private SalesorderDao order = new SalesorderDao();
	private UserDao user = new UserDao();
	
	//Category Model
	public boolean addCategory(int pid,String name,String description,int grade){
		return category.addCategory(pid, name, description, grade);
	}
	
	public Map<String,Object> getCategory(int id){
		return category.getCategory(id);
	}
	
	public List<Map<String, Object>> getTopCategories(){
		return category.getTopCategories();
	}
	
	public List<Map<String, Object>> getSubCategories(int pid){
		return category.getSubCategories(pid);
	}
	
	public boolean updateCategory(int id,Map<String,Object> map){
		return category.updateCategory(id, map);
	}
	
	//Product Model
	public boolean addProduct(String name,String description,double price,int categoryId){
		return product.addProduct(name, description, price, categoryId);
	}
	
	public Map<String,Object> getProduct(int id){
		return product.getProduct(id);
	}
	
	public List<Map<String, Object>> getProducts(int cid){
		return product.getProducts(cid);
	}
	
	public List<Map<String, Object>> getProductsOrdered(int cid,String column,boolean order){
		return product.getProductsOrdered(cid, column, order);
	}
	
	public List<Map<String, Object>> getLatest(){
		return product.getLatest();
	}
	
	public List<Map<String, Object>> getHot(){
		return product.getHot();
	}
	
	public boolean offShelve(int id){
		return product.offShelve(id);
	}
	
	public boolean sellProduct(int id,int count){
		return product.sellProduct(id, count);
	}
	
	public boolean updateAttribute(int id,Map<String,Object> map){
		return product.updateAttribute(id, map);
	}
	
	//Salesitem Model
	public boolean addItem(int pid,int pcount,int oid){
		return item.addItem(pid, pcount, oid);
	}
	
	public List<Map<String,Object>> getItems(int oid){
		return item.getItems(oid);
	}
	
	//Salesorder Model
	public boolean generateOrder(int uid){
		return order.generateOrder(uid);
	}
	
	public boolean generateOrder(int uid,String address,String phone){
		return order.generateOrder(uid, address, phone);
	}
	
	public boolean payOrder(int uid){
		return order.payOrder(uid);
	}
	
	public boolean shipOrder(int id){
		return order.shipOrder(id);
	}
	
	public List<Map<String, Object>> getUnshippedOrders(){
		return order.getUnshippedOrders();
	}
	
	//User Model
	public boolean registerUser(String username,String password,String email,String phone,String address){
		return user.registerUser(username, password, email, phone, address);
	}
	
	public int isValidUser(String username,String password){
		return user.isValidUser(username, password);
	}
	
	public void updateLogin(int id){
		user.updateLogin(id);
	}
	
	public boolean updateUser(String username,Map<String,Object> map){
		return user.updateUser(username, map);
	}
	
}
