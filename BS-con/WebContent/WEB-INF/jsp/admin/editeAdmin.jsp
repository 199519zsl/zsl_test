<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改管理员信息</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
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
		<li>查询所有管理员</li>
		<li>编辑</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>编辑信息</span></div>
    <form action="admin_updateAdmin" method="post">
    	<input type="hidden" name="admin.adm_id" value="${editeAdmin.adm_id}"/>
    	<input type="hidden" name="admin.adm_logintime" value="${editeAdmin.adm_logintime}"/>
    	<input type="hidden" name="admin.adm_time" value="${editeAdmin.adm_time}"/>
	    <ul class="forminfo">
		    <li><label><font color="#f00">*</font>账&nbsp;&nbsp;&nbsp;号</label><input name="admin.adm_account" readonly="readonly" id="acc" value="${editeAdmin.adm_account}" type="text" maxlength="10" class="dfinput" /><i>无法修改~</i></li>
		    <li><label><font color="#f00">*</font>修改密码</label><input name="admin.adm_password" id="pwd1" type="password" value="${editeAdmin.adm_password}" maxlength="18" class="dfinput" /><i>务必牢记哦~</i></li>
		    <li><label><font color="#f00">*</font>确认密码</label><input id="pwd2" type="password" maxlength="18" value="${editeAdmin.adm_password}" class="dfinput" onblur="check_pwd()"/><i id="pwdTip" style="color: #f00;"></i></li>
		    <li><label>性&nbsp;&nbsp;&nbsp;别</label><cite><input name="admin.adm_sex" type="radio" checked="checked" value="男"/>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;<input name="admin.adm_sex" type="radio" value="女"/>&nbsp;女</cite></li>
		    <li><label><font color="#f00">*</font>姓&nbsp;&nbsp;&nbsp;名</label><input name="admin.adm_name" value="${editeAdmin.adm_name}" type="text" maxlength="20" class="dfinput" /></li>
		    <li><label>手&nbsp;机&nbsp;号</label><input name="admin.adm_mobile" onblur="check_mob()" id="mob" type="text" value="${editeAdmin.adm_mobile}" maxlength="11" class="dfinput" /><i id="mobTip" style="color: #f00;"></i></li>
		    <li><label>年&nbsp;&nbsp;龄</label><input name="admin.adm_age" type="text" value="${editeAdmin.adm_age}" maxlength="3" class="dfinput" /></li>
		    <li><label>&nbsp;</label><input type="button" onclick="this.form.submit();" id="add" class="btn" value="提交"/></li>
	    </ul>
    </form>
    
    </div>

</body>
</html>
