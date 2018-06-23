package org.hgnc.ssh.dao.studentcourse;

import java.util.List;

import org.hgnc.ssh.bean.StudentToCourse;
import org.hgnc.ssh.dao.FirstDaoInte;
import org.hgnc.ssh.dto.course.StudentCourseDto;

public interface StudentCourseDaoInte extends FirstDaoInte<StudentToCourse>{
	public List<StudentCourseDto> getCourseByStudentId(String id);
	public void updateMark(String cid);
	
	public void deleteByCid(String cid);	//删除课程时，学生-课程 中间表记录也要删除
}
