<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://struts-menu.sf.net/tag" prefix="menu" %>
<html>
  <head>
	<title>欢迎使用猪猪管理系统后台管理系统</title>
	<link rel="stylesheet" type="text/css" media="screen" href="styles/global.css" />
	<script type="text/javascript" src="scripts/cookies.js"></script>
	<style type="text/css">
		<!--
		body {
			background-color:lightgrey;
		}
		-->
	</style>
  </head>  
  <body>
	<table cellpadding=0 cellspacing=0>
		<tr valign=top>
			 <td width="150">
				<menu:useMenuDisplayer name="DropDown" bundle="org.apache.struts.action.MESSAGE">
				    <menu:displayMenu name="AdminMenu" target="frame1"/>
				</menu:useMenuDisplayer>
			 </td>
		</tr>
	</table>	
  </body>
</html>