package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class CheckNameServlet extends HttpServlet {
	
	/*
	 * 使用ajax的方式检查用户名的唯一
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("userName");
		//存放一个响应内容的字符串,假设已经注册的用户名
		String responseContext = "true";
		RegisterDAO dao = new RegisterDAO();
		String sql = "select count(*) from register where userName=?";
		int n = dao.CheckName(sql, userName);
		session.setAttribute("userName", userName);
		if(n > 0){
			//用户名不能相同,已经有同样的用户了,用户已经存在
			responseContext = "false";
		} 
		//将处理结果返回给客户端
		out.println(responseContext);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
