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
    <title>管理员界面</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
  </head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>管理信息</li>
	<li>管理员界面</li>
	<li>账号设置</li>
    </ul>
    </div>
    
    <div class="mainindex">
    
	    <div class="box"></div>
	    <ul class="infolist">
	    	<li>
	    		<c:if test="${loginAdmin.adm_account=='admin'}"><a class="ibtn" href="admin_toAddAdmin">添加管理员</a></c:if>
	    		<a href="admin_toUpdatepwd" class="ibtn">修改密码</a>
	    	</li>
	    </ul>
	    <div class="xline"></div>
    	
    </div>
    
</body>
</html>
