<%@page pageEncoding="GB2312" contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addsmalltype.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">

  </head>
  
  <body>
<p> 增加小类</p>
<s:form method="POST" action="addSmalltype!save">
<select name="bigtypeid">
<s:iterator value="#request.bigtype" > 
<option value="<s:property value="bigtypeid"/>"><s:property value="bigtypename"/></option>
</s:iterator>
</select><br>
<s:textfield  name="smalltypename" label="小类"/><br>
<s:submit value="增加" />
</s:form>
  </body>
</html>
