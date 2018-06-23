<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加管理员</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>教学管理</li>
	<li>添加班级</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加班级</span></div>
    <form action="classroom_addClassroom" method="post">
	    <ul class="forminfo">
		    <li><label><font color="#f00">*</font>班级&nbsp;名称</label><input name="classroom.clr_name" type="text" maxlength="20" class="dfinput" /><i>提示：计科1201班</i></li>
		    <li><label><font color="#f00">*</font>班级&nbsp;人数</label><input name="classroom.clr_count" type="text" maxlength="3" class="dfinput" onblur="check_pwd()"/><i id="pwdTip" style="color: #f00;"></i></li>
		    <li><label><font color="#f00">*</font>班&nbsp;主&nbsp;任</label><input name="classroom.clr_teacher" type="text" maxlength="20" class="dfinput"/></li>
		    <li><label><font color="#f00">*</font>班&nbsp;&nbsp;&nbsp;长</label><input name="classroom.clr_monitor" type="text" maxlength="20" class="dfinput"/></li>
		    <li><label>&nbsp;</label><input type="button" onclick="this.form.submit();" id="add" class="btn" value="添加"/></li>
	    </ul>
    </form>
    
    </div>


</body>
</html>
