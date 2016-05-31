package com.shop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Ad;
import com.shop.page.PageBean;
import com.shop.service.AdService;

public class AdAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdService adService;
	public String title;
	public String pic;
	public String url;
	public String remark;
	private int pageSize;
    private int page;    //第几页 
    private PageBean pageBean;    //包含分页信息的bean
	public void setadService(AdService adService) {
		this.adService = adService;
	}
	public AdService getadService() {
		return adService;
	}
    public int getPage() {
        return page;
    }

    public void setPage(int page) {        //若URL中无此参数,会默认为第1页
        this.page = page;
    }
	public String save() throws Exception{
		Ad ad= new Ad();
		ad.setTitle(title);
		ad.setPic(pic);
		ad.setUrl(url);
		ad.setRemark(remark);
		ad.setInputdatetime((Date)new Date());
		adService.addAd(ad);
		return SUCCESS;
	}
	
	public String list() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String fieldname=request.getParameter("queryName");
        String value=request.getParameter("queryValue");
        List<Ad> list=new ArrayList<Ad>();
        pageSize=PageBean.getPageSize(); 
        this.setPageBean(adService.query(fieldname,value,pageSize,page));
        request.setAttribute("list",list);
        return "list";
    }
	
    public String get() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        Ad  ad=adService.getAd(id);
        request.setAttribute("ad",ad);
        return SUCCESS;	  
    }
    
    public String modify() throws Exception{
  	  HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        Ad  ad=adService.getAd(id);
      ad.setTitle(title);
      ad.setPic(pic);
      ad.setUrl(url);
      ad.setRemark(remark);
      ad.setInputdatetime((Date)new Date());
  
      adService.modifyAd(ad);
      return SUCCESS;
  } 
	   public String delete() throws Exception{
	        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	        Integer id=new Integer(request.getParameter("id"));
	        adService.delteteAd(id);
	        return SUCCESS;
	    }
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public PageBean getPageBean() {
		return pageBean;
	} 
	
}
