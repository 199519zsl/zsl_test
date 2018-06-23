<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改密码</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function check_acc(){
			var p1 = document.getElementById("acc").value;
			if(p1.length<5 || p1.length>10){
				document.getElementById("accTip").innerHTML="必须是5-10个字符哦~";
			}else{
    			document.getElementById("accTip").innerHTML = "√";
    		}
		}
		
		function check_pwd(){
			var p1 = document.getElementById("pwd1").value;
			var p2 = document.getElementById("pwd2").value;
			if(p1!=p2){
				document.getElementById("pwdTip").innerHTML="两次密码不一致,请重新输入~";
			}else{
    			document.getElementById("pwdTip").innerHTML = "√";
    		}
		}
		
	</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>学生信息</li>
	<li>修改密码</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改密码</span></div>
	    <form action="student_updateStudentpwd" method="post">
		    <ul class="forminfo">
		    	<li><label>个人ID</label><input name="student.stu_card" onblur="check_acc()" id="acc" type="text" maxlength="10" class="dfinput" /><i id="accTip" style="color: #f00;">不要将自己的ID告诉别人哟~</i></li>
			    <li><label>新&nbsp;密&nbsp;码</label><input name="student.stu_password" id="pwd1" type="password" maxlength="18" class="dfinput" /><i>务必牢记哦~</i></li>
			    <li><label>确认密码</label><input id="pwd2" type="password" maxlength="18" class="dfinput" onblur="check_pwd()"/><i id="pwdTip" style="color: #f00;"></i></li>
			    <li><label>&nbsp;</label><input type="button" onclick="this.form.submit();" id="add" class="btn" value="提交"/></li>
		    </ul>
	    </form>
    </div>
</body>
</html>
