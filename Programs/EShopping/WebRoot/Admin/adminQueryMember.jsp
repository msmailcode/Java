<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date" />
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>��Ա����</title>
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
		
		function f2(){
			var b = window.confirm("��ȷ��Ҫɾ��ȫ����Ա��Ϣ��?");
			if(b){
				//����ɾ����servlet�����е�����ȫ��ɾ��
				window.location.href = "/EShopping/servlet/DelAllMember";
			}else {
				
			}
		}
		function f3(){
			var b = window.confirm("��ȷ��Ҫ����ȫ����Ϣ��?");
			if(b){
				//����ɾ����servlet�����е�����ȫ��ɾ��
				window.location.href = "/EShopping/servlet/OutExcel";
			}else {
				
			}
		}
		//������Ʒ
		function QuickSearch(){
			var key = document.all.qKey.value;
			if (key !=null && key!="��Ʒ�ؼ���"){
				document.forms.form2.submit();
			}else {
				window.alert("��Ʒ�ؼ��ֲ���Ϊ��!");
			}
		}
		
	</script>
	<body class=body_normal leftMargin=0 topMargin=0>
		<!-- ��ôʵ�ֽ���ʾ�����jspҳ����,����һ��ȫ�ֵı��� -->
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
						.write("<script type='text/javascript'>alert('�޸���Ϣ�ɹ���');</script>");
					}
				} else if (n == 2) {
					if (m == 1) {
				out
						.write("<script type='text/javascript'>alert('��Ʒ������ӳɹ���');</script>");
					}
				} else if (n == 3) {
					if (m == 1) {
				out
						.write("<script type='text/javascript'>alert('��Ʒ�������ʧ�ܣ�');</script>");
					}
				}
			}
		%>
		<table>
			<tr>
				<td height="30" align="center" class="redText">
					Admin &gt;&gt; ��Ա����Ա &gt;&gt;
					<%=session.getAttribute("admin")%>
					��ã�
					<%=new Date().toLocaleString()%>
				</td>
			</tr>

		</table>

		<c:choose>
			<c:when test="${empty requestScope.list}">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					style="background-color:lightgrey; border:0px;">
					<tr>
						<td height="40" class="itemTitle" align="center">
							��Ա����
						</td>
					</tr>
					<tr>
						<td height="30" class="blueText" align="center">
							<span class="blueText"><a
								href="/EShopping/servlet/AdminLeaveWord" class="blueText">���Թ���</a>
							</span>
							<br>
							<br>
						</td>
					</tr>
					<tr>
						<td style="text-align:center;" class="redText">
							Ŀǰ��û���µļ�¼��
						</td>
					</tr>
					</c:when>
					<c:otherwise>
						<FONT face=����>
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
															<FONT class=font_title>��Ա����</FONT>&nbsp;
														</TD>
													</TR>
													<tr>
														<td height="30" class="blueText" align="center">
															<span class="blueText"><a
																href="/EShopping/servlet/AdminLeaveWord"
																class="blueText">���Թ���</a> 
															</span>
															<br>
															<br>
														</td>
													</tr>
												</TBODY>
											</TABLE>
											<form action="/EShopping/servlet/QueryMember" name="form2">
											<TABLE class=table_search id=Table4 cellSpacing=0
												cellPadding=3 width="100%">
												<!-- ��ѯ�������ύ -->
												
												<TBODY>
													<TR>
														<TD noWrap width="1%">
															&nbsp; ��������
															<input type="text" name="qKey" style="WIDTH: 180px;">
															��ѯ
															<SELECT id=query style="WIDTH: 85px;" name="query">
																<OPTION value="0" selected>
																	ȫ������
																</OPTION>
																<OPTION value="1">
																	��ʵ����
																</OPTION>
																<OPTION value="2">
																	��¼�ʺ�
																</OPTION>
																<OPTION value="3">
																	��ϵ��ַ
																</OPTION>
																<OPTION value="4">
																	��������
																</OPTION>
															</SELECT>
															<IMG style="CURSOR: hand;" height=17
																src="../image/ico_select.gif" width=16 align="middle"
																border=0>
														</TD>
														<TD noWrap width=*>
															<INPUT class=button_normal id=btnSearch type="button"
																value=��ѯ(S) name=btnSearch accessKey=s
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
															<INPUT class=button_normal type=button 
																value=����(N) name=btnNew>
															<INPUT class=button_normal onClick="f2();" type="button"
																value=ɾ��(D) name=btnDelete>
															<INPUT class=button_normal onclick="f3()" type="button"
																value="����(E)" name=btnOutExcel>
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
															<A href="adminMerSpe.jsp">���</A>
														</TD>
														<TD noWrap>
															<A href="adminMerSpe.jsp">��¼�ʺ�</A>
														</TD>
														<TD noWrap>
															<A href="adminMerSpe.jsp">��ʵ����</A>
														</TD>
														<TD noWrap>
															<A href="adminMerSpe.jsp">ע������</A>
														</TD>
														<TD noWrap>
															<A href="adminMerSpe.jsp">��ϵ��ַ</A>
														</TD>
														<TD noWrap>
															<A href="adminMerSpe.jsp">��Ա״̬</A>
														</TD>
														<TD noWrap>
															<A href="adminMerSpe.jsp">��Աά��</A>
														</TD>
													</TR>
													<page:pager dz="5">
														<!-- dz����Ĭ�ϵ���ʾ��¼�����������ָ������Ĭ��Ϊ20�� -->
														<c:forEach var="row" items="${requestScope.list}"
															varStatus="status">
															<page:item nr="${status.count}">
																<TR class=datagrid_itemstyle_normal
																	onmouseover="this.className='datagrid_itemstyle_over';"
																	style="CURSOR: hand"
																	onmouseout="this.className='datagrid_itemstyle_normal';"
																	align=middle nowrap="nowrap">


																	<!-- //nr��ʾҪ���������ĸ���ŵļ�¼,${status.count}��ʾ1,2,3....��ţ�������������﷨������i++�󣬰�i����nr -->

																	<td nowrap>
																		&nbsp;${status.count}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;${row.userName}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;${row.name}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;${row.regtime}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;${row.address}&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;
																		<c:if test="${row.state==1}">
																				����
																			</c:if>
																			<c:if test="${row.state==0}">
																				����
																			</c:if>
																		&nbsp;
																	</td>
																	<td nowrap align="center">
																		<a href="/EShopping/servlet/MemberInfo?id=${row.id}">��Ա����</a>&nbsp;&nbsp;
																		<a href="/EShopping/servlet/StopMember?id=${row.id}"
																			onclick='return confirm("��ȷ��Ҫ���õ�ǰ���û���?")'>����</a>&nbsp;&nbsp;
																		<a href="/EShopping/servlet/OnLockMember?id=${row.id}"
																			onclick='return confirm("��ȷ��Ҫ���õ�ǰ���û���?")'>����</a>&nbsp;&nbsp;
																		<a href="/EShopping/servlet/ResetPassWord?id=${row.id}"
																			onclick='return confirm("��ȷ��Ҫ���ø��ʻ���������?")'>����</a>&nbsp;&nbsp;
																	</td>

																</TR>
															</page:item>
														</c:forEach>
													</page:pager>
													<tr>
														<td colspan="7" align="center">
															<page:bt />
															<!--//������ʾ������ĵ�����  -->
														</td>
													</tr>
												</TBODY>
											</TABLE>
											</c:otherwise>
											</c:choose>
	</body>
</html>