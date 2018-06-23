package org.hgnc.ssh.dao.student;

import java.util.List;

import org.hgnc.ssh.bean.Admin;
import org.hgnc.ssh.bean.Student;
import org.hgnc.ssh.dao.SecondDaoClass;
import org.hgnc.ssh.dto.student.StudentClassroomDto;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImpl extends SecondDaoClass<Student> implements StudentDaoInte {
	@Override
	public void add(Student t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery("select * from HGNC_STUDENT order by STU_TIME");
		q.addEntity(Student.class);
		List<Student> list = q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllByClrId(String id) {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery("select * from HGNC_STUDENT where clr_id=?").setParameter(0, id);
		q.addEntity(Student.class);
		List<Student> list = q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<StudentClassroomDto> getDtoAll() {
		System.out.println("lol");
		List<StudentClassroomDto> list = this.getSession()
				.createSQLQuery(
						"select s.stu_id as sid,s.stu_card as scard,s.stu_password as spwd,s.stu_name as sname,s.stu_mobile as smob,s.stu_sex as sex,s.stu_age as sage,s.stu_major as smaj,s.stu_academy as sadmy,s.stu_time as stime,s.stu_province as spro,s.stu_address as sadd,c.clr_name as cname  "
								+ "from HGNC_STUDENT s,HGNC_CLASSROOM c where s.clr_id=c.clr_id order by stime ")
				.addScalar("sid", Hibernate.STRING).addScalar("scard").addScalar("spwd").addScalar("sname")
				.addScalar("smob").addScalar("sex").addScalar("sage").addScalar("smaj").addScalar("sadmy")
				.addScalar("stime").addScalar("spro").addScalar("sadd").addScalar("cname")
				.setResultTransformer(Transformers.aliasToBean(StudentClassroomDto.class)).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<StudentClassroomDto> getByKeywordsAll(String keywords) {
		List<StudentClassroomDto> list = this.getSession()
				.createSQLQuery(
						"SELECT s.stu_id as sid,s.stu_card as scard,s.stu_password as spwd,s.stu_name as sname,s.stu_mobile as smob,s.stu_sex as sex,s.stu_age as sage,s.stu_major as smaj,s.stu_academy as sadmy,s.stu_time as stime,s.stu_province as spro,s.stu_address as sadd,c.clr_name as cname  "
								+ "FROM HGNC_STUDENT s,HGNC_CLASSROOM c "
								+ "WHERE s.clr_id=c.clr_id and (s.stu_card like ? OR s.stu_name like ?)")
				.addScalar("sid", Hibernate.STRING).addScalar("scard").addScalar("spwd").addScalar("sname")
				.addScalar("smob").addScalar("sex").addScalar("sage").addScalar("smaj").addScalar("sadmy")
				.addScalar("stime").addScalar("spro").addScalar("sadd").addScalar("cname")
				.setParameter(0, "%" + keywords.trim() + "%").setParameter(1, "%" + keywords.trim() + "%")
				.setResultTransformer(Transformers.aliasToBean(StudentClassroomDto.class)).list();
		return list;
	}

	@Override
	public Student getById(String id) {
		return this.getHibernateTemplate().get(Student.class, id);
	}

	@Override
	public void update(Student t) {
		this.getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	public Student checkLogin(String card, String password) {
		Student student = null;
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery("select * from HGNC_STUDENT where STU_CARD=? and STU_PASSWORD=?")
				.setParameter(0, card.trim()).setParameter(1, password.trim());
		q.addEntity(Student.class);

		List<Student> list = q.list();
		int n = list.size();
		System.out.println(list.size());
		if (n == 1) {
			student = list.iterator().next();
		} else {
			student = new Student(); // 传递一个含null属性的admin
		}
		session.close();

		return student;
	}
	
	public Student getByCard(String card) {
		Session session = this.getSessionFactory().openSession();
		SQLQuery q = (SQLQuery) session.createSQLQuery(
						"select * from HGNC_STUDENT where STU_CARD=?")
						.setParameter(0, card.trim());
		q.addEntity(Student.class);
		List<Student> list = q.list();
		int n = list.size();
        System.out.println(list.size());
        Student student = null;
        if(n==1){
        	student = list.iterator().next();
        }else{
        	student = new Student();
        }
        session.close();
		return student;
	}
}
