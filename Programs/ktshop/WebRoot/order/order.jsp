<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="GB2312"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������ϸ</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <style type="text/css">
  body,td,th {
	font-family: verdana;
}
body {
	margin-left: 0px;
	margin-top: 0px;
}
  </style>
  </head>
  
<body>
   
      <table width="1224" border="0" align="center">
        <tr>
          <td width="235" height="94" align="center"><a href="./index.jsp"><img src="images/logo.gif" border="0"></a></td>
          <td width="849" height="100"><div align="center"><img src="./images/banner.jpg" width="468" height="80"></div></td>
          <td width="126" align="center"><img src="./images/collect.gif" alt="" width="100" height="30"><br>
            <br>
          <img src="./images/help.gif" alt="" width="100" height="32"></td>
        </tr>
        <tr>
          <td colspan="3"><s:action name="listMenu" executeResult="true"></s:action></td>
        </tr>
        <tr>
          <td valign="top" align="center"><table align="center" bgcolor=""><tr><td align="center">
    <s:set name="username" value="#session['username']" />
    <s:if test="#username==null">
    <table  height="100" width="210"><tr><td background="images/loginbg.jpg" align="center" width="220" rowspan="0" colspan="0">
      <b>��Ա��¼</b>
      <s:form method="POST" action="./loginAction!login">
      <s:textfield  name="user.username" label="�û���"/>
      <s:password  name="user.password"  label="����"/>
      <s:submit value="��¼" align="center"/> <s:reset value="����" align="center"/>
	  </s:form>
     </td>
    </tr> </table>
    </s:if>
    <s:else>
    <table align="center">
      <tr><td rowspan="0" colspan="0">
                ��ӭ��<s:property value="#session.username"/>��<br>
      <s:a href="cart/viewcart.jsp">�鿴���ﳵ</s:a>
      <s:form action="./logoutAction!logout">
      <s:submit value="ע��"></s:submit>
      </s:form>     
      </td></tr></table>
    </s:else> 
    </td></tr>
    <tr><td align="center" background="images/regbg.jpg"> <s:a href="user/adduser.jsp">
      <div align="center">ע���û�</div>
    </s:a> 
      </td>
    </tr> </table></td>
          <td colspan="2">�����������Ʒ�У�<br/>
        </p>
		<s:form method="POST" action="saveOrder!save">
      <table cellspacing="0" cellpadding="0" border="0" bgColor="#c0c0c0">
  <tr>
  <td> 
  <table cellspacing="1" cellpadding="0" border="0">
  <tr bgcolor="#ffffff">
<td align="center" background="./images/tablebg.jpg">��Ʒ���</td><td align="center" background="./images/tablebg.jpg"> ��Ʒ����</td><td align="center" background="./images/tablebg.jpg">  �۸�</td><td align="center" background="./images/tablebg.jpg">  ����</td><td align="center" background="./images/tablebg.jpg">  �ܼ�</td> </tr>
<s:set var="count" value="0"/> <s:iterator value="#session.shopcart" > 
<tr align="center" bgcolor="#ffffff"><td>
<s:property value="productid"/></td><td>
<s:property value="productname"/></td><td>
 <font size="5"> &yen; </font><font color="red" size="4"> <s:property value="price"/></font> Ԫ</td><td>
<s:set var="quantity" value="quantity"/><s:property value="quantity"/> </td><td>
<s:set var="cost" value="price*quantity"/> <font size="5"> &yen; </font> <font color="red" size="4"><s:property value="%{#cost}"/></font>Ԫ</td>
<s:set var="count" value="%{#count+#cost}"/>
</tr>
</s:iterator> 
<tr bgcolor="#ffffff"><td colspan="6" align="right">
�ϼƣ� <font size="5"> &yen; </font> <font color="red" size="4"><s:property value="%{#count}"/></font>Ԫ</td></tr></table></td></tr></table>
<br>
������ϵ��ʽ��
 <table cellspacing="0" cellpadding="0" border="0" bgColor="#c0c0c0">
  <tr>
  <td>
  <table cellspacing="1" cellpadding="0" border="0">
<tr height="20" bgcolor="#ffffff"><td colspan="2">
  <s:action name="getUser2" executeResult="true">
  <s:param name="username" value="#session.username"></s:param>
  </s:action>
</td></tr>
</table></td></tr>
</table>
<table>
<tr bgcolor="#ffffff">
<td colspan="2">
<s:select  
label="��ѡ������֧����ʽ" 
list="#{'֧����':'֧����','��������':'��������','����ת��':'����ת��','�ʾֻ��':'�ʾֻ��','���Žɷ�':'���Žɷ�'}"   
name="payment"/></td></tr>
<tr bgcolor="#ffffff"><td>
<s:select  
label="��ѡ�������ʼķ�ʽ" 
list="#{'���EMS':'���EMS','��ͨ�ٵ�':'��ͨ�ٵ�','˳������':'˳������'}"   
name="postway"/>
<s:hidden name="username" value="%{#session.username}"></s:hidden>
</td></tr>
<tr bgcolor="#ffffff"><td>
<s:submit value="���涩��" align="left"/>
</td></tr>
</table>
  </s:form></td>
        </tr>
        <tr>
          <td colspan="3"><div align="center">Copyright&copy;2016��ͨ������StShop��Ȩ����</div></td>
        </tr>
      </table>
  </body>
</html>