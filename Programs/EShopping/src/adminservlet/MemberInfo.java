package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Book;
import javabean.Member;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//显示一个会员的详细信息
public class MemberInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();

		try {
			int userID = Integer.parseInt(request.getParameter("id").toString());
			RegisterDAO dao = new RegisterDAO();
			Member member = (Member)dao.QueryMember(userID);
			request.setAttribute("member", member);
			request.getRequestDispatcher("/Admin/QueryMemberInfo.jsp").include(request, response);
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
