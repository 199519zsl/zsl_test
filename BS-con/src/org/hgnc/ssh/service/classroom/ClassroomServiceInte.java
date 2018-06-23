package org.hgnc.ssh.service.classroom;

import java.util.List;

import org.hgnc.ssh.bean.Classroom;

public interface ClassroomServiceInte {
	public void add(Classroom t);
	public void delete(String id);
	public void update(Classroom t);
	public Classroom getById(String id);
	public List<Classroom> getAll();
}
