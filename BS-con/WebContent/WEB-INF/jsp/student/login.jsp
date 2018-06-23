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
		<title>欢迎来到高校学生学籍管理系统</title>
		<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="<%=basePath%>js/jquery.js"></script>
		<script src="<%=basePath%>js/cloud.js" type="text/javascript"></script>

		<script language="javascript">
			function login_btn(){
				var card = $("#card").val();
        		var password = $("#pwd").val();
	        	$.ajax({
		            type: "post", 
		            url : "student_checkLogin?flag=check",
		            data: 'student.stu_card='+card+'&student.stu_password='+password, 
		            success: function(data){	//如果调用后台成功
		            	if(data=="A"){
		            		$("#loginTip").html("用户名或密码不正确");
		            	}else{
		            		document.getElementById("loginForm").submit();
		            	}
		        	}
	        	});
				
			}
			
			$(function() {
				$('.loginbox').css( {
					'position' : 'absolute',
					'left' : ($(window).width() - 692) / 2
				});
				$(window).resize(function() {
					$('.loginbox').css( {
						'position' : 'absolute',
						'left' : ($(window).width() - 692) / 2
					});
				})
			});
		</script>
	</head>

	<body
		style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">

		<div id="mainBody">
			<div id="cloud1" class="cloud"></div>
			<div id="cloud2" class="cloud"></div>
		</div>

		<div class="logintop">
			<span>黄冈师范学院-高校学生学籍管理系统</span>
			<ul>
				<li>
					<a href="#">回首页</a>
				</li>
				<li>
					<a href="#">帮助</a>
				</li>
				<li>
					<a href="#">关于</a>
				</li>
			</ul>
		</div>

		<div class="loginbody">

			<span class="systemlogo"></span>
			<div class="loginbox">
				<form action="student_main" id="loginForm" method="post">
					<ul>
						<li>
							<input id="card" type="text" class="loginuser" value="student"
								onclick="JavaScript:this.value=''" />
						</li>
						<li>
							<input id="pwd" type="password" class="loginpwd"
								onclick="JavaScript:this.value=''" />
						</li>
						<li id="loginTip" style="margin-bottom:10px;font-size:15px; color: #ff0000;">
						
						</li>
						<li>
							<input name="" type="button"
							 class="loginbtn" value="登录" onclick="login_btn()" />
							<label>
								<input name="" type="checkbox" value="" checked="checked" />
								记住密码
							</label>
							<label>
								<a href="#">忘记密码？</a>
							</label>
						</li>
						
					</ul>
					
				</form>
			</div>

		</div>

		<div class="loginbm">
			版权所有 2016
			<a href="">Made In HGNC</a>
		</div>

	</body>
</html>
