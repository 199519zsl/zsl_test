<%@ page language="java" import="java.util.*,com.product.bean.SupplierBean,com.product.dao.SupplierDao" pageEncoding="UTF-8"%>
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
  <div class="panel-head"><strong class="icon-reorder"> 供货商列表</strong></div>
  <div class="padding border-bottom">  

      <br/>         
  <br/>
 <form  action="" method="post"> 
    <input type="text" style="width:200px; " class="input w50" name="cucomplany" size="50" placeholder="请输入单位名称"  />&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="submit" class="button border-yellow" style="width:110px" ><span class="icon-plus-square-o"></span> 查询</button>  
 </form>
  </div>
  <table class="table">
    <tr>
      <td ><font style="font-weight:bold">单位编码</font></td>
      <td ><font style="font-weight:bold">单位名称</font></td>
      <td><font style="font-weight:bold">联系人</font></td>
        <td><font style="font-weight:bold">电话</font></td>
          <td><font style="font-weight:bold">email</font></td>
      <td ><font style="font-weight:bold">邮编</font></td>
      <td ><font style="font-weight:bold">地址</font></td>
      <td><font style="font-weight:bold">备注</font></td>
      <th width="15%">操作</th>
    </tr>

     
   
  </table>
</div>
<SCRIPT LANGUAGE=javascript>

function p_del() {
var msg = "您真的确定要删除吗？\n\n请确认！";
if (confirm(msg)==true){
return true;
}else{
return false;
}
}

</SCRIPT>


</body></html>