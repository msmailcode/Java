<%@ page contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>猪猪订单管理</title>
		<link href="CSS/style_crm.css" rel=stylesheet type="text/css">
	</head>
	<body class="body" bgcolor="#A2C97A">
		<jsp:include flush="true" page="top.jsp"></jsp:include>
		<table width="780" border="0" align="center" cellpadding="0"
			cellspacing="0" bgcolor="#FFFFFF"
			style="border:1px; border-style:solid; border-color:#888888">
			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td width="20" colspan="3">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					<table width="700" border="0" cellpadding="0" cellspacing="0"
						align="center">
						<tr>
							<td height="60">
								<img
									src="${pageContext.request.contextPath}/image/icon_order.gif" />
							</td>
						</tr>
						<tr>
							
							<td>
								<FORM  name=form1
												action="/EShopping/servlet/ClientQueryOrder">
												<TABLE class=table_search id=Table4 cellSpacing=0
													cellPadding=3 width="100%">
													<TBODY>
														<TR>
															<TD noWrap width="1%">
																
																<INPUT id=start style="WIDTH: 80px" 
																	name=start >
																<IMG id=ImgDate style="CURSOR: hand"
																	src="../image/calendar.gif" align=absMiddle>
																至
																<INPUT id=end style="WIDTH: 80px" 
																	name=end >
																<IMG id=Img1 style="CURSOR: hand"
																	src="../image/calendar.gif" align=absMiddle>
																<SPAN id=Label11>状态</SPAN>
																<SELECT 
																	name=state>
																	<OPTION value=1 selected>
																		确认
																	</OPTION>
																	<OPTION value=2>
																		已付款
																	</OPTION>
																	<OPTION value=3>
																		发货
																	</OPTION>
																	<OPTION value=4>
																		已到货
																	</OPTION>

																</SELECT>

																<INPUT class=text_normal id=UserListID
																	style="WIDTH: 0px" name=UserListID>
																<IMG style="CURSOR: hand" height=12
																	src="../image/address_book.gif" width=15
																	align=absMiddle border=0>
																<INPUT class=button_normal id=btnSearch
																
																	accessKey=s
																	
																	type=submit value=查询(Q) name=btnSearch>
														</TR>
													</TBODY>
												</TABLE>
											</FORM>
							</td>
							
						</tr>
						<tr>
							<td align="center">
								<table cellspacing="1" cellpadding="0" width="750" border="0"
									bgcolor="#F7F3F7" align="center">
									<tr height="26">
										<td class="blackTitle" align="center">
											序号
										</td>
										<td class="blackTitle" align="center">
											订单人
										</td>
										<td class="blackTitle" align="center">
											订单地址
										</td>
										<td class="blackTitle" align="center">
											订单电话
										</td>
										<td class="blackTitle" align="center">
											下单日期
										</td>
										<td class="blackTitle" align="center">
											订单状态
										</td>
										<td class="blackTitle" align="center">
											订单操作
										</td>
									</tr>


									<c:choose>

										<c:when test="${empty requestScope.arrayList}">
											<tr height="26" class="text" align="center" bgcolor="#FFFFFF">
												<td colspan="5" height="26" class="redText">
													对不起你还没有下任何订单,请先去购取商品！
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<page:pager dz="5">
												<c:forEach var="row" items="${requestScope.arrayList}"
													varStatus="status">
													<page:item nr="${status.count}">
														<tr height="26" class="text" align="center"
															bgcolor="#FFFFFF" class=datagrid_itemstyle_normal
															style="CURSOR: hand" align=middle nowrap="nowrap">
															<td nowrap>
																&nbsp;${status.count}&nbsp;
															</td>

															<td nowrap class="redText">
																&nbsp;${row.saveName}&nbsp;
															</td>
															<td nowrap class="redText">
																&nbsp;${row.saveAddress}&nbsp;
															</td>
															<td nowrap class="redText">
																&nbsp;${row.savePhone}&nbsp;
															</td>
															<td nowrap>
																&nbsp;${row.datatime}&nbsp;
															</td>
															<td nowrap>
																&nbsp;
																<c:if test="${row.state==1}">
																		确认
																	</c:if>
																<c:if test="${row.state==2}">
																		已付款
																	</c:if>
																<c:if test="${row.state==3}">
																		发货
																	</c:if>
																<c:if test="${row.state==4}">
																		已收货
																	</c:if>
																&nbsp;
															</td>
															<td nowrap align="center">
																<a href="/EShopping/servlet/CheckOrderInfo?id=${row.id}">查看订单</a>&nbsp;&nbsp;
															</td>

														</TR>

													</page:item>
												</c:forEach>
											</page:pager>
											<tr>
												<td colspan="7" align="center">
													<page:bt />
													<!--//这行显示最下面的导航栏  -->
												</td>
											</tr>

										</c:otherwise>
									</c:choose>

								</table>
							</td>
						</tr>
						<tr height="20">
							<td colspan="5"></td>
						</tr>

						<tr align="right">
							<td height="20" colspan="5">
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


				<td height="30" bgcolor="#4282CE" class="whiteText" align="center"
					colspan="3">
					如果你觉得这网站还不错请收藏 -- Author @St0816004
				</td>

			</tr>



		</table>

		<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>
