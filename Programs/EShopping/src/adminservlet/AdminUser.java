package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Admin;
import javabean.Book;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

//显示所有管理员的信息
public class AdminUser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		//首先判断权限的级别,这里不可能为空
		int admin = Integer.parseInt(request.getSession().getAttribute("adminType").toString());
		if(admin != 4){
		response.sendRedirect("/EShopping/error.htm");
		}else{
				String sql = "select * from admin";
				ArrayList<Admin> arrayList = dao.ListAllAdminInformation(sql);
				request.setAttribute("arrayList", arrayList);
				request.getRequestDispatcher("/Admin/admin.jsp").include(request, response);
			
		}
		
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
