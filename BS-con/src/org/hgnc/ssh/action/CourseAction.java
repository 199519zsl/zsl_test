package org.hgnc.ssh.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hgnc.ssh.bean.Course;
import org.hgnc.ssh.bean.Student;
import org.hgnc.ssh.bean.StudentToCourse;
import org.hgnc.ssh.bean.TeacherToCourse;
import org.hgnc.ssh.dto.course.StudentCourseDto;
import org.hgnc.ssh.dto.course.TeacherCourseDto;
import org.hgnc.ssh.dto.student.StudentClassroomDto;
import org.hgnc.ssh.service.classroom.ClassroomServiceInte;
import org.hgnc.ssh.service.course.CourseServiceInte;
import org.hgnc.ssh.service.student.StudentServiceInte;
import org.hgnc.ssh.service.studentcourse.StudentCourseServiceInte;
import org.hgnc.ssh.service.teacher.TeacherServiceInte;
import org.hgnc.ssh.service.teachercourse.TeacherCourseServiceInte;
import org.hgnc.ssh.util.MyTime;
import org.hgnc.ssh.util.MyUUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("courseAction")
@Scope("prototype")
public class CourseAction extends ActionSupport{
	private CourseServiceInte courseService;
	private TeacherServiceInte teacherService;
	private TeacherCourseServiceInte teacherCourseService;
	private StudentCourseServiceInte studentCourseService;
	private StudentServiceInte studentService;
	private ClassroomServiceInte classroomService;
	private Course course;
	
	public CourseServiceInte getCourseService() {
		return courseService;
	}
	@Resource
	public void setCourseService(CourseServiceInte courseService) {
		this.courseService = courseService;
	}
	
	public TeacherServiceInte getTeacherService() {
		return teacherService;
	}
	@Resource
	public void setTeacherService(TeacherServiceInte teacherService) {
		this.teacherService = teacherService;
	}
	
