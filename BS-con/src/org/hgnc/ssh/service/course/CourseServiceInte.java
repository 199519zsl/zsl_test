package org.hgnc.ssh.service.course;

import java.util.List;

import org.hgnc.ssh.bean.Course;
import org.hgnc.ssh.dto.course.TeacherCourseDto;

public interface CourseServiceInte {
	public void add(Course t);
	public void delete(String id);
	public void update(Course t);
	public Course getById(String id);
	public List<Course> getAll();
	
	public List<TeacherCourseDto> queryAllTeacherCourse();
}
