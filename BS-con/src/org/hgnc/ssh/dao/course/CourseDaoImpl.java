package org.hgnc.ssh.dao.course;

import java.util.List;

import org.hgnc.ssh.bean.Course;
import org.hgnc.ssh.dao.SecondDaoClass;
import org.hgnc.ssh.dto.course.TeacherCourseDto;
import org.hgnc.ssh.dto.student.StudentClassroomDto;
import org.hibernate.Hibernate;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository("courseDao")
public class CourseDaoImpl extends SecondDaoClass<Course> implements CourseDaoInte{
	@Override
	public void add(Course t) {
		this.getHibernateTemplate().save(t);
	}
	
	@Override
	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}
	
	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}
	
	@Override
	public Course getById(String id) {
		return this.getHibernateTemplate().get(Course.class, id);
	}
	
	@Override
	public void update(Course t) {
		this.getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	public List<TeacherCourseDto> queryAllTeacherCourse() {
		List<TeacherCourseDto> list = this.getSession().createSQLQuery(
				"select t.tea_name as tname,c.cre_id as cid,c.cre_name as cname,c.cre_score as cscore,c.cre_nature as cnature,c.cre_time as ctime" +
				" from HGNC_COURSE c,HGNC_TEACHER t,HGNC_TEACHER_COURSE tc" +
				" where c.cre_id=tc.tc_cid and tc.tc_tid=t.tea_id order by c.cre_time desc")
		.addScalar("tname",Hibernate.STRING).addScalar("cid").addScalar("cname").addScalar("cscore").addScalar("cnature").addScalar("ctime")
		.setResultTransformer(Transformers.aliasToBean(TeacherCourseDto.class)).list();
		
		return list;
	}
	
}
