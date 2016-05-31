package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//ɾ��ĳ����Ʒ����֮ǰ�ȿ�����û����Ʒ���ڣ��в���ɾ
public class DelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		try {
			RegisterDAO dao = new RegisterDAO();
			int id = Integer.parseInt(request.getParameter("id").toString());
			String sql1 = "select id from (select * from booktype where id in(select typeid from book) )as t1 where id=" + id;
			int m =  dao.CheckID(sql1);
			//����ɾ��,������Ϣ
			if(m > 0){
				out.write("<script type='text/javascript'>alert('����!���ڸ���Ʒ�ķ���,����ɾ��!');</script>");
				request.getRequestDispatcher("/servlet/AdminCateList").include(request, response);
			}else {
				String sql = "delete booktype where id=" + id + "";
				
				int n = dao.del(sql);
				if(n == 1){
					out.write("<script type='text/javascript'>alert('ɾ����Ʒ����ɹ�!');</script>");
				} else {
					out.write("<script type='text/javascript'>alert('ɾ����Ʒ����ʧ��!');</script>");
				}
				//��д��servlet����������е�����ת����adminCate.jsp
				request.getRequestDispatcher("/servlet/AdminCateList").include(request, response);
			}
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
