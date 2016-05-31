package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//删除某本书，如果有定单的存在该书就不能删除
public class DelBook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		try {
			int id = Integer.parseInt(request.getParameter("id").toString());
			
			String sql = "select id from (select * from book where id in(select bookid from orderdetail)) as temp where id=" + id;
			int m =  dao.CheckID(sql);
			if(m > 0){
				out.write("<script type='text/javascript'>alert('警告!存在该商品的订单,不能删除!');</script>");
				request.getRequestDispatcher("/servlet/AdminBookList").include(request, response);
			}else {
				String sql1 = "delete book where id=" + id + "";
				
				int n = dao.del(sql1);
				if(n == 1){
					out.write("<script type='text/javascript'>alert('删除成功!');</script>");
				} else {
					out.write("<script type='text/javascript'>alert('删除失败!');</script>");
				}
				//在写个servlet里面便利表中的数据转发到adminCate.jsp
				response.sendRedirect("/EShopping/servlet/AdminBookList");
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
