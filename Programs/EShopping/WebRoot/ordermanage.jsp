<%@ page contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>����������</title>
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
					<table width="700" border="0" cellpadding="0" cellspacing="0"
						align="center">
						<tr>
							<td height="60">
								<img
									src="${pageContext.request.contextPath}/image/icon_order.gif" />
							</td>
						</tr>
						<tr>
							
							<td>
								<FORM  name=form1
												action="/EShopping/servlet/ClientQueryOrder">
												<TABLE class=table_search id=Table4 cellSpacing=0
													cellPadding=3 width="100%">
													<TBODY>
														<TR>
															<TD noWrap width="1%">
																
																<INPUT id=start style="WIDTH: 80px" 
																	name=start >
																<IMG id=ImgDate style="CURSOR: hand"
																	src="../image/calendar.gif" align=absMiddle>
																��
																<INPUT id=end style="WIDTH: 80px" 
																	name=end >
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
																
																	accessKey=s
																	
																	type=submit value=��ѯ(Q) name=btnSearch>
														</TR>
													</TBODY>
												</TABLE>
											</FORM>
							</td>
							
						</tr>
						<tr>
							<td align="center">
								<table cellspacing="1" cellpadding="0" width="750" border="0"
									bgcolor="#F7F3F7" align="center">
									<tr height="26">
										<td class="blackTitle" align="center">
											���
										</td>
										<td class="blackTitle" align="center">
											������
										</td>
										<td class="blackTitle" align="center">
											������ַ
										</td>
										<td class="blackTitle" align="center">
											�����绰
										</td>
										<td class="blackTitle" align="center">
											�µ�����
										</td>
										<td class="blackTitle" align="center">
											����״̬
										</td>
										<td class="blackTitle" align="center">
											��������
										</td>
									</tr>


									<c:choose>

										<c:when test="${empty requestScope.arrayList}">
											<tr height="26" class="text" align="center" bgcolor="#FFFFFF">
												<td colspan="5" height="26" class="redText">
													�Բ����㻹û�����κζ���,����ȥ��ȡ��Ʒ��
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<page:pager dz="5">
												<c:forEach var="row" items="${requestScope.arrayList}"
													varStatus="status">
													<page:item nr="${status.count}">
														<tr height="26" class="text" align="center"
															bgcolor="#FFFFFF" class=datagrid_itemstyle_normal
															style="CURSOR: hand" align=middle nowrap="nowrap">
															<td nowrap>
																&nbsp;${status.count}&nbsp;
															</td>

															<td nowrap class="redText">
																&nbsp;${row.saveName}&nbsp;
															</td>
															<td nowrap class="redText">
																&nbsp;${row.saveAddress}&nbsp;
															</td>
															<td nowrap class="redText">
																&nbsp;${row.savePhone}&nbsp;
															</td>
															<td nowrap>
																&nbsp;${row.datatime}&nbsp;
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
																<a href="/EShopping/servlet/CheckOrderInfo?id=${row.id}">�鿴����</a>&nbsp;&nbsp;
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

										</c:otherwise>
									</c:choose>

								</table>
							</td>
						</tr>
						<tr height="20">
							<td colspan="5"></td>
						</tr>

						<tr align="right">
							<td height="20" colspan="5">
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


				<td height="30" bgcolor="#4282CE" class="whiteText" align="center"
					colspan="3">
					������������վ���������ղ� -- Author @St0816004
				</td>

			</tr>



		</table>

		<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>
