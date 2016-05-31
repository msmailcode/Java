package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//删除某个定单
public class DelOrderOne extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id").toString());
			String sql = "delete orders where id=" + id;
			RegisterDAO dao = new RegisterDAO();
			int n = dao.del(sql);
			if(n == 1){
				out.write("<script type='text/javascript'>alert('删除成功!');</script>");
			} else {
				out.write("<script type='text/javascript'>alert('删除失败!');</script>");
			}
			//在写个servlet里面便利表中的数据转发到adminCate.jsp
			response.sendRedirect("/EShopping/servlet/AdminOrderList");
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
