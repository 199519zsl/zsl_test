package org.hgnc.ssh.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hgnc.ssh.bean.Classroom;
import org.hgnc.ssh.bean.Student;
import org.hgnc.ssh.service.classroom.ClassroomServiceInte;
import org.hgnc.ssh.util.MyTime;
import org.hgnc.ssh.util.MyUUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("classroomAction")
@Scope("prototype")
public class ClassroomAction extends ActionSupport {
	private ClassroomServiceInte classroomService;
	private Classroom classroom;

	public ClassroomServiceInte getClassroomService() {
		return classroomService;
	}

	@Resource
	public void setClassroomService(ClassroomServiceInte classroomService) {
		this.classroomService = classroomService;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public void add(Classroom t) {
		this.classroomService.add(t);
	}

	public void delete(String id) {
		this.classroomService.delete(id);
	}

	public List<Classroom> getAll() {
		return this.classroomService.getAll();
	}

	public Classroom getById(String id) {
		return this.classroomService.getById(id);
	}

	public void update(Classroom t) {
		this.classroomService.update(t);
	}

	// 各种跳转

	// 跳转到添加班级
	public String toAddClassroom() {
		System.out.println("跳转到toAddClassroom");

		return "success";
	}

	// 添加班级
	public String addClassroom() {
		System.out.println("跳转到addClassroom");
		String tips = null;
		if (this.classroom != null && this.classroom.getClr_name().length() != 0
				&& this.classroom.getClr_count().length() != 0 && this.classroom.getClr_teacher().length() != 0
				&& this.classroom.getClr_monitor().length() != 0) {
			System.out.println(this.classroom.getClr_monitor());
			this.classroom.setClr_id(MyUUID.getUUID());
			this.classroom.setClr_time(MyTime.SimpleTimeTwo(new Date()));
			this.add(this.classroom);
			tips = "班级添加成功~";
		} else {
			tips = "班级添加失败~请按要求填写~";
			System.out.println("添加失败");
		}
		ServletActionContext.getRequest().getSession().setAttribute("indexTip", tips);

		return "success";
	}

	// 跳转到班级列表
	public String classroomList() {
		System.out.println("跳转到classroomList");
		List<Classroom> list = this.getAll();
		ActionContext.getContext().put("classroomList", list);
		ActionContext.getContext().put("itemsCount", list.size());

		return "success";
	}

	// 跳转到修改班级信息页面
	public String editeClassroom() {
		System.out.println("跳转到editeClassroom");
		String cid = ServletActionContext.getRequest().getParameter("cid");
		ActionContext.getContext().put("editeClassroom", this.getById(cid));

		return "success";
	}

	// 修改班级信息
	public String updateClassroom() {
		System.out.println("跳转到updateClassroom");
		this.update(this.classroom);
		return "success";
	}

	// 删除班级
	public String deleteClassroom() {
		System.out.println("跳转到deleteClassroom");
		String cid = ServletActionContext.getRequest().getParameter("cid");
		this.delete(cid);
		return "success";
	}

}
