<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>���������̳�</title>

<style type="text/css">
body,td,th {
	font-size: 12px;
}
.daohang {
	font-family: "����";
	font-size: 16px;
	color: #FFFFFF;
	text-decoration: none;
}
.shouye {
	font-family: "��������";
	font-size: 18px;
	color: #FFFFFF;
	text-decoration: none;
}
.guanglin {
	font-family: "����";
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
			if (key !=null && key!="��Ʒ�ؼ���"){
				document.forms.form2.submit();
			}else {
				window.alert("��Ʒ�ؼ��ֲ���Ϊ��!");
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
          <div align="right"><A href=# class="shouye" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.zhuzhuhome.com');">��Ϊ��ҳ</a></div>
        </div></td>
      </tr>
      <tr>
        <td height="15"><div align="center" class="STYLE5">
          <div align="right"><a href="javascript:window.external.AddFavorite('http://www.zhuzhuhome.com', '����֮��')" class="shouye">�ղر�վ</a></div>
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
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/ListAllIndex" class="daohang">������ҳ</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE40"><a href="/EShopping/register.jsp" target="_blank" class="daohang">������</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/LookCart" class="daohang">�����ﳵ</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/OrderMessage" class="daohang">������</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/LeaveMessage" class="daohang">��������</a></span></div></td>
        <td width="90" background="${pageContext.request.contextPath}/image/anniu1.gif"><div align="center"><span class="STYLE38"><a href="/EShopping/servlet/ToModRegister" class="daohang">�����޸�</a></span></div></td>
      </tr>
    </table>
        <div align="center"></div></td>
  </tr>
  <tr>
    <td height="18" align="center" valign="middle" background="${pageContext.request.contextPath}/image/bt1.gif">
      <marquee class="guanglin" onmouseover="stop()" onmouseout="start()" 
                        scrollAmount=3 scrollDelay=90>
      ��ӭ��������֮�ң�
      <SCRIPT language=JavaScript type=text/javascript valign="middle">
var isMonth = new
Array("1��","2��","3��","4��","5��","6��","7��","8��","9��","10��","11��","12��");
var isDay = new
Array("������","����һ","���ڶ�","������","������","������","������","������");
today = new Date () ;
Year=today.getYear();
Date=today.getDate();
if (document.all)
document.write(" "+Year+"��"+isMonth[today.getMonth()]+Date+"�ա�"+isDay[today.getDay()])
                  </SCRIPT>
                  ���Ǳ�վ��<%= (Integer)application.getAttribute("num") %>λ�ͻ��� 
    </marquee></td>
  </tr>
   <form action="/EShopping/servlet/QueryGoods" name="form2">
   <tr>
  
    <td height="18" align="center" valign="middle" background="${pageContext.request.contextPath}/image/bt1.gif">
     	<IMG src="${pageContext.request.contextPath}/image/icon_login.gif" align="absmiddle" width="28" height="20"> 
		<input type="text" name="qKey" style="WIDTH: 180px;">
        <SELECT id=query style="WIDTH: 85px;" name="query">
												<OPTION value="0" selected>
													ȫ������
												</OPTION>
												<OPTION value="1">
													���
												</OPTION>
												<OPTION value="2">
													��Ʒ����
												</OPTION>
												<OPTION value="3">
													��Ʒ�۸�
												</OPTION>
											</SELECT>		
		<IMG src="${pageContext.request.contextPath}/image/icon_search.gif" align="absmiddle" border="0" onclick="QuickSearch()"> 
    </td>
   
	</tr>
	 
	 </form>
</table>

</body>
</html>
