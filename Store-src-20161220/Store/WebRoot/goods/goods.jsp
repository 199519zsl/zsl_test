<%@page import="com.product.bean.GoodsBean"%>
<%@ page language="java" import="java.util.*,com.product.bean.GoodsBean,com.product.dao.GoodsDao" pageEncoding="UTF-8"%>
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
  <div class="panel-head"><strong class="icon-reorder"> 货物列表</strong></div>
  <div class="padding border-bottom">  
  <button type="button" style="width:110px; " class="button border-yellow" onclick="window.location.href='<%=basePath %>/goods/addGoods.jsp'"><span class="icon-plus-square-o"></span> 添加货物</button>
  <br/>
  <br/>
  <form  action="goodsServlet.do" method="post">
    <input type="text" style="width:200px; " class="input w50" name="gcompany" size="50" placeholder="请输入货物名称"  />&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="submit" class="button border-yellow" style="width:110px" ><span class="icon-plus-square-o"></span> 查询</button>  
  </form>
  </div>
  <table class="table">
    <tr>
      <td ><font style="font-weight:bold">货物编号</font></td>
      <td ><font style="font-weight:bold">货物名称</font></td>
      <td><font style="font-weight:bold">货物数量</font></td>
        <td><font style="font-weight:bold">货物价格</font></td>
          <td><font style="font-weight:bold">货物尺寸</font></td>
      <td ><font style="font-weight:bold">货物型号</font></td>
      <td ><font style="font-weight:bold">货物条形码</font></td>
      <td ><font style="font-weight:bold">货物类型</font></td>
      <td><font style="font-weight:bold">备注</font></td>
      <td width="15%">操作</td>
    </tr>
    
      <%
           List list  = (List)request.getAttribute("glist");	
             for(Object obj : list){
                 GoodsBean u = (GoodsBean)obj;
             %>
           <tr onclick="location='../ModifyGoods.do?id=<%=u.getGid() %>'">
           		<td><%=u.getGid() %></td>
				<td><%=u.getGname() %></td>
            	<td><%=u.getGnumber() %></td>
            	<td><%=u.getGprice() %></td>
            	<td><%=u.getGsize() %></td>
            	<td><%=u.getGmodel() %></td>
            	<td><%=u.getGbarcode()%></td>
            	<td><%=u.getGclass() %></td>
            	<td><%=u.getGremark() %></td>
            	 <td><div class="button-group">
      <a class="button border-main" href="modifyGoods.do?id=<%=u.getGid() %>"><span class="icon-edit"></span> 修改</a>
      <a class="button border-red" href="delgoods.do?id=<%=u.getGid() %>" onclick="p_del()"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
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