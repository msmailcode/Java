package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

public class ModUserSuccess extends HttpServlet {

	//修改管理员的信息成功
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String adminName = request.getParameter("adminName");
		String adminuserName = request.getParameter("adminuserName");
		String adminpassWord = request.getParameter("adminpassWord");
		int adminType = Integer.parseInt(request.getParameter("adminType"));
		
		
		String sql = "update admin set adminType='" + adminType + "',adminName='" + adminName+"',adminuserName='" + adminuserName+"',adminpassWord='" + adminpassWord+"' where id=" + id;
		RegisterDAO dao = new RegisterDAO();
		int n = dao.del(sql);
		if(n > 0){
			out.write("<script type='text/javascript'>alert('修改管理员信息成功！');</script>");
			String sql1 = "select * from admin";
			ArrayList<Admin> arrayList = dao.ListAllAdminInformation(sql1);
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
