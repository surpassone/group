<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>每日一点项目进程</title>
<link href="<%=basePath%>css/timeline.css" rel="stylesheet" type="text/css" />
  </head>
  
 <div class="content">
  <div class="wrapper">
    <div class="light"><i></i></div>
    <hr class="line-left">
    <hr class="line-right">
    <div class="main">
      <h1 class="title">每日一点项目日志</h1>
      <div class="year">
        <h2><a href="#">2015年<i></i></a></h2>
        <div class="list">
          <ul>
           <li class="cls highlight">
              <p class="date">11月19日</p>
              <p class="intro">成本管理模块的雏形</p>
              <p class="version">&nbsp;</p>
              <div class="more">
                <p>登陆模块：每个页面要判断当前用户是否登陆</p>
                <p>加入防止跨域录入的过滤器</p>
                <p>表单验证还不完善</p>
                <p>接下来：完成注册模块，表单验证、基础业务模块</p>
              </div>
            </li>
            <li class="cls highlight">
              <p class="date">11月15日</p>
              <p class="intro">项目框架搭建</p>
              <p class="version">&nbsp;</p>
              <div class="more">
                <p>采用springMVC框架</p>
                <p>封装JDBC方法</p>
                <p>Mysql数据库</p>
              </div>
            </li>
           
<!--             <li class="cls"> -->
<!--               <p class="date">3月12日</p> -->
<!--               <p class="intro">首家支持微信支付，多客服系统上线！</p> -->
<!--               <p class="version">&nbsp;</p> -->
<!--               <div class="more"> -->
<!--                 <p>为公众账号的微信支付提供技术接入，通过简单配置即可使用微信支付</p> -->
<!--                 <p>微信公众平台高级接口支持，通过认证的服务号可以使用多客服系统回复粉丝</p> -->
<!--                 <p>微商城首页添加多套模板，详情页支持模板自定义，商城购买商品支持微信支付；商城首页图片自适应等等十多个细节改进</p> -->
<!--               </div> -->
<!--             </li> -->
            
            <li class="cls highlight">
              <p class="date">10月</p>
              <p class="intro">项目讨论</p>
              <p class="version">&nbsp;</p>
              <div class="more">
                <p>确立开发模式</p>
                <p>讨论开发需求</p>
              </div>
            </li>
          </ul>
        </div>
      </div>
      
<!--       <div class="year"> -->
<!--         <h2><a href="#">2012年<i></i></a></h2> -->
<!--         <div class="list"> -->
<!--           <ul> -->
<!--             <li class="cls"> -->
<!--               <p class="date">8月</p> -->
<!--               <p class="intro">顿悟</p> -->
<!--               <p class="version">&nbsp;</p> -->
<!--               <div class="more"> -->
<!--                 <p>顿悟，微信公众平台是企业移动互联网化的入口</p> -->
<!--               </div> -->
<!--             </li> -->
<!--             <li class="cls"> -->
<!--               <p class="date">8月以前</p> -->
<!--               <p class="intro">实现一个NB的社会化APP</p> -->
<!--               <p class="version">&nbsp;</p> -->
<!--             </li> -->
<!--           </ul> -->
<!--         </div> -->
<!--       </div> -->
      <div class="year">
        <h2><a href="#">以前<i></i></a></h2>
        <div class="list">
          <ul>
            <li class="cls">
              <p class="date">&nbsp;</p>
              <p class="intro">适用浏览器：IE8、360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗.</p>
              <p class="version">&nbsp;</p>
              <div class="more">
                <p></p>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="<%=basePath%>js/jquery.js"></script>
<script>
	$(".main .year .list").each(function (e, target) {
	    var $target=  $(target),
	        $ul = $target.find("ul");
	    $target.height($ul.outerHeight()), $ul.css("position", "absolute");
	}); 
	$(".main .year>h2>a").click(function (e) {
	    e.preventDefault();
	    $(this).parents(".year").toggleClass("close");
	});
	</script>
</body>
  </body>
</html>
