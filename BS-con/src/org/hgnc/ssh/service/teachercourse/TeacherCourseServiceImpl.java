package org.hgnc.ssh.service.teachercourse;

import java.util.List;

import javax.annotation.Resource;

import org.hgnc.ssh.bean.TeacherToCourse;
import org.hgnc.ssh.dao.teachercourse.TeacherCourseDaoInte;
import org.springframework.stereotype.Service;

@Service("teacherCourseService")
public class TeacherCourseServiceImpl implements TeacherCourseServiceInte{
	private TeacherCourseDaoInte teacherCourseDao;
	
	public TeacherCourseDaoInte getTeacherCourseDao() {
		return teacherCourseDao;
	}
	@Resource
	public void setTeacherCourseDao(TeacherCourseDaoInte teacherCourseDao) {
		this.teacherCourseDao = teacherCourseDao;
	}

	public void add(TeacherToCourse t) {
		this.teacherCourseDao.add(t);
	}

	public void delete(String id) {
		TeacherToCourse t = this.getById(id);
		if(t !=null && t.getTc_id().length()!=0){
			this.teacherCourseDao.delete(id);
		}
	}

	public List<TeacherToCourse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public TeacherToCourse getById(String id) {
		return this.teacherCourseDao.getById(id);
	}

	public void update(TeacherToCourse t) {
		this.teacherCourseDao.update(t);
	}
	
	public String getTidByCid(String cid) {
		return this.teacherCourseDao.getTidByCid(cid);
	}
	public void deleteByCid(String cid) {
		this.teacherCourseDao.deleteByCid(cid);
	}

}
