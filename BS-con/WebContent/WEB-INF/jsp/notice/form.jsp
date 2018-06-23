<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>发布通知</title>
	<link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>editor/kindeditor.js"></script>
	  
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>校园管理</li>
    <li>发布通知</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>发布通知</span></div>
    <form action="notice_addNotice" method="post">
	    <ul class="forminfo">
	   		<li><label><font color="#f00">*</font>文章标题</label><input name="notice.ntc_title" type="text" class="dfinput" /><i>标题不能超过16个字</i></li>
	    	<li>
	    		<label>文章内容</label>
	    		<textarea name="notice.ntc_content" rows="" cols="" class="textinput">
	    		</textarea>
	    	</li>
	    	<li><label>&nbsp;</label><input  type="button" onclick="this.form.submit();" class="btn" value="发布"/></li>
	    </ul>
    </form>
    </div>


</body>
</html>
