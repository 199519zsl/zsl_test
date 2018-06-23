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
    <title>班级列表</title>
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
    <li>查询所有班级</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <table class="imgtable">
    
    <thead>
    <tr>
	    <th width="100px;">序号</th>
	    <th>班级名称</th>
	    <th>人数</th>
	    <th>班级任</th>
	    <th>班长</th>
	    <th>注册时间</th>
	    <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${classroomList}" var="obj" varStatus="sta">
	    <tr>
		    <td class="imgtd">${sta.index+1}</td>
		    <td>${obj.clr_name}</td>
		    <td>${obj.clr_count}</td>
		    <td>${obj.clr_teacher}</td>
		    <td>${obj.clr_monitor}</td>
		    <td>${obj.clr_time}</td>
	    	<td>
			   	<a href="classroom_editeClassroom?cid=${obj.clr_id}" class="tablelink">编辑</a>
			    <a href="classroom_deleteClassroom?cid=${obj.clr_id}" class="tablelink"> 删除</a>
		    </td>
	    </tr>
    </c:forEach>
    
    </tbody>
    
    </table>
    
    <div class="pagin">
    	<div class="message">共&nbsp;<i class="blue">${itemsCount}</i>&nbsp;条记录.</div>
    </div>
    
    </div>
    
	<script type="text/javascript">
		$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>
</html>
