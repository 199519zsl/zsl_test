<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>信息管理系统界面</title>
	</head>
	<frameset rows="88,*" cols="*" frameborder="no" border="0"
		framespacing="0">
		<frame src="admin_top" name="topFrame" scrolling="No"
			noresize="noresize" id="topFrame" title="topFrame" />
		<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
			<frame src="admin_left" name="leftFrame" scrolling="No"
				noresize="noresize" id="leftFrame" title="leftFrame" />
			<frame src="admin_index" name="rightFrame" id="rightFrame"
				title="rightFrame" />
		</frameset>
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
</html>
