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
    <title>С���Ʒ�б�</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">
	<style type="text/css">
	body {
	margin-top: 0px;
}
    </style>
	<script language="JavaScript"> function doSearch(){ if(document.all.searchValue.value=="") { alert("�������ѯ�ؼ���!"); }else{ window.location.href="productsAction!list?queryName="+document.all.searchName.value+"&&queryValue="+document.all.searchValue.value; } } </script>  
	
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  </head>
  
  <body>
  <table width="1024" border="0" align="center">
    <tr>
      <td width="236"><a href="./index.jsp"><img src="./images/logo.jpg" border="0" longdesc="./index.jsp"></a></td>
      <td width="778"><div align="center"><img src="./images/banner.jpg" width="468" height="80"></div></td>
    </tr>
    <tr>
      <td colspan="2"><s:action name="listMenu" executeResult="true"></s:action></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td valign="top">����:
  <select name="searchName">  <option value="productname">��Ʒ����</option></select><input type="text" name="searchValue" value="" size="10"/>  <input name="image" type="image" src="./images/20080520150627399.gif" width="59" height="18"  onClick="doSearch();"> <br/>
   <b> ��Ʒ�б�:</b><br>
  <table width="900" cellspacing="0" cellpadding="0" border="0" bgColor="#c0c0c0">
  <tr>
  <td>
  <table width="900" cellspacing="1" cellpadding="0" border="0" height="1" align="center">
  <tr bgcolor="#ffffff" align="center">
  <td background="./images/tablebg.jpg"><strong>���</strong></td><td background="./images/tablebg.jpg"><strong>��Ʒ���� </strong></td> <td background="./images/tablebg.jpg"><strong>ͼƬ</strong></td><td background="./images/tablebg.jpg"><strong>����</strong></td><td background="./images/tablebg.jpg"><strong>С��</strong></td> <td background="./images/tablebg.jpg"><strong>�۸�</strong></td><td background="./images/tablebg.jpg"><strong>��ϸ����</strong></td><td background="./images/tablebg.jpg"><strong>���ﳵ</strong></td></tr>       
       <s:iterator value="pageBean.list5">         
          <tr bgcolor="#ffffff" align="center">
          <td><s:property value="id"/></td>
          <td>
            <s:property value="productname"/>            </td><td>
             <a href="<s:property value="pic"/>"><img src="<s:property value="pic"/>" width="100" height="100" border="0"/></a> 
            </td>
            <td>
            <s:property value="bigcategory"/>            </td>
            <td>
            <s:property value="smallcategory"/>            </td>
            <td>       
            <font color="red" ><s:property value="price"/></font>Ԫ            </td>
            <td><a href="showProduct!get?id=<s:property value="id"/>"><img src="./images/20080521140854537.gif" width="60" height="21" border="0"></a></td>
            <td>
            <a href="addCart!add?id=<s:property value="id"/>"><img src="./images/20080521140854960.gif" width="60" height="21" border="0"></a>            </td> 
          </tr>  
        </s:iterator>
      </table>    </td>
    </tr>
  </table>
         ��<s:property value="pageBean.totalRows"/> ����¼
        ��<s:property value="pageBean.totalPages"/> ҳ
        ��ǰ��<s:property value="pageBean.currentPage"/>ҳ
        
        <s:if test="%{pageBean.currentPage == 1}">
            ��һҳ ��һҳ        </s:if>
        <s:else>
            <a href="listProducts!show?page=1">��һҳ</a>
            <a href="listProducts!show?page=<s:property value="%{pageBean.currentPage-1}"/>">��һҳ</a>        </s:else>
        <s:if test="%{pageBean.currentPage != pageBean.totalPages}">
            <a href="listProducts!show?page=<s:property value="%{pageBean.currentPage+1}"/>">��һҳ</a>
            <a href="listProducts!show?page=<s:property value="pageBean.totalPages"/>">���һҳ</a>        </s:if>
        <s:else>
      ��һҳ ���һҳ        </s:else></td>
    </tr>
    <tr>
      <td colspan="2"><div align="center">Copyright&copy;2014��ͨ������InfocomShop��Ȩ����</div></td>
    </tr>
  </table>
     
  </body>
</html>