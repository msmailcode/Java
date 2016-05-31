package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;
import javabean.Comment;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

public class AllComment extends HttpServlet {
	/*
	 * 查看所有对本书的评论
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		
		//查询所有的本书的评论
		String sql = "select * from comment where bookid=" + id;
		ArrayList<Comment> arrayList = dao.ListAllCommentInformation(sql);
		
		request.setAttribute("arrayList", arrayList);
		
		
		
		request.getRequestDispatcher("/listAllComment.jsp").include(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
