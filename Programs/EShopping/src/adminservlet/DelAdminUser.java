package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Admin;
import javabean.Book;
import javabean.Member;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

/*
 * 删除某个管理员
 */
public class DelAdminUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();

		try {
			int id = Integer.parseInt(request.getParameter("id").toString());
			RegisterDAO dao = new RegisterDAO();
			String sql = "delete admin where id=" + id;
			int n = dao.del(sql);
			if(n > 0){
				out.write("<script type='text/javascript'>alert('删除管理员信息成功！');</script>");
				String sql1 = "select * from admin";
				ArrayList<Admin> arrayList = dao.ListAllAdminInformation(sql1);
				request.setAttribute("arrayList", arrayList);
				request.getRequestDispatcher("/Admin/admin.jsp").include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
