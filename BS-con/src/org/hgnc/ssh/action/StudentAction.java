package org.hgnc.ssh.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hgnc.ssh.bean.Admin;
import org.hgnc.ssh.bean.Classroom;
import org.hgnc.ssh.bean.Student;
import org.hgnc.ssh.dto.course.StudentCourseDto;
import org.hgnc.ssh.dto.student.StudentClassroomDto;
import org.hgnc.ssh.service.classroom.ClassroomServiceInte;
import org.hgnc.ssh.service.course.CourseServiceInte;
import org.hgnc.ssh.service.student.StudentServiceInte;
import org.hgnc.ssh.service.studentcourse.StudentCourseServiceInte;
import org.hgnc.ssh.util.MyTime;
import org.hgnc.ssh.util.MyUUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("studentAction")
@Scope("prototype")
public class StudentAction extends ActionSupport {
	private StudentServiceInte studentService;
	private ClassroomServiceInte classroomService;
	private CourseServiceInte courseService;
	private StudentCourseServiceInte studentCourseService;
	private Student student;
	private Classroom classroom;
	private String flag;

	
	public StudentCourseServiceInte getStudentCourseService() {
		return studentCourseService;
	}
	@Resource
	public void setStudentCourseService(StudentCourseServiceInte studentCourseService) {
		this.studentCourseService = studentCourseService;
	}
	
	public CourseServiceInte getCourseService() {
		return courseService;
	}
	@Resource
	public void setCourseService(CourseServiceInte courseService) {
		this.courseService = courseService;
	}

	public StudentServiceInte getStudentService() {
		return studentService;
	}

	@Resource
	public void setStudentService(StudentServiceInte studentService) {
		this.studentService = studentService;
	}

	public ClassroomServiceInte getClassroomService() {
		return classroomService;
	}