	public StudentCourseServiceInte getStudentCourseService() {
		return studentCourseService;
	}
	@Resource
	public void setStudentCourseService(StudentCourseServiceInte studentCourseService) {
		this.studentCourseService = studentCourseService;
	}
	public TeacherCourseServiceInte getTeacherCourseService() {
		return teacherCourseService;
	}
	@Resource
	public void setTeacherCourseService(
			TeacherCourseServiceInte teacherCourseService) {
		this.teacherCourseService = teacherCourseService;
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
	
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void add(Course t) {
		this.courseService.add(t);
	}

	public void delete(String id) {
		this.courseService.delete(id);
	}

	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Course getById(String id) {
		return this.courseService.getById(id);
	}

	public void update(Course t) {
		this.courseService.update(t);
	}
	
	public List<TeacherCourseDto> queryAllTeacherCourse() {
		return this.courseService.queryAllTeacherCourse();
	}
	
	//各种跳转
	
	//跳转到添加课程页面
	public String toAddCourse(){
		System.out.println("跳转到toAddCourse");
		ActionContext.getContext().put("allTeacher", this.teacherService.getAll());
		ActionContext.getContext().put("allClassroom", this.classroomService.getAll());
		return "success";
	}
	
	//添加课程
	public String addCourse(){
		System.out.println("跳转到addCourse");
		String tid = ServletActionContext.getRequest().getParameter("selTeacher");
		String tips = null;
		if(this.course!=null && this.course.getCre_name().length()!=0
				&& this.course.getCre_score().length()!=0
				&& ! "-1".equals(this.course.getCre_nature())
				&& ! "-1".equals(tid)){
			
			//1.先设置好课程详细信息
			this.course.setCre_id(MyUUID.getUUID());
			this.course.setCre_time(MyTime.SimpleTimeTwo(new Date()));
			
			//2.a添加到教师-课程中间表
			TeacherToCourse tc = new TeacherToCourse();
			tc.setTc_id(MyUUID.getUUID());
			tc.setTc_time(MyTime.SimpleTimeTwo(new Date()));
			tc.setCourse(this.course);
			tc.setTeacher(this.teacherService.getById(tid));
			
			//3.必须先添加课程，后添加到中间表记录
			this.add(this.course);
			this.teacherCourseService.add(tc);
			/*
			 	添加到学生-课程中间表
				先筛选出对应班级的所有学生，
				然后这个班的所有学生都添加此课程,即加入中间表记录
			*/
			String cid = ServletActionContext.getRequest().getParameter("clrom");
			List<Student> list = this.studentService.getAllByClrId(cid);
			for(Student s:list){
				StudentToCourse sc = new StudentToCourse();
				sc.setSc_id(MyUUID.getUUID());
				sc.setSc_time(MyTime.SimpleTimeTwo(new Date()));
				sc.setCourse(this.course);
				sc.setStudent(s);
				this.studentCourseService.add(sc);
			}
			tips ="课程添加成功~";
		}else{
			tips = "课程添加失败，请按要求填写~";
		}
		ServletActionContext.getRequest().getSession().setAttribute("indexTip", tips);
		return "success";
	}
	
	//跳转到成绩录入界面
	public String toAddMark(){
		System.out.println("跳转到toAddMark");
		
		return "success";
	}
	
	//关键字查询学生
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
	
	//跳转到成绩录入界面
	public String addMark(){
		System.out.println("跳转到addMark");
		String sid = ServletActionContext.getRequest().getParameter("sid");
		List<StudentCourseDto> list = this.studentCourseService.getCourseByStudentId(sid);
		ActionContext.getContext().put("scStu", this.studentService.getById(sid));
		ActionContext.getContext().put("scDto", list);
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
	
	//录入成绩
	public String updateMark(){
		System.out.println("跳转到updateMark");
		String[] scores = ServletActionContext.getRequest().getParameterValues("scores");
		String[] scids = ServletActionContext.getRequest().getParameterValues("scids");
		for(int i=0;i<scores.length;i++){
			//每次循环，先获取中间表的信息，然后再修改每一门该课程的分数
			StudentToCourse sc = this.studentCourseService.getById(scids[i]);
			sc.setSc_mark(scores[i]);
			this.studentCourseService.update(sc);
			ServletActionContext.getRequest().getSession().setAttribute("markTip", "录入成绩成功!");
		}
		return "success";
	}
	
	//查询所有课程
	public String allCourse(){
		System.out.println("查询所有课程");
		String flag = ServletActionContext.getRequest().getParameter("flag");
		//查询所有课程
		List<TeacherCourseDto> list = this.courseService.queryAllTeacherCourse();
		if(flag == null){		//若不是查询，则列出所有课程
			ActionContext.getContext().put("tcList", list);
			ActionContext.getContext().put("tcCount", list.size());
		}else if(flag.trim()!=null && "query".equals(flag)){	//若是关键字查询，则列出按关键字查询的列表
			List<TeacherCourseDto> queryList = new ArrayList<TeacherCourseDto>();
			String keywords =ServletActionContext.getRequest().getParameter("keywords"); 
			if( !keywords.trim().equals("")){
				for(TeacherCourseDto t:list){
					if(t.getCname().contains(keywords) || t.getTname().contains(keywords)){
						queryList.add(t);
					}
				}
				ActionContext.getContext().put("queryKey", keywords);
				ActionContext.getContext().put("tcList", queryList);
				ActionContext.getContext().put("tcCount", queryList.size());
			}else{
				ActionContext.getContext().put("tcCount", 0);
			}
			
		}
		
		return "success";
	}
	
	//编辑课程
	public String editeCourse(){
		System.out.println("editeCourse编辑课程");
		String cid = ServletActionContext.getRequest().getParameter("cid");
		ActionContext.getContext().put("editeCourse", this.courseService.getById(cid));
		ActionContext.getContext().put("editeTeacher", this.teacherService.getById(this.teacherCourseService.getTidByCid(cid)));
		
		return "success";
	}
	
	//提交修改课程内容
	public String updateCourse(){
		System.out.println("updateCourse编辑课程");
		this.update(this.course);
		return "success";
	}
	
	//删除课程
	public String deleteCourse(){
		System.out.println("deleteCourse编辑课程");
		String cid = ServletActionContext.getRequest().getParameter("cid");
		this.delete(cid);			//1.删除课程表中的课程
		this.teacherCourseService.deleteByCid(cid);		//2.删除教师-课程中间表记录
		this.studentCourseService.deleteByCid(cid);		//3.删除学生-课程中间表记录
		return "success";
	}
	
}
