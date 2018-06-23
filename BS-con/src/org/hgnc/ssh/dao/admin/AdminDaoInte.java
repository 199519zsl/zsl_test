package org.hgnc.ssh.dao.admin;

import org.hgnc.ssh.bean.Admin;
import org.hgnc.ssh.dao.FirstDaoInte;

public interface AdminDaoInte extends FirstDaoInte<Admin>{
	public Admin checkLogin(String account,String password);
	public Admin getByAccount(String account);
}
