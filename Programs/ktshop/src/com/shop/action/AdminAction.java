package com.shop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Admin;
import com.shop.service.AdminService;

public class AdminAction  extends ActionSupport{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String adminLogin() throws Exception{   
	    	 HttpServletRequest req = ServletActionContext.getRequest();
	    	 Admin resultUser=adminService.Login(admin);
	    	 ActionContext context = ActionContext.getContext();
	         Map<String, Object> session = context.getSession();		
	         session.put("adminname",admin.getAdminname()); 
	         session.put("id",admin.getId()); 
	         req.getSession().setAttribute("admin", admin); 
	         if(null == resultUser){
	               return "fail";
	         }
	 return SUCCESS;


	    }
	 public String logout(){
	    	ActionContext context = ActionContext.getContext();
	    	    
	 		Map<?, ?> session = context.getSession();
	    	session.remove("adminname");

	    	return SUCCESS;
	    	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

}
