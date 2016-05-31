package com.shop.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.cart.Cart;
import com.shop.model.Order;
import com.shop.model.User;
import com.shop.page.PageBean;
import com.shop.service.OrderService;

public class OrderAction extends ActionSupport  {
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private OrderService orderService;
	private int productid;
	private int quantity;
	private int pageSize;
    private int page;    //第几页   
    private PageBean pageBean;   
	Timestamp orderdatetime;
	 String ifpay;
		String ifsent;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public OrderService getOrderService() {
		return orderService;
	} 
	

@SuppressWarnings("unchecked")
public String save() throws Exception{
    HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
    String payment=request.getParameter("payment");
    String postway=request.getParameter("postway");
    String username=request.getParameter("username");
    ActionContext context = ActionContext.getContext();
    Map<?, ?> session = context.getSession();
    List<Cart> shopcart =(List<Cart>) session.get("shopcart");
   
    for(int i=0;i<shopcart.size();i++){
		Cart cc=(Cart)shopcart.get(i);
    productid=cc.getProductid();
    quantity=cc.getQuantity();	
    Double price = cc.getPrice();
    double totalprice = price*quantity;
	Order order = new Order();
	 order.setUsername(username);
    order.setProductid(productid);
    order.setQuantity(quantity);
    order.setTotalprice(totalprice);	      
    order.setPayment(payment);
    order.setPostway(postway);
    order.setOrderdatetime((Date)new Date());	    
    orderService.addOrder(order);
    }
    return SUCCESS;}

	    
    
public String list() throws Exception{
    HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
    String fieldname=request.getParameter("queryName");
    String value=request.getParameter("queryValue");
    List<User> list=new ArrayList<User>();
    pageSize=PageBean.getPageSize(); 
    this.pageBean = orderService.getOrder2(fieldname,value,pageSize, page);
    request.setAttribute("list",list);
    return "list";  
}

public int getPage() {
    return page;
}

public void setPage(int page) {        //若URL中无此参数,会默认为第1页
    this.page = page;
}

public PageBean getPageBean() {
    return pageBean;
}

public void setPageBean(PageBean pageBean) {
    this.pageBean = pageBean;
}	
}



