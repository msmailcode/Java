<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��Ʒ�����Ϣ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
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
  </head>
  
  <body>
  <h3 align="center">��Ʒ��������</h3>
    <form action="servlet/TypeServlet" name="form1" onsubmit="return f1();">
    <table align="center">
    	<tr>��Ʒ��������:</tr>
    	<tr><input type="text" name="typeName"></tr><br><br>
    	<tr>
    	��Ʒ�������:
    	</tr>
    	<tr>
    	<textarea cols="30" rows="10" name="typeInfo"></textarea><br><br>
    	</tr>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<tr><input type="submit" value="�ύ" >
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" value="ȡ��"></tr>
    </table>	
    </form>
  </body>
</html>
