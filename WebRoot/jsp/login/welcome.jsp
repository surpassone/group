<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>提示页面</title>

<!--- CSS --->
<link rel="stylesheet" href="<%=basePath%>css/login.css" type="text/css" />
<script src="<%=basePath%>js/jquery.js"></script>

</head>

<body>
	<div id="container">
		<div class="welcome">
			<div class="welcome-user">${tip}</div>
			<div class="welcome-text">${text}</div>
			<div id="homebtn" class="home">
				<a href="goIndex.do?userId=${bean.getId()}">去首页</a>
			</div>
			<input id="userId" type="hidden" value="${bean.getId()}" />
		</div>
	</div>
	<div id="footer">Copyright &copy; 2015.JinXianDai Company All
		rights reserved.</div>
</body>


<script type="text/javascript">
	$(function() {
		/**
		如果密码不正确则跳转返回开始登陆页面
		 */
		var _a = $('#userId').val();
		if (!_a) {
			$("#homebtn").children("a").text("返回");
			$("#homebtn").children("a").attr("href", "back.do");
		}
	});
</script>

</html>
