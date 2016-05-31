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

public class AddMerSpe extends HttpServlet {

	//增加商品的类别
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//新增商品分类
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String typeName = request.getParameter("typeName");
		String typeInfo = request.getParameter("typeInfo");
		String sql = "insert into booktype values(?,?)";
		RegisterDAO dao = new RegisterDAO();
		int n = dao.AddInfo(sql, typeName, typeInfo);
		if (n > 0) {
			// 插入成功,便立
			String sql1 = "select * from booktype";
			ArrayList<TypeInfo> arrayList1 = dao.ListAllInformation(sql1);
			HttpSession session = request.getSession();
			session.setAttribute("arrayList1", arrayList1);
			out.write("<script type='text/javascript'>alert('新增商品分类成功!');</script>");
			request.getRequestDispatcher("/Admin/adminCate.jsp").include(request, response);
		} else {
			// 插入失败
			request.getRequestDispatcher("/Admin/adminCate.jsp?success=" + 3)
					.include(request, response);
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
