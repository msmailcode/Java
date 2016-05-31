<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date" />
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>订单查询</title>
		<link rel="stylesheet" type="text/css" href="../CSS/stylesheet.css">
		<link rel="stylesheet" type="text/css" href="../CSS/displaytag.css" />
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
	<script type="text/javascript">
		
		function f2(){
			var b = window.confirm("你确定要删除全部会员信息吗?");
			if(b){
				//进入删除的servlet将表中的数据全部删除
				window.location.href = "/EShopping/servlet/DelAllMember";
			}else {
				
			}
		}
		function f3(){
			var b = window.confirm("你确定要导出全部信息吗?");
			if(b){
				//进入删除的servlet将表中的数据全部删除
				window.location.href = "/EShopping/servlet/OutExcelOrders";
			}else {
				
			}
		}
		//搜索商品
		function QuickSearch(){
			var key = document.all.qKey.value;
			if (key !=null && key!="商品关键字"){
				document.forms.form2.submit();
			}else {
				window.alert("商品关键字不能为空!");
			}
		}
		
	</script>
	<body class=body_normal leftMargin=0 topMargin=0>
		<!-- 怎么实现将提示框打入jsp页面中,定义一个全局的变量 -->
		<%!int m = 0;%>
		<%
			Object obj = (Object) request.getParameter("success");
			m++;
			if (obj == null) {
				new Integer(0);
			} else {
				int n = Integer.parseInt(request.getParameter("success")
				.toString());
				if (n == 1) {
					if (m == 1) {
				out
						.write("<script type='text/javascript'>alert('修改信息成功！');</script>");
					}
				} else if (n == 2) {
					if (m == 1) {
				out
						.write("<script type='text/javascript'>alert('商品类别增加成功！');</script>");
					}
				} else if (n == 3) {
					if (m == 1) {
				out
						.write("<script type='text/javascript'>alert('商品类别增加失败！');</script>");
					}
				}
			}
		%>
		<table>
			<tr>
				<td height="30" align="center" class="redText">
					Admin &gt;&gt; 订单管理员 &gt;&gt;
					<%=session.getAttribute("admin")%>
					你好！
					<%=new Date().toLocaleString()%>
				</td>
			</tr>

		</table>

		<c:choose>
			<c:when test="${empty requestScope.arrayList}">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					style="background-color:lightgrey; border:0px;">
					<tr>
						<td height="40" class="itemTitle" align="center">
							订单查询结果
						</td>
					</tr>

					<tr>

						<td style="text-align:center;" class="blueText">
							抱歉查询到没有符合的结果!
						</td>
					</tr>
					</c:when>
					<c:otherwise>
						<FONT face=宋体>
							<TABLE width="100%" border=0>
								<TBODY>
									<TR>
										<TD>
											<TABLE id=Table1 style="HEIGHT: 40px" cellSpacing=0
												cellPadding=0 width="100%" align=center border=0>
												<TBODY>
													<TR>

														<TD class=sys_title_right width="100%" align="center">
															&nbsp;
															<FONT class=font_title>订单查询结果</FONT>&nbsp;
														</TD>
													</TR>

												</TBODY>
											</TABLE>

											<FORM id=form1 name=form1
												action="/EShopping/servlet/QueryOrder">
												<TABLE class=table_search id=Table4 cellSpacing=0
													cellPadding=3 width="100%">
													<TBODY>
														<TR>
															<TD noWrap width="1%">
																<SELECT id=ddlSign
																	name=ddlSign>
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
																<INPUT id=end style="WIDTH: 80px" value=2009-3-9
																	name=end onfocus="setday(this)" readonly>
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
																	onmouseover="this.className='button_focus';"
																	accessKey=s
																	onmouseout="this.className='button_normal';"
																	type=submit value=查询(Q) name=btnSearch>
														</TR>
													</TBODY>
												</TABLE>
											</FORM>

											<TABLE class=table_bar id=Table5 cellSpacing=0 cellPadding=2
												width="100%">
												<TBODY>
													<TR>
														<TD noWrap align=left width=*>
															<INPUT class=button_normal type=button value=新增(N)
																name=btnNew>
															<INPUT class=button_normal onClick="f2();" type="button"
																value=删除(D) name=btnDelete>
															<INPUT class=button_normal onclick="f3()" type="button"
																value="导出(E)" name=btnOutExcel>
														</TD>
														<TD noWrap width="1%"></TD>
													</TR>
												</TBODY>
											</TABLE>
											<TABLE class=datagrid_normal id=DataGrid1
												style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; WIDTH: 100%; BORDER-RIGHT-WIDTH: 0px"
												cellSpacing=1 cellPadding=0 rules=all border=0>
												<TBODY>
													<TR class=datagrid_headerstyle_normal align=middle
														nowrap="nowrap">
														<TD noWrap>
															<A href="adminMerSpe.jsp">序号</A>
														</TD>
														<TD noWrap>
															<A href="#1">收货人</A>
														</TD>
														<TD noWrap>
															<A href="#1">电话</A>
														</TD>
														<TD noWrap>
															<A href="#1">地址</A>
														</TD>
														<TD noWrap>
															<A href="#1">送货方式</A>
														</TD>
														<TD noWrap>
															<A href="#1">订单状态</A>
														</TD>
														<TD noWrap>
															<A href="#1">订单维护</A>
														</TD>
													</TR>
													<page:pager dz="5">
														<!-- dz代表默认的显示记录条数，如果不指定，则默认为20条 -->
														<c:forEach var="row" items="${requestScope.arrayList}"
															varStatus="status">
															<page:item nr="${status.count}">
																<TR class=datagrid_itemstyle_normal
																	onmouseover="this.className='datagrid_itemstyle_over';"
																	style="CURSOR: hand"
																	onmouseout="this.className='datagrid_itemstyle_normal';"
																	align=middle nowrap="nowrap">


																	<!-- //nr表示要处理的是哪个序号的记录,${status.count}显示1,2,3....序号，如果不用这种语法，可以i++后，把i传给nr -->

																	<td nowrap>
																		&nbsp;${status.count}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;${row.saveName}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;${row.savePhone}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;${row.saveAddress}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;
																		<c:if test="${row.deliverymode==1}">
																		平邮
																	</c:if>
																		<c:if test="${row.deliverymode==2}">
																		快递
																	</c:if>
																		<c:if test="${row.deliverymode==3}">
																		上门
																	</c:if>
																		&nbsp;
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
																		<a href="/EShopping/servlet/CheckOrderOne?id=${row.id}">订单详情</a>&nbsp;&nbsp;
																		<a href="/EShopping/servlet/DealWithOrder?id=${row.id}">订单处理</a>&nbsp;&nbsp;
																		

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
												</TBODY>
											</TABLE>
											</c:otherwise>
											</c:choose>
	</body>
</html>
