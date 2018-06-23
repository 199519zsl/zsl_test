package org.hgnc.ssh.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HGNC_CLASSROOM")
public class Classroom {
	private String clr_id;			//班级id
	private String clr_name;	//班级名称
	private String clr_count;	//班级人数
	private String clr_teacher;	//班主任
	private String clr_monitor;	//班长
	private String clr_time;		//班级创建时间
	
	@Id
	public String getClr_id() {
		return clr_id;
	}
	public void setClr_id(String clrId) {
		clr_id = clrId;
	}
	public String getClr_name() {
		return clr_name;
	}
	public void setClr_name(String clrName) {
		clr_name = clrName;
	}
	public String getClr_count() {
		return clr_count;
	}
	public void setClr_count(String clrCount) {
		clr_count = clrCount;
	}
	public String getClr_teacher() {
		return clr_teacher;
	}
	public void setClr_teacher(String clrTeacher) {
		clr_teacher = clrTeacher;
	}
	public String getClr_monitor() {
		return clr_monitor;
	}
	public void setClr_monitor(String clrMonitor) {
		clr_monitor = clrMonitor;
	}
	public String getClr_time() {
		return clr_time;
	}
	public void setClr_time(String clrTime) {
		clr_time = clrTime;
	}
	
}
