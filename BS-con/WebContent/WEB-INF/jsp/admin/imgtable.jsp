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
    <li>管理信息</li>
    <li>查询所有管理员</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <table class="imgtable">
    
    <thead>
    <tr>
	    <th width="100px;">序号</th>
	    <th>账号--密码</th>
	    <th>姓名</th>
	    <th>年龄</th>
	    <th>手机号</th>
	    <th>注册时间</th>
	    <th>性别</th>
	    <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${adminList}" var="obj" varStatus="sta">
	    <tr>
		    <td class="imgtd">${sta.index+1}</td>
		    <td>账号：${obj.adm_account}<p>密码：${obj.adm_password}</p></td>
		    <td>${obj.adm_name}</td>
		    <td>${obj.adm_age}</td>
		    <td>${obj.adm_mobile}</td>
		    <td>${obj.adm_time}</td>
		    <td>${obj.adm_sex}</td>
	    	<td>
			   	<a href="admin_editeAdmin?aid=${obj.adm_id}" class="tablelink">编辑</a>
			    <a href="admin_deleteAdmin?aid=${obj.adm_id}" class="tablelink"> 删除</a>
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
