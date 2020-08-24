package com.shoes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoes.model.Admin;
import com.shoes.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/adminloginaction", method = RequestMethod.POST)
    public String loginAction(ModelMap map, javax.servlet.http.HttpServletRequest request, 
    		 @RequestParam(value="admin_id", required=true) String adminId,
    		 @RequestParam(value="admin_pwd", required=true) String adminPwd) 
    {
	  
	  Admin admin = adminService.authenticate(adminId, adminPwd);
	  if (admin == null) { 
		  map.addAttribute("error", "Admin login failed");
		  return "admin/login";
	  }
	  // store admin id in session
	  HttpSession session = request.getSession();
	  session.setAttribute("admin_id", admin.getID());
	  
        return "admin/dashboard"; 
    }	
	 @RequestMapping(value = "/adminchangepassword", method = RequestMethod.GET)
	    public String changePwd(ModelMap map, javax.servlet.http.HttpServletRequest request) 
	    {
		  // check if session is still alive
		  HttpSession session = request.getSession();
		  if (session.getAttribute("admin_id") == null) {
			  return "admin/login";
		  }
		  
		  Admin admin = adminService.getAdminById((Long) session.getAttribute("admin_id"));
		  
		  map.addAttribute("admin", admin);
		  map.addAttribute("pageTitle", "ADMIN CHANGE PASSWORD");
	        return "admin/change-password"; 
	    }
	 @RequestMapping(value = "/adminchangepwdaction", method = RequestMethod.POST)
	    public String updatePassword(ModelMap map,  @RequestParam(value="pwd", required=true) String pwd,
	    		 @RequestParam(value="pwd2", required=true) String pwd2, 
	    		 javax.servlet.http.HttpServletRequest request)
	    {
		  // check if session is still alive
		  HttpSession session = request.getSession();
		  if (session.getAttribute("admin_id") == null) {
			  return "admin/login";
		  }
		  
		  
		  if (pwd == null || pwd2 == null || pwd.equals("") || pwd2.equals("")) {
			  map.addAttribute("error", "Error , Incomplete passwords submitted.");
			  return "admin/change-password";
		  }
		  if (!pwd.equals(pwd2)) {
			  map.addAttribute("error", "Error , Passwords do not match.");
			  return "admin/change-password";
		  }
		  Admin admin = adminService.getAdminById((Long) session.getAttribute("admin_id")); 
		  admin.setAdminPwd(pwd);
		  adminService.updatePwd(admin);
		  
	        return "admin/dashboard";  
	    }
	 @RequestMapping(value = "/adminlogout", method = RequestMethod.GET)
	    public String logout(ModelMap map, javax.servlet.http.HttpServletRequest request) 
	    {
		  	HttpSession session = request.getSession();
		  	session.invalidate();
		  	
	        return "admin/login"; 
	    }
	  

}
