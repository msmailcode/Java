<%@ page language="java" pageEncoding="gb2312"%>
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
			background-color:lightgrey;
		}
		-->
	</style>
		<script type="text/javascript">
		function f1(){
			var typeName = document.all.typeName.value ;
			var typeInfo = document.all.typeInfo.value ;
			if(typeName == ""){
				window.alert("�������Ʋ�����Ϊ�գ�");
				document.all.typeName.focus();
				return false;
			}
			if(typeInfo == ""){
				window.alert("������������Ϊ��!")
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
					��Ա����
				</td>
			</tr>
			<tr>
				<td height="30" align="center">
					<table width="609" border="0" cellpadding="0" cellspacing="1"
									bgcolor="#FFFFFF" height="270">

					
						<tr>
							<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								��Ա���� ��
							</td>
							<td>
								&nbsp;
								<select>
									<option value="1">
										��ͨ��Ա
									</option>
									<option value="2">
										�ƽ��Ա
									</option>
									<option value="3">
										�׽��Ա
									</option>
									<option value="4">
										��ʯ��Ա
									</option>
								</select>

							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								��¼�ʺ� ��
							</td>
							<td>
								&nbsp;${member.userName}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								��ʵ���� ��
							</td>
							<td>
								&nbsp;${member.name}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								���֤�� ��
							</td>
							<td>
								&nbsp;${member.card}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								��ϵ��ַ ��
							</td>
							<td>
								&nbsp;${member.address}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								ע��ʱ�� ��
							</td>
							<td>
								&nbsp;${member.regtime}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								�������� ��
							</td>
							<td>
								&nbsp;${member.email}
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								ע��״̬ ��
							</td>
							<td>
								&nbsp; 
								<c:if test="${member.state==1}">
								����
								</c:if>
								<c:if test="${member.state==0}">
								����
								</c:if>
							</td>
						</tr>
						<tr bgcolor="#F7F3F7" class="text">
										<td width="220" height="26" align="right">
								��ǰ�������� ��
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
			<a href="/EShopping/servlet/AdminMerList"> <font class="redText"><span>����</span></font> </a>
		</center>

	</body>
</html>
