package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javabean.Book;
import javabean.TypeInfo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
//��ҳ��ʾ����Ҫ
public class ListAllIndex extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		RegisterDAO dao = new RegisterDAO();
		
		//�ؼ�����ȡ��ǰ3��
		String sql = "select top 3 * from book where saleprice<>" + 0;
		ArrayList<Book> arrayList = dao.ListAllBookInformation(sql);
		request.setAttribute("arrayList", arrayList);
		
		//ԭ������ȡ��ǰ3��
		String sql1 = "select top 3 * from book where saleprice=" + 0;
		ArrayList<Book> arrayList1 = dao.ListAllBookInformation(sql1);
		request.setAttribute("arrayList1", arrayList1);
		
		//��Ʒ������ʾ
		String sql2 = "select * from booktype";
		ArrayList<TypeInfo> arrayList2 = dao.ListAllInformation(sql2);
		request.setAttribute("arrayList2", arrayList2);
		
		//��ʾվ�������Ƽ���ʮ��
		String sql3 = "select top 10 * from book";
		ArrayList<Book> arrayList3 = dao.ListAllBookInformation(sql3);
		request.setAttribute("arrayList3", arrayList3);
		
		//��ʾ������õ�ʮ����
		String sql4 = "select * from book where id in(select top 10 bookid from (select bookid,sum(number) as totalnumber from orderdetail group by bookid) as temp order by totalnumber desc)";
		ArrayList<Book> arrayList4 = dao.ListAllBookInformation(sql4);
		request.setAttribute("arrayList4", arrayList4);
		
		
		request.getRequestDispatcher("/index.jsp").include(request, response);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
