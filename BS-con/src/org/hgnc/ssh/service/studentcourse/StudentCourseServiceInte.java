package org.hgnc.ssh.service.studentcourse;

import java.util.List;

import org.hgnc.ssh.bean.StudentToCourse;
import org.hgnc.ssh.dto.course.StudentCourseDto;

public interface StudentCourseServiceInte {
	public void add(StudentToCourse t);
	public void delete(String id);
	public void update(StudentToCourse t);
	public StudentToCourse getById(String id);
	public List<StudentToCourse> getAll();
	
	public List<StudentCourseDto> getCourseByStudentId(String id);//获取此学生所有学习课程
	public void deleteByCid(String cid);	//删除课程时，学生-课程 中间表记录也要删除
}
