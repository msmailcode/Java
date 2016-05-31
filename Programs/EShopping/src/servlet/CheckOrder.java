package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;
import javabean.Comment;
import javabean.Member;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

public class CheckOrder extends HttpServlet {
	
	/*
	 * �ύ��������Ҫ��鶨���˵���ϸ��Ϣ������ʾ���ͻ���
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		
		//ͨ�������ҳ��˵�ȫ����Ϣ
		Object obj = request.getSession().getAttribute("userName");
		if(obj == null){
			response.sendRedirect("/EShopping/sorry.jsp");
		}else {
			String userName =(String)obj;
			Member member1 = dao.ToModRegister(userName);
			request.setAttribute("member1", member1);
			request.getRequestDispatcher("/checkorder.jsp").include(request, response);
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
