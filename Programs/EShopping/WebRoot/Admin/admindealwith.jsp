<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date"/>
<jsp:directive.page import="javabean.Orders"/>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>订单管理</title>
		<link rel="stylesheet" type="text/css" href="../CSS/stylesheet.css">
		<!--  <link rel="stylesheet" type="text/css" href="../CSS/displaytag.css" />-->
		<link href="../CSS/style_crm.css" rel=stylesheet type="text/css">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<style type="text/css">
		<!--
		body {
			background-color: lightgrey;
		}
		-->
	</style>
	</head>
	
	<body class=body_normal leftMargin=0 topMargin=0>
	<%
		Orders order = (Orders) request.getAttribute("order");
	%>
	<!-- 怎么实现将提示框打入jsp页面中,定义一个全局的变量 -->
	
	<table>
						<tr>
						<td height="30" align="center" class="redText">
						Admin >> 订单管理员 >> <%= session.getAttribute("admin") %> 你好！
						<%= new Date().toLocaleString() %>
						</td>
						</tr>
	
	</table>
	<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FFFFFF"
			style="border:1px; border-style:solid; border-color:#888888">


			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="60">
								<img
									src="${pageContext.request.contextPath}/image/icon_order_view.gif"
									width="150" height="29" />
							</td>
						</tr>

						<tr>
							<td align="center">
								<table width="94%" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#FFFFFF">


									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											订单编号：
										</td>
										<td>
											&nbsp;
											<%=order.getId()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											订单时间：
										</td>
										<td>
											&nbsp;
											<%=order.getDatatime()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											收货人姓名：
										</td>
										<td>
											&nbsp;
											<%=order.getSaveName()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											收货人电话：
										</td>
										<td>
											&nbsp;
											<%=order.getSavePhone()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											收货人邮编：
										</td>
										<td>
											&nbsp;
											<%=order.getZip()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											收货人地址：
										</td>
										<td>
											&nbsp;
											<%=order.getSaveAddress()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											送货方式：
										</td>
										<td>
											&nbsp;
											<c:if test="<%=order.getDeliverymode() == 1%>">
						平邮
					</c:if>
											<c:if test="<%=order.getDeliverymode() == 2%>">
						快递
					</c:if>
											<c:if test="<%=order.getDeliverymode() == 3%>">
						上门
					</c:if>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											付款方式：
										</td>
										<td>
											&nbsp;
											<c:if test="<%=order.getMoneymode() == 1%>">
						银行汇款
				</c:if>
											<c:if test="<%=order.getMoneymode() == 2%>">
						邮局汇款
				</c:if>
											<c:if test="<%=order.getMoneymode() == 3%>">
						网上支付
				</c:if>

										</td>
									</tr>
									<form action="/EShopping/servlet/DealWithOrderState">
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											订单状态修改：
										</td>
										<td>
											&nbsp;
											<input type="hidden" name="id" value="<%=order.getId() %>">
											<select name="state">
											<c:if test="<%=order.getState()==1 %>">
												<option value="1" selected="selected">确认</option>
												<option value="2">已付款</option>
												<option value="3">发货</option>
												<option value="4">已收货</option>
											</c:if>
											<c:if test="<%=order.getState()==2 %>">
												<option value="1" >确认</option>
												<option value="2" selected="selected">已付款</option>
												<option value="3">发货</option>
												<option value="4">已收货</option>
											</c:if>
											<c:if test="<%=order.getState()==3 %>">
												<option value="1" >确认</option>
												<option value="2" >已付款</option>
												<option value="3" selected="selected">发货</option>
												<option value="4">已收货</option>
											</c:if>
											<c:if test="<%=order.getState()==4 %>">
												<option value="4" selected="selected">已收货</option>
											</c:if>
												
											</select>
											&nbsp;<input type="submit" value="确认提交">
										</td>
										
									</tr>
									</form>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF"
											class="blueText">
											订单购物明细表
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<table cellspacing="1" cellpadding="0" width="100%"
												border="0" bgcolor="#F7F3F7">
												<tr height="26">
													<td class="blackTitle" align="center">
														序号
													</td>
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
														总金额
													</td>
												</tr>
												<c:choose>
												<c:when test="${empty arrayList}">
												
														<font class="redText">抱歉！该订单没有任何商品存在！</font>
													
												
												</c:when>
												<c:otherwise>
												<page:pager dz="5">
													<c:forEach items="${requestScope.arrayList}" var="row"
														varStatus="status">
														<page:item nr="${status.count}">
															<tr class="text" align="center" bgcolor="#FFFFFF">
																<td height="25">
																	&nbsp;${status.count}&nbsp;
																</td>
																<td height="25" class="redText">
																	&nbsp;
																	<a href="/EShopping/servlet/QueryOneInfo?id=${row.id}"
																		><font class="redText">${row.name}</font></a>
																</td>
																<td height="25">
																	￥${row.price}
																</td>
																<td height="25">
																	￥${row.saleprice}
																</td>
																<td height="25">
																	${row.number}
																</td>
																<td height="25">
																	￥${row.totalprice}
																</td>
															</tr>
														</page:item>
													</c:forEach>
													
												</page:pager>
												</c:otherwise>
												</c:choose>
												<tr>
													<td colspan="6" align="center">
														<page:bt />
														<!--//这行显示最下面的导航栏  -->
													</td>
												</tr>
												<tr height="10" bgcolor="#F7F3F7">
													<td colspan="5"></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="40" colspan="2" align="center" bgcolor="#FFFFFF"
											valign="bottom">
											<a href="/EShopping/servlet/AdminOrderList"> <span
												class="redText">返回</span> </a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr height="20">
							<td colspan="5"></td>
						</tr>
						<tr align="right">
							<td height="20">
								&nbsp;
							</td>
						</tr>
					</table>
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
		
		
		
		
	</body>
</html>
