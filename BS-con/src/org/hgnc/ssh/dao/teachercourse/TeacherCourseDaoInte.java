package org.hgnc.ssh.dao.teachercourse;

import org.hgnc.ssh.bean.TeacherToCourse;
import org.hgnc.ssh.dao.FirstDaoInte;

public interface TeacherCourseDaoInte extends FirstDaoInte<TeacherToCourse>{
	public String getTidByCid(String cid);	//通过课程ID查询教师ID-用于课程编辑
	
	/*通过课程ID删除中间记录
	 * 删除课程时，同时删除中间表中的记录
	*/
	public void deleteByCid(String cid);		
}
