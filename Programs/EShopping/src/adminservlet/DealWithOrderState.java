package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.OrderInfo;
import javabean.Orders;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
//�޸Ķ�����״̬
public class DealWithOrderState extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
//		������ϸ����Ѱ��ÿ����������ϸ��Ϣ
	 	int id = Integer.parseInt(request.getParameter("id"));
	 	int state = Integer.parseInt(request.getParameter("state"));
	 	String sql = "update orders set state="+state+" where id="+id;
	 	int n = dao.del(sql);
	 	if(n > 0){
	 		out.write("<script type='text/javascript'>alert('�޸�״̬�ɹ���');</script>");
	 	}
	 	request.getRequestDispatcher("/servlet/AdminOrderList").include(request, response);
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
