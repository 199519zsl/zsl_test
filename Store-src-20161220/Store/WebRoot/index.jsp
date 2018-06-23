<%@ page language="java" import="java.util.*,com.product.bean.UserBean,javax.servlet.http.HttpSession;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>仓库管理系统</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
    <SCRIPT LANGUAGE=javascript>

function p_del() {
var msg = "您真的确定要退出系统吗？\n\n请确认！";
if (confirm(msg)==true){
return true;
}else{
return false;
}
}

</SCRIPT>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />仓库管理系统</h1>
  </div>
<%
UserBean ubc = (UserBean)session.getAttribute("user");
 String name=ubc.getUsername();
 String utype=ubc.getUsertype();
 %>
  <div class="head-l"><img src="images/client.png" style="margin-left:670px"/>&nbsp;&nbsp;<font color="white">欢迎您,&nbsp;<%=utype %>&nbsp;:&nbsp;<%=name %>&nbsp;</font><a class="button button-little bg-green"  onclick="window.showModalDialog('<%=basePath %>/user/Modifypass.jsp',window,'dialogWidth:500px;dialogHeight:300px;dialogLeft:200px;dialogTop:200')"><span class="icon-home"></span> 修改密码</a> &nbsp;&nbsp; &nbsp; <a class="button button-little bg-red" href="login.jsp" onclick="javascript:p_del()"><span class="icon-power-off"></span> 退出登录</a>
   
  </div>
  
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基础数据管理</h2>
  <ul style="display:block">
    <% if("系统管理员".equalsIgnoreCase(utype)){%>
    <li><a href="UserServlet.do" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
  <%} if("出库管理员".equalsIgnoreCase(utype)||"系统管理员".equalsIgnoreCase(utype)){%>
     <li><a href="CustomerServlet.do" target="right"><span class="icon-caret-right"></span>客户信息管理</a></li>
     
     <% }if("入库管理员".equalsIgnoreCase(utype)||"系统管理员".equalsIgnoreCase(utype)){%>
       <li><a href="SupplierServlet.do" target="right"><span class="icon-caret-right"></span>供货商信息管理</a></li>
     <% }%>
  </ul>   
      
  <% if("系统管理员".equalsIgnoreCase(utype)||"入库管理员".equalsIgnoreCase(utype)){%>
   <h2><span class="icon-pencil-square-o"></span>货物信息管理</h2>
  <ul style="display:block">
    <li><a href="goodsServlet.do" target="right"><span class="icon-caret-right"></span>货物信息管理</a></li>  
  </ul> 
  <%} if("系统管理员".equalsIgnoreCase(utype)){%>
 
  <%} if("出库管理员".equalsIgnoreCase(utype)||"系统管理员".equalsIgnoreCase(utype)){%>
  
   <h2><span class="icon-pencil-square-o"></span>出库管理</h2>
  <ul style="display:block">
    <li><a href="<%=basePath %>/OutHouseList.do" target="right"><span class="icon-caret-right"></span>出库</a></li> 
  </ul>
  <%} if("入库管理员".equalsIgnoreCase(utype)||"系统管理员".equalsIgnoreCase(utype)){%>
   <h2><span  class="icon-pencil-square-o"></span>入库管理</h2>
  <ul style="display:block">
    <li><a href="<%=basePath %>/InHouseList.do" target="right"><span class="icon-caret-right"></span>入库</a></li> 
           
  </ul>
    <% }%>
  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread"><%--{:U('Index/info')}--%>
  <li><a href="/Store/info.html" target="right" class="icon-home">首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>

</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="info.html" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">

</div>
</body>
</html>
