package org.hgnc.ssh.dao.notice;

import java.util.List;

import org.hgnc.ssh.bean.Admin;
import org.hgnc.ssh.bean.Notice;
import org.hgnc.ssh.dao.SecondDaoClass;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDaoImpl extends SecondDaoClass<Notice> implements NoticeDaoInte{
	@Override
	public void add(Notice t) {
		this.getHibernateTemplate().save(t);
	}
	
	@Override
	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> getAll() {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"select * from HGNC_NOTICE order by NTC_TIME desc");
		q.addEntity(Notice.class);
		List<Notice> list = q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}
	
	@Override
	public Notice getById(String id) {
		return this.getHibernateTemplate().get(Notice.class, id);
	}
	
	@Override
	public void update(Notice t) {
		this.getHibernateTemplate().update(t);
	}
	
}
