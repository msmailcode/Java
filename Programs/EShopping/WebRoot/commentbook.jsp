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

		<title>猪猪之家--商品详细信息</title>
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
			<td height="80" colspan="2"><IMG src="${pageContext.request.contextPath}/image/icon_LeaveWord.gif" width="150" height="29"></td>
		  </tr>
		  <tr>
			<td colspan="2"></td>
		  </tr>
		  <tr>
		
			<td height="40" colspan="2" align="left" class="text">
				<img src="${pageContext.request.contextPath}/${book.fileName}" border="0" align="left">
				&nbsp;书类别：${book.typeid}<br>
				&nbsp;书名：${book.name}<br>
				&nbsp;出版社：${book.descript}<br>
				&nbsp;市场价：￥${book.price}<br>
				&nbsp;特价：￥${book.saleprice}<br>
				&nbsp;作者：${book.provider}<br>
				&nbsp;出版日期：${book.leavetime}<br>
				&nbsp;内容描述：${book.contents}<br>
			</td>
			
		  </tr>
		 
		  <tr>
			<td colspan="2" height="40"  align="left" class="redtext">
				尊敬的<%=session.getAttribute("userName") %>顾客！感谢您对本商品的评论！
				<img
			src="${pageContext.request.contextPath}/image/line.gif"
			border=0 width="600" height="11">
			</td>
			 
		  </tr>
		  
		  <form action="servlet/CommentBook">
		  <input type="hidden" name="id" value="${book.id}">
		  <input type="hidden" name="datatime" value="<%=new Date().toLocaleString() %>">
		  <tr>
		  <td align="left" class="text">
		  评论内容:
		  </td>
		  <td  class="text">
		  	<textarea rows="7" cols="80" name="contents"></textarea>
		  	</td>
		  </tr>
		  <tr>
		  <td align="center">
		  	<input type="submit" value="发表" align="middle">&nbsp;<input type="reset" value="取消" align="middle">
		  </td>
		  <td align="right">
		  <a href="/EShopping/servlet/AllComment?id=${book.id}"><font class="bluetext">查看本商品全部评论</font></a>
		  </td>
		  </tr>
		  
		  </form>
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
					如果你觉得这网站还不错请收藏 -- Author @St0816004
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
