<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>添加管理员</title>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check_acc() {
		var p1 = document.getElementById("acc").value;
		if (p1.length<5 || p1.length>10) {
			document.getElementById("accTip").innerHTML = "必须是5-10个字符哦~";
		} else {
			document.getElementById("accTip").innerHTML = "√";
		}
	}

	function check_pwd() {
		var p1 = document.getElementById("pwd1").value;
		var p2 = document.getElementById("pwd2").value;
		if (p1 != p2) {
			document.getElementById("pwdTip").innerHTML = "两次密码不一致,请重新输入~";
		} else {
			document.getElementById("pwdTip").innerHTML = "√";
		}
	}

	function check_mob() {
		var input = document.getElementById("mob").value;
		var tip = document.getElementById("mobTip");
		var match = /^[1][358][0-9]{9}$/;
		if (!match.test(input)) {
			tip.innerHTML = "手机号错误哦~亲";
		} else {
			tip.innerHTML = "√";
		}
	}
</script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>教学管理</li>
			<li>添加学生账号</li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>添加学生账号</span>
		</div>
		<form action="student_addStudent" method="post">
			<ul class="forminfo">
				<li><label><font color="#f00">*</font>账&nbsp;&nbsp;&nbsp;号</label><input
					name="student.stu_card" onblur="check_acc()" id="acc" type="text"
					maxlength="10" class="dfinput" /><i id="accTip"
					style="color: #f00;">请输入5-10个字符</i></li>
				<li><label><font color="#f00">*</font>密&nbsp;&nbsp;&nbsp;码</label><input
					name="student.stu_password" id="pwd1" type="password"
					maxlength="18" class="dfinput" /><i>务必牢记哦~</i></li>
				<li><label><font color="#f00">*</font>确认密码</label><input
					id="pwd2" type="password" maxlength="18" class="dfinput"
					onblur="check_pwd()" /><i id="pwdTip" style="color: #f00;"></i></li>
				<li><label>性&nbsp;&nbsp;&nbsp;别</label><cite><input
						name="student.stu_sex" type="radio" checked="checked" value="男" />&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;<input
						name="student.stu_sex" type="radio" value="女" />&nbsp;女</cite></li>
				<li><label><font color="#f00">*</font>姓&nbsp;&nbsp;&nbsp;名</label><input
					name="student.stu_name" type="text" maxlength="20" class="dfinput" /></li>
				<li><label><font color="#f00">*</font>学院-专业</label> <select
					name="student.stu_academy" style="height: 20px;">
						<option value="-1">====请选择所属学院====</option>
						<option value="体育学院">体育学院</option>
						<option value="新闻传媒学院">新闻传媒学院</option>
						<option value="计算机学院">计算机学院</option>
						<option value="化工学院">化工学院</option>
						<option value="数理学院">数理学院</option>
				</select> <select name="student.stu_major" style="height: 20px;">
						F<option value="-1">=====请选择专业=====</option>
						<option value="瑜伽">瑜伽</option>
						<option value="播音主持">播音主持</option>
						<option value="计算机技术">计算机科学与技术</option>
						<option value="应用化学">应用化学</option>
						<option value="应用数学">应用数学</option>

				</select></li>
				<li><label><font color="#f00">*</font>籍&nbsp;&nbsp;&nbsp;贯</label><input
					name="student.stu_province" id="acc" type="text" maxlength="10"
					class="dfinput" /></li>
				<li><label>手&nbsp;机&nbsp;号</label><input
					name="student.stu_mobile" onblur="check_mob()" id="mob" type="text"
					maxlength="11" class="dfinput" /><i id="mobTip"
					style="color: #f00;"></i></li>
				<li><label><font color="#f00">*</font>班&nbsp;&nbsp;&nbsp;级</label>
					<select name="selClassroom" style="height: 20px;">
						<option value="-1">=====请选择班级=====</option>
						<c:forEach items="${allClassroom}" var="obj">
							<option value="${obj.clr_id}">${obj.clr_name}</option>
						</c:forEach>
				</select></li>
				<li><label>地&nbsp;&nbsp;&nbsp;址</label><input
					name="student.stu_address" type="text" maxlength="32"
					class="dfinput" /></li>
				<li><label>年&nbsp;&nbsp;龄</label><input name="student.stu_age"
					type="text" maxlength="3" class="dfinput" /></li>
				<li><label>&nbsp;</label><input type="button"
					onclick="this.form.submit();" id="add" class="btn" value="添加" /></li>
			</ul>
		</form>

	</div>


</body>
</html>
