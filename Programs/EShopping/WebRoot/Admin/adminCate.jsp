<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date"/>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>��Ʒ����</title>
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
			window.location.href = "/EShopping/Admin/adminAddCate.jsp";
		}
		function f2(){
			var b = window.confirm("��ȷ��Ҫɾ��ȫ����Ϣ��?");
			if(b){
				//����ɾ����servlet�����е�����ȫ��ɾ��
				window.location.href = "/EShopping/servlet/DelTypeInfo";
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
		//function f4(){
			//response.setContentType("application/vnd.ms-excel;charset=GB2312");
			//<meta http-equiv='Content-Type' content='text/html; charset=GB2312'>
		//}
	</script>
	<body class=body_normal leftMargin=0 topMargin=0>
	<!-- ��ôʵ�ֽ���ʾ�����jspҳ����,����һ��ȫ�ֵı��� -->
	<%! int m = 0; %>
	<%
		Object obj = (Object)request.getParameter("success");
		m++;
		if(obj == null){
			new Integer(0);
		}
		else {
		int n = Integer.parseInt(request.getParameter("success").toString());
		if(n ==1){
			if(m ==1){
				out.write("<script type='text/javascript'>alert('�޸���Ϣ�ɹ���');</script>");
			}
		}
		else if(n ==2){
			if(m == 1){
				out.write("<script type='text/javascript'>alert('��Ʒ������ӳɹ���');</script>");
			}
		}
		else if(n ==3){
			if(m == 1){
				out.write("<script type='text/javascript'>alert('��Ʒ�������ʧ�ܣ�');</script>");
			}
		}
		}
		
	 %>
	<table>
						<tr>
						<td height="30" align="center" class="redText">
						Admin >> ��Ʒ�������Ա >> <%= session.getAttribute("admin") %> ��ã�
						<%= new Date().toLocaleString() %>
						</td>
						</tr>
	
	</table>
		
		<c:choose>
			<c:when test="${empty sessionScope.arrayList1}">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					style="background-color:lightgrey; border:0px;">
					<tr>
						<td height="40" class="itemTitle" align="center">
							��Ʒ�����Ϣ
						</td>
					</tr>
					<tr>
						<td height="30" class="blueText" align="center">
							<span class="blueText"><a href="/EShopping/Admin/adminAddCate.jsp"
								class="blueText">����</a>
							</span>
							<br>
							<br>
						</td>
					</tr>
					<tr>
						<td style="text-align:center;">
							�㻹û������µļ�¼!
						</td>
					</tr>
					</c:when>
					<c:otherwise>
						<FONT face=����>
			<TABLE width="100%" border=0>
				<TBODY>
					<TR>
						<TD>
							<TABLE id=Table1 style="HEIGHT: 40px" cellSpacing=0 cellPadding=0
								width="100%" align=center border=0>
								<TBODY>
									<TR>
										
										<TD class=sys_title_right width="100%" align="center">
											&nbsp;
											<FONT class=font_title>��Ʒ�������</FONT>&nbsp;
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<form action="/EShopping/servlet/QueryCate" name="form2">
							<TABLE class=table_search id=Table4 cellSpacing=0 cellPadding=3
								width="100%">
								<!-- ��ѯ�����ύ -->
								
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
													���
												</OPTION>
												<OPTION value="2">
													��Ʒ��������
												</OPTION>
												<OPTION value="3">
													��Ʒ�������
												</OPTION>
											</SELECT>
											<IMG style="CURSOR: hand;" height=17
												src="../image/ico_select.gif" width=16 align="middle" border=0>
										</TD>
										<TD noWrap width=*>
											<INPUT class=button_normal id=btnSearch
												type="button"
												value=��ѯ(S) name=btnSearch accessKey=s onclick="QuickSearch()">
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
												onclick="f1();" value=����(N) name=btnNew>
											<INPUT class=button_normal
												onClick="f2();" type="button" value=ɾ��(D)
												name=btnDelete>
											<INPUT class=button_normal	onclick="f3()"
												type="button" value="����(E)" name=btnOutExcel>
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
											<A href="adminCate.jsp">���</A>
										</TD>
										<TD noWrap>
											<A href="adminCate.jsp">��Ʒ��������</A>
										</TD>
										<TD noWrap>
											<A href="adminCate.jsp">��Ʒ��������</A>
										</TD>
										<TD noWrap>
											<A href="adminCate.jsp">��Ʒ����ά��</A>
										</TD>
									</TR>
									<page:pager dz="5">
										<!-- dz����Ĭ�ϵ���ʾ��¼�����������ָ������Ĭ��Ϊ20�� -->
										<c:forEach var="row" items="${sessionScope.arrayList1}" varStatus="status">
											<TR class=datagrid_itemstyle_normal
												onmouseover="this.className='datagrid_itemstyle_over';"
												style="CURSOR: hand"
												onmouseout="this.className='datagrid_itemstyle_normal';"
												align=middle nowrap="nowrap">

												<page:item nr="${status.count}">
													<!-- //nr��ʾҪ��������ĸ���ŵļ�¼,${status.count}��ʾ1,2,3....��ţ�������������﷨������i++�󣬰�i����nr -->

													<td nowrap>
														&nbsp;${status.count}&nbsp;
													</td>
													<td nowrap>
														&nbsp;${row.typeName}&nbsp;
													</td>
													<td nowrap>
														&nbsp;${row.typeInfo}&nbsp;
													</td>
													<td nowrap align="center">
														<a href="/EShopping/servlet/DelServlet?id=${row.id}"
															onclick='return confirm("ȷ��Ҫɾ����?")'>ɾ��</a>&nbsp;&nbsp;
														<a href="/EShopping/servlet/ToModTypeInfo?id=${row.id}">�޸�</a>
													</td>
												</page:item>
											</TR>
										</c:forEach>
									</page:pager>
									<tr>
										<td colspan="4" align="center">
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
