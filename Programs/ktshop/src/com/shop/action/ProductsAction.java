package com.shop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Products;
import com.shop.model.User;
import com.shop.page.PageBean;
import com.shop.service.ProductsService;

public class ProductsAction extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductsService productsService;
	public String productname;
	public String bigcategory;
	public String smallcategory;
	public String pic;
	public Double price;
	public int recommend;
	public String introduce;
	public String parameter;
	private int pageSize;
    private int page;    //第几页   
    private PageBean pageBean;    //包含分页信息的bean
 
	public String save() throws Exception{
	        Products product = new Products();
	        product.setProductname(productname);
	        product.setBigcategory(bigcategory);
	        product.setSmallcategory(smallcategory);
	        product.setPic(pic);	      
			product.setPrice(price);
			product.setRecommend(recommend);
			product.setParameter(parameter);
	        product.setIntroduce(introduce);
	        product.setRegdatetime((Date)new Date());
	    
	        productsService.addProducts(product);
	        return SUCCESS;
	    }

	public String list() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String fieldname=request.getParameter("queryName");
        String value=request.getParameter("queryValue");
        List<User> list=new ArrayList<User>();
        pageSize=PageBean.getPageSize(); 
        this.pageBean = productsService.getProducts2(fieldname,value,pageSize, page);
        request.setAttribute("list",list);
        return "list";
    }
	
	public String list2() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String fieldname=request.getParameter("queryName");
        String value=request.getParameter("queryValue");
        List<User> list=new ArrayList<User>();
        pageSize=PageBean.getPageSize(); 
        this.pageBean = productsService.getProducts8(fieldname,value,pageSize, page);
        request.setAttribute("list",list);
        return "list";
    }
	
	public String list3() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String fieldname=request.getParameter("queryName");
        String value=request.getParameter("queryValue");
        List<User> list=new ArrayList<User>();
        pageSize=PageBean.getPageSize(); 
        this.pageBean = productsService.getProducts9(fieldname,value,pageSize, page);
        request.setAttribute("list",list);
        return "list";
    }
	
	public String show2() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String bigcategory=request.getParameter("bigcategory");
        List<User> list=new ArrayList<User>();
        pageSize=PageBean.getPageSize(); 
        this.pageBean = productsService.listTypeProducts2(bigcategory,pageSize, page);
        request.setAttribute("list",list);
        return SUCCESS;	 
    }
	public String show() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String smallcategory=request.getParameter("smallcategory");
        List<User> list=new ArrayList<User>();
        pageSize=PageBean.getPageSize(); 
        this.pageBean = productsService.listTypeProducts(smallcategory,pageSize, page);
        request.setAttribute("list",list);
        return SUCCESS;	 
    }
    public String get() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        Products  product=productsService.getProduct(id);
        request.setAttribute("product",product);
        return SUCCESS;	  
    } 
    public String modify() throws Exception{
    	  HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
          Integer id=new Integer(request.getParameter("id"));
          Products  product=productsService.getProduct(id);
        product.setProductname(productname);
        product.setBigcategory(bigcategory);
        product.setSmallcategory(smallcategory);
        product.setPic(pic);
        product.setPrice(price);
        product.setRecommend(recommend);
        product.setIntroduce(introduce);
        product.setParameter(parameter);
        product.setRegdatetime((Date)new Date());
    
        productsService.modifyProduct(product);
        return SUCCESS;
    }
	   public String delete() throws Exception{
	        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	        Integer id=new Integer(request.getParameter("id"));
	        productsService.delteteProduct(id);
	        return SUCCESS;
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

		 public void setProductsService(ProductsService productsService) {
			this.productsService = productsService;
		}
		public ProductsService getProductsService() {
			return productsService;
		} 

}
