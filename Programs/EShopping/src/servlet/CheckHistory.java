package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

public class CheckHistory extends HttpServlet {

	/*
	 * 使用cookie保存我的浏览记录
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		//显示我曾经的浏览记录
		Cookie cookie [] = request.getCookies();
		ArrayList<Book> arrayList5 = new ArrayList<Book>();
		for (int i = 0; i <cookie.length; i++) {
			if(cookie[i].getName().endsWith("ss")){
			 	int id = Integer.parseInt(cookie[i].getValue());
			 	Book book = dao.ModInfoBook(id);
			 	arrayList5.add(book);
			 	
			}
		}
		request.setAttribute("arrayList5", arrayList5);
		request.getRequestDispatcher("/myHistory.jsp").include(request, response);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
