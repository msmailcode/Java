package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;
import javabean.Cart;
import javabean.Comment;
import javabean.Member;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//购物的过程中需要改变书的数量，可以修改数量，修改之前判断库存的状态
public class ModNum extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//修改数量
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int newNum = Integer.parseInt(request.getParameter("num"));
		
		//判断库存的状态
		RegisterDAO dao = new RegisterDAO();
		Book book = dao.ModInfoBook(id);
		int storage = book.getStorage();
		if(newNum > storage){
			out.print("<script type='text/javascript'>alert('抱歉！你所输的数量已超过库存！')</script>");
			request.getRequestDispatcher("/cat.jsp").include(request, response);
		}else{
		Member member = (Member)request.getSession().getAttribute("member");
		Cart cart = (Cart)member.getMap().get(id);
		cart.setNumber(newNum);
		//特价商品
		if(cart.getSaleprice() == 0){
			cart.setTotal(cart.getNumber()* cart.getPrice());
		}else{//不是特价
			cart.setTotal(cart.getNumber()* cart.getSaleprice());
		}
		member.getMap().put(id, cart);
		request.getSession().setAttribute("member", member);
		out.print("<script type='text/javascript'>alert('恭喜,修改数量成功！')</script>");
		request.getRequestDispatcher("/cat.jsp").include(request, response);
		out.flush();
		out.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
