<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>����֮��--��Ʒ��ϸ��Ϣ</title>
		<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="JS/jsonrpc.js"></script>
	</head>
	<body class="body" bgcolor="#A2C97A">
		<jsp:include flush="true" page="top.jsp"></jsp:include>


		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FFFFFF"
			style="border:1px; border-style:solid; border-color:#888888">
			<tr>
				<td width="20">
					&nbsp;
				</td>
				
				<td width="20">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
    <td>
		<table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
		  <tr>
			<td height="80" colspan="2"><IMG src="${pageContext.request.contextPath}/image/icon_goods.gif" width="150" height="29"></td>
		  </tr>
		  <tr>
			<td colspan="2"></td>
		  </tr>
		  <tr>
		
			<td height="40" colspan="2" align="left" class="text">
				<img src="${pageContext.request.contextPath}/${book.fileName}" border="0" align="left"> 
				&nbsp;������${book.name}<br>
				&nbsp;�����磺${book.descript}<br>
				&nbsp;�г��ۣ���${book.price}<br>
				&nbsp;�ؼۣ���${book.saleprice}<br>
				&nbsp;���ߣ�${book.provider}<br>
				&nbsp;�������ڣ�${book.leavetime}<br>
				&nbsp;����������${book.contents}<br>
			</td>
			
		  </tr>
		  <tr>
			<td colspan="2" height="40" align="center">
				<a href="/EShopping/servlet/TakeCart?id=${book.id}"><img src="${pageContext.request.contextPath}/image/icon_buy.gif" border=0></a>
			</td>
		  </tr>
		</table>
	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="30">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="30" bgcolor="#4282CE" class="whiteText" align="center">
					������������վ���������ղ� -- Author @St0816004
	</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="20">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>





									
									
							
		<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>
