package org.hgnc.ssh.bean;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="HGNC_COURSE")
public class Course {
	private String cre_id;			//课程id
	private String cre_name;	//课程名称
	private String cre_score;	//学分
	private String cre_nature;	//课程性质(选修课还是必修课？)
	private String cre_time;		//课程创建时间
	private Set<TeacherToCourse> tcc;		//教师表-课程表  多对多
	private Set<StudentToCourse> scc;		//学生表-课程表  多对多
	
	@Id
	public String getCre_id() {
		return cre_id;
	}
	public void setCre_id(String creId) {
		cre_id = creId;
	}
	public String getCre_name() {
		return cre_name;
	}
	public void setCre_name(String creName) {
		cre_name = creName;
	}
	public String getCre_score() {
		return cre_score;
	}
	public void setCre_score(String creScore) {
		cre_score = creScore;
	}
	public String getCre_nature() {
		return cre_nature;
	}
	public void setCre_nature(String creNature) {
		cre_nature = creNature;
	}
	public String getCre_time() {
		return cre_time;
	}
	public void setCre_time(String creTime) {
		cre_time = creTime;
	}
	
	@OneToMany(mappedBy="course")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<TeacherToCourse> getTcc() {
		return tcc;
	}
	public void setTcc(Set<TeacherToCourse> tcc) {
		this.tcc = tcc;
	}
	
	@OneToMany(mappedBy="course")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<StudentToCourse> getScc() {
		return scc;
	}
	public void setScc(Set<StudentToCourse> scc) {
		this.scc = scc;
	}
}
