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

	//����ֻ��һ��С�Ĳ��ԣ�������ajax�����鿴ͼƬ�ķ���
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//����һ����Ʒ�б������ݿ�õ�һ��arrayList
		String sql = "select * from book";
		RegisterDAO dao = new RegisterDAO();
		ArrayList<Book> arrayList = dao.ListAllBookInformation(sql);
		//�����õ�,û�н��
		
		String[][] shop ={{".NET��XML","58","/EShopping/images/730207164s.jpg"},
						  {"CMM�������","70","/EShopping/images/20062281678.jpg"},
						  {"ASP��վ���","88","/EShopping/images/2003122822304.jpg"},
						  {"Flash����","78","/EShopping/images/200622816327.jpg"},
						  {"��������","64","/EShopping/images/200622816327.jpg"},
						  {"ϵͳ����Ա","47","/EShopping/images/2003122822044.jpg"},
						  {"����Ա","23","/EShopping/images/2006224221626.jpg"},
						  {"Javaģʽ","35","/EShopping/images/2006226225259.gif"},
						  {"J2ME���","28","/EShopping/images/20031228222422.jpg"},
						  {"����������","66","/EShopping/images/20031226134537.jpg"},}; 
		
		//��ÿͻ����ύ�Ĳ���
		int index =Integer.parseInt(request.getParameter("index"));
		
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//��XML�ĵ���ʽ���ظ��ͻ���
		out.println("<shop>");
		out.println("<name>"+shop[index][0]+"</name>");
		out.println("<price>"+shop[index][1]+"</price>");
		out.println("<photo>"+shop[index][2]+"</photo>");
		out.println("</shop>");		

		out.flush();
		out.close();
	}

}
