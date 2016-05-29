package com.msmailcode.shop_jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;    
  
public class DB {
	//数据库用户名  
    private static final String USERNAME = "root";  
    //数据库密码  
    private static final String PASSWORD = "000000";  
    //驱动信息   
    private static final String DRIVER = "com.mysql.jdbc.Driver";  
    //数据库地址  
    private static final String URL = "jdbc:mysql://localhost:3306/shop_jsp";  
    private Connection connection;
    private PreparedStatement stmt;  
    private ResultSet resultSet;
    
    public DB() {  
        try{  
            Class.forName(DRIVER);           
        }catch(Exception e){  
        	e.printStackTrace();
        }  
    }
    
    public Connection getConnection(){  
        try {  
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);  
        } catch (SQLException e) {
            e.printStackTrace();  
        }  
        return connection;  
    }
    
    //INSERT,UPDATE,DELETE
    public boolean execute(String sql, List<Object>params)throws SQLException{  
        boolean flag = false;  
        int result = -1;  
        stmt = connection.prepareStatement(sql);  
        int index = 1;  
        if(params != null && !params.isEmpty()){  
            for(int i=0; i<params.size(); i++){  
                stmt.setObject(index++, params.get(i));  
            }  
        }  
        result = stmt.executeUpdate();  
        flag = result > 0 ? true : false;  
        return flag;  
    }
    
    //SELECT ONE
    public Map<String, Object> queryResult(String sql, List<Object> params) throws SQLException{  
        Map<String, Object> map = new HashMap<String, Object>();  
        int index  = 1;  
        stmt = connection.prepareStatement(sql);  
        if(params != null && !params.isEmpty()){  
            for(int i=0; i<params.size(); i++){  
                stmt.setObject(index++, params.get(i));  
            }  
        }  
        resultSet = stmt.executeQuery();//返回查询结果  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int col_len = metaData.getColumnCount();  
        while(resultSet.next()){  
            for(int i=0; i<col_len; i++ ){  
                String cols_name = metaData.getColumnName(i+1);  
                Object cols_value = resultSet.getObject(cols_name);  
                if(cols_value == null){  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
        }  
        return map;  
    }
    
    //SELECT NOT ONE
    public List<Map<String, Object>> queryResults(String sql, List<Object> params) throws SQLException{  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        int index = 1;  
        stmt = connection.prepareStatement(sql);  
        if(params != null && !params.isEmpty()){  
            for(int i = 0; i<params.size(); i++){  
                stmt.setObject(index++, params.get(i));  
            }  
        }  
        resultSet = stmt.executeQuery();  
        ResultSetMetaData metaData = resultSet.getMetaData();  
        int cols_len = metaData.getColumnCount();  
        while(resultSet.next()){  
            Map<String, Object> map = new HashMap<String, Object>();  
            for(int i=0; i<cols_len; i++){  
                String cols_name = metaData.getColumnName(i+1);  
                Object cols_value = resultSet.getObject(cols_name);  
                if(cols_value == null){  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
            list.add(map);  
        }  
  
        return list;  
    }
    
    public void close(){  
        if(resultSet != null){  
            try{  
                resultSet.close();              
            }catch(SQLException e){  
                e.printStackTrace();  
            }  
        }
        try {
			stmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
        try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
