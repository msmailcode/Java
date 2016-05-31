<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'down.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
.daohang {
	font-family: "黑体";
	font-size: 16px;
	color: #FFFFFF;
	text-decoration: none;
}
.shouye {
	font-family: "华文琥珀";
	font-size: 18px;
	color: #FFFFFF;
	text-decoration: none;
}
.guanglin {
	font-family: "黑体";
	font-size: 14px;
	color: #FFFFFF;
	font-weight: bold;
}
body {
	margin-top: 0px;
	margin-bottom: 0px;
}
-->
</style>
	
  </head>
  
  <body>
  
    <table width="782" height="70" border="0" align="center" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/image/floor.jpg">
  <tr>
  
    <td width="782" height="24"><div align="center"><span class="STYLE31">版权所有：Author @St0816004&nbsp;&nbsp;&nbsp; <br/>
    </span></div></td>
  </tr>
  <tr>
    <td height="12"><div align="center"><span class="STYLE31">电子信箱：yaorui19870714@163.com</span></div></td>
  </tr>
  <tr>
    <td height="32" valign="top"><div align="center"><span class="STYLE36"><span class="STYLE37">copyright&copy;</span>2009清华IT网上商城电子系统</span><img src="${pageContext.request.contextPath}/image/gs.gif" width="15" height="17" /></div></td>
  </tr>
</table>

  </body>
</html>
