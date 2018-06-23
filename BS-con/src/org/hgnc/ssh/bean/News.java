package org.hgnc.ssh.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HGNC_NEWS")
public class News {
	private String news_id;			//校园id
	private String news_title;		//标题
	private String news_content;	//内容
	private String news_time;		//发布时间
	
	@Id
	public String getNews_id() {
		return news_id;
	}
	public void setNews_id(String newsId) {
		news_id = newsId;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String newsTitle) {
		news_title = newsTitle;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String newsContent) {
		news_content = newsContent;
	}
	public String getNews_time() {
		return news_time;
	}
	public void setNews_time(String newsTime) {
		news_time = newsTime;
	}
}
