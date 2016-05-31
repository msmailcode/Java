package adminservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

//进行商品类型的查询
public class QueryCate extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String qKey = request.getParameter("qKey");
		int n = Integer.parseInt(request.getParameter("query").toString());
		RegisterDAO dao = new RegisterDAO();
		//默认按商品分类的名称来查询
		if(n == 0 || n == 2){
			String sql = "select * from booktype where typeName like '%" +qKey+ "%'";
			ArrayList<TypeInfo> list = dao.ListAllInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryCate.jsp").include(request, response);
			return;
		}else if(n == 1){ //按序号来查询
			String sql = "select * from booktype where id=" +qKey;
			ArrayList<TypeInfo> list = dao.ListAllInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryCate.jsp").include(request, response);
		}else if(n == 3){ //按商品的描述来查询
			String sql = "select * from booktype where typeInfo like '%" +qKey+ "%'";
			ArrayList<TypeInfo> list = dao.ListAllInformation(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Admin/adminQueryCate.jsp").include(request, response);
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
