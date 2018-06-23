package org.hgnc.ssh.dto.course;

public class TeacherCourseDto {
	private String tname;		//任课教师
	private String cid;			//课程ID
	private String cname;	//课程名称
	private String cscore;		//课程学分
	private String cnature;	//课程性质
	private String ctime;		//添加时间
	
	public TeacherCourseDto() {}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCscore() {
		return cscore;
	}
	public void setCscore(String cscore) {
		this.cscore = cscore;
	}
	public String getCnature() {
		return cnature;
	}
	public void setCnature(String cnature) {
		this.cnature = cnature;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
}
