package com.java.program;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLProcess {
	private String urls;
	private URL url;
	private String itemId;
	private String sellerId;
	private String order = "3";
	private int currentPage = 1;
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getOrder() {
			return order;
	}
	
	public void setOrder(String order) {
			this.order = order;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	URLProcess() throws IOException{
		this.url = new URL("https://rate.tmall.com/list_detail_rate.htm?itemId=2661994242&sellerId=217042976&order=3&currentPage=1");
	}
	
	URLProcess(String itemId, String sellerId, int currentPage) throws MalformedURLException{
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.currentPage = currentPage;
		this.urls = "https://rate.tmall.com/list_detail_rate.htm?itemId="+itemId+"&sellerId="+sellerId+"&order=3&currentPage="+currentPage;
		this.url = new URL(urls);
	}
	
	URLProcess(int currentPage) throws MalformedURLException{
		this.urls = "https://rate.tmall.com/list_detail_rate.htm?itemId=2661994242&sellerId=217042976&order=3&currentPage="+currentPage;
		this.url = new URL(urls);
	}
	
	public String accessData() throws IOException{
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
        InputStream inputStream = conn.getInputStream();   //通过输入流获得网站数据  
        byte[] getData = readInputStream(inputStream);     //获得网站的二进制数据  
        String data = new String(getData, "gb2312");  
		return data;
	}

    public static  byte[] readInputStream(InputStream inputStream) throws IOException {  
    	byte[] buffer = new byte[1024];  
    	int len = 0;  
		ByteArrayOutputStream bos = new ByteArrayOutputStream();  
		while((len = inputStream.read(buffer)) != -1) {  
			bos.write(buffer, 0, len);  
		}  		           
		bos.close();  
		return bos.toByteArray();  
     }
}
