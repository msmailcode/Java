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

//查找一个留言的详细信息
public class ListLeaveWord extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		//详细的留言信息
		int id = Integer.parseInt(request.getParameter("id"));
		LeaveWord leaveWord = dao.LeaveWordInfo(id);
		
		int userID = leaveWord.getMemberid();
		Member member = dao.QueryMember(userID);
		
		request.setAttribute("member", member);
		request.setAttribute("leaveWord", leaveWord);
		request.getRequestDispatcher("/Admin/adminLeaveWordInfo.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
