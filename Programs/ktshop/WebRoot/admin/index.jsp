<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员后台管理登录页面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">

  </head>
  
  <body>
  <s:form method="POST" action="adminLogin!adminLogin.action">
  <table bgcolor="#0080ff" align="center" border="0" cellspacing="0" cellpadding="0">
   <tr ><td rowspan="1" colspan="2" align="center" background="./images/adminbg.jpg"><b><font size="4">管理员登录</font></b></td></tr>
     <tr><td><s:textfield  name="admin.adminname" maxlength="24" label="管理员名"/></td></tr>
    <tr><td><s:password  name="admin.password" maxlength="24" label="密码"/></td></tr>
    <tr><td align="center"> <s:submit value="登录" align="center"/></td></tr>   
     </table> </s:form>
  </body>
</html>
