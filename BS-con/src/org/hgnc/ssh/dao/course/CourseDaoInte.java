package org.hgnc.ssh.dao.course;

import java.util.List;

import org.hgnc.ssh.bean.Course;
import org.hgnc.ssh.dao.FirstDaoInte;
import org.hgnc.ssh.dto.course.TeacherCourseDto;

public interface CourseDaoInte extends FirstDaoInte<Course>{
	public List<TeacherCourseDto> queryAllTeacherCourse();
}
