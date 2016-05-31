package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.OrderByXL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//进行商品类型的查询，查找出销量
public class OrderByCate extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		//查询出个各个类别商品小量
		String sql ="select booktype.id,booktype.typeName,temp2.number from booktype " +
				"join (select sum(number) as number,temp1.typeid from " +
				"(select book.id,book.typeid,temp.number from book join " +
				"(select bookid,sum(number) as number from orderdetail group by bookid)" +
				" as temp on book.id=temp.bookid) as temp1 group by temp1.typeid) " +
				"as temp2 on booktype.id=temp2.typeid order by temp2.number desc";
		
		ArrayList<javabean.OrderByCate> arrayList = dao.ListOrderByCate(sql);
		request.setAttribute("arrayList",arrayList);
		request.getRequestDispatcher("/Admin/OrderByCate.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
