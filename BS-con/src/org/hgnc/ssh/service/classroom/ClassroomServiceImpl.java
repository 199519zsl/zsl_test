package org.hgnc.ssh.service.classroom;

import java.util.List;

import javax.annotation.Resource;

import org.hgnc.ssh.bean.Classroom;
import org.hgnc.ssh.dao.classroom.ClassroomDaoInte;
import org.springframework.stereotype.Service;

@Service("classroomService")
public class ClassroomServiceImpl implements ClassroomServiceInte {
	private ClassroomDaoInte classroomDao;
	
	public ClassroomDaoInte getClassroomDao() {
		return classroomDao;
	}
	@Resource
	public void setClassroomDao(ClassroomDaoInte classroomDao) {
		this.classroomDao = classroomDao;
	}

	public void add(Classroom t) {
		this.classroomDao.add(t);
	}

	public void delete(String id) {
		Classroom c = this.getById(id);
		if(c!=null && c.getClr_name().length()!=0){
			this.classroomDao.delete(id);
		}
		
	}

	public List<Classroom> getAll() {
		return this.classroomDao.getAll();
	}

	public Classroom getById(String id) {
		return this.classroomDao.getById(id);
	}

	public void update(Classroom t) {
		this.classroomDao.update(t);
	}

}
