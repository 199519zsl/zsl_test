package org.hgnc.ssh.service.teacher;

import java.util.List;

import org.hgnc.ssh.bean.Teacher;

public interface TeacherServiceInte {
	public void add(Teacher t);
	public void delete(String id);
	public void update(Teacher t);
	public Teacher getById(String id);
	public List<Teacher> getAll();
}
