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

//����Ĺ�������Ҫ�ı���������������޸��������޸�֮ǰ�жϿ���״̬
public class ModNum extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�޸�����
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int newNum = Integer.parseInt(request.getParameter("num"));
		
		//�жϿ���״̬
		RegisterDAO dao = new RegisterDAO();
		Book book = dao.ModInfoBook(id);
		int storage = book.getStorage();
		if(newNum > storage){
			out.print("<script type='text/javascript'>alert('��Ǹ��������������ѳ�����棡')</script>");
			request.getRequestDispatcher("/cat.jsp").include(request, response);
		}else{
		Member member = (Member)request.getSession().getAttribute("member");
		Cart cart = (Cart)member.getMap().get(id);
		cart.setNumber(newNum);
		//�ؼ���Ʒ
		if(cart.getSaleprice() == 0){
			cart.setTotal(cart.getNumber()* cart.getPrice());
		}else{//�����ؼ�
			cart.setTotal(cart.getNumber()* cart.getSaleprice());
		}
		member.getMap().put(id, cart);
		request.getSession().setAttribute("member", member);
		out.print("<script type='text/javascript'>alert('��ϲ,�޸������ɹ���')</script>");
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
