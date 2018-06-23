package org.hgnc.ssh.dao.admin;

import java.util.List;

import org.hgnc.ssh.bean.Admin;
import org.hgnc.ssh.dao.SecondDaoClass;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository("adminDao")
public class AdminDaoImpl extends SecondDaoClass<Admin> implements AdminDaoInte{
	@Override
	public void add(Admin t) {
		this.getHibernateTemplate().save(t);
	}
	
	@Override
	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAll() {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"select * from HGNC_ADMIN order by ADM_TIME desc");
		q.addEntity(Admin.class);
		List<Admin> list = q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}
	
	@Override
	public Admin getById(String id) {
		return this.getHibernateTemplate().get(Admin.class, id);
	}
	
	@Override
	public void update(Admin t) {
		this.getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	public Admin checkLogin(String account,String password) {
		Admin admin = null;
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"select * from HGNC_ADMIN where ADM_ACCOUNT=? and ADM_PASSWORD=?")
						.setParameter(0, account.trim())
						.setParameter(1, password.trim());
		q.addEntity(Admin.class);
		
		List<Admin> list = q.list();
		int n = list.size();
        System.out.println(list.size());
        if(n==1){
        	admin = list.iterator().next();
        }else{
        	admin = new Admin();	//传递一个含null属性的admin
        }
        session.close();
		return admin;  
	}

	public Admin getByAccount(String account) {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"select * from HGNC_ADMIN where ADM_ACCOUNT=?")
						.setParameter(0, account.trim());
		q.addEntity(Admin.class);
		List<Admin> list = q.list();
		int n = list.size();
        System.out.println(list.size());
        Admin admin = null;
        if(n==1){
        	admin = list.iterator().next();
        }else{
        	admin = new Admin();
        }
        session.close();
		return admin;
	}
	
}
