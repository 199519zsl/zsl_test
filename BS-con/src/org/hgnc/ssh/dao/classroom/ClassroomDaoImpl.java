package org.hgnc.ssh.dao.classroom;

import java.util.List;

import org.hgnc.ssh.bean.Classroom;
import org.hgnc.ssh.dao.SecondDaoClass;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("classroomDao")
public class ClassroomDaoImpl extends SecondDaoClass<Classroom> implements ClassroomDaoInte{
	@Override
	public void add(Classroom t) {
		this.getHibernateTemplate().save(t);
	}
	
	@Override
	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> getAll() {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"select * from HGNC_CLASSROOM order by CLR_TIME desc");
		q.addEntity(Classroom.class);
		List<Classroom> list = q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}
	
	@Override
	public Classroom getById(String id) {
		return this.getHibernateTemplate().get(Classroom.class, id);
	}
	
	@Override
	public void update(Classroom t) {
		this.getHibernateTemplate().update(t);
	}
	
}
