package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//管理员回复留言
public class AdminAnswerWord extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		//回复信息
		int id = Integer.parseInt(request.getParameter("id"));
		String answerdate = request.getParameter("answerdate");
		String answercontent = request.getParameter("answercontent");
		
		String sql = "update leaveword set adminid='"+3+"',answercontent='"+answercontent+"',answerdate='"+answerdate+"',state='"+1+"' where id=" + id;
		int n = dao.del(sql);
		if(n > 0){
			out.print("<script type='text/javascript'>alert('回复留言成功！');</script>");
		}
		request.getRequestDispatcher("/servlet/AdminLeaveWord").include(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
