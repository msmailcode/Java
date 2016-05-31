<%@ page language="java" pageEncoding="gb2312"%>
<jsp:directive.page import="java.util.Date"/>
<%@ taglib uri="http://jpager.com/taglibs/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>商品特价管理</title>
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
			window.location.href = "/EShopping/Admin/adminAddMerSpe.jsp";
		}
		function f2(){
			var b = window.confirm("你确定要删除全部信息吗?");
			if(b){
				//进入删除的servlet将表中的数据全部删除
				window.location.href = "/EShopping/servlet/DelAllBook";
			}else {
				
			}
		}
		function f3(){
			var b = window.confirm("你确定要导出全部信息吗?");
			if(b){
				//进入删除的servlet将表中的数据全部删除
				window.location.href = "/EShopping/servlet/OutExcelBook";
			}else {
				
			}
		}
		//搜索商品
		function QuickSearch(){
			var key = document.all.qKey.value;
			if (key !=null && key!="商品关键字"){
				document.forms.form2.submit();
			}else {
				window.alert("商品关键字不能为空!");
			}
		}
		
	</script>
	<script language="javascript">
		//定义一个变量用于存放XMLHttpRequest对象
		var xmlHttp; 
		//记录事件发生时的鼠标位置
		var x,y;
		
		//该函数用于创建一个XMLHttpRequest对象
		function createXMLHttpRequest() {
			if (window.ActiveXObject) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} 
			else if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			}
		}
		
		//这是一个通过AJAX取得提示信息的方法
		function over(index){
			//记录事件发生时的鼠标位置
			x = event.clientX;
			y = event.clientY;		
			//创建一个XMLHttpRequest对象
			createXMLHttpRequest();
			//将状态触发器绑定到一个函数
			xmlHttp.onreadystatechange = processor;
			//这里建立一个对服务器的调用
			xmlHttp.open("GET", "/EShopping/servlet/CreateTip?index="+index);
			//发送请求
			xmlHttp.send(null);
		}
		
		//处理从服务器返回的XML文档
		function processor() {
			//定义一个变量用于存放从服务器返回的响应结果
			var result;
			if(xmlHttp.readyState == 4) { //如果响应完成
				if(xmlHttp.status == 200) {//如果返回成功
					//取出服务器返回的XML文档的所有shop标签的子节点
					result = xmlHttp.responseXML.getElementsByTagName("shop");
					//显示工具提示
					document.all.tip.style.display = "block";
					//显示工具提示的起始坐标
					document.all.tip.style.top = y;
					document.all.tip.style.left = x+10;
					document.all.photo.src = result[0].childNodes[2].firstChild.nodeValue;					
					document.all.tipTable.rows[1].cells[0].innerHTML="商品名称："+result[0].childNodes[0].firstChild.nodeValue;
					document.all.tipTable.rows[2].cells[0].innerHTML="商品价格："+result[0].childNodes[1].firstChild.nodeValue;
				}
			}
		}
		
		function out(){
			document.all.tip.style.display = "none";
		}								
		
	</script>
	<body class=body_normal leftMargin=0 topMargin=0>
	<!-- 怎么实现将提示框打入jsp页面中,定义一个全局的变量 -->
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
				out.write("<script type='text/javascript'>alert('修改信息成功！');</script>");
			}
		}
		else if(n ==2){
			if(m == 1){
				out.write("<script type='text/javascript'>alert('商品类别增加成功！');</script>");
			}
		}
		else if(n ==3){
			if(m == 1){
				out.write("<script type='text/javascript'>alert('商品类别增加失败！');</script>");
			}
		}
		}
		
	 %>
	<table>
						<tr>
						<td height="30" align="center" class="redText">
						Admin >> 商品分类管理员 >> <%= session.getAttribute("admin") %> 你好！
						<%= new Date().toLocaleString() %>
						</td>
						</tr>
	
	</table>
		
		<c:choose>
			<c:when test="${empty requestScope.arrayList}">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					style="background-color:lightgrey; border:0px;">
					<tr>
						<td height="40" class="itemTitle" align="center"> 
							商品特价管理 
						</td>
					</tr>
					<tr>
						<td height="30" class="blueText" align="center">
							<span class="blueText"><a href="/EShopping/Admin/adminAddMerSpe.jsp"
								class="blueText">增加</a>
							</span>
							<br>
							<br>
						</td>
					</tr>
					<tr>
						<td style="text-align:center;">
							你还没有添加新的记录!
						</td>
					</tr>
					</c:when>
					<c:otherwise>
						<FONT face=宋体>
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
											<FONT class=font_title>商品特价管理</FONT>&nbsp;
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<form action="/EShopping/servlet/QueryMerSpe" name="form2">
							<TABLE class=table_search id=Table4 cellSpacing=0 cellPadding=3
								width="100%">
								<!-- 查询表单的提交 -->
								
								<TBODY>
									<TR>
										<TD noWrap width="1%">
											&nbsp; 常用条件
											<input type="text" name="qKey" style="WIDTH: 180px;">
											查询
											<SELECT id=query style="WIDTH: 85px;" name="query">
												<OPTION value="0" selected>
													全部条件
												</OPTION>
												<OPTION value="1">
													商品型号
												</OPTION>
												<OPTION value="2">
													商品名称
												</OPTION>
												<OPTION value="3">
													商品优惠价
												</OPTION>
												<OPTION value="4">
													商品市场价
												</OPTION>
											</SELECT>
											<IMG style="CURSOR: hand;" height=17
												src="../image/ico_select.gif" width=16 align="middle" border=0>
										</TD>
										<TD noWrap width=*>
											<INPUT class=button_normal id=btnSearch
												type="button"
												value=查询(S) name=btnSearch accessKey=s onclick="QuickSearch()">
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
												onclick="f1();" value=新增(N) name=btnNew>
											<INPUT class=button_normal
												onClick="f2();" type="button" value=删除(D)
												name=btnDelete>
											<INPUT class=button_normal	onclick="f3()"
												type="button" value="导出(E)" name=btnOutExcel>
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
											<A href="adminMerSpe.jsp">序号</A>
										</TD>
										<TD noWrap>
											<A href="adminMerSpe.jsp">商品型号</A>
										</TD>
										<TD noWrap>
											<A href="adminMerSpe.jsp">商品名称</A>
										</TD>
										<TD noWrap>
											<A href="adminMerSpe.jsp">商品图片</A>
										</TD>
										<TD noWrap>
											<A href="adminMerSpe.jsp">商品市场价</A>
										</TD>
										<TD noWrap>
											<A href="adminMerSpe.jsp">商品特价</A>
										</TD>
										<TD noWrap>
											<A href="adminMerSpe.jsp">商品维护</A>
										</TD>
									</TR>
									<page:pager dz="5">
										<!-- dz代表默认的显示记录条数，如果不指定，则默认为20条 -->
										<c:forEach var="row" items="${requestScope.arrayList}" varStatus="status">
											<page:item nr="${status.count}">
											<TR class=datagrid_itemstyle_normal
												onmouseover="this.className='datagrid_itemstyle_over';"
												style="CURSOR: hand"
												onmouseout="this.className='datagrid_itemstyle_normal';"
												align=middle nowrap="nowrap">

												
													<!-- //nr表示要处理的是哪个序号的记录,${status.count}显示1,2,3....序号，如果不用这种语法，可以i++后，把i传给nr -->

													<td nowrap>
														&nbsp;${status.count}&nbsp;
													</td>
													<td nowrap>
														&nbsp;${row.descript}&nbsp;
													</td>
													<td nowrap>
														&nbsp;${row.name}&nbsp;
													</td>
													<td nowrap onmouseover="over(${row.id-1})" onmouseout="out()">
														&nbsp;${row.fileName}&nbsp;
													</td>
													<td nowrap>
														&nbsp;${row.price}&nbsp;
													</td>
													<td nowrap>
														&nbsp;${row.saleprice}&nbsp;
													</td>
													<td nowrap align="center">
														<a href="/EShopping/servlet/DelBook?id=${row.id}"
															onclick='return confirm("确定要删除吗?")'>删除</a>&nbsp;&nbsp;
														<a href="/EShopping/servlet/ToModBookInfo?id=${row.id}">修改</a>
													</td>
												
											</TR>
											
											</page:item>
										</c:forEach>
									</page:pager>
									<tr>
										<td colspan="7" align="center">
											<page:bt />
											<!--//这行显示最下面的导航栏  -->
										</td>
									</tr>
								</TBODY>
							</TABLE>
					</c:otherwise>
		</c:choose>
		<div id="tip" style="position:absolute;display:none;border:1px;border-style:solid;">
		<TABLE id="tipTable" border="0" bgcolor="#ffffee">
		<TR align="center">
			<TD><img id="photo" src="" height="80" width="80"></TD>
		</TR>
		<TR>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
		</TR>
	</TABLE>
	</div>	        
	</body>
</html>
