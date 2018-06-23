package org.hgnc.ssh.dao.studentcourse;

import java.util.List;

import org.hgnc.ssh.bean.StudentToCourse;
import org.hgnc.ssh.dao.SecondDaoClass;
import org.hgnc.ssh.dto.course.StudentCourseDto;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository("studentCourseDao")
public class StudentCourseDaoImpl extends SecondDaoClass<StudentToCourse> implements StudentCourseDaoInte{
	
	@Override
	public void add(StudentToCourse t) {
		this.getHibernateTemplate().save(t);
	}
	
	@Override
	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}
	
	@Override
	public List<StudentToCourse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public StudentToCourse getById(String id) {
		return this.getHibernateTemplate().get(StudentToCourse.class, id);
	}
	
	@Override
	public void update(StudentToCourse t) {
		this.getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	public List<StudentCourseDto> getCourseByStudentId(String id) {
		List<StudentCourseDto> list = this.getSession().createSQLQuery(
				"select s.stu_id as sid,s.stu_card as scard,s.stu_name as sname,s.stu_sex as sex,s.stu_academy as sadmy,sc.sc_id as scid,sc.sc_cid as sccid,sc.sc_pass as scpass,sc.sc_mark as scmark,c.cre_name as cname  " 
				+"from HGNC_STUDENT s,HGNC_STUDENT_COURSE sc,HGNC_COURSE c "
				+"where s.stu_id=sc.sc_sid and sc.sc_cid=c.cre_id and sc.sc_sid=?")
		.addScalar("sid",Hibernate.STRING).addScalar("scard").addScalar("sname").addScalar("sex").addScalar("sadmy")
		.addScalar("scid").addScalar("sccid").addScalar("scpass").addScalar("scmark")
		.addScalar("cname")
		.setParameter(0, id)
		.setResultTransformer(Transformers.aliasToBean(StudentCourseDto.class)).list();
		return list;
	}

	public void updateMark(String cid) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByCid(String cid) {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"delete from HGNC_STUDENT_COURSE where SC_CID=?")
						.setParameter(0, cid.trim());
		q.executeUpdate();
		session.close();
	}
	
}
