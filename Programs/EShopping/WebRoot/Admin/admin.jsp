<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date" />
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>系统用户管理</title>
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
	<script type="text/javascript">
		function f1(){
			window.location.href = "/EShopping/Admin/adminUser.jsp";
		}
		function f2(){
			var b = window.confirm("你确定要删除全部信息吗?");
			if(b){
				//进入删除的servlet将表中的数据全部删除
				window.location.href = "/EShopping/servlet/DelAllBook";
			}else {
				
			}
		}
		function f3(){
			var b = window.confirm("你确定要导出全部信息吗?");
			if(b){
				//进入删除的servlet将表中的数据全部删除
				window.location.href = "/EShopping/servlet/OutExcelAdminInfo";
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
					Admin &gt;&gt; 系统用户管理员 &gt;&gt;
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
							系统用户管理
						</td>
					</tr>
					<tr>
						<td height="30" class="blueText" align="center">
							<span class="blueText"><a
								href="/EShopping/servlet/AdminMerList" class="blueText">增加</a>
							</span>
							<br>
							<br>
						</td>
					</tr>
					<tr>
						<td style="text-align:center;"> 
							目前还没有新的管理员！ 
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
															<FONT class=font_title>系统用户管理</FONT>&nbsp;
														</TD>
													</TR>
													
												</TBODY>
											</TABLE>
											<form action="/EShopping/servlet/QueryAdminUser" name="form2">
											<TABLE class=table_search id=Table4 cellSpacing=0
												cellPadding=3 width="100%">
												<!-- 查询表单的提交 -->
												
												<TBODY>
													<TR>
														<TD noWrap width="1%">
															&nbsp; 常用条件
															<input type="text" name="qKey" style="WIDTH: 180px;">
															查询
															<SELECT id=query style="WIDTH: 85px;" name="query">
																<OPTION value="0" selected>
																	全部条件
																</OPTION>
																<OPTION value="1">
																	姓名
																</OPTION>
																<OPTION value="2">
																	帐号
																</OPTION>
																<OPTION value="3">
																	管理员类型
																</OPTION>
																
															</SELECT>
															<IMG style="CURSOR: hand;" height=17
																src="../image/ico_select.gif" width=16 align="middle"
																border=0>
														</TD>
														<TD noWrap width=*>
															<INPUT class=button_normal id=btnSearch type="button"
																value=查询(S) name=btnSearch accessKey=s
																onclick="QuickSearch()">
														</TD>
													</TR>
												</TBODY>

												
											</TABLE>
											</form>
											<TABLE class=table_bar id=Table5 cellSpacing=0 cellPadding=2
												width="100%">
												<TBODY>
													<TR>
														<TD noWrap align=left width=*>
															<INPUT class=button_normal type=button onclick="f1();"
																value=新增(N) name=btnNew>
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
															<A href="adminMerSpe.jsp">管理员姓名</A>
														</TD>
														<TD noWrap>
															<A href="adminMerSpe.jsp">管理员帐号</A>
														</TD>
														<TD noWrap>
															<A href="adminMerSpe.jsp">管理员类型</A>
														</TD>
														
														<TD noWrap>
															<A href="adminMerSpe.jsp">管理员维护</A>
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
																		&nbsp;${row.adminName}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;${row.adminuserName}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;
																		<c:if test="${row.adminType==1}">
																			商品管理员
																		</c:if>
																		<c:if test="${row.adminType==2}">
																			订单管理员
																		</c:if>
																		<c:if test="${row.adminType==3}">
																			会员管理员
																		</c:if>
																		<c:if test="${row.adminType==4}">
																			系统管理员
																		</c:if>
																		&nbsp;
																	</td>
																	<td nowrap align="center">
																		<a href="/EShopping/servlet/ModUserInfo?id=${row.id}"
																			>修改管理员</a>&nbsp;&nbsp;
																		<a href="/EShopping/servlet/DelAdminUser?id=${row.id}"
																			onclick='return confirm("确定要删除吗?")'>删除管理员</a>&nbsp;&nbsp;
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
