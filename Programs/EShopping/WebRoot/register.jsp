<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>猪猪网上书城会员注册</title>
		<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script language="javascript" src="CheckForm.js">
	</script>
		<script language="javascript">
	//定义一个变量用于存放XMLHttpRequest对象
	var xmlHttp; 
	//该函数用于创建一个XMLHttpRequest对象
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} 
		else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
	//这是一个启动AJAX异步通信的方法
	function beginCheck(){
		var userName = document.all.userName.value;
		if (userName == ""){//如果尚未输入注册名
		 	alert("对不起，请您输入注册名!");
		 	return;
		}
		//创建一个XMLHttpRequest对象
		createXMLHttpRequest();
		//将状态触发器绑定到一个函数
		xmlHttp.onreadystatechange = processor;
		//通过GET方法向指定的URL建立服务器的调用
		xmlHttp.open("GET", "servlet/CheckNameServlet?userName="+userName);
		//发送请求
		xmlHttp.send(null);
	}
	//这是一用来处理状态改变的函数
	function processor () {
		//定义一个变量用于存放从服务器返回的响应结果
		var responseContext;
		if(xmlHttp.readyState == 4) { //如果响应完成
			if(xmlHttp.status == 200) {//如果返回成功
				//取出服务器的响应内容
				responseContext = xmlHttp.responseText;
				//如果注册名检查有效
				if (responseContext.indexOf("true")!=-1){
					alert("恭喜您，该注册名有效！");
				}else{
					alert("对不起，该注册名已被使用！");
				}
			}
		}
	}
</script>
	</head>
	<%
		session.setAttribute("register", "yaorui");//向session中添加一个userName属性
	%>


	<body bgcolor="#A2C97A">
		<script>
function scrollit_r2l(seed)
{ var m1  = "欢迎光临猪猪商城用户注册!请准确填写你的个人信息!!" ;
  var m2  = "" ;
       var msg=m1+m2;
       var out = " "; 
       var c = 1; 
 var speed  = 180;
if (seed > 100)
{                seed-=2;
                var cmd="scrollit_r2l(" + seed + ")";   
             timerTwo=window.setTimeout(cmd,speed);}     
    else if (seed <= 100 && seed > 0)
     {                for (c=0 ; c < seed ; c++)
                      {       out+=" ";}   
       out+=msg;         seed-=2;      
   var cmd="scrollit_r2l(" + seed + ")";      
   window.status=out;         
 timerTwo=window.setTimeout(cmd,speed); }        
      else if (seed <= 0) 
{                if (-seed < msg.length) 
                  { 
                       out+=msg.substring(-seed,msg.length);        
                       seed-=2;                        
                       var cmd="scrollit_r2l(" + seed + ")";         
                       window.status=out;                     
       timerTwo=window.setTimeout(cmd,speed);}
       else {               window.status=" ";       
                 timerTwo=window.setTimeout("scrollit_r2l(100)",speed);
}
}
}
scrollit_r2l(100);
</script>
		<jsp:include flush="true" page="top.jsp"></jsp:include>
		
			<table width="780" border="1" align="center" cellpadding="0"
				cellspacing="2" bordercolor="#57AD00">
				<form method="post" action="servlet/RegisterServlet" name="form1"
			id="demo" onSubmit="return CheckForm.Check(this,2)">
				<tr>
					<td height="80" colspan="2">
						<IMG src="image/icon_regster.gif">
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						会员级别：
					</td>
					<td height="26">
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
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						登录帐号：
					</td>
					<td height="26">
						<input type="text" name="userName" size="30" styleClass="textBox" />
						<input type="button" value="有效性检查" onclick="beginCheck()" />
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						真实姓名：
					</td>
					<td height="26">
						<input dataType="Chinese" name="Name" styleClass="textBox"
							size="30" msg="用户名只能输入中文姓名">
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						性别：
					</td>
					<td height="26">
						<input type="radio" name="sex" value="man" checked>
						男
						<input type="radio" name="sex" value="woman" dataType="Group"
							msg="请选定一个性别！">
						女
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						登录密码：
					</td>
					<td height="26">
						<input name="pwd" dataType="SafeString"
							msg="密码必须至少包含一个字母且长度在6位以上！" type="password" size="30"
							styleClass="textBox" />
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						核对密码：
					</td>
					<td height="26">
						<input name="Repeat" type="password" dataType="Repeat" to="pwd"
							msg="两次输入的密码不一致！" size="30" class="textBox" />
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						身份证号：
					</td>
					<td height="26">
						<input dataType="IdCard" name="Card" msg="身份帐号不正确，长度必须是15位或18位！"
							size="30" styleClass="textBox" />
					</td>
				</tr>
				<input type="hidden" name="regtime" size="30" styleClass="textBox"
					value="<%=new Date().toLocaleString() %>" />
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						电子邮箱：
					</td>
					<td height="26">
						<input dataType="Email" name="Email"
							msg="邮箱格式不正确！按yaorui@163.com参考！" size="30" styleClass="textBox" />
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						联系地址：
					</td>
					<td height="26">
						<input type="text" name="address" size="30" styleClass="textBox" />
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						验证码:
					</td>
					<td height="26">
						<input type=text name="nam" size="30" styleClass="textBox">
						<script language="javascript" runat=client>
			var n=parseInt(Math.random()*8999+1000);
			document.write("<img id=mk src=image.jsp?num="+n+">");
			function nextImage(){
				n=parseInt(Math.random()*8999+1000);
				document.all("mk").src="image.jsp?num="+n;
			}
			</script>
						<a href="javascript:nextImage();">换一张</a>
					</td>
				</tr>


				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						猪猪会员协议：
					</td>
					<td height="26">
						<textarea name="textarea" cols="50" rows="5" type="_moz">腾讯公司依据本协议的规定提供服务，本协议具有合同效力。您必须完全同意本协议，才能够享受本网站提供的服务。您在拍拍网登录即表示您完全接受本协议的全部条款。
重要须知： 腾讯在此特别提醒用户认真阅读本《拍拍网用户服务协议》--- 用户应认真阅读本《拍拍网用户服务协议》 (下称《协议》)中各条款，包括免除或者限制腾讯责任的免责条款及对用户的权利限制。请您审阅并接受或不接受本《协议》（未成年人应在法定监护人陪同下审阅）。除非您接受本《协议》条款，否则您无权使用本网站提供的相关服务。您的使用行为将视为对本《协议》的接受，并同意接受本《协议》各项条款的约束。</textarea>
					</td>
				</tr>
				<tr>
					<td height="40" colspan="2" align="center">
						<input type="submit" name="submit" value="注册">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" name="reset" value="清空">
						&nbsp;&nbsp;&nbsp;
						<input type="button" name="check" value="检验"
							onclick="CheckForm.Check(document.getElementById('demo'),3)">
						<br>

					</td>
					
				</tr>
				
				</form>
			</table>
		
		<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>
