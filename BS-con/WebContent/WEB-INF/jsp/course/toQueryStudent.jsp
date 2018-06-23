<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>校园招聘</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/select-ui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>教学管理</li>
    <li>成绩录入/查询</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1">高级查询</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    <form action="course_toQueryStudent" method="post">
	    <ul class="seachform">
		    <li><label>请输入学号/姓名查询</label><input name="keywords" type="text" value="${keywords}" maxlength="20" class="scinput" /></li>
		    <li><label>&nbsp;</label><input type="button" class="scbtn" onclick="this.form.submit();" value="查询"/></li>
	    </ul>
    </form>
    
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th>序号<i class="sort"><img src="images/px.gif" /></i></th>
		        <th>学号</th>
		        <th>姓名</th>
		        <th>学院</th>
		        <th>专业</th>
		        <th>性别</th>
		        <th>操作</th>
	        </tr>
        </thead>
        
        <tbody>
        	<c:forEach items="${studentList}" var="obj" varStatus="sta">
		        <tr>
			        <td>${sta.index+1}</td>
			        <td>${obj.scard}</td>
			        <td>${obj.sname}</td>
			        <td>${obj.sadmy}</td>
			        <td>${obj.cname}</td>
			        <td>${obj.sex}</td>
			        <td><a href="course_queryMark?sid=${obj.sid}" class="tablelink"> 查询</a>&nbsp;&nbsp;&nbsp;<a href="course_addMark?sid=${obj.sid}" class="tablelink"> 成绩录入</a></td>
		        </tr>
	        </c:forEach> 
        </tbody>
    </table>
   <div class="pagin">
    	<div class="message">
    		共&nbsp;<i class="blue">${itemsCount}</i>&nbsp;条记录.
    	</div>
    </div>
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    </div>

</body>
</html>
