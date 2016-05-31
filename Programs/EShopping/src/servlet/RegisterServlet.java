package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;


//ע�����û�
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		String input = request.getParameter("nam");
		String mc =(String)session.getAttribute("num");
		
		//��֤�������ȷ
		if(!(input.equals(mc))){
			out.write("<script type='text/javascript'>alert('��֤�벻��ȷ��ע��ʧ�ܣ����������룡');</script>");
			request.getRequestDispatcher("/register.jsp").include(request, response);
			return;
		}
		
		Object obj = (Object)session.getAttribute("register");
		
		//��ֹ�ظ��ύע��
		if(obj == null){
			out.write("<script type='text/javascript'>alert('�벻Ҫ�ظ��ύע������');</script>");
			request.getRequestDispatcher("/index.html").include(request, response);
		} else {
//�Ƴ�session��userName����(������ظ��ύ��session�е�userName���Ա��Ƴ��ˣ�session.getAttribute("userName")����ֵΪ�գ���ִ��24�еĴ��룬�������dao��ע�᷽�������Ҳ���������ݿ���д����)
			session.removeAttribute("register");
			String userName = request.getParameter("userName");
			String Name = request.getParameter("Name");
			String sex = request.getParameter("sex");
			String passWord = request.getParameter("pwd");
			String card = request.getParameter("Card");
			String Email = request.getParameter("Email");
			String address = request.getParameter("address");
			String regtime = request.getParameter("regtime");
			RegisterDAO dao =new RegisterDAO();
			
			//�����ȼ���û����Ƿ����,��ajax�ķ�������û����Ƿ���Ψһ��
			String sql1 = "select count(*) from register where userName=?";
			int m = dao.CheckName(sql1, userName);
			if(m > 0){
				//�û���������ͬ,��ʾ,�����û�д����
				out.write("<script type='text/javascript'>alert('ע��ʧ��,��⵽�û����Ѿ�����,������ע��!');</script>");
				response.sendRedirect("/EShopping/register.jsp");
			} else {
				//�û�������ʹ��
				String sql = "insert into register(userName,Name,sex,passWord,card,Email,address,regtime) values(?,?,?,?,?,?,?,?)";
				
				int n = dao.AddRegister(sql,userName,Name,sex,passWord,card,Email,address,regtime);
				if(n == 0){
					out.write("<script type='text/javascript'>alert('ע��ʧ��');</script>");
					request.getRequestDispatcher("/register.jsp").include(request, response);
				} else {
					out.write("<script type='text/javascript'>alert('ע��ɹ�');</script>");
					request.getRequestDispatcher("/index.html").include(request, response);
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
