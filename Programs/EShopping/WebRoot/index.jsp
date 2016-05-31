<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>猪猪之家--网上书城</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="biao.css" rel="stylesheet" type="text/css" />
	</head>
	<style type="text/css">
<!--
a:link {
	color: #005122;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #005122;
}
a:hover {
	text-decoration: none;
	color: #0066CC;
}
a:active {
	text-decoration: none;
}
a.link9:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 9pt;
	color: #FF3333; 
	text-decoration:underline;
}
a.link9:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 9pt;
	color: #FF3333; 
	text-decoration:underline;
}
a.link9:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 9pt;
	color: #0000FF;
	text-decoration:underline;
}
a {
	font-size: 9pt;
}
body,td,th {
	font-size: 9pt;
}
.STYLE4 {color: #000000}
.STYLE5 {color: #0066CC}
.STYLE6 {color: #0066FF}
.STYLE7 {color: #FFFFFF}
-->
</style>
<script type="text/javascript">	
	function reg(){
		window.location.href = "/EShopping/register.jsp";
	}
</script>

	<body bgcolor="#A2C97A" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">
		<jsp:include flush="true" page="top.jsp"></jsp:include>

		<DIV id=STATICMENU
			style="Z-INDEX: 999; LEFT: 887px; VISIBILITY: visible; WIDTH: 76px; POSITION: absolute; TOP: 259px; HEIGHT: 203px">
			<table width="100%" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/qq_01.gif"
							width="103" height="36">
					</td>
				</tr>
				<tr>
					<td height="114"
						background="${pageContext.request.contextPath}/images/qq_02.gif">
						<table width="90%" align="center" cellpadding="0" cellspacing="0">

							<c:forEach items="${requestScope.arrayList3}" var="row">
								<tr>
									<td width="29%" height="24">
										<div align="center">
											<img
												src="${pageContext.request.contextPath}/images/hot_gif.gif"
												width="23" height="11">
										</div>
									</td>
									<td width="71%" height="24">
										<a href="/EShopping/servlet/QueryOneInfo?id=${row.id}"><c:out
												value="${row.name}"></c:out> </a>
									</td>
								</tr>
							</c:forEach>

						</table>
					</td>
				</tr>
				<tr>
					<td height="44" valign="bottom"
						background="${pageContext.request.contextPath}/images/qq_03.gif">
						<table width="100%" cellspacing="0" cellpadding="0">
							<tr>
								<td height="30">
									<div align="center" class="STYLE7">
										站长推荐
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<SCRIPT language=javascript>
<!--
var stmnGAP1 = 70; 
var stmnGAP2 = 325; 
var stmnBASE = 70; 
var stmnActivateSpeed = 200;
var stmnScrollSpeed = 10;

var stmnTimer;

function RefreshStaticMenu()
{
var stmnStartPoint, stmnEndPoint, stmnRefreshTimer;

stmnStartPoint = parseInt(STATICMENU.style.top, 10);
stmnEndPoint = document.body.scrollTop + stmnGAP2;
if (stmnEndPoint < stmnGAP1) stmnEndPoint = stmnGAP1;

stmnRefreshTimer = stmnActivateSpeed;

if ( stmnStartPoint != stmnEndPoint ) {
                stmnScrollAmount = Math.ceil( Math.abs( stmnEndPoint - stmnStartPoint ) / 15 );
                STATICMENU.style.top = parseInt(STATICMENU.style.top, 10) + ( ( stmnEndPoint<stmnStartPoint ) ? -stmnScrollAmount : stmnScrollAmount );
                stmnRefreshTimer = stmnScrollSpeed;
}

stmnTimer = setTimeout ("RefreshStaticMenu();", stmnRefreshTimer);
}

                STATICMENU.style.top = document.body.scrollTop + stmnBASE;
                RefreshStaticMenu();
//-->
      </SCRIPT>
		</DIV>





		<table width="780" border="1" align="center" cellpadding="0"
			cellspacing="2" bordercolor="#57AD00" bgcolor="#ADE000">
			<tr>
				<td align="left" valign="top">



					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="772" align="left" valign="top">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="195" align="left" valign="top">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="yinyin">
												<tr>
													<td width="12%" height="23" align="left"
														background="${pageContext.request.contextPath}/image/bt2.gif">
														<div align="center" class="STYLE22">
															<div align="left">
																<img
																	src="${pageContext.request.contextPath}/image/anniu2.gif"
																	width="20" height="20" />
															</div>
														</div>
													</td>
													<td width="88%"
														background="${pageContext.request.contextPath}/image/bt2.gif"
														class="daohang">
														猪猪公告
													</td>
												</tr>
												<tr>
													<td height="180" colspan="2" valign="middle">
														<table width="100%" height="180" border="0"
															cellpadding="0" cellspacing="0">
															<tr>
																<td class="STYLE36">
																	<marquee direction="up" onmouseover="stop()"
																		onmouseout="start()" scrollAmount=3 scrollDelay=90
																		width="195" height="180">
																		&nbsp;&nbsp;&nbsp;
																		<span class="text">经过猪猪工作室全体成员的共同努力，我的猪猪之家正式向广大用户开放了，欢迎大家在有空的时候进来坐坐，多多捧场，提出宝贵意见，谢谢您的光临！</span>
																	</marquee>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td width="139" align="left" valign="top" class="STYLE22">
											<table width="99%" border="0" cellpadding="0" cellspacing="0"
												class="yinyin">
												<tr>
													<td width="22" height="23"
														background="${pageContext.request.contextPath}/image/bt2.gif">
														<img
															src="${pageContext.request.contextPath}/image/anniu2.gif"
															width="20" height="20" />
													</td>
													<td width="116"
														background="${pageContext.request.contextPath}/image/bt2.gif"
														class="daohang">
														猪猪秀
													</td>
												</tr>
												<tr>
													<td colspan="2">
														<img
															src="${pageContext.request.contextPath}/image/photo.jpg"
															width="137" height="180" />
													</td>
												</tr>
											</table>
										</td>
										<td width="254" align="left" valign="top" class="STYLE22">
											<table width="99%" border="0" cellpadding="0" cellspacing="0"
												class="yinyin">
												<tr>
													<td width="22" height="23"
														background="${pageContext.request.contextPath}/image/bt2.gif">
														<img
															src="${pageContext.request.contextPath}/image/anniu2.gif"
															width="20" height="20" />
													</td>
													<td width="229"
														background="${pageContext.request.contextPath}/image/bt2.gif"
														class="daohang">
														猪猪宣言
													</td>
												</tr>
												<tr>
													<td colspan="2">
														<object
															classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
															width="250" height="180">
															<param name="movie"
																value="${pageContext.request.contextPath}/image/xuanyan.swf">
															<param name="quality" value="high">
															<embed
																src="${pageContext.request.contextPath}/image/xuanyan.swf"
																quality="high" type="application/x-shockwave-flash"
																width="250" height="180"></embed>
														</object>
													</td>
												</tr>
											</table>
										</td>
										<td width="184" align="left" valign="top" class="STYLE22">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="yinyin">
												<tr>
													<td width="22" height="23"
														background="${pageContext.request.contextPath}/image/bt2.gif">
														<span style="LINE-HEIGHT: 15pt"><span
															class="STYLE36"><img
																	src="${pageContext.request.contextPath}/image/anniu2.gif"
																	width="20" height="20" /> </span> </span>
													</td>
													<td width="162"
														background="${pageContext.request.contextPath}/image/bt2.gif">
														<span class="daohang" style="LINE-HEIGHT: 15pt">猪猪时钟</span>
													</td>
												</tr>
												<tr>
													<td colspan="2" align="right">
														<object
															classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
															width="170" height="180">
															<param name="movie"
																value="${pageContext.request.contextPath}/image/clock1.swf" />
															<param name="quality" value="high" />
															<param name="wmode" value="transparent" />
															<embed
																src="${pageContext.request.contextPath}/image/clock1.swf"
																width="170" height="180" quality="high"
																type="application/x-shockwave-flash" wmode="transparent"></embed>
														</object>
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
								<table width="100%" height="130" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="195" align="left" valign="top" class="yinyin">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="99" valign="top">
														<table width="100%" border="0" cellpadding="0"
															cellspacing="0">
															<tr>
																<td width="22" height="23"
																	background="${pageContext.request.contextPath}/image/bt2.gif">
																	<img
																		src="${pageContext.request.contextPath}/image/anniu2.gif"
																		width="20" height="20" />
																</td>
																<td width="88%"
																	background="${pageContext.request.contextPath}/image/bt2.gif"
																	class="daohang">
																	猪猪登录
																</td>
															</tr>
															<tr>

															</tr>
														</table>
														<!-- 登录的表单提交 -->
														<c:choose>
															<c:when test="${empty userName}">
																<form action="/EShopping/servlet/CheckServlet">
																	<table>
																		<tr>
																			<td>
																				用户名
																			</td>
																			<td>
																				<input type="text" name="userName" size="20" />
																			</td>
																		</tr>

																		<tr>
																			<td>
																				密 码
																			</td>
																			<td>
																				<input type="password" name="passWord" size="20" />
																			</td>
																		</tr>

																		<tr>
																			<td>
																				验证码
																			</td>

																			<td>
																				<input type=text name="nam" size="10"
																					styleClass="textBox">
																				<script language="javascript" runat=client>
																				var n=parseInt(Math.random()*8999+1000);
																				document.write("<img id=mk src=${pageContext.request.contextPath}/image.jsp?num="+n+">");
																				function nextImage(){
																					n=parseInt(Math.random()*8999+1000);
																					document.all("mk").src="image.jsp?num="+n;
																				}
																				</script>
																				<a href="javascript:nextImage();">换一张</a>

																			</td>
																		</tr>

																		<tr>

																			<td>
																				<input type="submit" value="登录" />
																			</td>
																			<td>
																				<input type="button" value="注册" onclick="reg()" />
																			</td>
																		</tr>
																	</table>
																</form>
															</c:when>
															<c:otherwise>
																<br>
																<br>
																尊敬的会员:<font class="red">${sessionScope.userName}<br>
																</font>
																<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您进入猪猪之家网上电子商城！
															</c:otherwise>
														</c:choose>


													</td>
												</tr>


												<tr>
													<td height="89">
														<table width="100%" height="20" border="0" cellpadding="0"
															cellspacing="0">
															<tr>
																<td height="20" colspan="2"
																	background="${pageContext.request.contextPath}/image/bt2.gif">
																	<img
																		src="${pageContext.request.contextPath}/image/anniu2.gif"
																		width="20" height="20" />
																	<font class="daohang">商城类别</font>
																</td>
															</tr>
															<tr>
																<td width="22">
																	<table width="194">
																		<c:choose>
																			<c:when test="${empty requestScope.arrayList2}">
																				<TD width="186" colspan="3" valign="top"
																					class="redText">
																					对不起还没有添加商品类别！
																				</TD>
																			</c:when>
																			<c:otherwise>
																				<c:forEach items="${requestScope.arrayList2}"
																					var="row">
																					<TR>
																						<TD class="text">
																							&nbsp;
																							<img
																								src="${pageContext.request.contextPath}/images/cateIcon.gif"
																								border="0">
																							<a
																								href="/EShopping/servlet/SortByTypeName?id=${row.id}">${row.typeName}</a>
																						</TD>
																					</TR>
																				</c:forEach>
																			</c:otherwise>
																		</c:choose>
																	</table>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td align="left" valign="top">
											<table width="576" height="205" border="0" cellpadding="0"
												cellspacing="0" class="yinyin">
												<tr>
													<td width="23" height="23"
														background="${pageContext.request.contextPath}/image/bt2.gif">
														<img
															src="${pageContext.request.contextPath}/image/anniu2.gif"
															width="20" height="20" />
													</td>
													<td width="550"
														background="${pageContext.request.contextPath}/image/bt2.gif"
														bgcolor="#ADE000" class="daohang">
														特价区
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<A href="/EShopping/servlet/MoreSecShop"><IMG hspace=5
																src="${pageContext.request.contextPath}/image/icon_more.gif"
																border=0> </A>
													</td>

												</tr>
												<tr>



													<td height="180" colspan="2" align="left" valign="top">
														<table cellspacing="0" cellpadding="0" width="286"
															border="0">
															<tbody>
																<tr>
																	欢迎挑选特价商品^-^
																	<!-- 在这里循环产生图片 -->
																	<c:choose>
																		<c:when test="${empty requestScope.arrayList}">

																			<TD valign="top" class="redText" colspan="3">
																				对不起还没有添加商品！
																			</TD>
																		</c:when>
																		<c:otherwise>
																			<c:forEach items="${requestScope.arrayList}"
																				var="row">

																				<TD valign="top" width="33%">
																					<table cellspacing=0 cellpadding=0 width=180
																						border=0>
																						<tr>

																							<td align="TOP">

																								<table width="110" height="120" border="0"
																									align="center" cellpadding="0" cellspacing="0"
																									style="border:1px; border-style:solid; border-color:#57AD00">
																									<tr align="center" valign="middle">
																										<td>
																											<!-- 进入商品浏览的详细信息 -->
																											<a
																												href="/EShopping/servlet/QueryOneInfo?id=${row.id}"
																												target=_blank> <img
																													src="${pageContext.request.contextPath}/${row.fileName}"
																													width="105" height="120" border="0">
																											</a>
																										</td>
																									</tr>
																								</table>
																							</td>
																						</tr>
																						<tr align="center" height="30">
																							<td>
																									<a
																												href="/EShopping/servlet/QueryOneInfo?id=${row.id}"
																												target=_blank><span
																									class="blueText">${row.name}</span> </a>
																							</td>
																						</tr>
																						<tr align="center" height="20">
																							<td class="text">
																								市场价 ： ￥${row.price}
																							</td>
																						</tr>
																						<tr align="center" height="20">
																							<td class="text">
																								特价 ： ￥${row.saleprice}
																							</td>
																						</tr>
																						<tr>
																							<td>

																								<a
																									href="/EShopping/servlet/TakeCart?id=${row.id}"><img
																										alt="添加到购物车！"
																										src="${pageContext.request.contextPath}/image/dyy_buycar.gif"
																										border=0> </a>
																								<a
																									href="/EShopping/servlet/CommentBookOne?id=${row.id}"><img
																										src="${pageContext.request.contextPath}/image/offline.gif"
																										border=0> </a>
																							</td>
																						</tr>
																					</table>
																				</TD>

																			</c:forEach>
																		</c:otherwise>
																	</c:choose>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
											</table>
										</td>




										<td align="left" valign="top"></td>
									</tr>


								</table>
							</td>
						</tr>

						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td width="195" align="left" valign="top" class="yinyin">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="12%" height="23"
														background="${pageContext.request.contextPath}/image/bt2.gif">
														<img
															src="${pageContext.request.contextPath}/image/anniu2.gif"
															width="20" height="20" />
													</td>
													<td width="88%"
														background="${pageContext.request.contextPath}/image/bt2.gif"
														class="daohang">
														商城信息
													</td>

												</tr>
												<tr>
													<td height="100" colspan="2" valign="top">
														&nbsp;订销量排名前十位！
														<table align="left">
															<c:forEach items="${requestScope.arrayList4}" var="row">
																<tr>
																	<td width="29%" height="24">
																		<div align="center">
																			<img
																				src="${pageContext.request.contextPath}/images/hot_gif.gif"
																				width="23" height="11">
																		</div>
																	</td>
																	<td width="71%" height="24">
																		<a href="/EShopping/servlet/QueryOneInfo?id=${row.id}"><c:out
																				value="${row.name}"></c:out> </a>
																	</td>
																</tr>
															</c:forEach>
														</table>
													</td>
												</tr>
											</table>
										</td>
										<td valign="top">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="yinyin">
												<tr>
													<td width="22" height="23"
														background="${pageContext.request.contextPath}/image/bt2.gif">
														<img
															src="${pageContext.request.contextPath}/image/anniu2.gif"
															width="20" height="20" />
													</td>
													<td width="617"
														background="${pageContext.request.contextPath}/image/bt2.gif"
														class="daohang">
														新品上市
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<A href="/EShopping/servlet/MoreNewShop"><IMG hspace=5
																src="${pageContext.request.contextPath}/image/icon_more.gif"
																border=0> </A>
													</td>
												</tr>
												<tr>
													<td colspan="2" align="left" valign="middle">

														最新的产品信息请任意浏览！

														<table cellspacing="0" cellpadding="0" width="286"
															border="0">
															<tbody>
																<tr>
																	<!-- 在这里循环产生图片 -->
																	<c:choose>
																		<c:when test="${empty requestScope.arrayList1}">

																			<TD valign="top" class="redText" colspan="3">
																				对不起还没有添加商品！
																			</TD>
																		</c:when>
																		<c:otherwise>
																			<c:forEach items="${requestScope.arrayList1}"
																				var="row">

																				<TD valign="top" width="33%">
																					<table cellspacing=0 cellpadding=0 width=180
																						border=0>
																						<tr>

																							<td valign="top">
																								<br>
																							</td>
																							<td align="TOP">
																								<table width="110" height="120" border="0"
																									align="center" cellpadding="0" cellspacing="0"
																									style="border:1px; border-style:solid; border-color:#57AD00">
																									<tr align="center" valign="middle">
																										<td>
																											<!-- 进入商品浏览的详细信息 -->
																											<a
																												href="/EShopping/servlet/QueryOneInfo?id=${row.id}"
																												target=_blank> <img
																													src="${pageContext.request.contextPath}/${row.fileName}"
																													width="105" height="120" border="0">
																											</a>
																										</td>
																									</tr>
																								</table>
																							</td>
																						</tr>
																						<tr align="center" height="30">
																							<td valign="top">
																								<br>
																							</td>
																							<td>
																									<a href="/EShopping/servlet/QueryOneInfo?id=${row.id}"
																												target=_blank><span
																									class="blueText">${row.name}</span> </a>
																							</td>
																						</tr>
																						<tr align="center" height="20">
																							<td valign="top">
																								<br>
																							</td>
																							<td class="text">
																								市场价 ： ￥${row.price}
																							</td>
																						</tr>
																						<tr align="center" height="20">
																							<td valign="top">
																								<br>
																							</td>
																							<td class="text">
																								特价 ： ￥${row.saleprice}
																							</td>
																						</tr>
																						<tr>
																							<td valign="top">
																								<br>
																							</td>
																							<td>

																								<a
																									href="/EShopping/servlet/TakeCart?id=${row.id}"><img
																										alt="添加到购物车！"
																										src="${pageContext.request.contextPath}/image/xiaoche.gif"
																										border=0> </a>
																								<a
																									href="/EShopping/servlet/CommentBookOne?id=${row.id}"><img
																										src="${pageContext.request.contextPath}/image/offline.gif"
																										border=0> </a>
																							</td>
																						</tr>
																					</table>
																				</TD>

																			</c:forEach>
																		</c:otherwise>
																	</c:choose>
																</tr>
															</tbody>
														</table>




													</td>
												</tr>
											</table>
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
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td width="195" align="left" valign="top" class="yinyin">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="12%" height="23"
											background="${pageContext.request.contextPath}/image/bt2.gif">
											<img
												src="${pageContext.request.contextPath}/image/anniu2.gif"
												width="20" height="20" />
										</td>
										<td width="88%"
											background="${pageContext.request.contextPath}/image/bt2.gif"
											class="daohang">
											商品浏览记录
										</td>
									</tr>
									<tr>
									
									
									<td height="100"  valign="top" class="redText" colspan="2">

											<!-- 浏览历史记录 -->
												
											<font class="redText">如需知道你曾浏览过的商品请点击！</font>
											<br>
											<br>
											<a href="/EShopping/servlet/CheckHistory">
											查看历史记录 
											</a>
									</td>
									
									</td>
									</tr>
								</table>
							</td>
							<td valign="top">
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="yinyin">
									<tr>
										<td width="22" height="23"
											background="${pageContext.request.contextPath}/image/bt2.gif">
											<img
												src="${pageContext.request.contextPath}/image/anniu2.gif"
												width="20" height="20" />
										</td>
										<td width="617"
											background="${pageContext.request.contextPath}/image/bt2.gif"
											class="daohang">
											美图欣赏
										</td>
									</tr>
									<tr>
										<td colspan="2" align="left" valign="middle">
											<!--滚动代码开始-->
											<DIV id=demo
												style="OVERFLOW: hidden; WIDTH: 577px; HEIGHT: 100px">
												<table width="577" height="56" border="0" cellspacing="0">
													<tr>
														<td id="demo11" valign="top">
															<table width='100%' cellpadding='0' cellspacing='5'
																border='0' align='center'>
																<tr valign='middle'>
																	<td width="100" valign="top">
																		<img
																			src="${pageContext.request.contextPath}/image/1.jpg"
																			width="100" height="75" />
																	</td>
																	<td width="100" valign="top">
																		<img
																			src="${pageContext.request.contextPath}/image/2.jpg"
																			width="100" height="75" />
																	</td>
																	<td width="100" valign="top">
																		<img
																			src="${pageContext.request.contextPath}/image/3.jpg"
																			width="100" height="75" />
																	</td>
																	<td width="100" valign="top">
																		<img
																			src="${pageContext.request.contextPath}/image/4.jpg"
																			width="100" height="75" />
																	</td>
																	<td width="100" valign="top">
																		<img
																			src="${pageContext.request.contextPath}/image/5.jpg"
																			width="100" height="75" />
																	</td>
																	<td width="100" valign="top">
																		<img
																			src="${pageContext.request.contextPath}/image/6.jpg"
																			width="100" height="75" />
																	</td>
																</tr>
															</table>
														</td>
														<td width="1" valign="top" id="demo12"></td>
													</tr>
												</table>
											</div>
											<SCRIPT>
  var speed=15
  demo12.innerHTML=demo11.innerHTML
  function Marquee11(){
  if(demo12.offsetWidth-demo.scrollLeft<=0)
  demo.scrollLeft-=demo11.offsetWidth
  else{
  demo.scrollLeft++
  }
  }
  var MyMar1=setInterval(Marquee11,speed)
 demo.onmouseover=function() {clearInterval(MyMar1)}
  demo.onmouseout=function() {MyMar1=setInterval(Marquee11,speed)}
</SCRIPT>
											<!--滚动代码结束-->
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>


		<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>

