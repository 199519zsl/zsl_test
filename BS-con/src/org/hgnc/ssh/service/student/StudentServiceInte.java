package org.hgnc.ssh.service.student;

import java.util.List;

import org.hgnc.ssh.bean.Student;
import org.hgnc.ssh.dto.student.StudentClassroomDto;

public interface StudentServiceInte {
	public void add(Student t);
	public void delete(String id);
	public void update(Student t);
	public Student getById(String id);
	public List<Student> getAll();
	
	public Student getByCard(String card);
	public Student checkLogin(String card,String password);
	public List<Student> getAllByClrId(String id);		//按班级ID查询，这个班的所有学生
	public List<StudentClassroomDto> getDtoAll();
	public List<StudentClassroomDto> getByKeywordsAll(String keywords);
}
