package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javabean.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//查看我的购物车
public class LookCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		//没有登陆的情况判断
		Object obj = request.getSession().getAttribute("member");
		if(obj == null){
			response.sendRedirect("/EShopping/sorry.jsp");
		}else{
			//如果登陆了就看后面的member有参数没有
			Member member = (Member)obj;
			Hashtable map = member.getMap();
			//表示还没有商品,提示用户选好商品在来查看
			if(map.size() == 0){
				out.print("<script type='text/javascript'>alert('抱歉你还没有添加商品,请添加商品后在来查看')</script>");
				request.getRequestDispatcher("/index.html").include(request, response);
			}else {
				response.sendRedirect("/EShopping/cat.jsp");
			}
			
		}
		out.flush();
		out.close();
	}
		

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
