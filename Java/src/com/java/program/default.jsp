<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.java.program.JavaServlet,java.util.Iterator,java.util.Map,java.util.HashMap" %>
<%	
	long ts1 = System.currentTimeMillis();
	JavaServlet program = new JavaServlet();
	HashMap<String,Double> scoreMap = program.Servlet();
    Iterator<Map.Entry<String,Double>> iter = scoreMap.entrySet().iterator();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sentiment Analysis Result</title>
</head>
<body>
	<h1>Sentiment Analysis Result</h1>
	<p>Review Content:Score</p>
	<%  
	int pos=0;
	int neg=0;
	int neu=0;
	int count=0;
	while(iter.hasNext()){
		Map.Entry<String,Double> entry = (Map.Entry<String,Double>) iter.next();
		String key = entry.getKey();
		Double value = entry.getValue();
		count++;
		if(value<0){
			neg++;
		}else if(value<5){
			neu++;
		}else{
			pos++;
		}
	%>
	<p><%= key %>:<%= value %></p>
	<%} %>
	<p>Count:<%= count %></p>
	<p>Positive(&gt 5):<%= pos %></p>
	<p>Neutral(0-5):<%= neu %></p>
	<p>Negative(&lt 0):<%= neg %></p>
	<%
		long ts2 =System.currentTimeMillis();
	%>
	<p><%= ts2-ts1 %>milliseconds</p>
</body>
</html>