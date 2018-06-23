<%@ page language="java" import="java.util.*,java.util.List,com.product.bean.UserBean,com.product.dao.UserDao;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong></div>
  <div class="padding border-bottom">  
  <button type="button" class="button border-yellow" onclick="location='user/addUser.jsp'"><span class="icon-plus-square-o"></span> 添加用户</button>
    <br/>         
  <br/>
 <form  action="<%=basePath %>UserServlet.do" method="post"> 
    <input type="text" style="width:200px; " class="input w50" name="cucomplany" size="50" placeholder="请输入用户名"  />&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="submit" class="button border-yellow" style="width:110px" ><span class="icon-plus-square-o"></span> 查询</button>  
 </form>
  </div>
   <% 
   //UserDao ud = new UserDao();
		//List list = ud.findAll();
		List list  = (List)request.getAttribute("cus");	 
   %>

  <table class="table table-hover text-center">
    <tr>
      <th width="10%">ID</th>
      <th width="15%">用户名</th>
      <th width="15%">密码</th>
      <th width="15%">用户身份</th>
      <th width="15%">操作</th>
    </tr>
  <%for(Object obj : list) 
    {
    	UserBean ub=(UserBean)obj;
    	
    %>
           <tr onclick="location='<%=basePath %>/Modifyuser.do?id=<%=ub.getId()  %>'">
           		<td><%=ub.getId() %></td>
				<td><%=ub.getUsername() %></td>
            	<td><%=ub.getPwd() %></td>
            	<td><%=ub.getUsertype() %></td>
        	   <td><div class="button-group">
                     <a class="button border-main" href="<%=basePath %>/Modifyuser.do?id=<%=ub.getId()  %>" ><span class="icon-edit"></span> 修改</a>
                     <a class="button border-red" href="<%=basePath %>/deleteUserServlet.do?id=<%=ub.getId() %>" onclick="javascript:p_del()"><span class="icon-trash-o"></span> 删除</a>
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