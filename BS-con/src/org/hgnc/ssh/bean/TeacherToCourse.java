package org.hgnc.ssh.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HGNC_TEACHER_COURSE")
public class TeacherToCourse {
	private String tc_id;		//教师-课程 中间表id
	private String tc_time;	//创建时间
	
	private Teacher teacher;
	private Course course;
	
	@Id
	public String getTc_id() {
		return tc_id;
	}
	public void setTc_id(String tcId) {
		tc_id = tcId;
	}
	public String getTc_time() {
		return tc_time;
	}
	public void setTc_time(String tcTime) {
		tc_time = tcTime;
	}
	
	@ManyToOne
	@JoinColumn(name="TC_TID")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TC_CID")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
