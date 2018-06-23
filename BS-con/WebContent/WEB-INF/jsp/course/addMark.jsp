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
    <title>修改成绩</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function btn_return(){
			window.location.href = "course_toAddMark";
		}
	</script>
</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li>教学管理</li>
			<li>成绩录入</li>
	    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>成绩录入</span></div>
    <form action="course_updateMark" method="post">
	    <ul class="forminfo">
	    	<li>
	    		<label>学&nbsp;&nbsp;&nbsp;号</label>
	    		<input name="scard" value="${scStu.stu_card}" type="text" style="width: 200px;" readonly="readonly" maxlength="10" class="dfinput" />
	    	</li>
		    <li><label>姓&nbsp;&nbsp;&nbsp;名</label><input name="" value="${scStu.stu_name}" type="text" style="width: 200px;" readonly="readonly" maxlength="20" class="dfinput" /></li>
		    <li><label>学&nbsp;&nbsp;&nbsp;院</label><input name="" value="${scStu.stu_academy}" type="text" style="width: 200px;" readonly="readonly" maxlength="20" class="dfinput" /></li>
		   	<c:forEach items="${scDto}" var="obj" varStatus="sta">
		   		<li>
		   			<label>第&nbsp;${sta.index+1}&nbsp;门</label>
			   		<input type="text" value="${obj.cname}" style="width: 120px;" readonly="readonly" class="dfinput"/>
			   		<input name="scores" type="text" style="width: 50px;" value="${obj.scmark}" maxlength="4" class="dfinput" />&nbsp;&nbsp;分
		   			<input name="scids" type="hidden" value="${obj.scid}"/>
		   		</li>
		   	</c:forEach>
		    <li>
		    	<input type="button" onclick="this.form.submit();" class="btn" value="提交"/>
		    	<input type="button" onclick="btn_return()" class="btn" value="返回"/>
		    </li>
	    </ul>
    </form>
    
    </div>

</body>
</html>