	@Resource
	public void setClassroomService(ClassroomServiceInte classroomService) {
		this.classroomService = classroomService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public void add(Student t) {
		this.studentService.add(t);
	}

	public void delete(String id) {
		this.studentService.delete(id);
	}

	public List<Student> getAll() {
		return this.studentService.getAll();
	}

	public List<StudentClassroomDto> getDtoAll() {
		return this.studentService.getDtoAll();
	}

	public List<StudentClassroomDto> getByKeywordsAll(String keywords) {
		return this.studentService.getByKeywordsAll(keywords);
	}

	public Student getById(String id) {
		return this.studentService.getById(id);
	}

	public void update(Student t) {
		this.studentService.update(t);
	}

	public Student checkLogin(String card, String password) {
		return this.studentService.checkLogin(card, password);
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public Student getByCard(String card){
		return this.studentService.getByCard(card);
	}

	// 各种跳转

	// 跳转到添加学生页面
	public String toAddStudent() {
		System.out.println("跳转到toAddStudent页面");
		ActionContext.getContext().put("allClassroom", this.classroomService.getAll());
		return "success";
	}

	// 添加学生
	public String addStudent() {
		System.out.println("addStudent信息页面");
		String tips = null;
		if (this.student != null && this.student.getStu_card().length() != 0
				&& this.student.getStu_password().length() != 0 && this.student.getStu_academy().length() != 0) {
			this.student.setStu_id(MyUUID.getUUID());
			this.student.setStu_time(MyTime.SimpleTimeTwo(new Date()));
			String cid = ServletActionContext.getRequest().getParameter("selClassroom");
			Classroom c = this.classroomService.getById(cid);
			this.student.setClassroom(c);
			this.add(this.student);
			tips = "学生添加成功";
		} else {
			tips = "添加失败~请按要求重新填写~";
		}
		ServletActionContext.getRequest().getSession().setAttribute("indexTip", tips);
		return "success";
	}

	// 跳转到学生列表页面
	public String studentList() {
		System.out.println("studentList信息页面");
		List<StudentClassroomDto> list = this.getDtoAll();
		ActionContext.getContext().put("studentList", list);
		ActionContext.getContext().put("itemsCount", list.size());
		return "success";
	}

	// 编辑学生信息
	public String editeStudent() {
		System.out.println("editeStudent跳转");
		String sid = ServletActionContext.getRequest().getParameter("sid");
		ActionContext.getContext().put("editeStudent", this.getById(sid));
		ActionContext.getContext().put("allClassroom", this.classroomService.getAll());
		return "success";
	}

	// 提交学生修改的信息
	public String updateStudent() {
		System.out.println("updateStudent界面");
		String cid = ServletActionContext.getRequest().getParameter("selClassroom");
		if (this.student != null && this.student.getStu_name().length() != 0
				&& this.student.getStu_password().length() != 0 && !"-1".equals(this.student.getStu_major())
				&& !"-1".equals(this.student.getStu_academy()) && !"-1".equals(cid)) {
			Classroom c = this.classroomService.getById(cid);
			this.student.setClassroom(c);
			this.update(this.student);
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("stuListTip", "修改学生信息失败~请按要求填写~");
		}

		return "success";
	}

	// 删除学生
	public String deleteStudent() {
		System.out.println("deleteStudent界面");
		String sid = ServletActionContext.getRequest().getParameter("sid");
		this.delete(sid);

		return "success";
	}

	public String main() {
		System.out.println("main界面");
		return "success";
	}

	// 跳转到studentExit界面
	public String studentExit() {
		System.out.println("studentExit界面");
		ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}

	// 跳转到index界面
	public String index() {
		System.out.println("index界面");
		return "success";
	}

	// 跳转到left界面
	public String left() {
		System.out.println("left界面");
		return "success";
	}

	// 跳转到top界面
	public String top() {
		System.out.println("top界面");
		return "success";
	}

	// 跳转到login界面
	public String login() {
		System.out.println("login界面");
		return "success";
	}

	// 跳转到checkLogin界面
	public String checkLogin() {
		String myReturn = null;
		if (flag != null && "check".equals(flag)) {
			try {
				if (student != null) {
					Student a = this.checkLogin(this.student.getStu_card(), this.student.getStu_password());
					if (a.getStu_id() != null) {
						System.out.println("登录匹配成功");
						ServletActionContext.getRequest().getSession().setAttribute("loginStudent", a);
					} else {
						HttpServletResponse response = ServletActionContext.getResponse();
						PrintWriter writer = response.getWriter();
						writer.print("A");
						writer.close();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("您无法操作!");
		}
		return myReturn;
	}

	// 跳转到修改指定账号密码页面
	public String toUpdateStudentpwd() {
		System.out.println("toUpdateStudentpwd界面");
		return "success";
	}
	
	//跳转到修改指定账号密码页面
		public String updateStudentpwd(){
			String tips = null;
			System.out.println("updateStudentpwd界面");
			System.out.println(this.student.getStu_card().length());
			System.out.println(this.student.getStu_password().length());
			Student a = this.getByCard(this.student.getStu_card());
			if(this.student.getStu_card().length() !=0
					&& this.student.getStu_password().length() !=0
					&& a.getStu_card() !=null){
				System.out.println("新密码:"+this.student.getStu_password());
				a.setStu_password(this.student.getStu_password());
				this.update(a);
				tips = "修改成功~";
			}else{
				System.out.println("账号不存在");
				tips = "警告：修改失败,账号不存在~";
			}
			ServletActionContext.getRequest().getSession().setAttribute("indexTip", tips);
			return "success";
		}
		
		public String toRetrieveMark(){
			System.out.println("查询成绩页面");
			return "success";
		}
		
		public String toQueryStudent(){
			System.out.println("跳转到toQueryStudent");
			String key = ServletActionContext.getRequest().getParameter("keywords");
			System.out.println(key+"====");
			if(key !=null && key.length()!=0){
				System.out.println("key非空");
				List<StudentClassroomDto> list = this.studentService.getByKeywordsAll(key);
				ActionContext.getContext().put("studentList", list);
				ActionContext.getContext().put("itemsCount", list.size());
				ActionContext.getContext().put("keywords", key);
			}
			
			return "success";
		}
		
		//查询成绩
		public String queryMark(){
			System.out.println("跳转到queryMark");
			String sid = ServletActionContext.getRequest().getParameter("sid");
			List<StudentCourseDto> list = this.studentCourseService.getCourseByStudentId(sid);
			ActionContext.getContext().put("scStu", this.studentService.getById(sid));
			ActionContext.getContext().put("scDto", list);
			return "success";
		}
		
}