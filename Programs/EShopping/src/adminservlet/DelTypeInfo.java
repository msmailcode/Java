package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

//删除所有的商品分类
public class DelTypeInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String sql = "delete booktype";
		RegisterDAO dao= new RegisterDAO();
		int n = dao.del(sql);
		if(n > 0){
			String sql1 = "select * from booktype";
			ArrayList<TypeInfo> arrayList1 = dao.ListAllInformation(sql1);
			HttpSession session = request.getSession();
			session.setAttribute("arrayList1", arrayList1);
			//request.getRequestDispatcher("/Admin/adminCate.jsp").forward(request, response);
			response.sendRedirect("/EShopping/Admin/adminCate.jsp");
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
