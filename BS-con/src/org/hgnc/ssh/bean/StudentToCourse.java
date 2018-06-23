package org.hgnc.ssh.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HGNC_STUDENT_COURSE")
public class StudentToCourse {
	private String sc_id;		//学生-课程 中间表 id
	private String sc_pass;	//是否通过
	private String sc_mark;	//课程分数
	private String sc_time;	//创建时间
	
	private Student student;
	private Course course;
	
	@Id
	public String getSc_id() {
		return sc_id;
	}
	public void setSc_id(String scId) {
		sc_id = scId;
	}
	public String getSc_pass() {
		return sc_pass;
	}
	public void setSc_pass(String scPass) {
		sc_pass = scPass;
	}
	public String getSc_mark() {
		return sc_mark;
	}
	public void setSc_mark(String scMark) {
		sc_mark = scMark;
	}
	public String getSc_time() {
		return sc_time;
	}
	public void setSc_time(String scTime) {
		sc_time = scTime;
	}
	
	@ManyToOne
	@JoinColumn(name="SC_SID")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SC_CID")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
