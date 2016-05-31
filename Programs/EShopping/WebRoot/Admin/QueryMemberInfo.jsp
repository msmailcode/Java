<%@ page language="java" pageEncoding="gb2312"%>
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
			background-color:lightgrey;
		}
		-->
	</style>
		<script type="text/javascript">
		function f1(){
			var typeName = document.all.typeName.value ;
			var typeInfo = document.all.typeInfo.value ;
			if(typeName == ""){
				window.alert("分类名称不允许为空！");
				document.all.typeName.focus();
				return false;
			}
			if(typeInfo == ""){
				window.alert("分类描述不能为空!")
				document.all.typeInfo.focus();
				return false;
			}
		}
	</script>
		
		<style type="text/css">
		<!--
		body {
			background-color: lightgrey;
		}
		-->
	</style>
	</head>



	<body>
		<table border="0" align="center" cellpadding="0" cellspacing="0"
			style="background-color:lightgrey; border:0px;">
			<tr>
				<td height="40" class="itemTitle" align="center">
					会员详情
				</td>
			</tr>
			<tr>
				<td height="30" align="center">
					<table width="609" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#FFFFFF" height="270">

					
						<tr>
							<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								会员级别 ：
							</td>
							<td>
								&nbsp;
								<select>
									<option value="1">
										普通会员
									</option>
									<option value="2">
										黄金会员
									</option>
									<option value="3">
										白金会员
									</option>
									<option value="4">
										钻石会员
									</option>
								</select>

							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								登录帐号 ：
							</td>
							<td>
								&nbsp;${member.userName}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								真实姓名 ：
							</td>
							<td>
								&nbsp;${member.name}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								身份证号 ：
							</td>
							<td>
								&nbsp;${member.card}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								联系地址 ：
							</td>
							<td>
								&nbsp;${member.address}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								注册时间 ：
							</td>
							<td>
								&nbsp;${member.regtime}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								电子邮箱 ：
							</td>
							<td>
								&nbsp;${member.email}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								注册状态 ：
							</td>
							<td>
								&nbsp; 
								<c:if test="${member.state==1}">
								启用
								</c:if>
								<c:if test="${member.state==0}">
								禁用
								</c:if>
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								当前在线人数 ：
							</td>
							<td>
								&nbsp;
								<%=(Integer) application.getAttribute("num")%>
							</td>
						</tr>

						<tr>
							<td height="10" colspan="2"></td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
		<center>
			<a href="/EShopping/servlet/AdminMerList"> <font class="redText"><span>返回</span></font> </a>
		</center>

	</body>
</html>
