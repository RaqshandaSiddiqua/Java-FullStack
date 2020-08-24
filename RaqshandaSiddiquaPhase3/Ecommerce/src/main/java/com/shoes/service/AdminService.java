package com.shoes.service;

import com.shoes.model.Admin;

public interface AdminService {
	public Admin authenticate(String adminId , String pwd);
	public Admin getAdminById(Long attribute);
	public void updatePwd(Admin admin);
}
