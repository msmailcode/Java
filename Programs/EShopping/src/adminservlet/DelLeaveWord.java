package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//ɾ��ĳ������
public class DelLeaveWord extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		try {
			int id = Integer.parseInt(request.getParameter("id").toString());
			
			
				String sql1 = "delete leaveword where id=" + id + "";
				
				int n = dao.del(sql1);
				if(n == 1){
					out.write("<script type='text/javascript'>alert('ɾ�����Գɹ�!');</script>");
				} else {
					out.write("<script type='text/javascript'>alert('ɾ������ʧ��!');</script>");
				}
				//��д��servlet����������е�����ת����adminCate.jsp
				response.sendRedirect("/EShopping/servlet/AdminLeaveWord");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
