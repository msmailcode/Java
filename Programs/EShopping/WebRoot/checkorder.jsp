<%@ page contentType="text/html; charset=gbk" %>
<jsp:directive.page import="java.util.Date"/>
<jsp:directive.page import="javabean.Member"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>订单确认</title>
<link href="CSS/stylesheet.css" rel="stylesheet" type="text/css">
</head>
<script language="javascript">
	//进入上一步
	function pre(){
		var url = "/EShopping/cat.jsp";
		window.location = url;
	}	

	//进入下一步
	function next(){
		if (document.all.saveName.value==''){
			alert('收货人姓名不能为空！');
		}else if (document.all.savePhone.value==''){
			alert('收货人电话不能为空！');
		}else if (document.all.zip.value==''){
			alert('收货人邮编不能为空！');
		}else if (document.all.saveAddress.value==''){
			alert('收货人地址不能为空！');
		}else{
			document.all.form1.submit();
		}				
	}		
</script>
<body class="body" bgcolor="#A2C97A">
<%
	Member member1 = (Member)request.getAttribute("member1");
 %>
 <jsp:include flush="true" page="top.jsp"></jsp:include>
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" style="border:1px; border-style:solid; border-color:#888888">
  <tr>
    <td>&nbsp;</td>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="60"><img src="${pageContext.request.contextPath}/image/Car_icon_04.gif" /></td>
      </tr>
      <tr>
        <td><table cellspacing="0" cellpadding="0" border="0" width="652" height="43">
            <tr valign="center">
              <td>
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_07.gif" />
										</td>
										<td class="C_Carbg_Default">
											查看购物车物品
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
										<td align="center">
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_09.gif" />
										</td>
										<td class="C_Carbg_Default">
											确认订单信息
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
										<td align="center">
											<img hspace="5"
												src="${pageContext.request.contextPath}/image/Car_11.gif" />
										</td>
										<td class="C_Carbg_Default">
											订单提交成功
										</td>
										<td>
											<img height="39"
												src="${pageContext.request.contextPath}/image/Car_15.gif"
												width="1" />
										</td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td>
			<form name="form1" action="/EShopping/servlet/OrderSuccess" method="post" style="margin:0px;">
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
            <tr bgcolor="#F7F3F7" class="text">
              <td width="260" height="26" align="right">收货人姓名：</td>
              <td>&nbsp;<input type="text" name="saveName" class="textBox" size="40" value="<%=member1.getName() %>"></td>
            </tr>
            <tr bgcolor="#F7F3F7" class="text">
              <td width="260" height="26" align="right">收货人联系电话：</td>
              <td>&nbsp;<input type="text" name="savePhone" class="textBox" size="40"></td>
            </tr>
            <tr bgcolor="#F7F3F7" class="text">
              <td width="260" height="26" align="right">收货人邮编：</td>
              <td>&nbsp;<input type="text" name="zip" class="textBox" size="40"></td>
            </tr>
            <tr bgcolor="#F7F3F7" class="text">
              <td width="260" height="26" align="right">付款方式：</td>
              <td>&nbsp;
    			<select name="moneymode">
    				<option value="1" selected="selected">银行付款</option>
    				<option value="2">邮局汇款</option>
    				<option value="3">网上支付</option>
    			</select>          
              </td>
            </tr>
            <tr bgcolor="#F7F3F7" class="text">
              <td width="260" height="26" align="right">送货方式：</td>
              <td>&nbsp;
              	<select name="deliverymode">
              		<option value="1" selected="selected">平邮</option>
              		<option value="2">快递</option>
              		<option value="3">上门</option>
              	</select>
              </td>
            </tr>
            <tr bgcolor="#F7F3F7" class="text">
              <td width="260" height="26" align="right">下单时间：</td>
              <td>&nbsp;<input type="text" name="datatime" class="textBox" size="40" value="<%=new Date().toLocaleString() %>" readonly="readonly"></td>
            </tr>
            <tr bgcolor="#F7F3F7" class="text">
              <td width="260" height="26" align="right">收货人详细地址：</td>
              <td>&nbsp;<input type="text" name="saveAddress"  class="textBox" size="40" value="<%=member1.getAddress() %>"></td>
            </tr>							
        </table>
		</form>
		</td>
      </tr>
	  <tr height="20"><td></td></tr>	  
      <tr align="center">
        <td>
			<img style="CURSOR: hand" onclick="pre()" src="${pageContext.request.contextPath}/image/Car_icon_back.gif" border="0" />
			<img src="${pageContext.request.contextPath}/image/Car_icon_06.gif" width="137" height="40" border="0" style="CURSOR: hand" onclick="next()" />		</td>
      </tr>

      <tr align="right">
        <td height="20">&nbsp;</td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
  
  <tr>
    <td>&nbsp;</td>
    
		<td height="30" bgcolor="#4282CE" class="whiteText" align="center">
					如果你觉得这网站还不错请收藏 -- Author @St0816004
				</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td height="20">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<jsp:include flush="true" page="down.jsp"></jsp:include>
</body>
</html>