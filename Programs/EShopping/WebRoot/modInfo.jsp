<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<jsp:directive.page import="javabean.Member"/>
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

		<title>���������̳ǻ�Աע��</title>
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
	</head>
	<%
		session.setAttribute("register", "yaorui");//��session�����һ��userName����
	%>


	<body bgcolor="#A2C97A">
		<script>
function scrollit_r2l(seed)
{ var m1  = "��ӭ���������̳��û�ע���޸�!��׼ȷ��д��ĸ�����Ϣ!!" ;
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
<%
	Member member = (Member)request.getAttribute("member");
	session.setAttribute("register", "yaorui");//��session�����һ��userName����
 %>
		<jsp:include flush="true" page="top.jsp"></jsp:include>
		
			<table width="780" border="1" align="center" cellpadding="0"
				cellspacing="2" bordercolor="#57AD00">
				<form  action="servlet/ModMemberInfoSuccess"
			id="demo" onSubmit="return CheckForm.Check(this,2)">
				<tr>
					<td height="80" colspan="2">
					<input type="hidden" value="<%=member.getId() %>" name="id">
						<IMG src="image/EditUser_01.gif">
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						��Ա����
					</td>
					<td height="26">
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
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						��¼�ʺţ�
					</td>
					<td height="26">
						<input type="text" name="userName" size="30" styleClass="textBox" readonly="readonly" value="<%=member.getUserName() %>"/>
						
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						��ʵ������
					</td>
					<td height="26">
						<input dataType="Chinese" name="Name" styleClass="textBox"
							size="30" msg="�û���ֻ��������������" value="<%=member.getName() %>">
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						�Ա�
					</td>
					<td height="26">
						<input type="radio" name="sex" value="man" checked="<%=member.getSex() %>">
						��
						<input type="radio" name="sex" value="woman" dataType="Group"
							msg="��ѡ��һ���Ա�" checked="<%=member.getSex() %>">
						Ů
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						�����룺
					</td>
					<td height="26">
						<input name="pwd" dataType="SafeString"
							msg="����������ٰ���һ����ĸ�ҳ�����6λ���ϣ�" type="password" size="30"
							styleClass="textBox" />
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						ȷ�����룺
					</td>
					<td height="26">
						<input name="Repeat" type="password" dataType="Repeat" to="pwd"
							msg="������������벻һ�£�" size="30" class="textBox" />
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						���֤�ţ�
					</td>
					<td height="26">
						<input dataType="IdCard" name="Card" msg="����ʺŲ���ȷ�����ȱ�����15λ��18λ��"
							size="30" styleClass="textBox" value="<%=member.getCard() %>"/>
					</td>
				</tr>
				<input type="hidden" name="regtime" size="30" styleClass="textBox"
					value="<%=new Date().toLocaleString() %>" />
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						�������䣺
					</td>
					<td height="26">
						<input dataType="Email" name="Email"
							msg="�����ʽ����ȷ����yaorui@163.com�ο���" size="30" styleClass="textBox" value="<%=member.getEmail() %>" />
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						��ϵ��ַ��
					</td>
					<td height="26">
						<input type="text" name="address" size="30" styleClass="textBox" value="<%=member.getAddress() %>"/>
					</td>
				</tr>
				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						��֤��:
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
						<a href="javascript:nextImage();">��һ��</a>
					</td>
				</tr>


				<tr bgcolor="#F7F3F7">
					<td width="260" height="26" class="text" align="right">
						�����ԱЭ�飺
					</td>
					<td height="26">
						<textarea name="textarea" cols="50" rows="5" type="_moz">��Ѷ��˾���ݱ�Э��Ĺ涨�ṩ���񣬱�Э����к�ͬЧ������������ȫͬ�ⱾЭ�飬���ܹ����ܱ���վ�ṩ�ķ���������������¼����ʾ����ȫ���ܱ�Э���ȫ�����
��Ҫ��֪�� ��Ѷ�ڴ��ر������û������Ķ������������û�����Э�顷--- �û�Ӧ�����Ķ������������û�����Э�顷 (�³ơ�Э�顷)�и���������������������Ѷ���ε�����������û���Ȩ�����ơ��������Ĳ����ܻ򲻽��ܱ���Э�顷��δ������Ӧ�ڷ����໤����ͬ�����ģ������������ܱ���Э�顷�����������Ȩʹ�ñ���վ�ṩ����ط�������ʹ����Ϊ����Ϊ�Ա���Э�顷�Ľ��ܣ���ͬ����ܱ���Э�顷���������Լ����</textarea>
					</td>
				</tr>
				<tr>
					<td height="40" colspan="2" align="center">
						<input type="submit" name="submit" value="�޸�">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" name="reset" value="���">
						&nbsp;&nbsp;&nbsp;
						<input type="button" name="check" value="����"
							onclick="CheckForm.Check(document.getElementById('demo'),3)">
						<br>

					</td>
				</tr>
				
				</form>
			</table>
		
		<jsp:include flush="true" page="down.jsp"></jsp:include>
	</body>
</html>
