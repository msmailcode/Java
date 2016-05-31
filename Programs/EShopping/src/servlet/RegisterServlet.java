package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;


//注册新用户
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		String input = request.getParameter("nam");
		String mc =(String)session.getAttribute("num");
		
		//验证码必须正确
		if(!(input.equals(mc))){
			out.write("<script type='text/javascript'>alert('验证码不正确，注册失败，请重新输入！');</script>");
			request.getRequestDispatcher("/register.jsp").include(request, response);
			return;
		}
		
		Object obj = (Object)session.getAttribute("register");
		
		//防止重复提交注册
		if(obj == null){
			out.write("<script type='text/javascript'>alert('请不要重复提交注册请求！');</script>");
			request.getRequestDispatcher("/index.html").include(request, response);
		} else {
//移除session的userName属性(如果是重复提交，session中的userName属性被移除了，session.getAttribute("userName")返回值为空，则执行24行的代码，不会调用dao的注册方法，因此也不会向数据库中写内容)
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
			
			//设置先检查用户名是否存在,用ajax的方法检测用户名是否是唯一的
			String sql1 = "select count(*) from register where userName=?";
			int m = dao.CheckName(sql1, userName);
			if(m > 0){
				//用户名不能相同,提示,告诉用户写出来
				out.write("<script type='text/javascript'>alert('注册失败,检测到用户名已经存在,请重新注册!');</script>");
				response.sendRedirect("/EShopping/register.jsp");
			} else {
				//用户名可以使用
				String sql = "insert into register(userName,Name,sex,passWord,card,Email,address,regtime) values(?,?,?,?,?,?,?,?)";
				
				int n = dao.AddRegister(sql,userName,Name,sex,passWord,card,Email,address,regtime);
				if(n == 0){
					out.write("<script type='text/javascript'>alert('注册失败');</script>");
					request.getRequestDispatcher("/register.jsp").include(request, response);
				} else {
					out.write("<script type='text/javascript'>alert('注册成功');</script>");
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
