<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>猪猪网上商城</title>

<style type="text/css">
body,td,th {
	font-size: 12px;
}
.daohang {
	font-family: "黑体";
	font-size: 16px;
	color: #FFFFFF;
	text-decoration: none;
}
.shouye {
	font-family: "华文琥珀";
	font-size: 18px;
	color: #FFFFFF;
	text-decoration: none;
}
.guanglin {
	font-family: "黑体";
	font-size: 14px;
	color: #FFFFFF;
	font-weight: bold;
}
body {
	margin-top: 0px;
	margin-bottom: 0px;
}

</style>


<script type="text/javascript">
	function QuickSearch(){
			var key = document.all.qKey.value;
			if (key !=null && key!="商品关键字"){
				document.forms.form2.submit();
			}else {
				window.alert("商品关键字不能为空!");
			}
		}
</script>
</head>





<body>
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="419" height="128"><img src="${pageContext.request.contextPath}/image/index_01.jpg" width="419" height="128" /></td>
    <td width="81" background="${pageContext.request.contextPath}/image/index_02.gif">&nbsp;</td>
    <td width="280" background="${pageContext.request.contextPath}/image/index_03.gif"><table width="100%" border="0" cellspacing="10">
      <tr>
        <td height="20"><div align="center" class="STYLE5">
          <div align="right"><A href=# class="shouye" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.zhuzhuhome.com');">设为首页</a></div>
        </div></td>
      </tr>
      <tr>
        <td height="15"><div align="center" class="STYLE5">
          <div align="right"><a href="javascript:window.external.AddFavorite('http://www.zhuzhuhome.com', '猪猪之家')" class="shouye">收藏本站</a></div>
        </div></td>
      </tr>
    </table>

</td>
  </tr>
</table>

<table width="780" height="43" border="0" align="center" cellpadding="0" cellspacing="0" class="ty" >
  <tr>
    <td align="center" bgcolor="#529E00"><table width="630" border="0" align="center">
      <tr>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/ListAllIndex" class="daohang">猪猪首页</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE40"><a href="/EShopping/register.jsp" target="_blank" class="daohang">猪猪档案</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/LookCart" class="daohang">猪猪购物车</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/OrderMessage" class="daohang">猪猪订单</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/LeaveMessage" class="daohang">猪猪留言</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/ToModRegister" class="daohang">猪猪修改</a></span></div></td>
      </tr>
    </table>
        <div align="center"></div></td>
  </tr>
  <tr>
    <td height="18" align="center" valign="middle" background="${pageContext.request.contextPath}/image/bt1.gif">
      <marquee class="guanglin" onmouseover="stop()" onmouseout="start()" 
                        scrollAmount=3 scrollDelay=90>
      欢迎光临猪猪之家！
      <SCRIPT language=JavaScript type=text/javascript valign="middle">
var isMonth = new
Array("1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月");
var isDay = new
Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期日");
today = new Date () ;
Year=today.getYear();
Date=today.getDate();
if (document.all)
document.write(" "+Year+"年"+isMonth[today.getMonth()]+Date+"日　"+isDay[today.getDay()])
                  </SCRIPT>
                  您是本站第<%= (Integer)application.getAttribute("num") %>位客户！ 
    </marquee></td>
  </tr>
   <form action="/EShopping/servlet/QueryGoods" name="form2">
   <tr>
  
    <td height="18" align="center" valign="middle" background="${pageContext.request.contextPath}/image/bt1.gif">
     	<IMG src="${pageContext.request.contextPath}/image/icon_login.gif" align="absmiddle" width="28" height="20"> 
		<input type="text" name="qKey" style="WIDTH: 180px;">
        <SELECT id=query style="WIDTH: 85px;" name="query">
												<OPTION value="0" selected>
													全部条件
												</OPTION>
												<OPTION value="1">
													序号
												</OPTION>
												<OPTION value="2">
													商品名称
												</OPTION>
												<OPTION value="3">
													商品价格
												</OPTION>
											</SELECT>		
		<IMG src="${pageContext.request.contextPath}/image/icon_search.gif" align="absmiddle" border="0" onclick="QuickSearch()"> 
    </td>
   
	</tr>
	 
	 </form>
</table>

</body>
</html>
