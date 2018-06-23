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
    <title>校园公告管理</title>
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
    <li>校园管理</li>
    <li>所有通知</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">序号</th>
    <th>编号</th>
    <th>标题</th>
    <th>简要内容</th>
    <th>发布时间</th>
    <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${allNotices}" var="obj" varStatus="sta">
	    <tr>
		    <td class="imgtd">${sta.index+1}</td>
		    <td align="center"><p>-</p>${obj.ntc_id}</td>
		    <td title="查看详细"><a href="notice_notice?nid=${obj.ntc_id}">${obj.ntc_title}</a></td>
		    <td title="查看详细"><a href="notice_notice?nid=${obj.ntc_id}">${obj.ntc_content}</a></td>
		    <td>${obj.ntc_time}</td>
		    <td>
			   	<a href="notice_notice?nid=${obj.ntc_id}" class="tablelink">查看</a>
			    <a href="notice_deleteNotice?nid=${obj.ntc_id}" class="tablelink"> 删除</a>
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
