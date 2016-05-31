package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class CommentBookOne extends HttpServlet {
	
	//电机发表评论后首先显示这本书的信息，在来发表评论
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
	 	Object obj = session.getAttribute("userName");
	 	if(obj == null){
	 		response.sendRedirect("/EShopping/sorry.jsp");
	 	}else{
		try {
			int userID = Integer.parseInt(request.getParameter("id").toString());
			RegisterDAO dao = new RegisterDAO();
			Book book = (Book)dao.ModInfoBook(userID);
			request.setAttribute("book", book);
			request.getRequestDispatcher("/commentbook.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
