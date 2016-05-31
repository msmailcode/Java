package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javabean.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�鿴�ҵĹ��ﳵ
public class LookCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		//û�е�½������ж�
		Object obj = request.getSession().getAttribute("member");
		if(obj == null){
			response.sendRedirect("/EShopping/sorry.jsp");
		}else{
			//�����½�˾Ϳ������member�в���û��
			Member member = (Member)obj;
			Hashtable map = member.getMap();
			//��ʾ��û����Ʒ,��ʾ�û�ѡ����Ʒ�����鿴
			if(map.size() == 0){
				out.print("<script type='text/javascript'>alert('��Ǹ�㻹û�������Ʒ,�������Ʒ�������鿴')</script>");
				request.getRequestDispatcher("/index.html").include(request, response);
			}else {
				response.sendRedirect("/EShopping/cat.jsp");
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
