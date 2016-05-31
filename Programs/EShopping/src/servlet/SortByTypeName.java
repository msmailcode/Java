package servlet;

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
//按照类别来进行浏览商品
public class SortByTypeName extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		RegisterDAO dao = new RegisterDAO();
		
		//按照不同类别的商品进行分类
		String sql = "select * from book where typeid="+id;
		ArrayList<Book> arrayList = dao.ListAllBookInformation(sql);
		
		request.setAttribute("arrayList", arrayList);
		
		
		
		request.getRequestDispatcher("/browsegoods.jsp").include(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
