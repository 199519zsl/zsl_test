<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>发布通知</title>
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
		
		function check_mob(){
  			var input = document.getElementById("mob").value;
    		var tip = document.getElementById("mobTip");
    		var match =/^[1][358][0-9]{9}$/;
    		if( ! match.test(input)){
    			tip.innerHTML = "手机号错误哦~亲";
    		}else{
    			tip.innerHTML = "√";
    		}
  		}
	</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>管理信息</li>
	<li>管理员界面</li>
	<li>账号设置</li>
	<li>添加管理员账号</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加管理员账号</span></div>
    <form action="admin_addAdmin" method="post">
	    <ul class="forminfo">
		    <li><label><font color="#f00">*</font>账&nbsp;&nbsp;&nbsp;号</label><input name="admin.adm_account" onblur="check_acc()" id="acc" type="text" maxlength="10" class="dfinput" /><i id="accTip" style="color: #f00;">请输入5-10个字符</i></li>
		    <li><label><font color="#f00">*</font>密&nbsp;&nbsp;&nbsp;码</label><input name="admin.adm_password" id="pwd1" type="password" maxlength="18" class="dfinput" /><i>务必牢记哦~</i></li>
		    <li><label><font color="#f00">*</font>确认密码</label><input id="pwd2" type="password" maxlength="18" class="dfinput" onblur="check_pwd()"/><i id="pwdTip" style="color: #f00;"></i></li>
		    <li><label>性&nbsp;&nbsp;&nbsp;别</label><cite><input name="admin.adm_sex" type="radio" checked="checked" value="男"/>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;<input name="admin.adm_sex" type="radio" value="女"/>&nbsp;女</cite></li>
		    <li><label><font color="#f00">*</font>姓&nbsp;&nbsp;&nbsp;名</label><input name="admin.adm_name" type="text" maxlength="20" class="dfinput" /></li>
		    <li><label>手&nbsp;机&nbsp;号</label><input name="admin.adm_mobile" onblur="check_mob()" id="mob" type="text" maxlength="11" class="dfinput" /><i id="mobTip" style="color: #f00;"></i></li>
		    <li><label>年&nbsp;&nbsp;龄</label><input name="admin.adm_age" type="text" maxlength="3" class="dfinput" /></li>
		    <li><label>&nbsp;</label><input type="button" onclick="this.form.submit();" id="add" class="btn" value="添加"/></li>
	    </ul>
    </form>
    
    </div>


</body>
</html>
