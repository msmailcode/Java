package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Member;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;

public class CheckServlet extends HttpServlet {
	/*
	 * ��½�û�����֤,�����������
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		String input = request.getParameter("nam");
		String mc =(String)session.getAttribute("num");
		
		if(!(input.equals(mc))){
			out.write("<script type='text/javascript'>alert('��֤�벻��ȷ����¼ʧ�ܣ����������룡');</script>");
			request.getRequestDispatcher("/index.html").include(request, response);
			return;
		}
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		
		
		
		RegisterDAO registerDAO = new RegisterDAO();
		String sql = "select count(*) from register where userName=? and passWord=? and state=" + 1;
		int n = registerDAO.CheckPesson(sql, userName, passWord);
		//������ʲô�ط�
		
		
		//���浽cookie�е���Ϣ
		if(n > 0){
			Cookie cookies [] = request.getCookies();
			if(userName != null){
				Cookie c = new Cookie("userName",userName);
				c.setMaxAge(3000);
				response.addCookie(c);
			} else if (cookies != null){
				for(int i=0;i<cookies.length;i++){
					if(cookies[i].getName().equals("userName")){
						userName = cookies[i].getValue();
						System.out.println(userName);
					}
				}
			}
			
			if(passWord != null){
				Cookie c = new Cookie("passWord",passWord);
				c.setMaxAge(3000);
				response.addCookie(c);
			} else if (cookies != null){
				for(int i=0;i<cookies.length;i++){
					if(cookies[i].getName().equals("passWord")){
						passWord = cookies[i].getValue();
						System.out.println(passWord);
					}
				}
			}
			
			Member member= new Member();
			member.setUserName(userName);
			member.setPassWord(passWord);
			session.setAttribute("member", member);
			session.setAttribute("userName", userName);
			response.sendRedirect("/EShopping/index.html");
		} else {
			out.write("<script type='text/javascript'>alert('�û������������,��¼ʧ��,�����µ�¼!');</script>");
			request.getRequestDispatcher("/index.html").include(request, response);
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
