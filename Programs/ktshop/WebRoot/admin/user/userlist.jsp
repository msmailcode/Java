<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>  
   

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">   
   
<html>   
   
    <head>   
   
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
   
       <title>用户后台管理</title>   
     <link href="./../css/style.css" rel="stylesheet" type="text/css">
    </head>   
   
    <body>  
     <table cellspacing="0" cellpadding="0" border="0" bgColor="#c0c0c0">
  <tr>
  <td> 
    <table cellspacing="1" cellpadding="0" border="0">   
    <tr bgcolor="#ffffff"><td background="./../images/tablebg.jpg">用户名</td><td background="./../images/tablebg.jpg">密码</td><td background="./../images/tablebg.jpg">爱好</td><td background="./../images/tablebg.jpg">图片</td><td colspan="2" align="center" background="./../images/tablebg.jpg">操作</td></tr>
      <s:iterator value="pageBean.list">
    <tr bgcolor="#ffffff">
       
          <td>
            <s:property value="username"/></td>
            <td><s:property value="password"/></td>
            <td> <s:property value="hobby"/></td>
            <td><img src="../<s:property value="pic"/>" width="50" height="50"></td>
             <td></td>
            <td>
            <a href="deleteUser!delete?id=<s:property value="id"/>">删除</a> 
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
            <a href="managerUser!list?page=1">第一页</a>
            <a href="managerUser!list?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPages}">
            <a href="managerUser!list?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
            <a href="managerUser!list?page=<s:property value="pageBean.totalPages"/>">最后一页</a>
        </s:if>
        <s:else>
            下一页 最后一页
        </s:else>   
    </body>   
   
</html>   