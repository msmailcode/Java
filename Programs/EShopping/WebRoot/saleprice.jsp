<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 特价商品浏览 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>猪猪之家--特价商品浏览</title>
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
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td valign="top">
								<br>
								<TABLE width="96%" border=0 align="center" cellPadding=0
									cellSpacing=0 class="C_Goods_Title">
									<TR>
										<TD>
											<IMG hspace=5 src="${pageContext.request.contextPath}/image/NewGoods_05.gif">
										</TD>
									</TR>
								</TABLE>
								<table width="96%" border="0" align="center" cellpadding="0"
									cellspacing="1" bgcolor="#F7F3F7">
									<tr bgcolor="#F7F3F7" valign="middle" align="center">
										<td height="30" class="blackTitle">
											序号
										</td>
										<td height="30" class="blackTitle">
											商品图片
										</td>
										<td height="30" class="blackTitle">
											商品基本信息
										</td>
										<td height="30" class="blackTitle">
											商品描述
										</td>
										<td height="30" class="blackTitle">
											基本操作
										</td>
									</tr>
									
									
									
									
									<c:choose>
									<c:when test="${empty requestScope.arrayList}">
										<tr>
											<td colspan="4" height="26" class="redText">
												&nbsp;
												还没有添加任何没有商品信息！
											</td>
										</tr>
									</c:when>
									<c:otherwise>
									<page:pager dz="5">
										<c:forEach items="${requestScope.arrayList}" var="row" varStatus="status">
										
											<tr valign="middle" bgcolor="#FFFFFF" nowrap="nowrap">
											
											
											<page:item nr="${status.count}">
											<td nowrap>
														&nbsp;${status.count}&nbsp;
											</td>
												<td width="100" align="center" nowrap>
													<a href="/EShopping/servlet/QueryOneInfo?id=${row.id}" target=_blank>
														<img src="${pageContext.request.contextPath}/${row.fileName}" width="80" height="100"
															border="1"> </a>
												</td>
												<td width="160" class="text" nowrap>
													<a href="/EShopping/servlet/QueryOneInfo?id=${row.id}" target=_blank><span
														class="blueText">${row.name}</span>
													</a>
													<br>
													市场价
													： ￥${row.price}
													<br>
													特价
													： ￥${row.saleprice}
													<br>
													作者
													：${row.provider}
													<br>
												</td>
												<td class="text" nowrap>
													${row.contents}
												</td>
												<td width="100" nowrap>
													<a href="/EShopping/servlet/QueryOneInfo?id=${row.id}" target=_blank><img
															src="${pageContext.request.contextPath}/image/icon_car.gif" border=0>
													</a>
													<br>
													<a href="/EShopping/servlet/CommentBookOne?id=${row.id}" target=_blank><font class="bluetext">我有话说</font></a>
													<br>
													<a href="/EShopping/servlet/TakeCart?id=${row.id}" ><img
															alt="添加到购物车" src="${pageContext.request.contextPath}/image/icon_buy.gif" border=0>
													</a>
													
													
												</td>
											</page:item>
											</tr>
																					
										</c:forEach>
										</page:pager>
									<tr>
										<td colspan="4" align="center">
											<page:bt />
											<!--//这行显示最下面的导航栏  -->
										</td>
									</tr>
									
									</c:otherwise>
								
									</c:choose>
									
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="3">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				<td height="30" bgcolor="#4282CE" class="whiteText" align="center">
					如果你觉得这网站还不错请收藏 -- Author @St0816004
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td height="20" colspan="3">
					&nbsp;
				</td>
			</tr>
		</table>
		<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>
