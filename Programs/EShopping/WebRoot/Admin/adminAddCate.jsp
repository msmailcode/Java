<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品类别信息</title>
    
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
  </head>
  
  <body>
  <h3 align="center">商品分类名称</h3>
    <form action="servlet/TypeServlet" name="form1" onsubmit="return f1();">
    <table align="center">
    	<tr>商品分类名称:</tr>
    	<tr><input type="text" name="typeName"></tr><br><br>
    	<tr>
    	商品类别描述:
    	</tr>
    	<tr>
    	<textarea cols="30" rows="10" name="typeInfo"></textarea><br><br>
    	</tr>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<tr><input type="submit" value="提交" >
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" value="取消"></tr>
    </table>	
    </form>
  </body>
</html>
