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
    <title>管理员列表</title>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>教学管理</li>
    <li>查询学生信息</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <div class="pagin">
    	<div class="message">
    		共&nbsp;<i class="blue">${itemsCount}</i>&nbsp;条记录.
    		&nbsp;&nbsp;&nbsp;<font color="#f00">${stuListTip}</font>
    	</div>
    </div>
    <table class="imgtable">
    
    <thead>
    <tr>
	    <th width="100px;">序号</th>
	    <th>账号--密码</th>
	    <th>姓名</th>
	    <th>性别</th>
	    <th>学院-专业-班级</th>
	    <th>年龄</th>
	    <th>手机号</th>
	    <th>籍贯</th>
	    <th>家庭住址</th>
	    <th>注册时间</th>
	    <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${studentList}" var="obj" varStatus="sta">
	    <tr>
		    <td class="imgtd">${sta.index+1}</td>
		    <td>账号：${obj.scard}<p>密码：${obj.spwd}</p></td>
		    <td>${obj.sname}</td>
		    <td>${obj.sex}</td>
		    <td>${obj.sadmy}<p>${obj.cname}</p></td>
		    <td>${obj.sage}</td>
		    <td>${obj.smob}</td>
		    <td>${obj.spro}</td>
		    <td>${obj.sadd}</td>
		    <td>${obj.stime}</td>
	    	<td>
			   	<a href="student_editeStudent?sid=${obj.sid}" class="tablelink">编辑</a>
			    <a href="student_deleteStudent?sid=${obj.sid}" class="tablelink"> 删除</a>
		    </td>
	    </tr>
    </c:forEach>
    
    </tbody>
    
    </table>
    
    </div>
    
	<script type="text/javascript">
		$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>
</html>
