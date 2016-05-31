<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>修改产品</title>    
    <meta http-equiv="Content- Type" content="text/html; charset=GB2312"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">
  <s:head theme="xhtml"/>   
  <sx:head parseContent="false"/>   
  </head>
  
  <body>
    <s:set id="product" value="#request.product"/> 
<s:form name="form" id="form" method="POST" action="modifyProduct!modify.action?id=%{#product.id}">  
  <table cellspacing="0" cellpadding="0" border="1" align="center" >
  <tr><td>
<table cellspacing="0" cellpadding="0" border="0" border="0">
  <tr> 
    <td colspan="3"><s:textfield  name="productname" label="产品名称" value="%{#product.productname}" size="60"/></td>
  </tr>
  <tr> 
    <td colspan="3">
<s:action name="listType2!list" executeResult="true"></s:action>
</td>
  </tr>
  <tr> 
    <td colspan="3">
         <iframe name=upload src="./upload/upload.jsp" width="800" height="220" scrolling=no frameborder=0></iframe>   
    <s:textfield
label="图片" 
name="pic" 
size="100" 
value="%{#product.pic}"/> </td>
  </tr>
    <tr>
  <td><s:textfield  name="price" label="价格" value="%{#product.price}" size="4"/></td><td>元</td>
  </tr>
  <tr>
  <td>是否推荐</td>
  <td>
<s:radio  
tooltip="是否推荐产品？" 
label="是否推荐" 
list="#{'1':'推荐','0':'不推荐'}"   
name="recommend" 
value="%{#product.recommend}"
/>
</td>
</tr>
  <tr> 
    <td>产品简介:</td>
    <td colspan="2"><sx:textarea name="introduce" value="%{#product.introduce}" cols="100" rows="10"></sx:textarea></td>
  </tr>
    <tr> 
    <td>技术参数:</td>
    <td colspan="2"><sx:textarea name="parameter" value="%{#product.parameter}" cols="100" rows="10"></sx:textarea></td>
  </tr>
  <tr>
  <td colspan="3"><s:submit value="修改" />
  </td></tr>
</table>
</td></tr></table>
 </s:form> 
</body>
  
</html>
