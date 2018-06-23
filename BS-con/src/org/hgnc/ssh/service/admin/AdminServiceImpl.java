package org.hgnc.ssh.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.hgnc.ssh.bean.Admin;
import org.hgnc.ssh.dao.admin.AdminDaoInte;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminServiceInte{
	private AdminDaoInte adminDao;
	
	public AdminDaoInte getAdminDao() {
		return adminDao;
	}
	@Resource
	public void setAdminDao(AdminDaoInte adminDao) {
		this.adminDao = adminDao;
	}

	public void add(Admin t) {
		this.adminDao.add(t);
	}

	public void delete(String id) {
		Admin admin = this.getById(id);
		if(admin != null && admin.getAdm_account().length() !=0){
			this.adminDao.delete(id);
		}
		
	}

	public List<Admin> getAll() {
		return this.adminDao.getAll();
	}

	public Admin getById(String id) {
		return this.adminDao.getById(id);
	}

	public void update(Admin t) {
		this.adminDao.update(t);
	}
	
	public Admin checkLogin(String account, String password) {
		return this.adminDao.checkLogin(account, password);
	}
	public Admin getByAccount(String account) {
		return this.adminDao.getByAccount(account);
	}
	
}
