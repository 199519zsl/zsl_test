package org.hgnc.ssh.service.teacher;

import java.util.List;

import javax.annotation.Resource;

import org.hgnc.ssh.bean.Teacher;
import org.hgnc.ssh.dao.teacher.TeacherDaoInte;
import org.springframework.stereotype.Service;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherServiceInte {
	private TeacherDaoInte teacherDao;
	
	public TeacherDaoInte getTeacherDao() {
		return teacherDao;
	}
	@Resource
	public void setTeacherDao(TeacherDaoInte teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void add(Teacher t) {
		this.teacherDao.add(t);
	}

	public void delete(String id) {
		Teacher teacher = this.getById(id);
		if(teacher != null && teacher.getTea_account().length() !=0){
			this.teacherDao.delete(id);
		}
	}

	public List<Teacher> getAll() {
		return this.teacherDao.getAll();
	}

	public Teacher getById(String id) {
		return this.teacherDao.getById(id);
	}

	public void update(Teacher t) {
		this.teacherDao.update(t);
	}

}
