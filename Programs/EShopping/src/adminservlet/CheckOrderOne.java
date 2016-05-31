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

//查找列出某个人的定单的详情
public class CheckOrderOne extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		//定单明细表。查寻出每个定单的详细信息
		 	int id = Integer.parseInt(request.getParameter("id"));
		 	Orders order = dao.QueryOrder(id);
		 	
		 	String sql1 = "select book.id,book.name,book.price,book.saleprice,temp.number,temp.totalprice " +
		 			"from book join (select number,totalprice,bookid from orderdetail where orderid="+id+") " +
		 			"as temp on book.id=temp.bookid";
		 	
		 	ArrayList<OrderInfo> arrayList = dao.ListOneOrdersInformation(sql1);
		 	request.setAttribute("order", order);
		 	request.setAttribute("arrayList", arrayList);
		 	request.getRequestDispatcher("/Admin/adminOrderInfo.jsp").include(request, response);
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
