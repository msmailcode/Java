package com.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.shop.model.Smalltype;
import com.shop.service.SmalltypeService;

public class SmalltypeAction {
	private static final String SUCCESS = "success";
	private SmalltypeService smalltypeService;
        public  Integer bigtypeid;
	public String smalltypename;


	public void setSmalltypeService(SmalltypeService smalltypeService) {
		this.smalltypeService = smalltypeService;
	}

	public SmalltypeService getSmalltypeService() {
		return smalltypeService;
	}
	public String save() throws Exception{
		Smalltype smalltype = new Smalltype();
                smalltype.setBigtypeid(bigtypeid);  
		 smalltype.setSmalltypename(smalltypename);  
		smalltypeService.addSmalltype(smalltype);
		return SUCCESS;

	}
	public String list() throws Exception{
		 HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	        Integer id=new Integer(request.getParameter("id"));
	        List<Smalltype> smalltype=smalltypeService.query(id);
	        request.setAttribute("smalltype",smalltype);
	        return SUCCESS;	  
    }
	public String list2() throws Exception{
		 HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);	      
	        List<Smalltype> smalltype=smalltypeService.getSmalltypes();
	        request.setAttribute("smalltype",smalltype);
	        return SUCCESS;	  
   }

}
