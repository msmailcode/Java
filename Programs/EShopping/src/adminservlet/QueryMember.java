package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Member;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

//���л�Ա�Ĳ�ѯ
public class QueryMember extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String qKey = request.getParameter("qKey");
		int n = Integer.parseInt(request.getParameter("query").toString());
		RegisterDAO dao = new RegisterDAO();
		//Ĭ�ϰ���¼�ʺ�����ѯ
		if(n == 0 || n == 2){
			String sql = "select * from register where userName like '%" +qKey+ "%'";
			ArrayList<Member> list = dao.ListAllMemberInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryMember.jsp").include(request, response);
			return;
		}else if(n == 1){ //��������ѯ
			String sql = "select * from register where Name like '%" +qKey+ "%'";
			ArrayList<Member> list = dao.ListAllMemberInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryMember.jsp").include(request, response);
		}else if(n == 3){ //����ϵ��ַ����ѯ
			String sql = "select * from register where address like '%" +qKey+ "%'";
			ArrayList<Member> list = dao.ListAllMemberInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryMember.jsp").include(request, response);
			return;
		}else if(n == 4){ //��������������ѯ
			String sql = "select * from register where Email like '%" +qKey+ "%'";
			ArrayList<Member> list = dao.ListAllMemberInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryMember.jsp").include(request, response);
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
