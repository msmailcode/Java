<%@ page contentType="text/html; charset=gb2312"%>
<jsp:directive.page import="java.util.Date"/>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>猪猪留言</title>
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
			<tr>
				<td height="60">
					<img src="${pageContext.request.contextPath}/image/icon_liuyan.gif" />
				</td>
			</tr>
			<tr>
				<td height="26" align="center">
					<c:choose>
						<c:when test="${empty requestScope.arrayList}">
							<span class="redText">你还没有留言,请赶快留言</span>
						</c:when>
						<c:otherwise>
							<page:pager dz="5">
								<c:forEach var="row" items="${requestScope.arrayList}"
									varStatus="status">
									<page:item nr="${status.count}">
										<table width="90%" border="0" cellpadding="4" cellspacing="0"
											style="border:1px; border-color:black; border-style:solid;">
											<tr bgcolor="#F7F3F7">
												<td class="text">
													<span class="blackTitle">标题</span>：${row.title}
												</td>
												<td align="right" class="text">
													<span class="blackTitle"> 留言者</span>:<%=session.getAttribute("userName") %>&nbsp;
													<span class="blackTitle">留言日期</span>:${row.leavrdate}
												</td>
											</tr>
											<tr>
												<td class="text" colspan="2">
													${row.content}
												</td>
											</tr>
											<tr>
												<td colspan="2" bgcolor="#F7F3F7" class="blackTitle">
													回复内容：
												</td>
											</tr>
											<tr>
												<td class="text" colspan="2">
													${row.answercontent}
												</td>
											</tr>
										</table>
										<table cellpadding="0" cellspacing="0">
											<tr height="10">
												<td></td>
											</tr>
										</table>
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
				</td>
			</tr>
			<tr bgcolor="#F7F3F7">
				<td height="26" bgcolor="#FFFFFF">
					<form name="form1" action="/EShopping/servlet/InputWord" method="post"
						style="margin:0px;">
						<table width="94%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td colspan="2">
									<img
										src="${pageContext.request.contextPath}/image/icon_LeaveWord.gif"
										width="140" height="45" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td height="30" align="right" class="blackTitle">
									标题：
								</td>
								<td height="30">
									<input type="hidden"
										value="<%=session.getAttribute("userName")%>" name="userName">
									<input type="hidden"
										value="<%=new Date().toLocaleString()%>" name="leavrdate">	
									<input type="text" id="title" name="title"
										class="textBox" size="61" />
								</td>
							</tr>
							<tr>
								<td align="right" class="blackTitle">
									留言内容：
								</td>
								<td>
									<textarea id="content" name="content" rows="4" cols="60"
										class="textBox"></textarea>
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;
								</td>
								<td height="35">
									<input type="submit" class="C_Input" value="提交留言" />
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td height="30" bgcolor="#4282CE" class="whiteText" align="center"
					colspan="3">
					<font class="whiteText">如果你觉得这网站还不错请收藏 -- Author @St0816004</font>
				</td>
			</tr>

			<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>
