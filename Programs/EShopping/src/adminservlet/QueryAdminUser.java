package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Admin;
import javabean.Book;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//���й���Ա��ѯ
public class QueryAdminUser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String qKey = request.getParameter("qKey");
		int n = Integer.parseInt(request.getParameter("query").toString());
		RegisterDAO dao = new RegisterDAO();
		//Ĭ�Ϲ���Ա�ź�����ѯ
		if(n == 0 || n == 2){
			String sql = "select * from admin where adminuserName like '%" +qKey+ "%'";
			ArrayList<Admin> arrayList = dao.ListAllAdminInformation(sql);
			request.setAttribute("arrayList", arrayList);
			request.getRequestDispatcher("/Admin/Queryadmin.jsp").include(request, response);
			return;
		}else if(n == 1){ //����������ѯ
			String sql = "select * from admin where adminName like '%" +qKey+ "%'";
			ArrayList<Admin> arrayList = dao.ListAllAdminInformation(sql);
			request.setAttribute("arrayList", arrayList);
			request.getRequestDispatcher("/Admin/Queryadmin.jsp").include(request, response);
		}else if(n == 3){ //������Ա������������ѯ
			String sql = "select * from admin where adminType like '%" +qKey+ "%'";
			ArrayList<Admin> arrayList = dao.ListAllAdminInformation(sql);
			request.setAttribute("arrayList", arrayList);
			request.getRequestDispatcher("/Admin/Queryadmin.jsp").include(request, response);
			return;
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
