package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


import javabean.Cart;
import javabean.Member;
import javabean.OrderDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.jdbc.odbc.OdbcDef;

import dao.RegisterDAO;

public class OrderSuccess extends HttpServlet {

	//复杂的方法，下定单成功之前先存到定单表，在存到定单明晰表
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
	 	HttpSession session = request.getSession();
	 	RegisterDAO dao = new RegisterDAO();
	 	Object obj = session.getAttribute("userName");
	 	if(obj == null){
	 		response.sendRedirect("/EShopping/sorry.jsp");
	 	}else{
	 		
	 		//先查出该用户人的id
	 		String userName = (String)obj;
	 		Member member = dao.ToModRegister(userName);
	 		int userID = member.getId();
	 		String datatime = request.getParameter("datatime");
	 		String saveName = request.getParameter("saveName");
	 		String savePhone = request.getParameter("savePhone");
	 		String saveAddress = request.getParameter("saveAddress");
	 		String zip = request.getParameter("zip");
	 		int deliverymode = Integer.parseInt(request.getParameter("deliverymode"));
	 		int moneymode = Integer.parseInt(request.getParameter("moneymode"));
	 		String sql = "insert into orders(userID,datatime,saveName,savePhone,saveAddress,zip,deliverymode,moneymode) values("+userID+",'"+datatime+"','"+saveName+"','"+savePhone+"','"+saveAddress+"','"+zip+"',"+deliverymode+","+moneymode+")";
	 		int n = dao.del(sql);
	 		if(n > 0){
	 			//寸到定单表成功后在寸到定单明晰表中
	 			Object obj1 = session.getAttribute("member");
	 			if(obj1 == null){
	 				response.sendRedirect("/EShopping/sorry.jsp");
	 			}else {
	 				Member member2 = (Member)obj1;
	 				Iterator it = member2.getMap().values().iterator();
	 				while(it.hasNext()){
	 				 	Cart cart = (Cart)it.next();
	 				 	OrderDetail orderDetail = new OrderDetail();
	 				 	orderDetail.setBookid(cart.getBookid());
	 				 	orderDetail.setNumber(cart.getNumber());
	 				 	orderDetail.setTotalprice(cart.getTotal());
	 				 	//得到定单id的方法
	 				 	String sql1 = " select max(id) as temp from orders";
	 				   	int n1 = dao.CheckOrder(sql1);
	 				   	orderDetail.setOrderid(n1);
	 				   	int n2 =dao.insetorder(orderDetail);
	 				   	String sql3 = "select temp from (select sum(totalprice) as temp,orderid from orderdetail group by orderid) as a where orderid=" + n1;
	 				   	float n3 = dao.CheckPrice(sql3);
	 				   	request.setAttribute("n1", n1);
	 				   	request.setAttribute("n3", n3);
	 				   	request.setAttribute("datatime", datatime);
	 				}
		 			request.getRequestDispatcher("/ordersuccess.jsp").include(request, response);
	 			}
	 			
	 		}
	 	}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
