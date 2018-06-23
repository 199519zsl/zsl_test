<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改管理员信息</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function check_pwd(){
			var p1 = document.getElementById("pwd1").value;
			var p2 = document.getElementById("pwd2").value;
			if(p1!=p2){
				document.getElementById("pwdTip").innerHTML="两次密码不一致,请重新输入~";
			}else{
    			document.getElementById("pwdTip").innerHTML = "√";
    		}
		}
		
		function check_mob(){
  			var input = document.getElementById("mob").value;
    		var tip = document.getElementById("mobTip");
    		var match =/^[1][358][0-9]{9}$/;
    		if( ! match.test(input)){
    			tip.innerHTML = "手机号错误哦~亲";
    		}else{
    			tip.innerHTML = "√";
    		}
  		}
	</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	    <li>管理信息</li>
		<li>查询所有教师</li>
		<li>编辑</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>编辑信息</span></div>
    <form action="teacher_updateTeacher" method="post">
    	<input type="hidden" name="teacher.tea_id" value="${editeTeacher.tea_id}"/>
    	<input type="hidden" name="teacher.tea_time" value="${editeTeacher.tea_time}"/>
	    <ul class="forminfo">
		    <li><label><font color="#f00">*</font>账&nbsp;&nbsp;&nbsp;号</label><input name="teacher.tea_account" readonly="readonly" id="acc" value="${editeTeacher.tea_account}" type="text" maxlength="10" class="dfinput" /><i>无法修改~</i></li>
		    <li><label><font color="#f00">*</font>修改密码</label><input name="teacher.tea_password" id="pwd1" type="password" value="${editeTeacher.tea_password}" maxlength="18" class="dfinput" /><i>务必牢记哦~</i></li>
		    <li><label><font color="#f00">*</font>确认密码</label><input id="pwd2" type="password" maxlength="18" value="${editeTeacher.tea_password}" class="dfinput" onblur="check_pwd()"/><i id="pwdTip" style="color: #f00;"></i></li>
		    <li><label>性&nbsp;&nbsp;&nbsp;别</label><cite><input name="teacher.tea_sex" type="radio" checked="checked" value="男"/>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;<input name="teacher.tea_sex" type="radio" value="女"/>&nbsp;女</cite></li>
		    <li><label><font color="#f00">*</font>姓&nbsp;&nbsp;&nbsp;名</label><input name="teacher.tea_name" value="${editeTeacher.tea_name}" type="text" maxlength="20" class="dfinput" /></li>
		    <li><label>手&nbsp;机&nbsp;号</label><input name="teacher.tea_mobile" onblur="check_mob()" id="mob" type="text" value="${editeTeacher.tea_mobile}" maxlength="11" class="dfinput" /><i id="mobTip" style="color: #f00;"></i></li>
		    <li>
		    	<label><font color="#f00">*</font>学&nbsp;&nbsp;&nbsp;院</label>
		    	<select name="teacher.tea_academy" style="height: 20px;">
		    		<option value="-1">====请选择所属学院====</option>
		    		<option value="电气工程学院">电气工程学院</option>
		    		<option value="新闻传媒学院">新闻传媒学院</option>
		    		<option value="数学与计算机学院">数学与计算机学院</option>
		    		<option value="化工学院">化工学院</option>
		    	</select>
		    </li>
		    <li><label>省&nbsp;&nbsp;&nbsp;份</label><input name="teacher.tea_province" value="${editeTeacher.tea_province}" id="acc" type="text" maxlength="10" class="dfinput" /></li>
		    <li><label>地&nbsp;&nbsp;&nbsp;址</label><input name="teacher.tea_address" value="${editeTeacher.tea_address}" type="text" maxlength="32" class="dfinput" /></li>
		    <li><label>年&nbsp;&nbsp;龄</label><input name="teacher.tea_age" type="text" value="${editeTeacher.tea_age}" maxlength="3" class="dfinput" /></li>
		    <li><label>&nbsp;</label><input type="button" onclick="this.form.submit();" id="add" class="btn" value="提交"/></li>
	    </ul>
    </form>
    
    </div>

</body>
</html>
