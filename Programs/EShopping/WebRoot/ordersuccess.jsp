<%@ page contentType="text/html; charset=gbk"%>
<jsp:directive.page import="java.util.Date" />
<jsp:directive.page import="javabean.Member" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>订单确认</title>
		<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
	</head>
	<script language="javascript">
	//进入上一步
	function pre(){
		var url = "/EShopping/cat.jsp";
		window.location = url;
	}	

	//进入下一步
	function next(){
		if (document.all.saleName.value==''){
			alert('收货人姓名不能为空！');
		}else if (document.all.salePhone.value==''){
			alert('收货人电话不能为空！');
		}else if (document.all.zip.value==''){
			alert('收货人邮编不能为空！');
		}else if (document.all.saveAddress.value==''){
			alert('收货人地址不能为空！');
		}else{
			document.all.form1.submit();
		}				
	}		
</script>
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
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="60">
								<img
									src="${pageContext.request.contextPath}/image/Car_icon_04.gif" />
							</td>
						</tr>
						<tr>
							<td>
								<table cellspacing="0" cellpadding="0" border="0" width="652"
									height="43">
									<tr valign="center">
										<td>
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_07.gif" />
										</td>
										<td class="C_Carbg_Default">
											查看购物车物品
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
										<td align="center">
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_09.gif" />
										</td>
										<td class="C_Carbg_Default">
											确认订单信息
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
										<td align="center">
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_11.gif" />
										</td>
										<td class="C_Carbg_Default">
											订单提交成功
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#FFFFFF">
									<tr bgcolor="#F7F3F7" class="text">
										<td width="240" rowspan="4" align="center" bgcolor="#FFFFFF">
											<IMG hspace=5
												src="${pageContext.request.contextPath}/image/Car_icon_10.gif">
										</td>
										<td height="26">
											&nbsp;恭喜你,订单提交成功,我们将尽快回复！
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26">
											&nbsp;订单编号:<%=Integer.parseInt(request.getAttribute("n1").toString()) %>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26">
											&nbsp;订单总金额:<%=Float.parseFloat(request.getAttribute("n3").toString()) %>
										</td>
									</tr>
									<tr bgcolor="#F7F3F7" class="text">
										<td height="26">
											&nbsp;下单日期:<%=request.getAttribute("datatime").toString()%>
										</td>
									</tr>
								</table>
							</td>
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

				<td height="30" bgcolor="#4282CE" class="whiteText" align="center">
					如果你觉得这网站还不错请收藏 -- Author @St0816004
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
		<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>
