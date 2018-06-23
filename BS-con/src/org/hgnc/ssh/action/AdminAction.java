package org.hgnc.ssh.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hgnc.ssh.bean.Admin;
import org.hgnc.ssh.service.admin.AdminServiceInte;
import org.hgnc.ssh.util.MyTime;
import org.hgnc.ssh.util.MyUUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport{
	private AdminServiceInte adminService;
	private Admin admin;
	private String flag;
	
	public AdminServiceInte getAdminService() {
		return adminService;
	}
	@Resource
	public void setAdminService(AdminServiceInte adminService) {
		this.adminService = adminService;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	public void add(Admin t) {
		this.adminService.add(t);
	}

	public void delete(String id) {
		this.adminService.delete(id);
	}

	public List<Admin> getAll() {
		return this.adminService.getAll();
	}

	public Admin getById(String id) {
		return this.adminService.getById(id);
	}
	
	public Admin getByAccount(String account) {
		return this.adminService.getByAccount(account);
	}

	public void update(Admin t) {
		this.adminService.update(t);
	}
	
	public Admin checkLogin(String account, String password) {
		return this.adminService.checkLogin(account, password);
	}
	
	
	//各种跳转
	
	//跳转到login界面
	public String login(){
		System.out.println("login界面");
		return "success";
	}
	
	//跳转到adminExit界面
	public String adminExit(){
		System.out.println("adminExit界面");
		ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}
	
	//跳转到checkLogin界面
	public String checkLogin(){
		String myReturn = null;
		if(flag!=null&&"check".equals(flag)){
			try {
				if(admin!=null){
					Admin a = this.checkLogin(this.admin.getAdm_account(), this.admin.getAdm_password());
					if( a.getAdm_id() != null ){
						System.out.println("登录匹配成功");
						//获取上次登录的时间
						ServletActionContext.getRequest().getSession().setAttribute("loginTime", a.getAdm_logintime());
						//设置本次登录时间
						a.setAdm_logintime(MyTime.SimpleTimeTwo(new Date()));
						this.update(a);
						ServletActionContext.getRequest().getSession().setAttribute("loginAdmin", a);
					}else{
						HttpServletResponse response = ServletActionContext.getResponse();
						PrintWriter writer = response.getWriter();
						writer.print("A");
						writer.close();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}else{
			System.out.println("您无法操作!");
		}
		return myReturn;
	}
	
	//跳转到main界面
	public String main(){
		System.out.println("main界面");
		return "success";
	}
	//跳转到index界面
	public String index(){
		System.out.println("index界面");
		return "success";
	}
	//跳转到left界面
	public String left(){
		System.out.println("left界面");
		return "success";
	}
	//跳转到top界面
	public String top(){
		System.out.println("top界面");
		return "success";
	}
	
	//跳转到imgtable界面
	public String imgtable(){
		System.out.println("imgtable界面");
		List<Admin> list = this.getAll();
		ActionContext.getContext().put("adminList", list);
		ActionContext.getContext().put("itemsCount", list.size());
		return "success";
	}
	
	//跳转到accountSet界面
	public String accountSet(){
		System.out.println("accountSet界面");
		
		return "success";
	}
	
	//跳转到toAddAdmin添加管理员用户界面
	public String toAddAdmin(){
		System.out.println("toAddAdmin界面");
		
		return "success";
	}
	
	//添加管理员用户
	public String addAdmin(){
		System.out.println("addAdmin界面");
		String tips = null;
		this.admin.setAdm_id(MyUUID.getUUID());
		this.admin.setAdm_logintime(MyTime.SimpleTimeTwo(new Date()));
		this.admin.setAdm_time(MyTime.SimpleTimeTwo(new Date()));
		if(this.admin.getAdm_account().length()!=0 
				&& this.admin.getAdm_password().length()!=0
				&& this.admin.getAdm_name().length()!=0){
			this.add(this.admin);
			tips = "管理员添加成功!";
		}else{
			tips = "添加失败，请重新添加~";
		}
		ServletActionContext.getRequest().getSession().setAttribute("indexTip", tips);
		return "success";
	}
	
	//跳转到修改密码页面
	public String toUpdatepwd(){
		System.out.println("toUpdatepwd界面");
		
		return "success";
	}
	
	//修改管理员个人密码页面
	public String updatepwd(){
		System.out.println("updatepwd界面");
		Admin a = (Admin) ServletActionContext.getRequest().getSession().getAttribute("loginAdmin");
		a.setAdm_password(this.admin.getAdm_password());
		String tips = "";
		if(this.admin != null && this.admin.getAdm_password().length() !=0){
			this.update(a);
			tips = "修改密码成功！";
		}else{
			tips = "修改密码失败，请重新填写！";
		}
		ServletActionContext.getRequest().getSession().setAttribute("indexTip", tips);
		return "success";
	}
	
	//跳转到修改指定账号密码页面
	public String toUpdateAdminpwd(){
		System.out.println("toUpdateAdminpwd界面");	
		return "success";
	}
	
	//跳转到修改指定账号密码页面
	public String updateAdminpwd(){
		String tips = null;
		System.out.println("updateAdminpwd界面");
		System.out.println(this.admin.getAdm_account().length());
		System.out.println(this.admin.getAdm_password().length());
		Admin a = this.getByAccount(this.admin.getAdm_account());
		if(this.admin.getAdm_account().length() !=0
				&& this.admin.getAdm_password().length() !=0
				&& a.getAdm_account() !=null){
			System.out.println("新密码:"+this.admin.getAdm_password());
			a.setAdm_password(this.admin.getAdm_password());
			this.update(a);
			tips = "修改成功~";
		}else{
			System.out.println("账号不存在");
			tips = "警告：修改失败,账号不存在~";
		}
		ServletActionContext.getRequest().getSession().setAttribute("indexTip", tips);
		return "success";
	}
	
	//删除管理员
	public String deleteAdmin(){
		System.out.println("deleteAdmin界面");
		String aid = ServletActionContext.getRequest().getParameter("aid");
		this.delete(aid);
		
		return "success";
	}
	
	//编辑管理员信息
	public String editeAdmin(){
		System.out.println("editeAdmin界面");
		String aid = ServletActionContext.getRequest().getParameter("aid");
		ActionContext.getContext().put("editeAdmin", this.getById(aid));
		
		return "success";
	}
	
	//提交管理员修改的信息
	public String updateAdmin(){
		System.out.println("updateAdmin界面");
		this.update(this.admin);
		
		return "success";
	}
	
}
