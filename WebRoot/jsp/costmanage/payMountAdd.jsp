<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ssm.util.DateUtil"%>
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
<script src="<%=basePath%>js/laydate/laydate.js"></script>
</head>


<body>


	<span href="#" class="button" id="toggle-add">记账</span>
	<div id="payAdd">
		<div id="triangle"></div>
		<h1>记账</h1>
		<form id="mountform" action="<%=path%>/costmanageController/save.do"
			method="post">
			<input type="number" id="mount" name="mount" placeholder="本日支出" />
			<div style="width:auto; margin:10px auto;">
				<span id="da">记账时间：</span><input id="date" name="date"
					class="laydate-icon" onclick="laydate()">
			</div>
			<input id="btn" name="btn" type="submit" value="确定" />
		</form>
	</div>
<input type="hidden" id="userId" value="${userId}"/>
</body>
<script type="text/javascript">
	$('#toggle-add').click(function() {
		$('#payAdd').toggle();
	});
</script>
<script>
	var txt = document.getElementById('mount');
	var btn = document.getElementById('btn');
	var reg = /^\d*$/;
	btn.onclick = function() {
		var val = txt.value;
		if (!reg.test(val)) {
			alert('只能输入数字!');
		}
		$("#mountform").submit();
	}
</script>
<script type="text/javascript">
$(function(){
var _a=$("#userId").val();
if(!_a){
alert("对不起，请登录！");
window.location.href="<%=basePath%>jsp/login/login.jsp";
}
});
</script>
</html>
