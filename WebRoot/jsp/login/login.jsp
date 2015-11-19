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
<title>登陆</title>
<link rel="stylesheet" href="<%=basePath%>css/login.css" type="text/css" />
</head>
<body>
	<div id="container">
		<form method="post" action="<%=path%>/LoginController/login.do">
			<div class="login">每日一点登陆</div>
			<div class="username-text">用户名:</div>
			<div class="password-text">密码:</div>
			<div class="username-field">
				<input id="username" type="text" name="username" value="admin" />
			</div>
			<div class="password-field">
				<input type="password" id="password" name="password" value="admin" />
			</div>
			<input type="checkbox" name="remember-me" id="remember-me" /><label
				for="remember-me">记住我一周</label>
			<div class="forgot-usr-pwd">
				 <a href="#">忘记密码</a>  &nbsp; &nbsp;<a href="#">新用户注册</a>
			</div>
			
			<input  type="submit"  name="submit" value="登陆" />
		</form>
	</div>
	<div id="footer">Copyright &copy; 2015.JinXianDai Company All
		rights reserved.</div>
	<div style="display:none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</html>
