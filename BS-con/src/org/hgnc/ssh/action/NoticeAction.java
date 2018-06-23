package org.hgnc.ssh.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hgnc.ssh.bean.Notice;
import org.hgnc.ssh.service.notice.NoticeServiceInte;
import org.hgnc.ssh.util.MyTime;
import org.hgnc.ssh.util.MyUUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("noticeAction")
@Scope("prototype")
public class NoticeAction extends ActionSupport{
	private NoticeServiceInte noticeService;
	private Notice notice;
	
	public NoticeServiceInte getNoticeService() {
		return noticeService;
	}
	@Resource
	public void setNoticeService(NoticeServiceInte noticeService) {
		this.noticeService = noticeService;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	public void add(Notice t) {
		this.noticeService.add(t);
	}

	public void delete(String id) {
		this.noticeService.delete(id);
	}

	public List<Notice> getAll() {
		return this.noticeService.getAll();
	}

	public Notice getById(String id) {
		return this.noticeService.getById(id);
	}

	public void update(Notice t) {
		this.noticeService.update(t);
	}
	
	

	//各种跳转
	
	//跳转到form界面
	public String form(){
		System.out.println("form界面跳转");
		return "success";
	}
	//添加通知
	public String addNotice(){
		System.out.println("addNotice跳转");
		if(this.notice != null && this.notice.getNtc_title().length() != 0){
			this.notice.setNtc_id(MyUUID.getUUID());
			this.notice.setNtc_time(MyTime.SimpleTimeTwo(new Date()));
			this.add(this.notice);
		}
		return "success";
	}
	
	//所有通知
	public String allNotices(){
		System.out.println("allNotices跳转");
		List<Notice> list = this.getAll();
		ActionContext.getContext().put("allNotices",list);
		ActionContext.getContext().put("itemsCount",list.size());
		return "success";
	}
	
	//查看通知详细
	public String notice(){
		System.out.println("notice详细-跳转");
		String nid = ServletActionContext.getRequest().getParameter("nid");
		System.out.println(nid);
		ActionContext.getContext().put("noticeInfo", this.getById(nid));
		return "success";
	}
	
	//删除通知
	public String deleteNotice(){
		System.out.println("deleteNotice-跳转");
		String nid = ServletActionContext.getRequest().getParameter("nid");
		System.out.println("删除的为"+nid);
		this.delete(nid);
		return "success";
	}
	
}
