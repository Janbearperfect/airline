<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--  <%@ include file="../check.jsp" %>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>航空售票系统</title>
 <link rel="stylesheet" href="/airline/assets/layui/css/layui.css">
 <script type="text/javascript" src="/airline/assets/js/jquery-1.9.1.js"></script>
 <script src="/airline/assets/layui/layui.js"></script>
  <script src="/airline/assets/js/main.js"></script>
 <script>
layui.use('element', function(){
  var element = layui.element;
});
</script> 
<%
String type="";
  try{
type=session.getAttribute("type").toString();
}catch(Exception e){
	response.sendRedirect("managerLogin");
}  
  
%>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
  	<% if(type.equals("1")){ %>
    <div class="layui-logo">航空后台管理系统</div>
    <%}else if(type.equals("3")){ %>
    <div class="layui-logo">航空售票系统</div>

    <%}else if(type.equals("2")){ %>
    <div class="layui-logo">航空管理系统</div>
    <%} %> 
    
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">用户</a></li>
<!--       <li class="layui-nav-item"><a href="">控制台</a></li> -->
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="" target="aaa" >邮件管理</a></dd>
          <dd><a href="" target="aaa" >消息管理</a></dd>
          <dd><a href="" target="aaa" >授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
     <li class="layui-nav-item"><a href="">消息</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;" >
         <!--  <img src="http://t.cn/RCzsdCq" class="layui-nav-img"> -->
          <i class="username"></i>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="../Index/safe.jsp" target="aaa">修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item loginout"><a href="#">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item">
          <a class="" href="javascript:;">基本设置</a>
          <dl class="layui-nav-child">
            <% if(type.equals("2")){ %>
            <dd><a href="javascript:;">个人信息</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="javascript:;">列表三</a></dd>
            <%} else if(type.equals("1")){ %>
             <dd><a href="../basic/basic.jsp" target="aaa">个人信息</a></dd>
             <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="javascript:;">列表三</a></dd>
            <%} %>
          </dl>
        </li>
         <%if(type.equals("1")){ %>
         <li class="layui-nav-item">
          <a href="javascript:;"  >信息管理</a>
          <dl class="layui-nav-child">
            <dd><a href="airport" target="aaa" >机场管理</a></dd>
            <dd><a href="users" target="aaa" >用户管理</a></dd>
            <dd><a href="branch" target="aaa" >营业点管理</a></dd>
            <dd><a href="sales" target="aaa" >营业员管理</a></dd>
              <dd><a href="airplaneModel" target="aaa" >机务管理</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;"  >票务管理</a>
          <dl class="layui-nav-child">
            <dd><a href="selljknticket/1" target="aaa" >已售机票</a></dd>
            <dd><a href="changeticket" target="aaa" >改签机票</a></dd>
            <dd><a href="refundticket" target="aaa" >退订机票</a></dd>
          </dl>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;"  >航班管理</a>
          <dl class="layui-nav-child">
          <dd><a href="planflight" target="aaa" >航班计划</a></dd>
            <dd><a href="timeflight" target="aaa" >实时航班</a></dd>
            <dd><a href="pastflight" target="aaa" >往期航班</a></dd>
            <dd><a href="flight/flightview" target="aaa" >航班状况</a></dd>
             <dd><a href="queryflight" target="aaa" >航班查询</a></dd>
          </dl>
        </li>
		<li class="layui-nav-item">
          <a href="javascript:;">财务管理</a>
          <dl class="layui-nav-child">
            <dd><a href="dailyfinancial"  target="aaa">每日财报</a></dd>
            <dd><a href="quarterfinancial"  target="aaa">季度财报</a></dd>
            <dd><a href="yearlyfinancial"  target="aaa">年度财报</a></dd>
          </dl>
        </li>
         
        <%}else if(type.equals("3")){ %>
         <li class="layui-nav-item">
          <a href="javascript:;"  >票务管理</a>
          <dl class="layui-nav-child">
            <dd><a href="queryflight" target="aaa" >航班查询</a></dd>
            <dd><a href="salesqueryuser" target="aaa" >个人信息查询</a></dd>
          </dl>
        </li>
     <%}else if(type.equals("2")){ %>
       <li class="layui-nav-item">
          <a href="javascript:;"  >信息管理</a>
          <dl class="layui-nav-child">
            <dd><a href="sales" target="aaa" >营业员管理</a></dd>
            <dd><a href="planflight" target="aaa" >航班计划</a></dd>
            <dd><a href="queryflight" target="aaa" >航班查询</a></dd>
          </dl>
        </li>
       <li class="layui-nav-item">
          <a href="javascript:;"  >票务管理</a>
          <dl class="layui-nav-child">
            <dd><a href="selljknticket/1" target="aaa" >已售机票</a></dd>
            <dd><a href="changeticket" target="aaa" >改签机票</a></dd>
            <dd><a href="refundticket" target="aaa" >退订机票</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">财务管理</a>
          <dl class="layui-nav-child">
            <dd><a href="dailyfinancial"  target="aaa">每日财报</a></dd>
            <dd><a href="quarterfinancial"  target="aaa">季度财报</a></dd>
            <dd><a href="yearlyfinancial"  target="aaa">年度财报</a></dd>
          </dl>
        </li>
     <%} %>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
			<iframe src="javascript:;" frameborder="0" name="aaa" style="width:100%; height:100%">
			</iframe>
  </div>
  
<div class="layui-footer">
    © uek.com - 底部固定区域
  </div> 
</div>
</body>
</html>
  

  
