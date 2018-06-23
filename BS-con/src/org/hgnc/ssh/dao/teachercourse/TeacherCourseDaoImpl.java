package org.hgnc.ssh.dao.teachercourse;

import java.util.List;

import org.hgnc.ssh.bean.Teacher;
import org.hgnc.ssh.bean.TeacherToCourse;
import org.hgnc.ssh.dao.SecondDaoClass;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("teacherCourseDao")
public class TeacherCourseDaoImpl extends SecondDaoClass<TeacherToCourse> implements TeacherCourseDaoInte{

	@Override
	public void add(TeacherToCourse t) {
		this.getHibernateTemplate().save(t);
	}
	@Override
	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}
	@Override
	public List<TeacherToCourse> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}
	@Override
	public TeacherToCourse getById(String id) {
		return this.getHibernateTemplate().get(TeacherToCourse.class, id);
	}
	
	@Override
	public void update(TeacherToCourse t) {
		this.getHibernateTemplate().update(t);
	}
	
	@SuppressWarnings("unchecked")
	public String getTidByCid(String cid) {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"select * from HGNC_TEACHER_COURSE where TC_CID=?")
						.setParameter(0, cid.trim());
		q.addEntity(TeacherToCourse.class);
		List<TeacherToCourse> list = q.list();
		String tid = null;
		if(list.size()==1){
			tid = list.iterator().next().getTeacher().getTea_id();
		}
		session.close();
		return tid;
	}
	
	public void deleteByCid(String cid) {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"delete from HGNC_TEACHER_COURSE where TC_CID=?")
						.setParameter(0, cid.trim());
		q.executeUpdate();
		session.close();
	}
	
}
