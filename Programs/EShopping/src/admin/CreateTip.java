package admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

public class CreateTip extends HttpServlet {

	//这里只是一个小的测试，测试用ajax技术查看图片的方法
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//虚拟一个商品列表，查数据库得到一个arrayList
		String sql = "select * from book";
		RegisterDAO dao = new RegisterDAO();
		ArrayList<Book> arrayList = dao.ListAllBookInformation(sql);
		//便利得到,没有结果
		
		String[][] shop ={{".NET和XML","58","/EShopping/images/730207164s.jpg"},
						  {"CMM软件过程","70","/EShopping/images/20062281678.jpg"},
						  {"ASP网站设计","88","/EShopping/images/2003122822304.jpg"},
						  {"Flash入门","78","/EShopping/images/200622816327.jpg"},
						  {"电子商务","64","/EShopping/images/200622816327.jpg"},
						  {"系统分析员","47","/EShopping/images/2003122822044.jpg"},
						  {"分析员","23","/EShopping/images/2006224221626.jpg"},
						  {"Java模式","35","/EShopping/images/2006226225259.gif"},
						  {"J2ME设计","28","/EShopping/images/20031228222422.jpg"},
						  {"高质量程序","66","/EShopping/images/20031226134537.jpg"},}; 
		
		//获得客户端提交的参数
		int index =Integer.parseInt(request.getParameter("index"));
		
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//以XML文档形式返回给客户端
		out.println("<shop>");
		out.println("<name>"+shop[index][0]+"</name>");
		out.println("<price>"+shop[index][1]+"</price>");
		out.println("<photo>"+shop[index][2]+"</photo>");
		out.println("</shop>");		

		out.flush();
		out.close();
	}

}
