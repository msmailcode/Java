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
	 * ʹ��ajax�ķ�ʽ����û�����Ψһ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("userName");
		//���һ����Ӧ���ݵ��ַ���,�����Ѿ�ע����û���
		String responseContext = "true";
		RegisterDAO dao = new RegisterDAO();
		String sql = "select count(*) from register where userName=?";
		int n = dao.CheckName(sql, userName);
		session.setAttribute("userName", userName);
		if(n > 0){
			//�û���������ͬ,�Ѿ���ͬ�����û���,�û��Ѿ�����
			responseContext = "false";
		} 
		//�����������ظ��ͻ���
		out.println(responseContext);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
