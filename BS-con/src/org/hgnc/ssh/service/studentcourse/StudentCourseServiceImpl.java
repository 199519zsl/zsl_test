package org.hgnc.ssh.service.studentcourse;

import java.util.List;

import javax.annotation.Resource;

import org.hgnc.ssh.bean.StudentToCourse;
import org.hgnc.ssh.dao.studentcourse.StudentCourseDaoInte;
import org.hgnc.ssh.dto.course.StudentCourseDto;
import org.springframework.stereotype.Service;

@Service("studentCourseService")
public class StudentCourseServiceImpl implements StudentCourseServiceInte{
	private StudentCourseDaoInte studentCourseDao;
	
	public StudentCourseDaoInte getStudentCourseDao() {
		return studentCourseDao;
	}
	@Resource
	public void setStudentCourseDao(StudentCourseDaoInte studentCourseDao) {
		this.studentCourseDao = studentCourseDao;
	}

	public void add(StudentToCourse t) {
		this.studentCourseDao.add(t);
	}

	public void delete(String id) {
		StudentToCourse s = this.getById(id);
		if(s!=null && s.getSc_id().length()!=0){
			this.studentCourseDao.delete(id);
		}
	}

	public List<StudentToCourse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentToCourse getById(String id) {
		return this.studentCourseDao.getById(id);
	}

	public void update(StudentToCourse t) {
		this.studentCourseDao.update(t);
	}
	
	public List<StudentCourseDto> getCourseByStudentId(String id) {
		return this.studentCourseDao.getCourseByStudentId(id);
	}
	
	public void deleteByCid(String cid) {
		 this.studentCourseDao.deleteByCid(cid);
	}

}
