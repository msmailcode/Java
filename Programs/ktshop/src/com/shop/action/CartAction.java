package com.shop.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.cart.Cart;
import com.shop.model.Products;
import com.shop.service.ProductsService;
public class CartAction extends ActionSupport  {
	/**
	 * 
	 */
	private ProductsService productsService;
	private static final long serialVersionUID = 1L;
	private int id;
	private List<Cart> shopcart;
	public void setProductsService(ProductsService productsService) {
			this.productsService = productsService;
		}
		public ProductsService getProductsService() {
			return productsService;
		} 

	@SuppressWarnings("unchecked")
	public String add(){
		  HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	        Integer id=new Integer(request.getParameter("id"));
	  
	        Products product=productsService.getProduct(id);
	     	 Cart cartitem=new Cart();
		        cartitem.setProductid(id);
		        cartitem.setProductname(product.getProductname());
		        cartitem.setPrice(product.getPrice());
		        cartitem.setQuantity(1);
	        ActionContext context = ActionContext.getContext();
	        Map<String, Object> session = context.getSession();		       
	        List<Cart> shopcart =(List<Cart>) session.get("shopcart");
	        if (shopcart==null){
	        	 shopcart=new ArrayList<Cart>();
	        	 shopcart.add(cartitem);	
	        }
	        else
	        {
	        	boolean find=false; 
	        for(int i=0;i<shopcart.size();i++){
				Cart cc=(Cart)shopcart.get(i);
	            if (cc.getProductid()==id) { 
	        	 
	        	 cc.setQuantity(cc.getQuantity()+1);   
	        	 find=true;
	        	 break;
	            }
	        }
	        if(!find)
	         {
	     
	        	 shopcart.add(cartitem);	
	         }
	    
	        }

	        session.put("shopcart",shopcart); 
			return SUCCESS;
			}

	@SuppressWarnings("unchecked")
	public String delete(){
		 HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	        Integer productid=new Integer(request.getParameter("productid"));	        
		 ActionContext context = ActionContext.getContext();
	        Map<String, Object> session = context.getSession();
	        List<Cart> shopcart =(List<Cart>) session.get("shopcart");
	        for(int i=0;i<shopcart.size();i++){
				Cart cc=(Cart)shopcart.get(i);
	        	if (cc.getProductid()==productid){
	        		   shopcart.remove(i);
	        		   break;
	        	}
	        }	     
	        session.put("shopcart",shopcart); 		       
	        return SUCCESS;	
	}

	@SuppressWarnings("unchecked")
	public String update(){
		  HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	      Integer productid=new Integer(request.getParameter("productid"));
		Integer quantity=new Integer(request.getParameter("quantity"));
	      ActionContext context = ActionContext.getContext();
	        Map<String, Object> session = context.getSession();
	        List<Cart> shopcart =(List<Cart>) session.get("shopcart");
	        for(int i=0;i<shopcart.size();i++){
				Cart cc=(Cart)shopcart.get(i);
	        	if (cc.getProductid()==productid){
	        		   cc.setQuantity(quantity);
	        		   break;
	        	}
	        }	     
	        session.put("shopcart",shopcart); 		       
	        return SUCCESS;	
	}
	public String clear(){
		  ActionContext context = ActionContext.getContext();
	        Map<?, ?> session = context.getSession();
	        session.clear();	
	        return SUCCESS;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setShopcart(List<Cart> shopcart) {
		this.shopcart = shopcart;
	}
	public List<Cart> getShopcart() {
		return shopcart;
	}
}
