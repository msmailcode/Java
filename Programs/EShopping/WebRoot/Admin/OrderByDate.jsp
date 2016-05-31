<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date" />
<jsp:directive.page import="javabean.Orders" />
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>时间类别统计</title>
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
	<script type="text/javascript" src="../date.js">
	</script>

	<body class=body_normal leftMargin=0 topMargin=0>
		<%
		Orders order = (Orders) request.getAttribute("order");
		%>
		<!-- 怎么实现将提示框打入jsp页面中,定义一个全局的变量 -->

		<table>
			<tr>
				<td height="30" align="center" class="redText">
					Admin >> 订单管理员 >>
					<%=session.getAttribute("admin")%>
					你好！
					<%=new Date().toLocaleString()%>
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
						<tr bgcolor="#F7F3F7" class="text">
							<td height="26" colspan="2" align="center" bgcolor="#FFFFFF"
								class="blueText">
								按时间段统计各类别销量排行
							</td>
						</tr>
						<tr>
							<td height="26" colspan="2" align="center" bgcolor="#FFFFFF"
								class="blueText">
								请选择时间段！
							</td>
						</tr>
						<tr>
							<FORM id=form1 name=form1 action="/EShopping/servlet/OrderByDate">
								<TABLE class=table_search id=Table4 cellSpacing=0 cellPadding=3
									width="100%">
									<TBODY>
										<TR>
											<TD noWrap width="1%">
												<SELECT id=ddlSign name=ddlSign>
													<OPTION value=本日 selected>
														本日
													</OPTION>
													<OPTION value=本周>
														本周
													</OPTION>
													<OPTION value=本月>
														本月
													</OPTION>
													<OPTION value=本季>
														本季
													</OPTION>
													<OPTION value=本年>
														本年
													</OPTION>
												</SELECT>
												<INPUT id=start style="WIDTH: 80px" value=2009-3-9
													name=start onfocus="setday(this)" readonly>
												<IMG id=ImgDate style="CURSOR: hand"
													src="../image/calendar.gif" align=absMiddle>
												至
												<INPUT id=end style="WIDTH: 80px" value=2009-3-9 name=end
													onfocus="setday(this)" readonly>
												<IMG id=Img1 style="CURSOR: hand"
													src="../image/calendar.gif" align=absMiddle>
												<SPAN id=Label11>状态</SPAN>
												<SELECT name=state>
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

												<INPUT class=text_normal id=UserListID style="WIDTH: 0px"
													name=UserListID>
												<IMG style="CURSOR: hand" height=12
													src="../image/address_book.gif" width=15 align=absMiddle
													border=0>
												<INPUT class=button_normal id=btnSearch
													onmouseover="this.className='button_focus';" accessKey=s
													onmouseout="this.className='button_normal';" type=submit
													value=查询(Q) name=btnSearch>
										</TR>
									</TBODY>
								</TABLE>
							</FORM>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
							<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
								<table cellspacing="1" cellpadding="0" width="100%" border="0"
									bgcolor="#F7F3F7">
									<tr height="26">
										<td class="blackTitle" align="center">
											序号
										</td>
										<td class="blackTitle" align="center">
											类别号
										</td>
										<td class="blackTitle" align="center">
											总销量
										</td>
									</tr>
									<c:choose>
										<c:when test="${empty arrayList}">
											<font class="redText">你还没有选择时间段或没有符合的查询结果,请确保关键字正确！</font>
										</c:when>
										<c:otherwise>
											<page:pager dz="10">
												<c:forEach items="${requestScope.arrayList}" var="row"
													varStatus="status">
													<page:item nr="${status.count}">
														<tr class="text" align="center" bgcolor="#FFFFFF">
															<td height="25">
																&nbsp;${status.count}&nbsp;
															</td>
															<td height="25" class="redText">
																&nbsp;
																<font class="redText">
																<c:if test="${row.typeid==83}">
																		计算机
																</c:if>
																<c:if test="${row.typeid==84}">
																		经营
																</c:if>
																<c:if test="${row.typeid==85}">
																		故事
																</c:if>
																<c:if test="${row.typeid==86}">
																		美图
																</c:if>
																<c:if test="${row.typeid==87}">
																		其他
																</c:if>
																</font>
															</td>
															<td height="25">
																&nbsp;${row.number}&nbsp;
															</td>

														</tr>
													</page:item>
												</c:forEach>
											</page:pager>
										</c:otherwise>
									</c:choose>
									<tr>
										<td colspan="5" align="center">
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
