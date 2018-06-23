<%@page import="com.product.bean.GoodsBean"%>
<%@ page language="java" import="java.util.*,com.product.bean.*,com.product.dao.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="<%=basePath%>/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>/css/admin.css">
<script src="<%=basePath%>/js/jquery.js"></script>
<script src="<%=basePath%>/js/pintuer.js"></script>
</head>
<body>

<div class="panel admin-panel">
  
  <div class="padding border-bottom">  
  <button type="button" style="width:110px; " class="button border-yellow" onclick="window.showModalDialog('<%=basePath %>/InHouse.do',window,'dialogWidth:1000px;dialogHeight:600px;dialogLeft:200px;dialogTop:200')"><span class="icon-plus-square-o"></span> 添加入库</button>
  <br/>
  <br/>
  <form  action="InHouseList.do" method="post"> 
    <input type="text" style="width:200px; " class="input w50" name="gcompany" size="50" placeholder=""  />&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="submit" class="button border-yellow" style="width:110px" ><span class="icon-plus-square-o"></span> 查询</button>  
  </form>
  </div>
  <div class="panel-head"><strong class="icon-reorder">采购入库列表</strong></div>
  <table class="table">
    <tr>
      <td ><font style="font-weight:bold">入库单号</font></td>
      <td ><font style="font-weight:bold">货物名称</font></td>
      <td ><font style="font-weight:bold">货物数量</font></td>
        <td><font style="font-weight:bold">货物尺寸</font></td>
          <td><font style="font-weight:bold">货物型号</font></td>
      <td ><font style="font-weight:bold">货物条形码</font></td>
      <td ><font style="font-weight:bold">入库日期</font></td>
      <td ><font style="font-weight:bold">入库员</font></td>
   
    </tr>
    
      <%
        List list  = (List)request.getAttribute("inlist");	
             for(Object obj : list){
                 InhouseBean u = (InhouseBean)obj;
             %>
           <tr >
           		<td><%=u.getIncode() %></td>
				<td><%=u.getIname() %></td>
            	<td><%=u.getInumber() %></td>
            	<td><%=u.getIsize()%></td>
            	<td><%=u.getImodel() %></td>
            	<td><%=u.getIbarcode()%></td>
            	<td><%=u.getItime()%></td>
            	<td><%=u.getOperatorname()%></td>
            
            	            	
            </tr>
          <%} %>
   
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