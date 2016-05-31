package com.shop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.News;
import com.shop.page.PageBean;
import com.shop.service.NewsService;

public class NewsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NewsService newsService;
	public String title;
	public String author; 
	public String newstype;
	public String pic;
	public int recommend;
	public String content;
	public String cc;
	private int pageSize;
    private int page;    //第几页 
    private PageBean pageBean;    //包含分页信息的bean
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	public NewsService getNewsService() {
		return newsService;
	}
    public int getPage() {
        return page;
    }

    public void setPage(int page) {        //若URL中无此参数,会默认为第1页
        this.page = page;
    }
	public String save() throws Exception{
		News news= new News();
		news.setTitle(title);
		news.setAuthor(author);
		news.setNewstype(newstype);
		news.setPic(pic);
		news.setRecommend(recommend);
		news.setContent(content);
		news.setCc(cc);
		news.setPublicdatetime((Date)new Date());
		newsService.addnews(news);
		return SUCCESS;
	}
	
	public String list() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String fieldname=request.getParameter("queryName");
        String value=request.getParameter("queryValue");
        List<News> list=new ArrayList<News>();
        pageSize=PageBean.getPageSize(); 
        this.setPageBean(newsService.query(fieldname,value,pageSize,page));
        request.setAttribute("list",list);
        return "list";
    }
	
    public String get() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        News  news=newsService.getNew(id);
        request.setAttribute("news",news);
        return SUCCESS;	  
    }
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public PageBean getPageBean() {
		return pageBean;
	} 
	
}
