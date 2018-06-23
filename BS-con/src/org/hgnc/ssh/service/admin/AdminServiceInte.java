package org.hgnc.ssh.service.admin;

import java.util.List;

import org.hgnc.ssh.bean.Admin;

public interface AdminServiceInte {
	public void add(Admin t);
	public void delete(String id);
	public void update(Admin t);
	public Admin getById(String id);
	public List<Admin> getAll();
	
	public Admin checkLogin(String account,String password);
	public Admin getByAccount(String account);
}
