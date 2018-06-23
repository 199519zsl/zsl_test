<%@ page language="java" import="java.util.*,com.product.bean.UserBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UserBean ubc = (UserBean)session.getAttribute("user");
String uid = ubc.getId()+"";
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
  <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>Modifyuser.do?id=<%=uid %>">
      <table>
      <tr ><div class="form-group">
      <td width="30%">      
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        </td>
        <td>
        <div class="field">
          <input type="password" class="input w50" name="pass" id="pass" size="50" placeholder="请输入密码" data-validate="required:请输入密码,length#>=5:密码不能小于5位" />         
        </div>     
      </td>
       </div>
      <tr>
      <div class="form-group">
      <td>      
        <div class="label">
          <label for="sitename">重新输入新密码：</label>
        </div>
        </td>
        <td>
        <div class="field">
          <input type="password" class="input w50" name="pass2" id="pass2" size="50" placeholder="请输入密码" data-validate="required:请输入密码,length#>=5:密码不能小于5位" />         
        </div>
        </td>
      </div></tr>
       </table>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
           <button class="button bg-main icon-check-square-o" type="submit" onclick="pcheck()"> 修改</button>
   			 <button class="button bg-main icon-check-square-o"  onclick="javascript:history.go(-1);"> 返回</button>
        </div>
       
      </div>      
    </form>
  </div>
</div>

<SCRIPT LANGUAGE=javascript>

function pcheck() {
alert("2");
//var msg = "您真的确定要删除吗？\n\n请确认！";
var p1= document.getElementsById("pass").value;
alert(p1);
//if (confirm(msg)==true){
//return true;
//}else{
//return false;
//}
}

</SCRIPT>

</body></html>
