package org.hgnc.ssh.service.student;

import java.util.List;

import javax.annotation.Resource;

import org.hgnc.ssh.bean.Student;
import org.hgnc.ssh.dao.student.StudentDaoInte;
import org.hgnc.ssh.dto.student.StudentClassroomDto;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentServiceInte {
	private StudentDaoInte studentDao;

	public StudentDaoInte getStudentDao() {
		return studentDao;
	}

	@Resource
	public void setStudentDao(StudentDaoInte studentDao) {
		this.studentDao = studentDao;
	}

	public void add(Student t) {
		this.studentDao.add(t);
	}

	public void delete(String id) {
		Student s = this.getById(id);
		if (s != null && s.getStu_card().length() != 0) {
			this.studentDao.delete(id);
		}
	}

	public List<Student> getAll() {
		return this.studentDao.getAll();
	}

	public Student getById(String id) {
		return this.studentDao.getById(id);
	}

	public void update(Student t) {
		this.studentDao.update(t);
	}

	public List<StudentClassroomDto> getDtoAll() {
		return this.studentDao.getDtoAll();
	}

	public List<StudentClassroomDto> getByKeywordsAll(String keywords) {
		return this.studentDao.getByKeywordsAll(keywords);
	}

	public List<Student> getAllByClrId(String id) {
		return this.studentDao.getAllByClrId(id);
	}

	@Override
	public Student checkLogin(String card, String password) {
		return this.studentDao.checkLogin(card, password);
	}

	@Override
	public Student getByCard(String card) {
		return this.studentDao.getByCard(card);
	}

}
