 <%@page pageEncoding="GB2312" contentType="text/html; charset=gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>��ͨ������-��Աע�ᣡ</title>
    <meta http-equiv="Content- Type" content="text/html; charset=GB2312"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
  <body>
<s:form name="form" id="form" method="POST" action="addUser!save">
  <table width="1024" border="0" align="center">
    <tr>
      <td width="200" align="center"><div align="center"><a href="./index.jsp"><img src="./images/logo.gif" border="0"></a></div></td>
      <td width="814"><div align="center"><span class="STYLE2">����ϸ��д���ĸ������ϣ�</span></div></td>
    </tr>   
    <tr>
      <td colspan="2"><table width="100%" align="center" background="images/regpagebg.jpg">
        <tr><td>
          <div align="right">
            <s:textfield  name="username" label="��Ա��" align="left"/>
          </div></td></tr>
        <tr><td>
          <div align="right">
            <s:password  value="20"  name="password" maxlength="20" label="����"/>
          </div></td></tr>
        <tr><td>
          <div align="right">
            <s:radio  tooltip="��ѡ�������Ա�"
             label="�Ա�" 
             list="#{'1':'����','0':'Ů��'}"   
           name="sex" 
           value="1"
           />
          </div></td></tr> 
             <tr><td>
          <div align="right">
            <s:textfield  name="birthday" label="��������" align="left"/>
          </div></td></tr>
           <tr><td height="18"> 
          <div align="right">
            <s:select 
  tooltip="��ѡ������ѧ����"
  label="�����̶�" 
  list="{'Сѧ','����','����','��ר','����','˶ʿ','��ʿ'}"
  name="education"
  headerKey="��ѡ��" 
  headerValue="��ѡ��"/> 
          </div></td></tr>  
                 <tr><td height="18"> 
          <div align="right">
            <s:select 
  tooltip="��ѡ�����Ĺ�����"
  label="ְҵ" 
  list="{'ũ��','����','��ʦ','У��','�����ɲ�','��˾/��ҵ�쵼','����','����������','ҵ��Ա','��е����ʦ','web����Ա','��������ʦ','����','���繤��ʦ','ҽ��','��ʿ','�곤','����ְҵ'}"
  name="job"
    headerKey="��ѡ��" 
  headerValue="��ѡ��"/> 
          </div></td></tr>  
          <tr><td>
        <s:select  
  tooltip="��ѡ�����İ���"
  label="����" 
  list="#{'����':'����','����':'����','����':'����','�����˶�':'�����˶�','����':'����'}"   
  name="hobby" 
  emptyOption="None" 
  headerKey="��ѡ��" 
  headerValue="��ѡ��"/></td></tr>  
        <tr><td height="18"> 
          <div align="right">
            <s:checkboxlist 
  tooltip="��ѡ���������ѣ�"
  label="����" 
  list="{'С��','����','Сǿ','��ǿ','С��','����','С��','��','С��','����','С��','����','С��','���'}"
  name="friends"/> 
          </div></td></tr>
        <tr><td colspan="2"> 
       <iframe name=upload src="./upload/upload.jsp" width="800" height="220" scrolling=no frameborder=0></iframe>   
    <s:textfield
