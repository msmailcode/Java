package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java_cup.internal.internal_error;

import dao.RegisterDAO;

//显示所有的特价商品的信息
public class AdminSpeList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		int admin = Integer.parseInt(request.getSession().getAttribute("adminType").toString());
		if(admin != 1){
		response.sendRedirect("/EShopping/error.htm");
		}else{
		RegisterDAO dao = new RegisterDAO();
		String sql = "select * from book where saleprice=" + 0;
		ArrayList<Book> arrayList = dao.ListAllBookInformation(sql);
		request.setAttribute("arrayList", arrayList);
		request.getRequestDispatcher("/Admin/adminMer.jsp").include(request, response);
		out.flush();
		out.close();
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
