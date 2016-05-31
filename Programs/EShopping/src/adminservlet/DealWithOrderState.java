package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.OrderInfo;
import javabean.Orders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
//修改定单的状态
public class DealWithOrderState extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
//		定单明细表。查寻出每个定单的详细信息
	 	int id = Integer.parseInt(request.getParameter("id"));
	 	int state = Integer.parseInt(request.getParameter("state"));
	 	String sql = "update orders set state="+state+" where id="+id;
	 	int n = dao.del(sql);
	 	if(n > 0){
	 		out.write("<script type='text/javascript'>alert('修改状态成功！');</script>");
	 	}
	 	request.getRequestDispatcher("/servlet/AdminOrderList").include(request, response);
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
