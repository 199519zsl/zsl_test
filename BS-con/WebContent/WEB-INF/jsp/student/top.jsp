<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>无标题文档</title>
<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript">
	$(function(){	
		//顶部导航切换
		$(".nav li a").click(function(){
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})	
	})	
	</script>

</head>

<body style="background: url(images/topbg.gif) repeat-x;">

	<div class="topleft">
		<img src="images/logo.png" title="系统首页" />
	</div>

	<div class="topright">
		<ul>
			<li><span><img src="images/help.png" title="帮助"
					class="helpimg" /></span><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
			<li><a href="student_studentExit" target="_parent">退出</a></li>
		</ul>

		<div class="user">
			<span>学生</span> <i>消息</i> <b>0</b>
		</div>

	</div>

</body>
</html>
