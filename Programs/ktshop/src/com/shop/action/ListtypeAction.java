package com.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Bigtype;
import com.shop.model.Smalltype;
import com.shop.service.BigtypeService;
import com.shop.service.SmalltypeService;

public class ListtypeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigtypeService bigtypeService;
	private SmalltypeService smalltypeService;
	public void setBigtypeService(BigtypeService bigtypeService) {
		this.bigtypeService = bigtypeService;
	}
	public BigtypeService getBigtypeService() {
		return bigtypeService;
	}
	public void setSmalltypeService(SmalltypeService smalltypeService) {
		this.smalltypeService = smalltypeService;
	}
	public SmalltypeService getSmalltypeService() {
		return smalltypeService;
	}
    public String list() throws Exception{
    	HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST); 	 
    	 List<Bigtype>  bigtype= bigtypeService.getBigtypes();
        request.setAttribute("bigtype",bigtype);
        List<Smalltype> smalltype=smalltypeService.getSmalltypes();
        request.setAttribute("smalltype",smalltype);
        return SUCCESS;	 
    } 

}
