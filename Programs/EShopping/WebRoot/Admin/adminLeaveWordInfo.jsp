<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date"/>
<jsp:directive.page import="javabean.Orders"/>
<jsp:directive.page import="javabean.LeaveWord"/>
<jsp:directive.page import="javabean.Member"/>
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
		LeaveWord leaveWord = (LeaveWord) request.getAttribute("leaveWord");
		Member member = (Member)request.getAttribute("member");
	%>
	<!-- 怎么实现将提示框打入jsp页面中,定义一个全局的变量 -->
	
	<table>
						<tr>
						<td height="30" align="center" class="redText">
						Admin >> 会员管理员 >> <%= session.getAttribute("admin") %> 你好！
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
								<table width="94%" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#FFFFFF">
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF"
											class="blueText">
											留言详情
										</td>
									</tr>

									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											留言标题：
										</td>
										<td>
											&nbsp;
											<%=leaveWord.getTitle()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											顾客姓名：
										</td>
										<td>
											&nbsp;
											<%=member.getName()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											留言时间：
										</td>
										<td>
											&nbsp;
											<%=leaveWord.getLeavrdate()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											留言内容：
										</td>
										<td>
											&nbsp;
											<%=leaveWord.getContent()%>
										</td>
									</tr>
									
									
									
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF"
											class="blueText">
											管理员回复
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<form action="/EShopping/servlet/AdminAnswerWord">
											<table cellspacing="1" cellpadding="0" width="100%"
												border="0" bgcolor="#F7F3F7">
												<tr>
													<td>
														管理员回复：
														<input type="hidden" name="id" value="<%=leaveWord.getId() %>">
														<input type="hidden" name="answerdate" value="<%=new Date().toLocaleString() %>">
													</td>
												</tr>
												<tr height="10" bgcolor="#F7F3F7">
													<td colspan="5">
														<textarea rows="5" cols="70" name="answercontent"></textarea>
													</td>
												</tr>
												<tr>
													<td>
														<input type="submit" value="回复该留言">
													</td>
												</tr>
											</table>
											</form>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="40" colspan="2" align="center" bgcolor="#FFFFFF"
											valign="bottom">
											<a href="/EShopping/servlet/AdminLeaveWord"> <span
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
