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


public class DelAllCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//退回商品架,使用map删除所有的书,不需要dao
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		Member member = (Member)request.getSession().getAttribute("member");
		member.getMap().clear();
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
