<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date"/>
<jsp:directive.page import="javabean.Orders"/>
<jsp:directive.page import="javabean.LeaveWord"/>
<jsp:directive.page import="javabean.Member"/>
<jsp:directive.page import="javabean.Admin"/>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>�û�����</title>
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
		Admin admin = (Admin)request.getAttribute("admin");
	%>
	<!-- ��ôʵ�ֽ���ʾ�����jspҳ����,����һ��ȫ�ֵı��� -->
	
	<table>
						<tr>
						<td height="30" align="center" class="redText">
						Admin >> ϵͳ�û�����Ա >> <%= session.getAttribute("admin") %> ��ã�
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
									src="${pageContext.request.contextPath}/image/icon_liuyan.gif"
									width="150" height="29" />
							</td>
						</tr>

						<tr>
							<td align="center">
							<form action="/EShopping/servlet/AddUserSuccess">
								<table width="94%" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#FFFFFF">
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF"
											class="blueText">
											��������Ա
										</td>
									</tr>

									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											����Ա������
										</td>
										<td>
											&nbsp;
											<input type="text" name="adminName" >
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											����Ա�ʺţ�
										</td>
										<td>
											&nbsp;
											<input type="text" name="adminuserName">
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											����Ա���룺
										</td>
										<td>
											&nbsp;
											<input type="password" name="adminpassWord">
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											����Ա���ͣ�
										</td>
										<td>
											&nbsp;
											<select name="adminType">
												<option value="1">��Ʒ����Ա</option>
												<option value="2">��������Ա</option>
												<option value="3">��Ա����Ա</option>
												<option value="4">ϵͳ����Ա</option>
											</select>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
									<td width="220" height="26" align="right">
											<input type="submit" value="����">
											
										</td>
										<td >
										&nbsp;
											<input type="reset" value="ȡ��">
											
										</td>
									</tr>
									
									
									
									
									<tr bgcolor="#F7F3F7" class="text">
										<td height="40" colspan="2" align="center" bgcolor="#FFFFFF"
											valign="bottom">
											<a href="/EShopping/servlet/AdminUser"> <span
												class="redText">����</span> </a>
										</td>
									</tr>
								</table>
								</form>
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
