package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javabean.Cart;
import javabean.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DelOneCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//通过一本书的ID将删除这本书
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Member member = (Member)request.getSession().getAttribute("member");
		Cart cart = (Cart)member.getMap().remove(id);
		//member.getMap().put(id, cart);
		request.getSession().setAttribute("member", member);
		request.getRequestDispatcher("/cat.jsp").include(request, response);
		out.flush();
		out.close();
			
			
	
	}
		
		
		

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
