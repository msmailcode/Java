package com.shop.action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.User;
import com.shop.page.PageBean;
import com.shop.service.UserService;
public class UserAction extends ActionSupport  {
    private static final long serialVersionUID = 1L;
  //private User user = new User();
    private User user;

    public String username;
    public int userid;
    public String password;
    public int sex;
    public Date birthday;
    public String education;
    public String job;
    public String friends;
    public String pic;
    public String message;
    public String hobby;
    public String province;
    public String city;
    public String address;
    public Integer post;
    public String telphone;
    public String mobilephone;
    public String email;
    private UserService userService;
    private int pageSize;
    private int page;    //第几页   
    private PageBean pageBean;    //包含分页信息的bean
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

    public void setUserService(UserService userService){
        this.userService=userService;
    }
    public String save() throws Exception{
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setEducation(education);
        user.setJob(job);
        user.setHobby(hobby);
        user.setFriends(friends);
        user.setPic(pic);
        user.setMessage(message);
        user.setProvince(province);
        user.setCity(city);
        user.setAddress(address);
        user.setPost(post);
        user.setTelphone(telphone);
        user.setMobilephone(mobilephone);
        user.setEmail(email);
        user.setRegdatetime((Date)new Date());
        userService.addUser(user);
        return SUCCESS;
    } 


	public String list() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String fieldname=request.getParameter("queryName");
        String value=request.getParameter("queryValue");
        List<User> list=new ArrayList<User>();
        pageSize=PageBean.getPageSize(); 
        this.pageBean = userService.getUser3(fieldname,value,pageSize, page);
        request.setAttribute("list",list);
        return "list";
    }

    public String get() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        User  user=userService.getUser(id);
        request.setAttribute("user",user);
        return SUCCESS;	  
    } 
	 
    public String modify() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        User  user=userService.getUser(id);
        user.setPassword(password);
        user.setSex(sex);
        user.setEducation(education);
        user.setJob(job);
        user.setHobby(hobby);
        user.setFriends(friends);
        user.setPic(pic);
        user.setMessage(message);
        user.setProvince(province);
        user.setCity(city);
        user.setAddress(address);
        user.setPost(post);
        user.setTelphone(telphone);
        user.setMobilephone(mobilephone);
        
        userService.modifyUser(user);
        return SUCCESS;
    } 

    public String delete() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        userService.delteteUser(id);
        return SUCCESS;
    }

    public String view() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Integer id=new Integer(request.getParameter("id"));
        User  user=userService.getUser(id);
        request.setAttribute("user",user);
        return SUCCESS;	  
    } 
	
    public String userLogin() throws Exception{   
        String retVal = ERROR;  
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        String username=new String(((ServletRequest) request).getParameter("username"));
        String password=new String(((ServletRequest) request).getParameter("password"));
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();		
        session.put("username",username); 
        boolean isLogin =userService.isLogin(username,password); 
        if (isLogin) 
        retVal=SUCCESS; 
        return retVal; 
    }
    public String login() throws Exception{   
    	 HttpServletRequest req = ServletActionContext.getRequest();
    	 User resultUser=userService.Login(user);
    	  if(null == resultUser){
              return "error";
        }
    	 ActionContext context = ActionContext.getContext();
         Map<String, Object> session = context.getSession();		
         session.put("username",user.getUsername()); 
         session.put("id",user.getId()); 
         req.getSession().setAttribute("user", user); 
       
         return SUCCESS;

    }
    public String getUser1() throws Exception{
        HttpServletRequest  request= (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);       
     	 ActionContext context = ActionContext.getContext();    
		Map<?, ?> session = context.getSession();
        String username=(String) session.get("username");
        List<User>  user=userService.findByUser(username);
        request.setAttribute("user",user);
        return SUCCESS;	  
    } 
    
    public String logout(){
    	 ActionContext context = ActionContext.getContext();
    	    
 		Map<?, ?> session = context.getSession();
    	session.remove("username");

    	return SUCCESS;
    	}

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    } 
    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }



}
