package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.msmailcode.shop_jsp.model.Model;

public class function {
	public static void main(String[] args){
		/*
		String sql = "UPDATE product SET ";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("String", "Object");
		map.put("key", "value");
		List<Object> params =new ArrayList<Object>();
		for(Map.Entry<String,Object> entry : map.entrySet()){
			sql += entry.getKey() + " = ? , ";
			params.add(entry.getValue());
		}
		sql = sql.substring(0,sql.length()-2);
		sql += "WHERE username = ?";
		//params.add(name);
		System.out.println(sql);
		*/
		//System.out.println(DigestUtils.sha1Hex("password")); 5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8
		Model model =new Model();
		Map<String,Object> product = model.getProduct(1);
		System.out.println(product);
	}
}
