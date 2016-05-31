package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

//删除某个商品分类之前先看看有没有商品存在，有不能删
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
			//不能删除,返回信息
			if(m > 0){
				out.write("<script type='text/javascript'>alert('警告!存在该商品的分类,不能删除!');</script>");
				request.getRequestDispatcher("/servlet/AdminCateList").include(request, response);
			}else {
				String sql = "delete booktype where id=" + id + "";
				
				int n = dao.del(sql);
				if(n == 1){
					out.write("<script type='text/javascript'>alert('删除商品分类成功!');</script>");
				} else {
					out.write("<script type='text/javascript'>alert('删除商品分类失败!');</script>");
				}
				//在写个servlet里面便利表中的数据转发到adminCate.jsp
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
