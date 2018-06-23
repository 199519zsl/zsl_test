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
	
	<script type="text/javascript">
		function btn_return(){
			window.location.href = "notice_allNotices";
		}
	</script>
	
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>所有通知</li>
    <li>查看详细</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>通知</span></div>
    <form action="notice_deleteNotice?nid=${noticeInfo.ntc_id}" method="post">
	    <ul class="forminfo">
	   		<li><label>标题</label><input value="${noticeInfo.ntc_title}" readonly="readonly" type="text" class="dfinput" /></li>
	    	<li>
	    		<label>内容</label>
	    		<br/>
	    		<font style="font-size: 20px;" color="red">&nbsp;&nbsp;${noticeInfo.ntc_content}</font>
	    	</li>
	    	<li>&nbsp;</li>
	    	<li><div class="formtitle"></div></li>
	    	<li>
	    		<label>&nbsp;</label><input  type="button" onclick="btn_return()" class="btn" value="返回"/>
	    		<label>&nbsp;</label><input  type="button" onclick="this.form.submit();" class="btn" value="删除"/>
	    	</li>
	    </ul>
    </form>
    </div>

</body>
</html>
