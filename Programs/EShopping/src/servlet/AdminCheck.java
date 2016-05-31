package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class AdminCheck extends HttpServlet {
	/*
	 * 判断管理员用户登陆成功与否
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String adminuserName = request.getParameter("userName");
		String adminpassWord = request.getParameter("passWord");
		
		RegisterDAO dao = new RegisterDAO();
		String sql = "select count(*) from admin where adminuserName=? and adminpassWord=?";
		int n = dao.CheckAdmin(sql, adminuserName,adminpassWord);

		if(n > 0){
			//有相同的表示查询到的用户名和密码正确成功,我想设置权限，根据一个字段类型,由用户名我可以找到id
			session.setAttribute("admin", adminuserName);
			Admin admin = dao.QueryAdmin(adminuserName);
			int adminType = admin.getAdminType();
			//通过类型来判断权限
			session.setAttribute("adminType", adminType);
			response.sendRedirect("/EShopping/Admin/adminIndex.jsp");
		} else {
			//不相同表示用户名或者密码错误
			out.write("<script type='text/javascript'>alert('用户名或密码错误,登录失败,请重新登录!');</script>");
			request.getRequestDispatcher("/Admin/adminLogin.jsp").include(request, response);
		}
		
		//将处理结果返回给客户端
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
