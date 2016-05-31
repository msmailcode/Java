package servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class CommentBook extends HttpServlet {
	//ͼ�����ۣ�����ĳ��ͼ�����Ϣ
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
	 	HttpSession session = request.getSession();
	 	Object obj = session.getAttribute("userName");
	 	if(obj == null){
	 		response.sendRedirect("/EShopping/sorry.jsp");
	 	}else{
	 		RegisterDAO dao = new RegisterDAO();
	 		int bookid = Integer.parseInt(request.getParameter("id"));
	 		String contents = request.getParameter("contents");
	 		String datatime = request.getParameter("datatime");
	 		//��ͼ���ID�ڲ����۱�
	 		String userName = session.getAttribute("userName").toString();
	 		String sql = "insert into comment values('"+userName+"',"+bookid+",'"+datatime+"','"+contents+"')";
	 		int n = dao.del(sql);
	 		if(n > 0){
	 			out.write("<script type='text/javascript'>alert('��ϲ�㷢�����۳ɹ���');</script>");
	 			request.getRequestDispatcher("/index.html").include(request, response);
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
