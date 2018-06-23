package org.hgnc.ssh.bean;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="HGNC_STUDENT")
public class Student {
	private String stu_id;				//学生id
	private String stu_card;			//校园账号
	private String stu_password;	//校园密码
	private String stu_name;		//姓名
	private String stu_mobile;		//学生手机号
	private String stu_sex;			//性别
	private String stu_age;			//年龄
	private String stu_major;		//专业
	private String stu_academy;	//学院
	private String stu_time;			//入学时间
	private String stu_province;	//省份
	private String stu_address;	//家庭地址
	private Set<StudentToCourse> scs;		//学生表-课程表  多对多
	private Classroom classroom;				//学生表-班级表  多对一
	
	@Id
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stuId) {
		stu_id = stuId;
	}
	public String getStu_card() {
		return stu_card;
	}
	public void setStu_card(String stuCard) {
		stu_card = stuCard;
	}
	public String getStu_password() {
		return stu_password;
	}
	public void setStu_password(String stuPassword) {
		stu_password = stuPassword;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stuName) {
		stu_name = stuName;
	}
	public String getStu_mobile() {
		return stu_mobile;
	}
	public void setStu_mobile(String stuMobile) {
		stu_mobile = stuMobile;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stuSex) {
		stu_sex = stuSex;
	}
	public String getStu_age() {
		return stu_age;
	}
	public void setStu_age(String stuAge) {
		stu_age = stuAge;
	}
	public String getStu_major() {
		return stu_major;
	}
	public void setStu_major(String stuMajor) {
		stu_major = stuMajor;
	}
	public String getStu_academy() {
		return stu_academy;
	}
	public void setStu_academy(String stuAcademy) {
		stu_academy = stuAcademy;
	}
	public String getStu_time() {
		return stu_time;
	}
	public void setStu_time(String stuTime) {
		stu_time = stuTime;
	}
	public String getStu_province() {
		return stu_province;
	}
	public void setStu_province(String stuProvince) {
		stu_province = stuProvince;
	}
	public String getStu_address() {
		return stu_address;
	}
	public void setStu_address(String stuAddress) {
		stu_address = stuAddress;
	}
	
	@OneToMany(mappedBy="student")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<StudentToCourse> getScs() {
		return scs;
	}
	public void setScs(Set<StudentToCourse> scs) {
		this.scs = scs;
	}
	
	@ManyToOne
	@LazyCollection(LazyCollectionOption.EXTRA)
	@JoinColumn(name="CLR_ID")
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
}
