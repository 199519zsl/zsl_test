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
<style>  
.conter  
{  
width:100%;  
height:300px;  
border:0px solid #000;  
padding:0px;  
} 
 
.conter h1  
{  
height:20px;  
font-size:14px;  
font-weight:bold;
background:#F2F9FD;  
line-height:20px;  
text-indent:5px;  
margin-top:0px;  
}  
</style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 添加入库货物信息</strong></div>
  <div class="conter"><h1>基本信息</h1> 
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>/addbuyin.do">
    
    
     <table border=0 style="border-spacing:5px; width:1000px;height:250px" >
     <tr>
	     <td style="vertical-align:middle;">
	     	 <div class="label">
	          <label for="sitename">入库货物名称：</label>
	        </div>
	     </td>
	     <td style="vertical-align:middle;">
	      <div class="field">
	          <input type="text" style="width:200px;" class="input w50" id="mpass" name="iname" size="50" placeholder="请输入货物名称" data-validate="required:请输入货物名称" />       
	        </div>
	     </td>
	     <td style="vertical-align:middle;">
	        <div class="label">
	          <label for="sitename">货物数量：</label>
	        </div>
	     </td>
	     <td style="vertical-align:middle;">
	     	 <div class="field">
	          <input type="text" style="width:200px;" class="input w50" id="mpass" name="inumber" size="50" placeholder="请输入货物数量" data-validate="required:请输入货物数量" />       
	        </div>
	     </td>
     </tr>
     <tr>
		     <td style="vertical-align:middle;">
		     <div class="label">
		          <label for="sitename">货物价格：</label>
		        </div>
		     </td>
		     <td style="vertical-align:middle;">
		     	<div class="field">
		         <input type="text" style="width:200px;" class="input w50" id="mpass" name="iprice" size="50" placeholder="请输入货物价格" data-validate="required:请输入货物价格" />       
		        </div>
		     </td>
		     <td style="vertical-align:middle;">
			     <div class="label">
			          <label for="sitename">货物尺寸：</label>
			        </div>
		     </td>
		     <td style="vertical-align:middle;">
		     	 <div class="field">
		         <input type="text" style="width:200px;" class="input w50" id="mpass" name="isize" size="50" placeholder="请输入货物尺寸" data-validate="required:请输入货物尺寸" />       
		        </div>
		     </td>
     </tr>
     
     <tr>
	     <td style="vertical-align:middle;">
	     	<div class="label">
	          <label for="sitename">货物型号：</label>
	        </div>
	     </td>
	     <td style="vertical-align:middle;">
	     	 <div class="field">
	         <input type="text" style="width:200px;" class="input w50" id="mpass" name="imodel" size="50" placeholder="请输入货物型号" data-validate="required:请输入货物型号" />       
	        </div>
	     </td>
     <td style="vertical-align:middle;">
     	<div class="label">
          <label for="sitename">货物条形码：</label>
        </div>
     </td>
     <td style="vertical-align:middle;">
     	<div class="field">
         <input type="text"  style="width:200px;" class="input w50" id="mpass" name="ibarcode" size="50" placeholder="请输入货物条形码" data-validate="required:请输入货物条形码" />       
        </div>
     </td>
     </tr>
     <tr>
	     <td style="vertical-align:middle;">
	     	<div class="label">
	          <label for="sitename">入库时间：</label>
	        </div>
	     </td>
	     <td style="vertical-align:middle;">
	     	 <div class="field">
	         <input type="text" style="width:200px;" class="input w50" id="mpass" name="itime" size="50" placeholder="请输入入库时间" data-validate="required:请输入入库时间" />       
	        </div>
	     </td>
     <td style="vertical-align:middle;">
     	<div class="label">
          <label for="sitename">入库人员：</label>
        </div>
     </td>
     <td style="vertical-align:middle;">
     	<div class="field">
         <input type="text"  style="width:200px;" class="input w50" id="mpass" name="username" size="50" placeholder="请输入入库人员" data-validate="required:请输入入库人员" />       
        </div>
     </td>
     </tr>
     <tr>
		     <td style="vertical-align:middle;">
		     <div class="label">
		          <label for="sitename">供应商：</label>
		        </div>
		     </td>
		     <td style="vertical-align:middle;">
		     	<div class="field">
		         <input type="text" style="width:200px;" class="input w50" id="mpass" name="pcomplany" size="50" placeholder="请输入供应商" data-validate="required:请输入供应商" />       
		        </div>
		     </td>
		    
	 <td></td>
     <td></td>
     </tr>
     <tr>
     <td></td>
     
     <td><button class="button bg-main icon-check-square-o" type="submit"> 添加</button> </td>
     <td> <button class="button bg-main icon-check-square-o"  onclick="javascript:history.go(-1);"> 返回</button></td>
     <td></td>
     </tr>
     </table>
     
    </form>
  </div>
  </div>
</div>
</body></html>
