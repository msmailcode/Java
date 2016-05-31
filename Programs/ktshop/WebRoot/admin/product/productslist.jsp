<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>shop购物网后台管理_管理产品列表</title>
      
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">

  </head>
  
  <body >
  <table cellspacing="0" cellpadding="0" border="0" bgColor="#c0c0c0">
  <tr>
  <td>
  <table cellspacing="1" cellpadding="0" border="0">
  <tr bgcolor="#ffffff">
 <td background="./images/tablebg.jpg">产品名称 </td> <td background="./images/tablebg.jpg">图片</td><td background="./images/tablebg.jpg">大类</td><td background="./images/tablebg.jpg">小类</td> <td background="./images/tablebg.jpg">价格</td><td colspan="2" align="center" background="./images/tablebg.jpg">操作</td></tr>   
            
            <s:iterator value="pageBean.list2">      
            <tr bgcolor="#ffffff">  
            <td>
            <s:property value="productname"/>
            </td> 
            <td>
            <img src="<s:property value="pic"/>" width="50" height="50"/> 
            </td>
             <td>
             <s:property value="bigcategory"/>
             </td>
            <td>
             <s:property value="smallcategory"/>
             </td>
             <td>
                <font color="red" ><s:property value="price"/></font>元 
                </td>
                <td>
             <a href="getProduct!get?id=<s:property value="id"/>">修改</a>
             </td>
             <td>
             <a href="deleteProduct!delete?id=<s:property value="id"/>" >删除</a>
             </td>
          </tr> 
        </s:iterator>
        </table>
        </td>
        </tr>
        </table>
          共<s:property value="pageBean.totalRows"/> 条记录
        共<s:property value="pageBean.totalPages"/> 页
        当前第<s:property value="pageBean.currentPage"/>页<br/>
        
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页
        </s:if>
        <s:else>
            <a href="adminProducts!list?page=1">第一页</a>
            <a href="adminProducts!list?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPages}">
            <a href="adminProducts!list?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="adminProducts!list?page=<s:property value="pageBean.totalPages"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>   
  </body>
</html>
