package org.hgnc.ssh.dao.teacher;

import java.util.List;

import org.hgnc.ssh.bean.Teacher;
import org.hgnc.ssh.dao.SecondDaoClass;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("teacherDao")
public class TeacherDaoImpl extends SecondDaoClass<Teacher> implements TeacherDaoInte{
	@Override
	public void add(Teacher t) {
		this.getHibernateTemplate().save(t);
	}
	
	@Override
	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAll() {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"select * from HGNC_TEACHER order by TEA_TIME desc");
		q.addEntity(Teacher.class);
		List<Teacher> list = q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}
	
	@Override
	public Teacher getById(String id) {
		return this.getHibernateTemplate().get(Teacher.class, id);
	}
	
	@Override
	public void update(Teacher t) {
		this.getHibernateTemplate().update(t);
	}
	
}
