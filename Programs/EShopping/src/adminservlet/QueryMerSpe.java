package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//进行特价商品查询
public class QueryMerSpe extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String qKey = request.getParameter("qKey");
		int n = Integer.parseInt(request.getParameter("query").toString());
		RegisterDAO dao = new RegisterDAO();
		//默认按商品的名称来查询
		if(n == 0 || n == 2){
			String sql = "select * from book where name like '%" +qKey+ "%' and saleprice=" + 0 ;
			ArrayList<Book> list = dao.ListAllBookInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryMerSpe.jsp").include(request, response);
			return;
		}else if(n == 3){ //按优惠价来查询
			String sql = "select * from book where saleprice like '%" +qKey+ "%' and saleprice=" + 0;
			ArrayList<Book> list = dao.ListAllBookInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryMerSpe.jsp").include(request, response);
		}else if(n == 4){ //按市场的描述来查询
			String sql = "select * from book where price like '%" +qKey+ "%' and saleprice=" + 0;
			ArrayList<Book> list = dao.ListAllBookInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryMerSpe.jsp").include(request, response);
			return;
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
