package org.hgnc.ssh.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HGNC_NOTICE")
public class Notice {
	private String ntc_id;			//校园公告id
	private String ntc_title;		//标题
	private String ntc_content;//内容
	private String ntc_time;		//发布时间
	
	@Id
	public String getNtc_id() {
		return ntc_id;
	}
	public void setNtc_id(String ntcId) {
		ntc_id = ntcId;
	}
	public String getNtc_title() {
		return ntc_title;
	}
	public void setNtc_title(String ntcTitle) {
		ntc_title = ntcTitle;
	}
	public String getNtc_content() {
		return ntc_content;
	}
	public void setNtc_content(String ntcContent) {
		ntc_content = ntcContent;
	}
	public String getNtc_time() {
		return ntc_time;
	}
	public void setNtc_time(String ntcTime) {
		ntc_time = ntcTime;
	}
}
