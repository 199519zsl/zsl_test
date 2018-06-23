package org.hgnc.ssh.bean;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="HGNC_TEACHER")
public class Teacher {
	private String tea_id;				//教师id
	private String tea_account;	//教师账号
	private String tea_password;	//教师密码
	private String tea_name;		//姓名
	private String tea_mobile;		//手机号
	private String tea_sex;			//性别
	private String tea_age;			//年龄
	private String tea_academy;	//所属学院
	private String tea_province;	//省份
	private String tea_address;	//家庭住址
	private String tea_time;			//入职时间
	private Set<TeacherToCourse> tct;	//教师表-课程表  多对多
	
	@Id
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String teaId) {
		tea_id = teaId;
	}
	public String getTea_account() {
		return tea_account;
	}
	public void setTea_account(String teaAccount) {
		tea_account = teaAccount;
	}
	public String getTea_password() {
		return tea_password;
	}
	public void setTea_password(String teaPassword) {
		tea_password = teaPassword;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String teaName) {
		tea_name = teaName;
	}
	public String getTea_mobile() {
		return tea_mobile;
	}
	public void setTea_mobile(String teaMobile) {
		tea_mobile = teaMobile;
	}
	public String getTea_sex() {
		return tea_sex;
	}
	public void setTea_sex(String teaSex) {
		tea_sex = teaSex;
	}
	public String getTea_age() {
		return tea_age;
	}
	public void setTea_age(String teaAge) {
		tea_age = teaAge;
	}
	public String getTea_academy() {
		return tea_academy;
	}
	public void setTea_academy(String teaAcademy) {
		tea_academy = teaAcademy;
	}
	public String getTea_province() {
		return tea_province;
	}
	public void setTea_province(String teaProvince) {
		tea_province = teaProvince;
	}
	public String getTea_address() {
		return tea_address;
	}
	public void setTea_address(String teaAddress) {
		tea_address = teaAddress;
	}
	public String getTea_time() {
		return tea_time;
	}
	public void setTea_time(String teaTime) {
		tea_time = teaTime;
	}
	
	@OneToMany(mappedBy="teacher")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<TeacherToCourse> getTct() {
		return tct;
	}
	public void setTct(Set<TeacherToCourse> tct) {
		this.tct = tct;
	}
}