label="ͷ��" 
name="pic" 
size="100"/></td>           
    </tr>
        <tr><td valign="top">
          <s:textarea id="message" label="��������" name="message" cols="50" rows="10"></s:textarea>
          </td>
    </tr>
    <tr><td>
      <s:set name="area"
   value="#{'��ѡ�������ڵ�ʡ�ݣ�':{'��ѡ�������ڵĳ��У�'},
                    '����':{'����'},
                     '���':{'���'},
                     '�ӱ�':{'ʯ��ׯ','��ɽ','�ػʵ�','����','��̨','����','�żҿ�','�е�','����','�ȷ�','��ˮ'},
                     'ɽ��':{'̫ԭ','��ͬ','��Ȫ','����','����','˷��','����','�˳�','����','�ٷ�','����'},
                     '���ɹ�������':{'���ͺ���','��ͷ','�ں�','���','ͨ��','������˹','���ױ���','�����׶�','�����첼','�˰���','���ֹ�����','��������'},
                     '����':{'����','����','��ɽ','��˳','��Ϫ','����','����','Ӫ��','����','����','�̽�','����','����','��«��'},
                     '����':{'����','����','��ƽ','��Դ','ͨ��','��ɽ','��ԭ','�׳�','�ӱ߳�����������'},
                     '������':{'������','�������','����','�׸�','˫Ѽɽ','����','����','��ľ˹','��̨��','ĵ����','�ں�','�绯','���˰������'},
                     '�Ϻ�':{'�Ϻ�'},
                     '����':{'�Ͼ�','����','����','����','����','��ͨ','���Ƹ�','����','�γ�','����','��','̩��','��Ǩ'},
                     '�㽭':{'����','����','����','����','����','����','��','����','��ɽ','̨��','��ˮ'},
                     '����':{'�Ϸ�','�ߺ�','����','����','����ɽ','����','ͭ��','����','��ɽ','����','����','����','����','����','����','����','����'},
                     '����':{'����','����','����','����','Ȫ��','����','��ƽ','����','����'},
                     '����':{'�ϲ�','������','Ƽ��','�Ž�','����','ӥ̶','����','����','�˴�','����','����'},
                     'ɽ��':{'����','�ൺ','�Ͳ�','��ׯ','��Ӫ','��̨','Ϋ��','����','̩��','����','����','����','����','����','�ĳ�','����','����'},
                     '����':{'֣��','����','����','ƽ��ɽ','����','�ױ�','����','����','���','����','���','����Ͽ','����','����','����','�ܿ�','פ����','��Դ'},
                     '����':{'�人','��ʯ','ʮ��','�˲�','�差','����','����','Т��','����','�Ƹ�','����','����','��ʩ����������������','ʡֱϽ�ؼ�������λ'},
                     '����':{'��ɳ','����','��̶','����','����','����','����','�żҽ�','����','����','����','����','¦��','��������������������'},
                     '�㶫':{'����','�ع�','����','�麣','��ͷ','��ɽ','����','տ��','ï��','����','����','÷��','��β',' ��Դ','����','��Զ','��ݸ','��ɽ','����','����','�Ƹ�'},
                     '����׳��������':{'����','����','����','����','����','���Ǹ�','����','���','����','��ɫ','����','�ӳ�','����','����'},
                     '����':{'����','����','ʡֱϽ�ؼ�������λ'},
                     '����':{'����'},
                     '�Ĵ�':{'�ɶ�','�Թ�','��֦��','����','����','��Ԫ','����','�ڽ�','��ɽ','�ϳ�','üɽ','�˱�','�㰲 ','����','�Ű�','����','����','���Ӳ���Ǽ��������','���β���������','��ɽ����������'},
                     '����':{'����','����ˮ','����','��˳','ͭ�ʵ���','ǭ���ϲ���������������','�Ͻڵ���','ǭ�������嶱��������','ǭ�ϲ���������������'},
                     '����':{'����','����','��Ϫ','��ɽ','��ͨ','����','�ն�','�ٲ�','��������������','��ӹ���������������','��ɽ׳������������','��˫���ɴ���������','��������������','�º���徰����������','ŭ��������������','�������������'},
                    '����������':{'������','��������','ɽ�ϵ���','�տ������','��������','�������','��֥����'},
                     '����':{'����','ͭ��','����','����','μ��','�Ӱ�','����','����','����','����'},
                     '����':{'����','������','���','����','��ˮ','����','��Ҵ','ƽ��','��Ȫ','����','����','¤��','���Ļ���������','���ϲ���������'},
                     '�ຣ':{'������','��������','��������������','���ϲ���������','���ϲ���������','�������������','��������������','�����ɹ������������'},
                     '���Ļ���������':{'����','ʯ��ɽ','����','��ԭ','����'},
                     '�½�ά���������':{'��³ľ��','��������','��³������','���ܵ���','��������������','���������ɹ�������','���������ɹ�������','�����յ���','�������տ¶�����������','��ʲ����','�������','���������������','���ǵ���','����̩����','������ֱϽ�ؼ���������'},
                     '̨��':{'̨��','����','��¡','̨��','̨��','����','����'},
                     '����ر�������':{'���'},
                     '�����ر�������':{'����'}
                 }" />
                  <s:doubleselect label="ʡ��/����" list="#area.keySet()" name="province"
   doubleName="city" formName="form" doubleList="#area[top]" />
    </td></tr>
      <tr><td>
          <div align="right">
            <s:textfield  name="address" label="��ַ" align="left" size="100"/>
          </div></td></tr>
            <tr><td>
          <div align="right">
            <s:textfield  name="post" label="�ʱ�" align="left"/>
          </div></td></tr>
            <tr><td>
          <div align="right">
            <s:textfield  name="telphone" label="�绰" align="left" value="-"/>
          </div></td></tr>
            <tr><td>
          <div align="right">
            <s:textfield  name="mobilephone" label="�ֻ�" align="left"/>
          </div></td></tr>
             <tr><td>
          <div align="right">
            <s:textfield  name="email" label="����" align="left" value="@" />
          </div></td></tr>
        <tr><td>   
          <div align="right">
            <s:submit value="ע��" align="center"/>
          </div></td></tr>          
          </table></td>
    </tr>
    <tr>
      <td colspan="2"><div align="center">Copyright&copy;2016��ͨ������StShop��Ȩ����</div></td>
    </tr>
  </table>
     
  </s:form>
  </body>  

</html>