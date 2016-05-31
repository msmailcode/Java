package adminservlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.LeaveWord;
import javabean.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//显示所有留言信息
public class AdminLeaveWord extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		
			//便利留言信息
			String sql = "select * from leaveword";
			ArrayList<LeaveWord> arrayList = dao.ListLeaveWord(sql);
			request.setAttribute("arrayList", arrayList);
			request.getRequestDispatcher("/Admin/adminLeavaWord.jsp").include(request, response);
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
