<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date" />
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>������ѯ</title>
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
				window.location.href = "/EShopping/servlet/OutExcelOrders";
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
					Admin &gt;&gt; ��������Ա &gt;&gt;
					<%=session.getAttribute("admin")%>
					��ã�
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
							������ѯ���
						</td>
					</tr>

					<tr>

						<td style="text-align:center;" class="blueText">
							��Ǹ��ѯ��û�з��ϵĽ��!
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
															<FONT class=font_title>������ѯ���</FONT>&nbsp;
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
																	<OPTION value=���� selected>
																		����
																	</OPTION>
																	<OPTION value=����>
																		����
																	</OPTION>
																	<OPTION value=����>
																		����
																	</OPTION>
																	<OPTION value=����>
																		����
																	</OPTION>
																	<OPTION value=����>
																		����
																	</OPTION>
																</SELECT>
																<INPUT id=start style="WIDTH: 80px" value=2009-3-9
																	name=start onfocus="setday(this)" readonly>
																<IMG id=ImgDate style="CURSOR: hand"
																	src="../image/calendar.gif" align=absMiddle>
																��
																<INPUT id=end style="WIDTH: 80px" value=2009-3-9
																	name=end onfocus="setday(this)" readonly>
																<IMG id=Img1 style="CURSOR: hand"
																	src="../image/calendar.gif" align=absMiddle>
																<SPAN id=Label11>״̬</SPAN>
																<SELECT 
																	name=state>
																	<OPTION value=1 selected>
																		ȷ��
																	</OPTION>
																	<OPTION value=2>
																		�Ѹ���
																	</OPTION>
																	<OPTION value=3>
																		����
																	</OPTION>
																	<OPTION value=4>
																		�ѵ���
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
																	type=submit value=��ѯ(Q) name=btnSearch>
														</TR>
													</TBODY>
												</TABLE>
											</FORM>

											<TABLE class=table_bar id=Table5 cellSpacing=0 cellPadding=2
												width="100%">
												<TBODY>
													<TR>
														<TD noWrap align=left width=*>
															<INPUT class=button_normal type=button value=����(N)
																name=btnNew>
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
															<A href="#1">�ջ���</A>
														</TD>
														<TD noWrap>
															<A href="#1">�绰</A>
														</TD>
														<TD noWrap>
															<A href="#1">��ַ</A>
														</TD>
														<TD noWrap>
															<A href="#1">�ͻ���ʽ</A>
														</TD>
														<TD noWrap>
															<A href="#1">����״̬</A>
														</TD>
														<TD noWrap>
															<A href="#1">����ά��</A>
														</TD>
													</TR>
													<page:pager dz="5">
														<!-- dz����Ĭ�ϵ���ʾ��¼�����������ָ������Ĭ��Ϊ20�� -->
														<c:forEach var="row" items="${requestScope.arrayList}"
															varStatus="status">
															<page:item nr="${status.count}">
																<TR class=datagrid_itemstyle_normal
																	onmouseover="this.className='datagrid_itemstyle_over';"
																	style="CURSOR: hand"
																	onmouseout="this.className='datagrid_itemstyle_normal';"
																	align=middle nowrap="nowrap">


																	<!-- //nr��ʾҪ��������ĸ���ŵļ�¼,${status.count}��ʾ1,2,3....��ţ�������������﷨������i++�󣬰�i����nr -->

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
																		ƽ��
																	</c:if>
																		<c:if test="${row.deliverymode==2}">
																		���
																	</c:if>
																		<c:if test="${row.deliverymode==3}">
																		����
																	</c:if>
																		&nbsp;
																	</td>
																	<td nowrap>
																		&nbsp;
																<c:if test="${row.state==1}">
																		ȷ��
																	</c:if>
																<c:if test="${row.state==2}">
																		�Ѹ���
																	</c:if>
																<c:if test="${row.state==3}">
																		����
																	</c:if>
																<c:if test="${row.state==4}">
																		���ջ�
																	</c:if>
																		&nbsp;
																	</td>
																	<td nowrap align="center">
																		<a href="/EShopping/servlet/CheckOrderOne?id=${row.id}">��������</a>&nbsp;&nbsp;
																		<a href="/EShopping/servlet/DealWithOrder?id=${row.id}">��������</a>&nbsp;&nbsp;
																		

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
