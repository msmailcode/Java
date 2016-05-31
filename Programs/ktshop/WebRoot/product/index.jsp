<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>产品列表</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">
	 <script language="JavaScript"> function doSearch(){ if(document.all.searchValue.value=="") { alert("请输入查询关键字!"); }else{ window.location.href="productsAction!list?queryName="+document.all.searchName.value+"&&queryValue="+document.all.searchValue.value; } } </script>  
	
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <style type="text/css">
  body {
	margin-left: 0px;
	margin-top: 0px;
}
  </style>
  </head>
  
  <body>
  <table width="1224" border="0" align="center">
    <tr>
      <td width="200"><a href="./index.jsp"><img src="images/logo.gif" border="0"></a></td>
      <td width="814" height="100"><div align="center"><img src="./images/banner.jpg" width="468" height="80"></div></td>
    </tr>
    <tr>
      <td colspan="2"><s:action name="listMenu" executeResult="true"></s:action></td>
    </tr>
    <tr>
      <td width="220" valign="top">
        <div align="center"><s:action name="listType" executeResult="true"></s:action></div>
      </td>
      <td valign="top">搜索:
    <select name="searchName">  
      <option value="productname">产品名称</option>
    </select>
    <input type="text" name="searchValue" value="请输入关键字" size="10"/>  
       <input name="image" type="image" src="./images/search.gif" onClick="doSearch();">
    <br/>
    <b> 产品列表:</b><br>
  </p>
  <table width="100%" cellspacing="10" cellpadding="0" border="0" bgColor="" align="center">
  <tr>
      <%int n=0;%>
           <s:iterator value="pageBean.list2"> 
            <%n=n+1;%>  
  <td> 
  <table cellspacing="1" cellpadding="0" border="0" height="0"  bgColor="#c0c0c0" align="center">         
          <tr bgcolor="#ffffff" align="center">      
          <td align="center" bgcolor="#ffffff">    <s:property value="bigcategory"/>>><s:property value="smallcategory"/>    
            <br> 
             <s:set name="pic" value="pic" />
            <s:if test="#pic==''">           
 <img src="./images/nopic_small.jpg" width="150" height="150" border="0"/>
        </s:if>
         <s:else>            
<a href="<s:property value="pic"/>"><img src="<s:property value="pic"/>" width="150" height="150" border="0"/></a></s:else><br>       
           <font size="5"> &yen; </font><font color="red" size="4"><b><s:property value="price"/></b></font>元  <br>
                       <a href="showProduct!get?id=<s:property value="id"/>"> <s:property value="productname"/></a><br>    
            <a href="addCart!add?id=<s:property value="id"/>"><img src="./images/addcart.gif" border="0"></a></td>      
   </tr> </table>
</td>
         <%if ((n%5)==0){
%>
              </tr>
              <%}%>
   </s:iterator>       
      </table>     
     共<s:property value="pageBean.totalRows"/> 条记录
        共<s:property value="pageBean.totalPages"/> 页
        当前第<s:property value="pageBean.currentPage"/>页
        
        <s:if test="%{pageBean.currentPage == 1}">
            第一页 上一页        </s:if>
        <s:else>
            <a href="productsAction2!list?page=1">第一页</a>
            <a href="productsAction2!list?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPages}">
            <a href="productsAction2!list?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="productsAction2!list?page=<s:property value="pageBean.totalPages"/>">最后一页</a>        </s:if>
        <s:else>
        下一页 最后一页        </s:else>   </td>
    </tr>   
  </table>       
    </td>
    </tr>
    <tr>
      <td colspan="2"><div align="center">Copyright&copy;2016康通购物网StShop版权所有</div></td>
    </tr>
  </table>
  <p>   
  </body>
</html>
