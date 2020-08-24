package com.shoes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shoes.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	@Query(value = "SELECT * FROM ADMIN WHERE ADMIN_ID = ?1 AND ADMIN_PWD = ?2", nativeQuery = true)
	  public List<Admin> authenticate(String adminId, String pwd );
	@Query(value = "SELECT * FROM ADMIN WHERE ID = ?1 ", nativeQuery = true)
	  public List<Admin> ID(long adminId );
	@Modifying
	@Query(value = "UPDATE ADMIN SET ADMIN_PWD=?1 WHERE ID = ?2 ", nativeQuery = true)
	  public void update(String pwd, long id );
}
