package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class ModMemberInfoSuccess extends HttpServlet {

	//�޸�ע����Ϣ��Ҫ��֤��ȶ෽����ж�
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		String input = request.getParameter("nam");
		String mc =(String)session.getAttribute("num");
		
		if(!(input.equals(mc))){
			out.write("<script type='text/javascript'>alert('��֤�벻��ȷ���޸�ע����Ϣʧ�ܣ����������룡');</script>");
			request.getRequestDispatcher("/register.jsp").include(request, response);
			return;
		}
		
		Object obj = (Object)session.getAttribute("register");
		
		if(obj == null){
			out.write("<script type='text/javascript'>alert('�벻Ҫ�ظ��ύ�޸�����');</script>");
			request.getRequestDispatcher("/index.html").include(request, response);
		} else {
			session.removeAttribute("register");
			int id = Integer.parseInt(request.getParameter("id"));
			String userName = request.getParameter("userName");
			String Name = request.getParameter("Name");
			String sex = request.getParameter("sex");
			String passWord = request.getParameter("pwd");
			String card = request.getParameter("Card");
			String Email = request.getParameter("Email");
			String address = request.getParameter("address");
			String regtime = request.getParameter("regtime");
			RegisterDAO dao =new RegisterDAO();
			String sql = "update register set userName='" + userName + "',Name='" + Name+"',sex='" + sex+"',passWord='" + passWord+"',card='" + card+"',Email='" + Email+"',address='" + address+"',regtime='" + regtime+"' where id=" + id;
			int n = dao.del(sql);
			if(n > 0){
				out.write("<script type='text/javascript'>alert('�޸���Ϣ�ɹ�!');</script>");
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
