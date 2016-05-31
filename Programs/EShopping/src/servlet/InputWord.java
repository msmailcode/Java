package servlet;

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
//发表留言
public class InputWord extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		//留言管理
		Object obj = request.getSession().getAttribute("userName");
		if(obj == null){
			response.sendRedirect("/EShopping/sorry.jsp");
		}else {
			//根据自己的名字查
			String userName = (String)obj;
			Member member = dao.ToModRegister(userName);
			int memberid = member.getId();
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String leavrdate = request.getParameter("leavrdate");
			
			//进行留言
			String sql = "insert into leaveword(memberid,title,content,leavrdate) " +
					"values('"+memberid+"','"+title+"','"+content+"','"+leavrdate+"')";
			
			int n = dao.del(sql);
			if(n > 0){
					out.write("<script type='text/javascript'>alert('感谢您的留言，我们将尽快回复！');</script>");
					memberid = member.getId();
					String sql1 = "select * from leaveword where memberid=" + memberid;
					ArrayList<LeaveWord> arrayList = dao.ListLeaveWord(sql1);
					
					request.setAttribute("arrayList", arrayList);
					request.getRequestDispatcher("/leaveword.jsp").include(request, response);
			}
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
