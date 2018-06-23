package org.hgnc.ssh.dto.course;

public class StudentCourseDto {
	private String sid;			//学生表
	private String scard;
	private String sname;
	private String sex;
	private String sadmy;		
	
	private String scid;			//学生-课程中间表
	private String sccid;
	private String scpass;
	private String scmark;	
	
	private String cname;	//课程表
	
	public StudentCourseDto() {}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getSccid() {
		return sccid;
	}
	public void setSccid(String sccid) {
		this.sccid = sccid;
	}

	public String getScid() {
		return scid;
	}
	public void setScid(String scid) {
		this.scid = scid;
	}

	public String getScard() {
		return scard;
	}
	public void setScard(String scard) {
		this.scard = scard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadmy() {
		return sadmy;
	}
	public void setSadmy(String sadmy) {
		this.sadmy = sadmy;
	}
	public String getScpass() {
		return scpass;
	}
	public void setScpass(String scpass) {
		this.scpass = scpass;
	}
	public String getScmark() {
		return scmark;
	}
	public void setScmark(String scmark) {
		this.scmark = scmark;
	}

	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
