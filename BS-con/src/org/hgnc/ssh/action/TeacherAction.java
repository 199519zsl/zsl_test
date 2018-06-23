package org.hgnc.ssh.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hgnc.ssh.bean.Admin;
import org.hgnc.ssh.bean.Teacher;
import org.hgnc.ssh.service.teacher.TeacherServiceInte;
import org.hgnc.ssh.util.MyTime;
import org.hgnc.ssh.util.MyUUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TeacherAction extends ActionSupport{
	private TeacherServiceInte teacherService;
	private Teacher teacher;
	
	public TeacherServiceInte getTeacherService() {
		return teacherService;
	}
	@Resource
	public void setTeacherService(TeacherServiceInte teacherService) {
		this.teacherService = teacherService;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void add(Teacher t) {
		this.teacherService.add(t);
	}

	public void delete(String id) {
		this.teacherService.delete(id);
	}

	public List<Teacher> getAll() {
		return this.teacherService.getAll();
	}

	public Teacher getById(String id) {
		return this.teacherService.getById(id);
	}

	public void update(Teacher t) {
		this.teacherService.update(t);
	}
	
	
	//各种跳转
	
	//跳转到添加教师页面
	public String toAddTeacher(){
		System.out.println("跳转到toAddTeacher页面");
		
		return "success";
	}
	//添加教师
	public String addTeacher(){
		System.out.println("跳转到addTeacher页面");
		String tips = null;
		if(this.teacher != null && this.teacher.getTea_account().length() !=0
				&& this.teacher.getTea_name().length() != 0
				&& this.teacher.getTea_password().length() != 0){
			tips = "教师添加成功!";
			this.teacher.setTea_id(MyUUID.getUUID());
			this.teacher.setTea_time(MyTime.SimpleTimeTwo(new Date()));
			this.add(this.teacher);
		}else{
			tips = "添加失败，请按照要求重新填写~";
		}
		ServletActionContext.getRequest().getSession().setAttribute("indexTip", tips);
		return "success";
	}
	
	//跳转到教师列表
	public String teacherList(){
		System.out.println("跳转到teacherList页面");
		List<Teacher> list = this.getAll();
		ActionContext.getContext().put("teacherList", list);
		ActionContext.getContext().put("itemsCount", list.size());
		return "success";
	}
	
	//跳转到编辑教师信息
	public String editeTeacher(){
		System.out.println("跳转到editeTeacher页面");
		String tid = ServletActionContext.getRequest().getParameter("tid");
		ActionContext.getContext().put("editeTeacher", this.getById(tid));
		
		return "success";
	}
	
	//修改教师信息
	public String updateTeacher(){
		System.out.println("跳转到updateTeacher页面");
		if( ! "-1".equals(this.teacher.getTea_academy()) ){
			this.update(this.teacher);
		}
		
		return "success";
	}
	
	//删除教师
	public String deleteTeacher(){
		System.out.println("跳转到deleteTeacher页面");
		String tid = ServletActionContext.getRequest().getParameter("tid");
		this.delete(tid);
		
		return "success";
	}
}
