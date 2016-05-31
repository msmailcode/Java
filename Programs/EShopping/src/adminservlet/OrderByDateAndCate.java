package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//指定的时间和类别进行商品类型的销量的查询
public class OrderByDateAndCate extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int state = Integer.parseInt(request.getParameter("state"));
		//按时间统计查询出个各个类别商品小量
		String sql = "select * from (select typeid,sum(number) as number from " +
				"(select * from (select orderdetail.orderid,number,orderdetail.bookid from orderdetail join " +
				"(select id from orders where datatime between '"+start+"' and '"+end+"') " +
				"as temp1 on orderdetail.orderid=temp1.id) as temp2 join " +
				"(select book.id,booktype.typeName,book.typeid from  booktype join book on book.typeid=booktype.id) " +
				"as temp3 on temp2.bookid=temp3.id) as temp4 group by typeid) as temp5 where typeid="+state;
		
		ArrayList<javabean.OrderByDate> arrayList = dao.ListOrderByDate(sql);
		request.setAttribute("arrayList",arrayList);
		
		request.getRequestDispatcher("/Admin/OrderByDateAndCate.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
