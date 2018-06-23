package org.hgnc.ssh.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HGNC_ADMIN")
public class Admin {
	private String adm_id; // 管理员id
	private String adm_account; // 管理员账号
	private String adm_password; // 密码
	private String adm_name; // 姓名
	private String adm_mobile; // 手机号
	private String adm_sex; // 性别
	private String adm_age; // 年龄
	private String adm_time; // 注册时间
	private String adm_logintime; // 上次登录时间

	@Id
	public String getAdm_id() {
		return adm_id;
	}

	public void setAdm_id(String admId) {
		adm_id = admId;
	}

	public String getAdm_account() {
		return adm_account;
	}

	public void setAdm_account(String admAccount) {
		adm_account = admAccount;
	}

	public String getAdm_password() {
		return adm_password;
	}

	public void setAdm_password(String admPassword) {
		adm_password = admPassword;
	}

	public String getAdm_name() {
		return adm_name;
	}

	public void setAdm_name(String admName) {
		adm_name = admName;
	}

	public String getAdm_mobile() {
		return adm_mobile;
	}

	public void setAdm_mobile(String admMobile) {
		adm_mobile = admMobile;
	}

	public String getAdm_sex() {
		return adm_sex;
	}

	public void setAdm_sex(String admSex) {
		adm_sex = admSex;
	}

	public String getAdm_age() {
		return adm_age;
	}

	public void setAdm_age(String admAge) {
		adm_age = admAge;
	}

	public String getAdm_time() {
		return adm_time;
	}

	public void setAdm_time(String admTime) {
		adm_time = admTime;
	}

	public String getAdm_logintime() {
		return adm_logintime;
	}

	public void setAdm_logintime(String admLogintime) {
		adm_logintime = admLogintime;
	}

}
