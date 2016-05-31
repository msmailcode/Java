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

//修改商品分类信息成功
public class ModSuccessServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String typeName = request.getParameter("typeName");
		String typeInfo = request.getParameter("typeInfo");
		
		String sql = "update booktype set typeName='" + typeName + "',typeInfo='" + typeInfo+"' where id=" + id;
		RegisterDAO dao = new RegisterDAO();
		int n = dao.del(sql);
		if(n > 0){
			out.write("<script type='text/javascript'>alert('修改商品分类成功!');</script>");
			String sql1 = "select * from booktype";
			ArrayList<TypeInfo> arrayList1 = dao.ListAllInformation(sql1);
			HttpSession session = request.getSession();
			session.setAttribute("arrayList1", arrayList1);
		}
		request.getRequestDispatcher("/Admin/adminCate.jsp").include(request, response);
		
		
		
		
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
