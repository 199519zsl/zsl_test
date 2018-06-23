<%@ page language="java" import="java.util.*,com.product.bean.UserBean" pageEncoding="UTF-8"%>
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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
 
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改用户信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="Modifyuser.do">

      <%	 
           UserBean ub  = (UserBean)request.getAttribute("user");%>
	 <div class="form-group">
        <div class="label">
          <label for="sitename">用户编号：</label>
        </div>
        <div class="field">
         <input type="text" class="input w50" id="name" readonly  name="uid" value=<%= ub.getId() %> size="50" placeholder="请输入用户名" data-validate="required:请输入用户名" />       
               
        </div>
      </div>    
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="name" name="name" value=<%= ub.getUsername() %> size="50" placeholder="请输入用户名" data-validate="required:请输入用户名" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="pass" value=<%= ub.getPwd() %> size="50" placeholder="请输入密码" data-validate="required:请输入密码,length#>=5:密码不能小于5位" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户类型：</label>
        </div>
        <div >
        <%
        if(ub.getUsertype().equals("系统管理员"))
        {%>
        <input type="radio" name="type"  value="系统管理员" style="margin-left:40px" checked/>系统管理员
				            <input type="radio" name="type" value="入库管理员" />入库管理员
				            <input type="radio" name="type" value="出库管理员" />出库管理员
        <%} %>
           <%
        if(ub.getUsertype().equals("入库管理员"))
        {%>
        <input type="radio" name="type"  value="系统管理员" style="margin-left:40px" />系统管理员
				            <input type="radio" name="type" value="入库管理员" checked/>入库管理员
				            <input type="radio" name="type" value="出库管理员" />出库管理员
        <%} %>
           <%
        if(ub.getUsertype().equals("出库管理员"))
        {%>
                            <input type="radio" name="type"  value="系统管理员" style="margin-left:40px" />系统管理员
				            <input type="radio" name="type" value="入库管理员" />入库管理员
				            <input type="radio" name="type" value="出库管理员" checked/>出库管理员
        <%} %>
                           
       </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
           <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>
   			 <button class="button bg-main icon-check-square-o"  onclick="javascript:history.go(-1);"> 返回</button>
        </div>
      </div>      
    </form>
  </div>
</div>

</body></html>
