package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;
import javabean.Member;
import javabean.OrderBean;
import javabean.Orders;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

//����һ���˵Ķ��������е���Ϣ
public class OrderMessage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		//���ҳ��µ����ںͶ�����ţ�״̬�ͽ��
		Object obj = request.getSession().getAttribute("userName");
		if(obj == null){
			response.sendRedirect("/EShopping/sorry.jsp");
		}else {
			String userName = (String)obj;
			Member member = dao.ToModRegister(userName);
			int id = member.getId();
			String sql = "select * from orders where userID=" + id;
			ArrayList<Orders> arrayList = dao.ListAllOrdersInformation(sql);
			request.setAttribute("arrayList", arrayList);
			request.getRequestDispatcher("/ordermanage.jsp").include(request, response);
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
