<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>无标题文档</title>
		<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="<%=basePath%>js/jquery.js"></script>
		<script type="text/javascript">
			$(function() {
				//导航切换
				$(".menuson li").click(function() {
					$(".menuson li.active").removeClass("active")
					$(this).addClass("active");
				});
			
				$('.title').click(function() {
					var $ul = $(this).next('ul');
					$('dd').find('ul').slideUp();
					if ($ul.is(':visible')) {
						$(this).next('ul').slideUp();
					} else {
						$(this).next('ul').slideDown();
					}
				});
			})
		</script>

	</head>

	<body style="background: #f0f9fd;">
		<div class="lefttop">
			<span></span>数据操作
		</div>

		<dl class="leftmenu">
			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" />
					</span>用户管理
				</div>
				<ul class="menuson">
					<li class="active">
						<cite></cite><a href="admin_index" target="rightFrame">管理员界面</a><i></i>
					</li>
					<li>
						<cite></cite><a href="admin_toAddAdmin" target="rightFrame">添加管理员</a><i></i>
					</li>
					<li>
						<cite></cite><a href="admin_imgtable" target="rightFrame">查询所有管理员</a><i></i>
					</li>
					<li>
						<cite></cite><a href="admin_toUpdateAdminpwd" target="rightFrame">修改管理员密码</a><i></i>
					</li>
				</ul>
			</dd>

			<dd>
				<div class="title">
					<span><img src="images/leftico02.png" />
					</span>成绩管理
				</div>
				<ul class="menuson">
					<!-- <li>
						<cite></cite><a href="notice_form" target="rightFrame">发布通知</a><i></i>
					</li>
					<li>
						<cite></cite><a href="notice_allNotices" target="rightFrame">所有通知</a><i></i>
					</li> -->
					<li>
						<cite></cite><a href="course_toAddMark" target="rightFrame">成绩录入/查询</a><i></i>
					</li>
				</ul>
			</dd>

			<dd>
				<div class="title">
					<span><img src="images/leftico03.png" />
					</span>课程管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="course_toAddCourse" target="rightFrame">发布课程</a><i></i>
					</li>
					<li>
						<cite></cite><a href="course_allCourse" target="rightFrame">查询课程</a><i></i>
					</li>
					<li>
						<cite></cite><a href="teacher_toAddTeacher" target="rightFrame">添加教师</a><i></i>
					</li>
					<li>
						<cite></cite><a href="teacher_teacherList" target="rightFrame">查询所有教师</a><i></i>
					</li>
					<li>
						<cite></cite><a href="classroom_toAddClassroom" target="rightFrame">添加班级</a><i></i>
					</li>
					<li>
						<cite></cite><a href="classroom_classroomList" target="rightFrame">查询所有班级</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico04.png" />
					</span>学生学籍信息管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="student_toAddStudent" target="rightFrame">添加学生</a><i></i>
					</li>
					<li>
						<cite></cite><a href="student_studentList" target="rightFrame">查询学生信息</a><i></i>
					</li>
				</ul>
			</dd>
		</dl>
	</body>
</html>
