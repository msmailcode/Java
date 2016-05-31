package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Book;
import javabean.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class ToModRegister extends HttpServlet {

	//要修改某个人的信息前先列出这个人的信息
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
	 		RegisterDAO dao = new RegisterDAO();
	 		String userName = session.getAttribute("userName").toString();
	 		 Member member = (Member)dao.ToModRegister(userName);
	 		 request.setAttribute("member", member);
	 		 request.getRequestDispatcher("/modInfo.jsp").forward(request, response);
	 	}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
