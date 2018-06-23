<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改班级信息</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	    <li>管理信息</li>
		<li>查询所有班级</li>
		<li>编辑</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>编辑班级信息</span></div>
    <form action="classroom_updateClassroom" method="post">
    	<input type="hidden" name="classroom.clr_id" value="${editeClassroom.clr_id}"/>
    	<input type="hidden" name="classroom.clr_time" value="${editeClassroom.clr_time}"/>
	    <ul class="forminfo">
		    <li><label><font color="#f00">*</font>班级名称</label><input name="classroom.clr_name" value="${editeClassroom.clr_name}" type="text" maxlength="10" class="dfinput" /></li>
		    <li><label><font color="#f00">*</font>人数</label><input name="classroom.clr_count" type="text" value="${editeClassroom.clr_count}" maxlength="3" class="dfinput" /></li>
		    <li><label><font color="#f00">*</font>班主任</label><input name="classroom.clr_teacher" readonly="readonly" value="${editeClassroom.clr_teacher}" type="text" maxlength="20" class="dfinput" /></li>
		   	<li><label><font color="#f00">*</font>班长</label><input name="classroom.clr_monitor" readonly="readonly" value="${editeClassroom.clr_monitor}" type="text" maxlength="20" class="dfinput" /></li>
		    <li><label>&nbsp;</label><input type="button" onclick="this.form.submit();" id="add" class="btn" value="提交"/></li>
	    </ul>
    </form>
    
    </div>

</body>
</html>
