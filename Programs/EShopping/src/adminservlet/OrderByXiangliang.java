package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.OrderByXL;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//按销量排名来查询
public class OrderByXiangliang extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		//查询出商品销量排名
		String sql ="select * from (select book.id,book.name,book.price,book.saleprice,temp1.number from book join " +
				"(select * from (select bookid,sum(number) as number from orderdetail group by bookid) as temp) " +
				"as temp1 on book.id=temp1.bookid) as temp2 order by number desc";
		ArrayList<OrderByXL> arrayList = dao.ListOrderByXL(sql);
		request.setAttribute("arrayList",arrayList);
		request.getRequestDispatcher("/Admin/OrderByXiaoliang.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
