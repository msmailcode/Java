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
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

/*
 * 删除所有的书
 */
public class DelAllBook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String sql = "delete book";
		RegisterDAO dao= new RegisterDAO();
		int n = dao.del(sql);
		if(n > 0){
			String sql1 = "select * from book";
			ArrayList<Book> arrayList = dao.ListAllBookInformation(sql);
			//HttpSession session = request.getSession();
			request.setAttribute("arrayList", arrayList);
			request.getRequestDispatcher("/Admin/adminMerSpe.jsp").include(request, response);
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
