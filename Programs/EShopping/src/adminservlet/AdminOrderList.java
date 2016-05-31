package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Orders;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

//显示所有的定单的信息
public class AdminOrderList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		int admin = Integer.parseInt(request.getSession().getAttribute("adminType").toString());
		if(admin != 2){
		response.sendRedirect("/EShopping/error.htm");
		}else{
				String sql = "select * from orders";
				ArrayList<Orders> arrayList = dao.ListAllOrdersInformation(sql);
				request.setAttribute("arrayList", arrayList);
				request.getRequestDispatcher("/Admin/adminOrder.jsp").include(request, response);
			}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
