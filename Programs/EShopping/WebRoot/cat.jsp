<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<jsp:directive.page import="javabean.Cart"/>
<jsp:directive.page import="javabean.Member"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>猪猪电子商城购物车管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
		 
		<script type="text/javascript" src="JS/jsonrpc.js"></script>
		
	</head>
	<script type="text/javascript">
	//更改数量
	function modiNum(bookid,newNum){
		if(isNaN(newNum)){
			window.alert("错误,数量只能为数字！");
			return;
		}
		window.location.href = "/EShopping/servlet/ModNum?id=" + bookid + "&num=" + newNum;
	}
	//退回商品架
	function f1(bookid){
		var b = window.confirm("你确定要删除全部信息吗?");
			if(b){
				//进入删除的servlet将表中的数据全部删除
				window.location.href = "/EShopping/servlet/DelOneCart?id=" + bookid;
			}else {
				
			}
	}
	//清空购物车
	function clearCart(){
		var b = window.confirm("你确定要删除全部信息吗?");
		if(b){
		var url = "/EShopping/servlet/DelAllCart";
		window.location = url;
		}else {
		
		}
	}
	
	//继续购物
	function continueBuy(){
		var url = "/EShopping/index.html";
		window.location = url;
	}

	//进入下一步
	function next(){
		var url = "/EShopping/servlet/CheckOrder";
		window.location = url;
	}		
</script>

<%
	Member member1 = (Member)session.getAttribute("member");
	if(member1.getMap().size() == 0){
		out.write("<script type='text/javascript'>alert('购物车中还没有图书,请重新选购图书！');</script>");
		out.write("<script type='text/javascript'>window.location='/EShopping/index.html'</script>");
	}
 %>
	<body class="body" bgcolor="#A2C97A">
	
		<table align="center">
			<tr>
				<td>
					<jsp:include flush="true" page="top.jsp"></jsp:include>
				</td>
			</tr>
			<tr>
				<td>
					<table width="780" border="0" align="center" cellpadding="0"
						cellspacing="0" bgcolor="#FFFFFF"
						style="border:1px; border-style:solid; border-color:#888888">
						<tr>
							<td height="60">
								<img
									src="${pageContext.request.contextPath}/image/Car_icon_04.gif" />
							</td>
						</tr>
						<tr>
							<td>
								<table cellspacing="0" cellpadding="0" border="0">
									<tr valign="middle">
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
							<td align="center">

								<table cellspacing="1" cellpadding="0" width="94%" border="0"
									bgcolor="#F7F3F7">

									<% 
		Member member = (Member)request.getSession().getAttribute("member"); 
		Hashtable map =  member.getMap();
		int i = 0;
		float totalprice = 0;
		if(map.size()!=0){
		%>
									<tr height="26">
										<td class="blackTitle" align="center">
											商品名称
										</td>
										<td class="blackTitle" align="center">
											市场价
										</td>
										<td class="blackTitle" align="center">
											特价
										</td>
										<td class="blackTitle" align="center">
											数量
										</td>
										<td class="blackTitle" align="center">
											金额
										</td>
										<td class="blackTitle" align="center">
											操作
										</td>
									</tr>
									<% 
		for(Iterator iter = map.values().iterator();iter.hasNext();i++){
			Cart cart = (Cart)iter.next();
			totalprice = totalprice + cart.getTotal();
			%>
									<tr valign="middle" bgcolor="#FFFFFF" nowrap="nowrap">
										<td class="blueText">
											&nbsp;
											<a href="/EShopping/servlet/QueryOneInfo?id=<%=cart.getBookid() %>"
												target="_blank" > <font class="blueText"><%=cart.getName() %> </font></a>
										</td>
										<td nowrap>
											￥
											<%=cart.getPrice() %>
										</td>
										<td nowrap>
											￥
											<span><%=cart.getSaleprice() %> </span>
										</td>
										<td nowrap>
											<input type="text" class="textBox"
												value="<%=cart.getNumber()%>" size="4" 
												onChange="modiNum(<%=cart.getBookid() %>,this.value)"/>
										</td>
										<td nowrap>
											￥
											<span><%=cart.getTotal()%> </span>
										</td>
										<td nowrap>
											
												<input type="image" 
												onclick="f1(<%=cart.getBookid() %>)"
												src="${pageContext.request.contextPath}/image/delete_01.gif"
												border="0" />
										</td>

									</tr>

									<%
										}
										}
									%>
								<tr>
													<td colspan="6" class="Order_Total">
														<img hspace="5"
															src="${pageContext.request.contextPath}/image/me03.gif"
															align="absmiddle" />
														共有
														<%=i %>
														种商品,总金额
														<span><%=totalprice %>
														</span>
													</td>
												</tr>

									<tr height="20">
										<td colspan="6">
											<br>
											<br>
										</td>
									</tr>
									<tr align="right">
										<td colspan="6" bgcolor="#FFFFFF">
											<input type="image"
												src="/EShopping/image/Car_icon_01.gif"
												style="BORDER: 0px;WIDTH: 126px; HEIGHT: 39px;"
												onClick="clearCart()">
											<img style="CURSOR: hand" onClick="continueBuy()"
												src="/EShopping/image/Car_icon_02.gif" />
											<img
												src="/EShopping/image/Car_icon_03.gif"
												onClick="next()" border="0" style="CURSOR: hand" />
										</td>
									</tr>
									<tr align="right">
										<td height="20" colspan="6">
											&nbsp;
										</td>
									</tr>

									<tr>
										<td colspan="6">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td height="30" bgcolor="#4282CE" class="whiteText" colspan="6" align="center">
											如果你觉得这网站还不错请收藏 -- Author @St0816004
										</td>
									</tr>
									<tr>
										<td height="20" colspan="3">
											&nbsp;
										</td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td>
					<jsp:include flush="true" page="down.jsp"></jsp:include>
				</td>
			</tr>
		</table>
	</body>
</html>
