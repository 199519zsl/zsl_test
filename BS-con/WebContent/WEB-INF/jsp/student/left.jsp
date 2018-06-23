<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>无标题文档</title>
		<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="<%=basePath%>js/jquery.js"></script>
		<script type="text/javascript">
			$(function() {
				//导航切换
				$(".menuson li").click(function() {
					$(".menuson li.active").removeClass("active")
					$(this).addClass("active");
				});
			
				$('.title').click(function() {
					var $ul = $(this).next('ul');
					$('dd').find('ul').slideUp();
					if ($ul.is(':visible')) {
						$(this).next('ul').slideUp();
					} else {
						$(this).next('ul').slideDown();
					}
				});
			})
		</script>

	</head>

	<body style="background: #f0f9fd;">
		<div class="lefttop">
			<span></span>数据操作
		</div>

		<dl class="leftmenu">

			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" />
					</span>用户管理
				</div>
				<ul class="menuson">
					<li>
					    <cite></cite><a href="student_index" target="rightFrame">学生主界面</a><i></i>
					</li>
					<li class="active">
						<cite></cite><a href="student_toUpdateStudentpwd" target="rightFrame">修改密码界面</a><i></i>
					</li>
				</ul>
			</dd>

			<dd>
				<div class="title">
					<span><img src="images/leftico02.png" />
					</span>成绩与课程管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="student_toRetrieveMark" target="rightFrame">成绩与课程查询</a><i></i>
					</li>
				</ul>
			</dd>
		</dl>

	</body>
</html>
