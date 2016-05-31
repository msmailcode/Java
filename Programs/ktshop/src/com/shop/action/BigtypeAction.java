package com.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.shop.model.Bigtype;
import com.shop.model.Smalltype;
import com.shop.service.BigtypeService;
import com.shop.service.SmalltypeService;

public class BigtypeAction {
	private static final String SUCCESS = "success";
	private BigtypeService bigtypeService;
	private SmalltypeService smalltypeService;
	public String bigtypename;

	public void setBigtypeService(BigtypeService bigtypeService) {
		this.bigtypeService = bigtypeService;
	}

	public BigtypeService getBigtypeService() {
		return bigtypeService;
	}
	public String save() throws Exception{
		Bigtype bigtype = new Bigtype();
		 bigtype.setBigtypename(bigtypename);  
		bigtypeService.addBigtype(bigtype);
		return SUCCESS;

	}
    public String list() throws Exception{
    	HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST); 	 
    	 List<Bigtype>  bigtype= bigtypeService.getBigtypes();
        request.setAttribute("bigtype",bigtype);
        List<Smalltype> smalltype=smalltypeService.getSmalltypes();
        request.setAttribute("smalltype",smalltype);
        return "bigtype";	  
    }
    public String list2() throws Exception{
    	HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST); 	 
    	 List<Bigtype>  bigtype= bigtypeService.getBigtypes();
        request.setAttribute("bigtype",bigtype);
        List<Smalltype> smalltype=smalltypeService.getSmalltypes();
        request.setAttribute("smalltype",smalltype);
        return "type";	  
    }
    public String list3() throws Exception{
    	HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST); 	 
    	 List<Bigtype>  bigtype= bigtypeService.getBigtypes();
        request.setAttribute("bigtype",bigtype);
        return "listbigtype";	  
    }

	public void setSmalltypeService(SmalltypeService smalltypeService) {
		this.smalltypeService = smalltypeService;
	}

	public SmalltypeService getSmalltypeService() {
		return smalltypeService;
	} 



}
