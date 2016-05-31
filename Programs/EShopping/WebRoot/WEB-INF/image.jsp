<%@ page contentType="image/jpeg" language="java" 
import="java.io.*"
import="java.awt.*"
import="javax.imageio.ImageIO"
import="java.awt.image.BufferedImage"
pageEncoding="GBK"
%>
<html>
<head>
<title>бщжЄТыбЁдё</title>
</head>
<body>
<%
	try{
		BufferedImage bf=new BufferedImage(70,25,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=bf.createGraphics();
		g2.setPaint(new Color(0,0,255));
		g2.fillRect(0,0,70,25);
		g2.setPaint(new Color(255,255,255));
		String str=request.getParameter("num");
		session.setAttribute("num",str);
		g2.setFont(new Font("Arial",Font.BOLD,24));
		g2.drawString(str,7,20);
		for(int i=0;i<10;i++){
			int r=(int)(Math.random()*255);
			int g=(int)(Math.random()*255);
			int b=(int)(Math.random()*255);
			g2.setPaint(new Color(r,g,b));
			int x1=(int)(Math.random()*80);
			int y1=(int)(Math.random()*30);
			int x2=(int)(Math.random()*80);
			int y2=(int)(Math.random()*30);
			g2.drawLine(x1,y1,x2,y2);
		}
		g2.dispose();
		ImageIO.write(bf,"jpg",response.getOutputStream());
	}catch(Exception e){
		System.out.println(e);
	}
%>
</body>
</html>