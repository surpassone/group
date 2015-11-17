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

<title>增加今日账目</title>
<link rel="stylesheet" href="<%=basePath%>css/payadd.css" media="screen"
	type="text/css" />

<script src="<%=basePath%>js/jquery.js"></script>

</head>


<body>

	<span href="#" class="button" id="toggle-add">记账</span>

	<div id="payAdd">
		<div id="triangle"></div>
		<h1>记账</h1>
		<form action="<%=path%>/costmanageController/save.do" method="post">
			<input type="text" placeholder="本日支出" /> 
			<input type="submit"	value="确定" />
		</form>
	</div>

</body>
<script type="text/javascript">
	$('#toggle-add').click(function() {
		$('#payAdd').toggle();
	});
// 	alert("<%=path%>");
</script>
</html>
