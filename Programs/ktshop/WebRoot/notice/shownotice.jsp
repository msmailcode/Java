<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <s:set id="notice" value="#request.notice"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:property value="%{#notice.title}"/>-信通购物网公告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">
    <style type="text/css">
<!--
.STYLE1 {color: #000000}
body {
	margin-top: 0px;
}
-->
    </style>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head> 
  <body><table align="center" width="1224"><tr><td width="200"><s:a href="index.jsp"><img src="images/logo.jpg" border="0"/></s:a></td><td height="100"><div align="center"><img src="./images/banner2.jpg" width="468" height="80"></div></td>
  </tr>
  <tr><td valign="top" bgColor="#cccccc" align="center">公告</td><td>
  <strong> 类别：</strong><s:property value="%{#notice.noticetype}"/><br/>
  <strong>   标题：</strong><s:property value="%{#notice.title}"/><br/>
<strong>作者：</strong>  <s:property value="%{#notice.author}"/><br/>
<strong>图片：</strong>
 <s:set name="pic" value="%{#notice.pic}" /> <s:if test="#pic==''">           
 <img src="./images/nopic_big.jpg" width="200" height="200" border="0"/>
        </s:if>
         <s:else> 
<img src="<s:property value="%{#notice.pic}"/>" align="middle" width="400" height="300"/></s:else><br/>
<strong>内容：</strong><s:property value="%{#notice.content}" escape="false"/><br/>
<strong> 出处：</strong><s:property value="%{#notice.cc}"/><br/>
<strong>发布时期时间：</strong><s:property value="%{#notice.publicdatetime}"/></td></tr>
  </table>
  <div align="center"> 
 Copyright&copy;2014信通购物网InfocomShop版权所有  </div>
  </body>
</html>
