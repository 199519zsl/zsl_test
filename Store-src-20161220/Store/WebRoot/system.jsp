<%@ page language="java" import="java.util.*,com.product.bean.SystemBean,com.product.dao.SystemDao; " pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'system.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >
   <% 
        SystemDao ud = new SystemDao();
		List list = ud.findAll();

   %>
   <table class="table table-hover text-center">
    <%for(Object obj : list) 
    {
    	SystemBean ub=(SystemBean)obj;
    	
    %>
           <tr >
           		<td><%=ub.getParameter() %>
           		</td>
           		<br/>
            </tr>
            <tr >
           		<td><%=ub.getPvalue() %></td>
            </tr>
            <tr >
           		<td><%=ub.getParemark() %></td>
            </tr>
    <%} %> 
   
   
   
   
   </table>
    <div class="form-group">
        <div style="margin-left:200px">
         <img alt="" src="images/1.png" style="height:410px ;width:620px">
        </div>
       
      
</div>
  </body>
</html>
