package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Orders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//按时间段和状态来查询定单信息
public class ClientQueryOrder extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int state = Integer.parseInt(request.getParameter("state"));
		String sql = "select * from orders where datatime between '"+start+"' and '"+end+"' and state="+state;
		ArrayList<Orders> arrayList = dao.ListAllOrdersInformation(sql);
		request.setAttribute("arrayList", arrayList);
		
		request.getRequestDispatcher("/ordermanage.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
