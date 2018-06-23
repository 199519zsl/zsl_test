<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 添加用户信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath %>/adduser.do">
      <div class="form-group">
        
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="name" name="name" size="50" placeholder="请输入用户名" data-validate="required:请输入用户名" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="pass" size="50" placeholder="请输入密码" data-validate="required:请输入密码,length#>=5:密码不能小于5位" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label >用户类型：</label>
        </div>
        <div ><br/>
                            <input type="radio" name="type" value="系统管理员" style="margin-left:10px" />系统管理员
				            <input type="radio" name="type" value="入库管理员" />入库管理员
				            <input type="radio" name="type" value="出库管理员" />出库管理员
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 添加</button>&nbsp; &nbsp;
          <button class="button bg-main icon-check-square-o"  onclick="javascript:history.go(-1);"> 返回</button>
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>
