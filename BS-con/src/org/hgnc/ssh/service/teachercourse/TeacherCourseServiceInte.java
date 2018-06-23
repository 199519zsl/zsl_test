package org.hgnc.ssh.service.teachercourse;

import java.util.List;

import org.hgnc.ssh.bean.TeacherToCourse;


public interface TeacherCourseServiceInte {
	public void add(TeacherToCourse t);
	public void delete(String id);
	public void update(TeacherToCourse t);
	public TeacherToCourse getById(String id);
	public List<TeacherToCourse> getAll();
	
	public String getTidByCid(String cid);	//通过课程ID查询教师ID-用于课程编辑
	
	/*通过课程ID删除中间记录
	 * 删除课程时，同时删除中间表中的记录
	*/
	public void deleteByCid(String cid);		
}
