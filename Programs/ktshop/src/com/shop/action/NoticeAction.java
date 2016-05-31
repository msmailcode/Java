package com.shop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Notice;
import com.shop.page.PageBean;
import com.shop.service.NoticeService;

public class NoticeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String title;
	public String author; 
	public String noticetype;
	public String pic;
	public int recommend;
	public String content;
	public String cc;
	private int pageSize;
    private int page;    //第几页 
    private PageBean pageBean;    //包含分页信息的bean
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public NoticeService getNoticeService() {
		return noticeService;
	}
    public int getPage() {
        return page;
    }

    public void setPage(int page) {        //若URL中无此参数,会默认为第1页
        this.page = page;
    }
	public String save() throws Exception{
		Notice notice= new Notice();
		notice.setTitle(title);
		notice.setAuthor(author);
		notice.setNoticetype(noticetype);
		notice.setPic(pic);
		notice.setRecommend(recommend);
		notice.setContent(content);
		notice.setCc(cc);
		notice.setPublicdatetime((Date)new Date());
		noticeService.addnotice(notice);
		return SUCCESS;
	}
	
	public String list() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String fieldname=request.getParameter("queryName");
        String value=request.getParameter("queryValue");
        List<Notice> list=new ArrayList<Notice>();
        pageSize=PageBean.getPageSize(); 
        this.setPageBean(noticeService.query(fieldname,value,pageSize,page));
        request.setAttribute("list",list);
        return "list";
    }
	
    public String get() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        Notice  notice=noticeService.getNotice(id);
        request.setAttribute("notice",notice);
        return SUCCESS;	  
    }
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public PageBean getPageBean() {
		return pageBean;
	} 
	
}
