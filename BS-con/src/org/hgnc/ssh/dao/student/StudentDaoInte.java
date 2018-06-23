package org.hgnc.ssh.dao.student;

import java.util.List;

import org.hgnc.ssh.bean.Student;
import org.hgnc.ssh.dao.FirstDaoInte;
import org.hgnc.ssh.dto.student.StudentClassroomDto;

public interface StudentDaoInte extends FirstDaoInte<Student>{
	public List<Student> getAllByClrId(String id);
	public List<StudentClassroomDto> getDtoAll();
	public List<StudentClassroomDto> getByKeywordsAll(String keywords);
	public Student checkLogin(String card,String password);
	public Student getByCard(String card);
}
