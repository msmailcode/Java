<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<jsp:directive.page import="javabean.Book"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>商品管理</title>
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
	<script type="text/javascript" src="../date.js">
		</script>
		<script type="text/javascript">
		function ShowObject(objName)
			{
				var col_focus = "#ff6600";
				var col_blur = "#000000";

				document.all("divbase").style.color = col_blur;
				document.all("divbz").style.color = col_blur;
				
				document.all("Tblbase").style.display = "none";
				document.all("Tblbz").style.display = "none";
				    
				document.all("div" + objName).style.color = col_focus;
				document.all("Tbl" + objName).style.display = "";
			}
			
			//设置图片显示			 
			function preview()
			{
				document.all("img_photo").src=document.form1.fileName.value;
			}
			function f1(){
				var typeid = document.getElementById("typeid").value;
				window.alert(typeid);
			}
	</script>
	</head>
	<body class=body_normal>
	<%  
    	Book book = (Book)request.getAttribute("book");  
     %>
		<table border="0" align="center" cellpadding="0" cellspacing="0"
			style="background-color:lightgrey; border:0px;">
			<tr>
				<td height="40" class="itemTitle" align="center">
					商品信息修改
				</td>
			</tr>
		</table>
		<!-- 提交到的位置 -->
		<FORM id=form1 name=form1 action="/EShopping/servlet/ToModBookSuccess" method="post"  enctype="multipart/form-data">
			<input type="hidden" value="<%=book.getId() %>" name="id">
			<INPUT type=hidden
				value=dDwxOTY1ODE4MjE7dDw7bDxpPDE+Oz47bDx0PHA8bDxlbmN0eXBlOz47bDxtdWx0aXBhcnQvZm9ybS1kYXRhOz4+O2w8aTw3PjtpPDE5PjtpPDIxPjs+O2w8dDxwPHA8bDxFbmFibGVkOz47bDxvPHQ+Oz4+Oz47Oz47dDw7bDxpPDA+O2k8MT47PjtsPHQ8O2w8aTwwPjtpPDE+O2k8Mj47aTwzPjs+O2w8dDw7bDxpPDE+Oz47bDx0PHA8cDxsPFRleHQ7PjtsPOS6p+WTgeexu+WIqzs+Pjs+Ozs+Oz4+O3Q8O2w8aTwwPjtpPDI+Oz47bDx0PHQ8O3Q8aTwzPjtAPCA756Gs5Lu2O+i9r+S7tjs+O0A8IDvnoazku7Y76L2v5Lu2Oz4+Oz47Oz47dDxwPHA8bDxUZXh0O1JlYWRPbmx5O1Zpc2libGU7PjtsPFxlO288Zj47bzxmPjs+Pjs+Ozs+Oz4+O3Q8O2w8aTwxPjs+O2w8dDxwPHA8bDxUZXh0Oz47bDzkuqflk4HlkI3np7A7Pj47Pjs7Pjs+Pjt0PDtsPGk8Mj47PjtsPHQ8cDxwPGw8VGV4dDtSZWFkT25seTtWaXNpYmxlOz47bDxcZTtvPGY+O288Zj47Pj47Pjs7Pjs+Pjs+Pjt0PDtsPGk8MD47aTwxPjtpPDI+O2k8Mz47PjtsPHQ8O2w8aTwxPjs+O2w8dDxwPHA8bDxUZXh0Oz47bDzkuqflk4Hop4TmoLw7Pj47Pjs7Pjs+Pjt0PDtsPGk8Mj47PjtsPHQ8cDxwPGw8VGV4dDtSZWFkT25seTtWaXNpYmxlOz47bDxcZTtvPGY+O288Zj47Pj47Pjs7Pjs+Pjt0PDtsPGk8MT47PjtsPHQ8cDxwPGw8VGV4dDs+O2w85Lqn5ZOB5Z6L5Y+3Oz4+Oz47Oz47Pj47dDw7bDxpPDI+Oz47bDx0PHA8cDxsPFRleHQ7UmVhZE9ubHk7VmlzaWJsZTs+O2w8XGU7bzxmPjtvPGY+Oz4+Oz47Oz47Pj47Pj47Pj47dDw7bDxpPDA+O2k8MT47aTwyPjtpPDQ+Oz47bDx0PDtsPGk8MD47aTwxPjtpPDI+O2k8Mz47PjtsPHQ8O2w8aTwxPjs+O2w8dDxwPHA8bDxUZXh0Oz47bDzkuqflk4HnvJbnoIE7Pj47Pjs7Pjs+Pjt0PDtsPGk8MT47aTwzPjs+O2w8dDxwPHA8bDxUZXh0Oz47bDxcZTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDtSZWFkT25seTtWaXNpYmxlOz47bDxcZTtvPGY+O288Zj47Pj47Pjs7Pjs+Pjt0PDtsPGk8MT47PjtsPHQ8cDxwPGw8VGV4dDs+O2w86K6h6YeP5Y2V5L2NOz4+Oz47Oz47Pj47dDw7bDxpPDA+O2k8Mj47PjtsPHQ8dDw7dDxpPDU+O0A8IDvku7Y75aWXO+S4qjvljIU7PjtAPCA75Lu2O+WllzvkuKo75YyFOz4+Oz47Oz47dDxwPHA8bDxUZXh0O1JlYWRPbmx5O1Zpc2libGU7PjtsPFxlO288Zj47bzxmPjs+Pjs+Ozs+Oz4+Oz4+O3Q8O2w8aTwwPjtpPDE+O2k8Mj47aTwzPjs+O2w8dDw7bDxpPDE+Oz47bDx0PHA8cDxsPFRleHQ7PjtsPOmUgOWUruWumuS7tzs+Pjs+Ozs+Oz4+O3Q8O2w8aTwzPjs+O2w8dDxwPHA8bDxUZXh0O1JlYWRPbmx5O1Zpc2libGU7PjtsPFxlO288Zj47bzxmPjs+Pjs+Ozs+Oz4+O3Q8O2w8aTwxPjs+O2w8dDxwPHA8bDxUZXh0Oz47bDzmiJDmnKzku7c7Pj47Pjs7Pjs+Pjt0PDtsPGk8Mz47PjtsPHQ8cDxwPGw8VGV4dDtSZWFkT25seTtWaXNpYmxlOz47bDxcZTtvPGY+O288Zj47Pj47Pjs7Pjs+Pjs+Pjt0PDtsPGk8MD47aTwxPjtpPDI+O2k8Mz47PjtsPHQ8O2w8aTwxPjs+O2w8dDxwPHA8bDxUZXh0Oz47bDzlupPlrZg7Pj47Pjs7Pjs+Pjt0PDtsPGk8Mz47PjtsPHQ8cDxwPGw8VGV4dDtSZWFkT25seTtWaXNpYmxlOz47bDxcZTtvPGY+O288Zj47Pj47Pjs7Pjs+Pjt0PDtsPGk8MT47PjtsPHQ8cDxwPGw8VGV4dDs+O2w85L6b5bqU5ZWGOz4+Oz47Oz47Pj47dDw7bDxpPDQ+Oz47bDx0PHA8cDxsPFRleHQ7UmVhZE9ubHk7VmlzaWJsZTs+O2w8XGU7bzxmPjtvPGY+Oz4+Oz47Oz47Pj47Pj47dDw7bDxpPDA+O2k8MT47PjtsPHQ8O2w8aTwwPjs+O2w8dDxwPHA8bDxUZXh0Oz47bDzkuqflk4HnroDku4s7Pj47Pjs7Pjs+Pjt0PDtsPGk8Mz47PjtsPHQ8cDxwPGw8VGV4dDtSZWFkT25seTtWaXNpYmxlOz47bDxcZTtvPGY+O288Zj47Pj47Pjs7Pjs+Pjs+Pjs+Pjs+Pjs+Pjs+T9LSv4K9r/03PyH4nsC8Y54nxLY=
				name=__VIEWSTATE>
			<TABLE class=table_bar id=Table4 width="100%">
				<TBODY>
					<TR>
						<TD style="WIDTH: 100%">
							<INPUT class=button_normal 
								 style="WIDTH: 60px"
								type=button value=新增(N) name=btnSaveNew>
							
							<INPUT class=button_normal 
								 style="WIDTH: 60px"
								type=button value=编辑(E) name=BtnEdit>
							<INPUT class=button_normal 
								type=button
								value="关 闭(C)" name=btnClose>
							<INPUT class=button_normal 
								 type="submit" style="WIDTH: 60px"
								value=保存(S) name=btnSave>	
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			
			<TABLE class=table_bar1 id=Table3 width="100%">
				<TBODY>
					<TR>
						<TD noWrap width=60>
							<SPAN id=Lblproduct_bigclass style="WIDTH: 60px">商品类别</SPAN>
						</TD>
						<TD noWrap width=160>
						
							<SELECT style="WIDTH: 140px"
								name=typeid>
							<c:forEach items="${sessionScope.arrayList1}" var="row">
								<OPTION value="${row.id}">
								<c:out value="${row.typeName}"></c:out>
								</OPTION>
							</c:forEach>	
							</SELECT>
						
						</TD>
						<TD noWrap width=60>
							<SPAN id=Lblproduct_name>商品名称</SPAN>
						</TD>
						<TD noWrap width=160>
							<INPUT class=text_normal style="WIDTH: 140px"
								name="name" value="<%=book.getName()  %>">
							<SPAN id=Label1
								style="FONT-WEIGHT: bold; FONT-SIZE: x-small; COLOR: red">*</SPAN>
						</TD>
					</TR>
					<TR>
						<TD noWrap>
							<SPAN id=Lblproduct_spec style="WIDTH: 60px">商品规格</SPAN>
						</TD>
						<TD noWrap>
							<INPUT class=text_normal style="WIDTH: 140px"
								name="marque" value="<%=book.getMarque()  %>" >
						</TD>
						<TD noWrap>
							<SPAN id=Lblproduct_model>商品型号</SPAN>
						</TD>
						<TD noWrap>
							<INPUT class=text_normal style="WIDTH: 140px"
								name=descript value="<%=book.getDescript()  %>">
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE id=Table2 height=22 cellSpacing=1 borderColorDark=#ffffff
				cellPadding=1 width="100%" borderColorLight=#8596ca border=0>
				<TBODY>
					<TR class=datagrid_headerstyle_normal>
						<TD id=divbase style="CURSOR: hand; COLOR: #ff6600"
							onclick="ShowObject('base');" noWrap align=middle>
							&nbsp;基本资料&nbsp;&nbsp;
						</TD>
						<TD id=divbz style="CURSOR: hand; COLOR: #000000"
							onclick="ShowObject('bz');" noWrap align=middle>
							&nbsp;产品图片&nbsp;&nbsp;
						</TD>
						<TD align=middle width="80%">
							&nbsp;
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE class=table_bar1 id=Tblbase width="100%">
				<TBODY>
					<TR>
						<TD noWrap width=60>
							<SPAN id=Lblproduct_code style="WIDTH: 60px">现有库存</SPAN>
						</TD>
						<TD noWrap width=160>
							<INPUT class=text_normal style="WIDTH: 140px"
								name=storage value="<%=book.getStorage()  %>">
						</TD>
						<TD noWrap width=60>
							<SPAN id=Lblproduct_unit>计量单位</SPAN>
						</TD>
						<TD noWrap width=160>
							<SELECT style="WIDTH: 140px; HEIGHT: 24px"
								name=unit>
								<OPTION value="本 " selected>本</OPTION>
								<OPTION value=件>
									件
								</OPTION>
								<OPTION value=套>
									套
								</OPTION>
								<OPTION value=个>
									个
								</OPTION>
								<OPTION value=包>
									包
								</OPTION>
							</SELECT>
						</TD>
					</TR>
					<TR>
						<TD noWrap>
							<SPAN id=Lblproduct_price style="WIDTH: 60px">市场价</SPAN>
						</TD>
						<TD noWrap>
							<INPUT class=text_normal  style="WIDTH: 140px"
								name=price value="<%=book.getPrice()  %>">
						</TD>
						<TD noWrap>
							<SPAN id=Lblproduct_cost_price>优惠价</SPAN>
						</TD>
						<TD noWrap>
							<INPUT class=text_normal 
								style="WIDTH: 140px" name=saleprice value="<%=book.getSaleprice()  %>">
						</TD>
					</TR>
					<TR>
						<TD noWrap>
							<SPAN id=Lblproduct_storage style="WIDTH: 60px">出厂日期</SPAN>
						</TD>
						<TD noWrap>
							<INPUT class=text_normal 
								style="WIDTH: 140px" name=leavetime onfocus="setday(this)" readonly value="<%=book.getLeavetime()  %>">
						</TD>
						<TD noWrap>
							<SPAN id=Lblproduct_provide>供应商</SPAN>
						</TD>
						<TD noWrap>
							<INPUT class=text_normal 
								style="WIDTH: 140px" name=provider value="<%=book.getProvider()  %>">
							<IMG id=Img1 onclick=doSelProvide();
								src="../image/ico_select.gif" align=absMiddle>
						</TD>
					</TR>
					<TR>
						<TD colSpan=4></TD>
					</TR>
					<TR>
						<TD noWrap>
							<SPAN id=Lblproduct_memo>产品简介</SPAN>
						</TD>
						<TD noWrap colSpan=3>
							<FONT face=宋体><TEXTAREA class=text_normal
									 style="WIDTH: 430px" name=contents
									rows=12><%=book.getContents() %></TEXTAREA> </FONT>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE id=Tblbz style="DISPLAY: none" cellSpacing=0 cellPadding=2
				width="100%" border=0>
				<TBODY>
					<TD noWrap>
						<SPAN id=Label6 style="WIDTH: 60px">产品图片</SPAN>
						<INPUT id=filePhoto
							style="BORDER-RIGHT: #ffffff 1px solid; BORDER-TOP: #ffffff 1px solid; BORDER-LEFT: #ffffff 1px solid; WIDTH: 250px; BORDER-BOTTOM: #ffffff 1px solid; BACKGROUND-COLOR: #ecf7ff"
							type=file onchange=preview() size=1 name=fileName>
					</TD>
					<TR>
						<TD noWrap>
							<FONT face=宋体><IMG id=img_photo title=建议上传大小：320*250
									height=250 width=320 border=0 name=img_photo>
							</FONT>&nbsp;
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</FORM>
	</BODY>
</HTML>
