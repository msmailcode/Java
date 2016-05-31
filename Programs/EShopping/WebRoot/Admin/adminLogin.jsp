<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<title>欢迎进入猪猪管理后台系统</title>
<link href="../CSS/stylesheet.css" rel="stylesheet" type="text/css">
</head>
<script language="javascript">
	
	//这是一个启动AJAX异步通信的方法
	function beginCheck(){
		var userName = document.all.userName.value;
		var passWord = document.all.passWord.value;
		if (userName == ""){//如果尚未输入注册名
		 	alert("请您输入帐户!");
		 	document.forms.form1.userName.focus();
		 	return;
		}
		if(passWord == ""){
			alert("请输入密码!");
			document.forms.form1.passWord.value;
			return;
		}
		window.document.forms.form1.submit();
	}
</script> 
<body>
<form  name="form1" action="/EShopping/servlet/AdminCheck">
	<table width="551" height="350" border="0" align="center" cellpadding="0" cellspacing="0" background="../image/login_back.jpg">
	  <tr>
		<td height="203">&nbsp;</td>
	  </tr>
	  <tr>
		<td><table width="80%"  border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="50" class="blackTitle">
				帐号：
			</td>
			<td>
				<input type="text" name="userName" size="15" styleClass="textBox"/>
			</td>
			<td width="50" class="blackTitle">
				密码：
			</td>
			<td>
				<input type="password" name="passWord" size="15" styleClass="textBox"/>
			</td>
			<td width="80">
				<div align="right">				
					<input type="image" src="../image/login_button.jpg" border="0" onclick="beginCheck()">
				</div>
			</td>
		  </tr>
		</table></td>
	  </tr>
	</table>
</form>
</body>
</html>
