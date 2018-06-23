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
<link rel="stylesheet" href="<%=basePath%>/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>/css/admin.css">
<script src="<%=basePath%>/js/jquery.js"></script>
<script src="<%=basePath%>/js/pintuer.js"></script>
</head>
<body>

<div class="panel admin-panel">
  
  <div class="padding border-bottom">  
  
  <form  action="<%=basePath%>/InHouse.do?method=query" method="post"> 
    <input type="text" style="width:200px; " class="input w50" name="gcompany" size="50" placeholder="请输入名称"  />&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="submit" class="button border-yellow" style="width:110px" ><span class="icon-plus-square-o"></span> 查询</button>  
  <button type="button" style="width:110px; " class="button border-yellow" 
  onclick="window.showModalDialog('<%=basePath %>/goods/addGoods.jsp',window,'dialogWidth:900px;dialogHeight:400px;dialogLeft:200px;dialogTop:200')">
  <span class="icon-plus-square-o"></span> 添加货物</button>
  </form>
  </div>
  <table class="table">
  <div class="panel-head"><strong class="icon-reorder"> 待入库货物列表</strong></div>
    <tr>
      <td ><font style="font-weight:bold">货物编号</font></td>
      <td ><font style="font-weight:bold">货物名称</font></td>      
        <td><font style="font-weight:bold">货物价格</font></td>
          <td><font style="font-weight:bold">货物尺寸</font></td>
      <td ><font style="font-weight:bold">货物型号</font></td>
      <td ><font style="font-weight:bold">货物条形码</font></td>
      <td ><font style="font-weight:bold">货物类型</font></td>
      <td><font style="font-weight:bold">备注</font></td>
      <td><font style="font-weight:bold">货物数量</font></td>
      
      <td width="20%">操作</td>
    </tr>
    
      <%
      String inlistcode=(String) request.getSession().getAttribute("inlistcode");
      if(null==inlistcode){
      inlistcode="";
      }
      List glist= (List) request.getAttribute("goodslist");
      if(null== glist){
      glist = new ArrayList();
      }
             for(Object obj : glist){
                 GoodsBean u = (GoodsBean)obj;
             %>
          <form id="<%=u.getGid() %>" action="<%=basePath%>//InHouse.do?method=add&id=<%=u.getGid() %>" method="post">   
           <tr>
           		<td><%=u.getGid() %></td>
				<td><%=u.getGname() %></td>
            	
            	<td><%=u.getGprice() %></td>
            	<td><%=u.getGsize() %></td>
            	<td><%=u.getGmodel() %></td>
            	<td><%=u.getGbarcode()%></td>
            	<td><%=u.getGclass() %></td>
            	<td><%=u.getGremark() %></td>
            	<td>
            	<div class="field">
	          <input type="text" style="width:100px;" class="input w50" id="gcount" name="gcount_<%=u.getGid() %>" size="50" placeholder="请输入数量" data-validate="required:请输入数量" />       
	        </div>
            	</td>
            	 <td><div class="button-group">
            	 <button class="button bg-main icon-check-square-o" type="submit">添加到入库列表</button>
      </div></td>
            </tr>
            </form>
          <%} %>
   
  </table>
  <hr style="border:3px double green;width:100%;height:3px" />
  
  <table class="table">
  <div class="panel-head"><strong class="icon-reorder"> 已选入库货物列表</strong>>>>>>>>入库单号(系统自动产生):<%= inlistcode%></div>
    <tr>
      <td ><font style="font-weight:bold">货物编号</font></td>
      <td ><font style="font-weight:bold">货物名称</font></td>      
      <td><font style="font-weight:bold">货物价格</font></td>
      <td><font style="font-weight:bold">货物尺寸</font></td>
      <td ><font style="font-weight:bold">货物型号</font></td>
      <td ><font style="font-weight:bold">货物条形码</font></td>
      <td ><font style="font-weight:bold">货物类型</font></td>
      <td><font style="font-weight:bold">备注</font></td>
      <td><font style="font-weight:bold">货物数量</font></td>
      <td width="20%">操作</td>
    </tr>
    
      <%
      List templist= (List) request.getSession().getAttribute("templist");
      if (null!=templist){
      List list2 = templist;
      
             for(Object obj : list2){
                 GoodsBean u2 = (GoodsBean)obj;
             %>
           <form action="<%=basePath%>/InHouse.do?method=modify&id=<%=u2.getGid() %>" method="post">
           <tr >
           		<td><%=u2.getGid() %></td>
				<td><%=u2.getGname() %></td>
            	<td><%=u2.getGprice() %></td>
            	<td><%=u2.getGsize() %></td>
            	<td><%=u2.getGmodel() %></td>
            	<td><%=u2.getGbarcode()%></td>
            	<td><%=u2.getGclass() %></td>
            	<td><%=u2.getGremark() %></td>
            	<td>
            	<div class="field">
	          <input type="text" style="width:100px;" class="input w50" id="gtmpcount" name="gtmpcount_<%=u2.getGid() %>" value =<%=u2.getGnumber() %>  size="50" placeholder="请输入数量" data-validate="required:请输入数量" />       
	        </div>
            	</td>
            	 <td><div class="button-group">
      <button class="button bg-main icon-check-square-o" type="submit">修改</button>
      <a class="button border-red" href="<%=basePath%>/InHouse.do?method=del&id=<%=u2.getGid() %>" onclick="p_del()"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
            </tr>
            </form>

          <%}} %>
   
  </table>
  <form action="<%=basePath%>/InHouse.do?method=conform" method="post">
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 确定入库</button>&nbsp; &nbsp;         
        </div>
        
      </div>  

        </form>
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