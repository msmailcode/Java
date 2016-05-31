<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<jsp:directive.page import="javabean.Member" />
<jsp:directive.page import="javabean.Cart" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'cart.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<body class="body" bgcolor="#A2C97A">
		<table align="center">
			<tr>
				<td>
					<jsp:include flush="true" page="top.jsp"></jsp:include>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="780" border="0" align="center" cellpadding="0"
						cellspacing="0" bgcolor="#FFFFFF"
						style="border:1px; border-style:solid; border-color:#888888">
						<tr>
							<td height="60">
								<img
									src="${pageContext.request.contextPath}/image/Car_icon_04.gif" />
							</td>
						</tr>
						<tr>
							<td>
								<table cellspacing="0" cellpadding="0" border="0" align="center"
									width="97%">
									<tr valign="center">
										<td>
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_07.gif" />
										</td>
										<td class="C_Carbg_Default">
											查看购物车物品
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
										<td align="middle">
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_09.gif" />
										</td>
										<td class="C_Carbg_Default">
											确认订单信息
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
										<td align="middle">
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_11.gif" />
										</td>
										<td class="C_Carbg_Default">
											订单提交成功
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
									</tr>
									<tr>
										<td colspan="9" align="center">
											<table cellspacing="1" cellpadding="0" width="94%" border="0"
												bgcolor="#F7F3F7">

												<% 
		Member member = (Member)request.getSession().getAttribute("member"); 
		Hashtable map =  member.getMap();
		int i = 0;
		float totalprice = 0;
		if(map.size()!=0){
		%>
												<tr height="26">
													<td class="blackTitle" align="center">
														商品名称
													</td>
													<td class="blackTitle" align="center">
														市场价
													</td>
													<td class="blackTitle" align="center">
														特价
													</td>
													<td class="blackTitle" align="center">
														数量
													</td>
													<td class="blackTitle" align="center">
														金额
													</td>
													<td class="blackTitle" align="center">
														操作
													</td>
												</tr>
												<% 
		for(Iterator iter = map.values().iterator();iter.hasNext();i++){
			Cart cart = (Cart)iter.next();
			totalprice = totalprice + cart.getTotal();
			%>
												<tr valign="middle" bgcolor="#FFFFFF" nowrap="nowrap">


													<td nowrap>
														&nbsp;
														<a href="mer.do?method=showMer&id=${row.bookid}"
															target="_blank"> <%=cart.getName() %> </a>
													</td>
													<td nowrap>
														￥
														<%=cart.getPrice() %>
													</td>
													<td nowrap>
														￥
														<span><%=cart.getSaleprice() %>
														</span>
													</td>
													<td nowrap>
														<input type="text" class="textBox"
															value="<%=cart.getNumber() %>" size="4" />
													</td>
													<td nowrap>
														￥
														<span><%=cart.getTotal() %>
														</span>
													</td>
													<td nowrap>
														<input type="image"
															src="${pageContext.request.contextPath}/image/delete_01.gif"
															border="0" />
													</td>

												</tr>

												<%
		}
		}
	  %>
												<tr align="center" bgcolor="#FFFFFF">
												</tr>
												<tr>
													<td colspan="6" class="Order_Total">
														<img hspace="5"
															src="${pageContext.request.contextPath}/image/me03.gif"
															align="absmiddle" />
														共有
														<%=i %>
														种商品,总金额
														<span><%=totalprice %>
														</span>
													</td>
												</tr>

											</table>
										</td>
									</tr>
									<tr height="20">
									<td colspan="7">
								<br>
								<br>
							</td>
						</tr>
						<tr align="right" colspan="9">
							<td>
								<input type="image"
									src="${pageContext.request.contextPath}/image/Car_icon_01.gif"
									style="BORDER: 0px;WIDTH: 126px; HEIGHT: 39px;"
									onClick="clearCart()">
								<img style="CURSOR: hand" onClick="continueBuy()"
									src="${pageContext.request.contextPath}/image/Car_icon_02.gif" />
								<img
									src="${pageContext.request.contextPath}/image/Car_icon_03.gif"
									onClick="next()" border="0" style="CURSOR: hand" />
							</td>
						</tr>
						<tr align="right">
							<td height="20" colspan="9">
								&nbsp;
							</td>
						</tr>



								</table>
							</td>
						</tr>
					</table>

				</td>
			</tr>

			<tr>
				<td>
					<table>

						

					</table>
				</td>

			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>
								&nbsp;
							</td>
							<td height="30" bgcolor="#4282CE" class="whiteText"
								align="center">
								如果你觉得这网站还不错请收藏 -- Author @St0816004
							</td>
							<td>
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
							<td height="20">
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
						</tr>

					</table>

				</td>
			</tr>
			<tr>
				<td>
					<jsp:include flush="true" page="down.jsp"></jsp:include>
				</td>

			</tr>
		</table>
		<br>
	</body>
</html>
