package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javabean.Book;
import javabean.Cart;
import javabean.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class TakeCart extends HttpServlet {

	//核心将物品放到购物车中
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		
		Object obj = request.getSession().getAttribute("member");
		if(obj == null){
			response.sendRedirect("/EShopping/sorry.jsp");
		}else{
			
			int userID = Integer.parseInt(request.getParameter("id"));
			RegisterDAO dao = new RegisterDAO();
			Book book = dao.ModInfoBook(userID);
			
			Cart c = new Cart();
			c.setBookid(userID);
			c.setName(book.getName());
			c.setNumber(1);
			c.setPrice(book.getPrice());
			c.setSaleprice(book.getSaleprice());
			//求取总价格的方法
			if(c.getSaleprice() == 0){
				c.setTotal(c.getNumber()* book.getPrice());
			}else {
				c.setTotal(c.getNumber()* book.getSaleprice());
			}
			Member member = (Member)obj;
			if(member.getMap().get(userID)==null){
				out.print("<script type='text/javascript'>alert('添加商品到购物车成功！')</script>");
				member.getMap().put(c.getBookid(), c);
				request.getSession().setAttribute("member", member);
			}else {
				out.print("<script type='text/javascript'>alert('抱歉该商品已经存在于购物车中！请从新选择商品！')</script>");
			
			}
			request.getRequestDispatcher("/index.html").include(request, response);
		}
		

		out.flush();
		out.close();
	}
		
		
		

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
