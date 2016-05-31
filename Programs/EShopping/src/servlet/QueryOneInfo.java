package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Book;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

public class QueryOneInfo extends HttpServlet {

	//查询一个商品的信息，详细信息
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();

		try {
			int userID = Integer.parseInt(request.getParameter("id").toString());
			//设置cookie的浏览记录
			Cookie cookie = new Cookie(userID+"ss",userID+"");
			cookie.setMaxAge(3000);
			response.addCookie(cookie);
			
			RegisterDAO dao = new RegisterDAO();
			Book book = (Book)dao.ModInfoBook(userID);
			
			request.setAttribute("book", book);
			request.getRequestDispatcher("/queryone.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
