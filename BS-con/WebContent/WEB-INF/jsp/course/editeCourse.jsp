<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>发布课程</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>editor/kindeditor.js"></script>
	  
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>教学管理</li>
    <li>查询课程</li>
    <li>编辑课程</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>编辑课程</span></div>
    <form action="course_updateCourse" method="post">
    	<input type="hidden" value="${editeCourse.cre_id}" name="course.cre_id"/>
    	<input type="hidden" value="${editeCourse.cre_time}" name="course.cre_time"/>
	    <ul class="forminfo">
	   		<li><label><font color="#f00">*</font>课程名称</label><input name="course.cre_name" value="${editeCourse.cre_name}" maxlength="20" type="text" class="dfinput" /><i>不能超过20个字</i></li>
	    	<li>
	    		<label><font color="#f00">*</font>任课教师</label>
	    		<input name="tea" value="${editeTeacher.tea_name}" readonly="readonly" maxlength="20" type="text" class="dfinput" />
	    		<i>暂时无法修改~</i>
	    	</li>
	    	<li>
	    		<label><font color="#f00">*</font>课程性质</label>
	    		<c:if test="${editeCourse.cre_nature=='选修课'}">
	    			<select name="course.cre_nature" style="height: 20px;">
			    		<option value="-1">=====请选择课程性质=====</option>
			    		<option value="选修课" selected="selected">选修课</option>
			    		<option value="必修课">必修课</option>
			    		<option value="专业必修课">专业必修课</option>
		    		</select>
	    		</c:if>
		    	<c:if test="${editeCourse.cre_nature=='必修课'}">
	    			<select name="course.cre_nature" style="height: 20px;">
			    		<option value="-1">=====请选择课程性质=====</option>
			    		<option value="选修课">选修课</option>
			    		<option value="必修课" selected="selected">必修课</option>
			    		<option value="专业必修课">专业必修课</option>
		    		</select>
	    		</c:if>
	    		<c:if test="${editeCourse.cre_nature=='专业必修课'}">
	    			<select name="course.cre_nature" style="height: 20px;">
			    		<option value="-1">=====请选择课程性质=====</option>
			    		<option value="选修课">选修课</option>
			    		<option value="必修课">必修课</option>
			    		<option value="专业必修课" selected="selected">专业必修课</option>
		    		</select>
	    		</c:if>
	    	</li>
	    	<li><label><font color="#f00">*</font>学分</label><input name="course.cre_score" value="${editeCourse.cre_score}" maxlength="2" type="text" class="dfinput" /></li>
	    	<li><label>&nbsp;</label><input  type="button" onclick="this.form.submit();" class="btn" value="修改"/></li>
	    </ul>
    </form>
    </div>

</body>
</html>
