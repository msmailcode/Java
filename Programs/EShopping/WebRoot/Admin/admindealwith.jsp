<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date"/>
<jsp:directive.page import="javabean.Orders"/>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>��������</title>
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
		Orders order = (Orders) request.getAttribute("order");
	%>
	<!-- ��ôʵ�ֽ���ʾ�����jspҳ����,����һ��ȫ�ֵı��� -->
	
	<table>
						<tr>
						<td height="30" align="center" class="redText">
						Admin >> ��������Ա >> <%= session.getAttribute("admin") %> ��ã�
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
									src="${pageContext.request.contextPath}/image/icon_order_view.gif"
									width="150" height="29" />
							</td>
						</tr>

						<tr>
							<td align="center">
								<table width="94%" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#FFFFFF">


									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											������ţ�
										</td>
										<td>
											&nbsp;
											<%=order.getId()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											����ʱ�䣺
										</td>
										<td>
											&nbsp;
											<%=order.getDatatime()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											�ջ���������
										</td>
										<td>
											&nbsp;
											<%=order.getSaveName()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											�ջ��˵绰��
										</td>
										<td>
											&nbsp;
											<%=order.getSavePhone()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											�ջ����ʱࣺ
										</td>
										<td>
											&nbsp;
											<%=order.getZip()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											�ջ��˵�ַ��
										</td>
										<td>
											&nbsp;
											<%=order.getSaveAddress()%>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											�ͻ���ʽ��
										</td>
										<td>
											&nbsp;
											<c:if test="<%=order.getDeliverymode() == 1%>">
						ƽ��
					</c:if>
											<c:if test="<%=order.getDeliverymode() == 2%>">
						���
					</c:if>
											<c:if test="<%=order.getDeliverymode() == 3%>">
						����
					</c:if>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											���ʽ��
										</td>
										<td>
											&nbsp;
											<c:if test="<%=order.getMoneymode() == 1%>">
						���л��
				</c:if>
											<c:if test="<%=order.getMoneymode() == 2%>">
						�ʾֻ��
				</c:if>
											<c:if test="<%=order.getMoneymode() == 3%>">
						����֧��
				</c:if>

										</td>
									</tr>
									<form action="/EShopping/servlet/DealWithOrderState">
									<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
											����״̬�޸ģ�
										</td>
										<td>
											&nbsp;
											<input type="hidden" name="id" value="<%=order.getId() %>">
											<select name="state">
											<c:if test="<%=order.getState()==1 %>">
												<option value="1" selected="selected">ȷ��</option>
												<option value="2">�Ѹ���</option>
												<option value="3">����</option>
												<option value="4">���ջ�</option>
											</c:if>
											<c:if test="<%=order.getState()==2 %>">
												<option value="1" >ȷ��</option>
												<option value="2" selected="selected">�Ѹ���</option>
												<option value="3">����</option>
												<option value="4">���ջ�</option>
											</c:if>
											<c:if test="<%=order.getState()==3 %>">
												<option value="1" >ȷ��</option>
												<option value="2" >�Ѹ���</option>
												<option value="3" selected="selected">����</option>
												<option value="4">���ջ�</option>
											</c:if>
											<c:if test="<%=order.getState()==4 %>">
												<option value="4" selected="selected">���ջ�</option>
											</c:if>
												
											</select>
											&nbsp;<input type="submit" value="ȷ���ύ">
										</td>
										
									</tr>
									</form>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF"
											class="blueText">
											����������ϸ��
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26" colspan="2" align="center" bgcolor="#FFFFFF">
											<table cellspacing="1" cellpadding="0" width="100%"
												border="0" bgcolor="#F7F3F7">
												<tr height="26">
													<td class="blackTitle" align="center">
														���
													</td>
													<td class="blackTitle" align="center">
														��Ʒ����
													</td>
													<td class="blackTitle" align="center">
														�г���
													</td>
													<td class="blackTitle" align="center">
														�ؼ�
													</td>
													<td class="blackTitle" align="center">
														����
													</td>
													<td class="blackTitle" align="center">
														�ܽ��
													</td>
												</tr>
												<c:choose>
												<c:when test="${empty arrayList}">
												
														<font class="redText">��Ǹ���ö���û���κ���Ʒ���ڣ�</font>
													
												
												</c:when>
												<c:otherwise>
												<page:pager dz="5">
													<c:forEach items="${requestScope.arrayList}" var="row"
														varStatus="status">
														<page:item nr="${status.count}">
															<tr class="text" align="center" bgcolor="#FFFFFF">
																<td height="25">
																	&nbsp;${status.count}&nbsp;
																</td>
																<td height="25" class="redText">
																	&nbsp;
																	<a href="/EShopping/servlet/QueryOneInfo?id=${row.id}"
																		><font class="redText">${row.name}</font></a>
																</td>
																<td height="25">
																	��${row.price}
																</td>
																<td height="25">
																	��${row.saleprice}
																</td>
																<td height="25">
																	${row.number}
																</td>
																<td height="25">
																	��${row.totalprice}
																</td>
															</tr>
														</page:item>
													</c:forEach>
													
												</page:pager>
												</c:otherwise>
												</c:choose>
												<tr>
													<td colspan="6" align="center">
														<page:bt />
														<!--//������ʾ������ĵ�����  -->
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
												class="redText">����</span> </a>
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
