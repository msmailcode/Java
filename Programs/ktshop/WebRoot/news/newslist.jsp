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
    <title>�����б�</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">
	 <script language="JavaScript"> function doSearch(){ if(document.all.searchValue.value=="") { alert("�������ѯ�ؼ���!"); }else{ window.location.href="newsAction!list?queryName="+document.all.searchName.value+"&&queryValue="+document.all.searchValue.value; } } </script>  
	
     <style type="text/css">
<!--
.STYLE1 {color: #000000}
body {
	margin-left: 0px;
	margin-top: 0px;
}
-->
     </style>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
  
  <body>
  <table align="center" width="1224"><tr><td nowrap align="center" width="200"><s:a href="index.jsp"><img src="images/logo.gif" border="0"/></s:a></td><td height="100"><div align="center"><img src="./images/banner2.jpg" alt="���2" width="468" height="80"></div></td>
  </tr>
  <tr><td valign="top" align="center" bgColor="blue"><b>�������</b><br>
  ��ҵ����<br>
  ��˾����</td><td> ����:<select name="searchName">  <option value="title">����</option>  <option value="newstype">�������</option> <option value="author">����</option> </select>   <input type="text" name="searchValue" value="" size="10"/>      <input name="image" type="image" src="./images/newssearch.gif"  onClick="doSearch();">
 <br/>
   <b> �����б�:</b><br>
    <table width="100%" cellspacing="0" cellpadding="0" border="0" bgColor="#8080ff" align="center">
  <tr>
  <td>
  <table width="100%" cellspacing="1" cellpadding="0" border="0" height="1">
  <tr bgcolor="#ffffff" align="center">
  <td background="./images/newstablebg.jpg"><strong>���</strong></td><td background="./images/newstablebg.jpg"><strong>ͼƬ</strong></td><td background="./images/newstablebg.jpg"><strong>���� </strong></td><td background="./images/newstablebg.jpg"><strong>����</strong></td> <td background="./images/newstablebg.jpg"><strong>���</strong></td><td background="./images/newstablebg.jpg"><strong>����</strong></td><td background="./images/newstablebg.jpg"><strong>��ϸ����</strong></td></tr>       
      
       <s:iterator value="pageBean.list4" status="news">         
          <tr bgcolor="#ffffff" align="center">
          <td><s:property value="id"/></td>
            <td>
             <s:set name="pic" value="pic" />
            <s:if test="#pic==''">           
 <img src="./images/nopic_small.jpg" width="100" height="100" border="0"/>
        </s:if>
         <s:else>
             <a href="<s:property value="pic"/>"> <img src="<s:property value="pic"/>" width="100" height="100" border="0"/></a> </s:else>
            </td>
          <td>
            <s:property value="title"/>
            </td>
               <td>
            <s:property value="author"/>
            </td>
               <td>
            <s:property value="newstype"/>
            </td>
   <td>
            <s:property value="cc"/>
            </td>
            <td><a href="viewNews!get?id=<s:property value="id"/>"><img src="./images/viewdetail.gif" width="100" height="36" border="0"></a></td>
            </tr>  
        </s:iterator>
        </table>
        </td>
        </tr>
      </table>
         ��<s:property value="pageBean.totalRows"/> ����¼
        ��<s:property value="pageBean.totalPages"/> ҳ
        ��ǰ��<s:property value="pageBean.currentPage"/>ҳ
        
        <s:if test="%{pageBean.currentPage == 1}">
            ��һҳ ��һҳ
        </s:if>
        <s:else>
            <a href="newsAction!list?page=1">��һҳ</a>
            <a href="newsAction!list?page=<s:property value="%{pageBean.currentPage-1}"/>">��һҳ</a>
        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPages}">
            <a href="newsAction!list?page=<s:property value="%{pageBean.currentPage+1}"/>">��һҳ</a>
            <a href="newsAction!list?page=<s:property value="pageBean.totalPages"/>">���һҳ</a>
        </s:if>
        <s:else>
            ��һҳ ���һҳ
        </s:else>   </td></tr></table><div align="center">  
 Copyright&copy;2016��ͨ������StShop��Ȩ����    
  </div>
  </body>
</html>