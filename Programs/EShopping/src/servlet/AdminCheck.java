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
	 * �жϹ���Ա�û���½�ɹ����
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
			//����ͬ�ı�ʾ��ѯ�����û�����������ȷ�ɹ�,��������Ȩ�ޣ�����һ���ֶ�����,���û����ҿ����ҵ�id
			session.setAttribute("admin", adminuserName);
			Admin admin = dao.QueryAdmin(adminuserName);
			int adminType = admin.getAdminType();
			//ͨ���������ж�Ȩ��
			session.setAttribute("adminType", adminType);
			response.sendRedirect("/EShopping/Admin/adminIndex.jsp");
		} else {
			//����ͬ��ʾ�û��������������
			out.write("<script type='text/javascript'>alert('�û������������,��¼ʧ��,�����µ�¼!');</script>");
			request.getRequestDispatcher("/Admin/adminLogin.jsp").include(request, response);
		}
		
		//�����������ظ��ͻ���
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
