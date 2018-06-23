<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>学生界面</title>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>学生信息</li>
			<li>学生界面</li>
		</ul>
	</div>

	<div class="mainindex">


		<div class="welinfo">
			<span><img src="images/sun.png" alt="天气" /></span> <b>亲爱的${loginStudent.stu_name}，你好，欢迎使用高校学生学籍管理系统</b>(www.hgnc.net)
			<a href="student_editeStudent?sid=${loginStudent.stu_id}" target="rightFrame">账号设置</a>
			&nbsp;&nbsp;&nbsp;&nbsp; <font color="#f00">${indexTip}</font>

		</div>

		<div class="welinfo">
			<span><img src="images/time.png" alt="时间" /></span> <i>您上次登录的时间：${loginTime}</i>
			（不是您登录的？<a href="admin_toUpdatepwd">请点这里</a>）
		</div>

		<div class="xline"></div>

		<ul class="iconlist">

			<li><img src="images/ico01.png" />
			<p>
					<a href="#">添加班级</a>
				</p></li>
			<li><img src="images/ico02.png" />
			<p>
					<a href="#">添加教师</a>
				</p></li>
			<li><img src="images/ico03.png" />
			<p>
					<a href="#">添加学生</a>
				</p></li>
			<li><img src="images/ico04.png" />
			<p>
					<a href="#">发布课程</a>
				</p></li>
			<li><img src="images/ico06.png" />
			<p>
					<a href="#">学生查询</a>
				</p></li>

		</ul>

		<div class="ibox">
			<a href="#" class="ibtn"><img
				src="images/iadd.png" />添加新的管理员</a>
		</div>

		<div class="xline"></div>
		<div class="box"></div>

		<div class="welinfo">
			<span><img src="images/dp.png" alt="提醒" /></span><b>黄冈师范学院-高校学生学籍管理系统使用指南</b>
		</div>

		<ul class="infolist">
			<li><span>您可以快速进行校园通知的查看</span><a href="notice_allNotices"
				class="ibtn">查看通知</a></li>
			<li><span>您可以快速发布校园通知</span><a href="notice_form" class="ibtn">发布通知</a></li>
			<li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn"
				href="#">账户管理</a></li>
		</ul>

		<div class="xline"></div>

	</div>

</body>
</html>
