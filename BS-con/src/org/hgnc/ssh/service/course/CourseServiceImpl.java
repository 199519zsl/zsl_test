package org.hgnc.ssh.service.course;

import java.util.List;

import javax.annotation.Resource;

import org.hgnc.ssh.bean.Course;
import org.hgnc.ssh.dao.course.CourseDaoInte;
import org.hgnc.ssh.dto.course.TeacherCourseDto;
import org.springframework.stereotype.Service;

@Service("courseService")
public class CourseServiceImpl implements CourseServiceInte {
	private CourseDaoInte courseDao;
	
	public CourseDaoInte getCourseDao() {
		return courseDao;
	}
	@Resource
	public void setCourseDao(CourseDaoInte courseDao) {
		this.courseDao = courseDao;
	}

	public void add(Course t) {
		this.courseDao.add(t);
	}

	public void delete(String id) {
		Course c = this.getById(id);
		if(c!=null && c.getCre_id().length()!=0){
			this.courseDao.delete(id);
		}
		
	}

	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Course getById(String id) {
		return this.courseDao.getById(id);
	}

	public void update(Course t) {
		this.courseDao.update(t);
	}
	public List<TeacherCourseDto> queryAllTeacherCourse() {
		return this.courseDao.queryAllTeacherCourse();
	}

}
