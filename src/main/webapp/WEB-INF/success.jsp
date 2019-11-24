<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="airsystem.entity.Airport"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>航班查询</title>
    <link rel="stylesheet" href="/airline/assets/css/base.css">
    <link rel="stylesheet" href="/airline/assets/css/success.css">
</head>
<body>
    <!--导航栏-->
    <header>
        <div class="title-content-zst">
            <div class="title-header-zst">
                <a href="index.html">首页</a>
            </div>
            <div class="title-main-zst">
                <div class="title-name-zst">太原航空</div>
                <div class="title-classify-zst">旅行预订</div>
                <div class="title-classify-zst">旅行信息</div>
                <div class="title-classify-zst"></div>
            </div>
        </div>
    </header>
    <!--机票导航-->
    <div class="main-zst">
        <div class="main-title-zst">
            <div class="main-title-first-zst"><span style="margin-left: 5px">选择航班</span></div>
            <ul>
                <li>乘客</li>
                <li>查看并付款</li>
                <li>完成</li>
            </ul>
        </div>
    </div>
    <div class="main">
    	<h1>恭喜您！  购票成功！</h1>
    	<span><strong class="num">5</strong>秒后返回首页</span><br>
    	<a href="index">点击此处返回首页</a>
    </div>
<!--底部-->
    <div class="end-zst">
        <div class="end-content-zst">
            <div class="end-content-first-zst">
                <span>帮助</span>
                <div class="content-border-zst"></div>
                <ul>
                    <li>
                        <a href="#">客户关系</a>
                        <a href="#">联系我们</a>
                        <a href="#">收据于退款</a>
                        <a href="#">常见问题解答</a>
                        <a href="#">代理机构信息</a>
                        <a href="#">行李于可选服务费</a>
                        <a href="#">客户服务</a>
                        <a href="#">承运条款</a>
                    </li>


                </ul>
            </div>
            <div class="end-content-first-zst">
                <span>简介</span>
                <div class="content-border-zst"></div>
                <ul>
                    <li>
                        <a href="#">关于我们</a>
                        <a href="#">工作机会</a>
                        <a href="#">法律、隐私、版权</a>
                        <a href="#">浏览器兼容</a>
                        <a href="#">Web可访问行</a>
                    </li>


                </ul>
            </div>
            <div class="end-content-first-zst">
                <span>其他</span>
                <div class="content-border-zst"></div>
                <ul>
                    <li>
                    <a href="#">On Business</a>
                    </li>
                    <li>
                        <a href="#">货运</a>
                    </li>
                    <li>
                        <a href="#">其他</a>
                    </li>
                </ul>
            </div>
            <div class="bottom-border-zst"></div>
        </div>


    </div>
    <script src="/airline/assets/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="/airline/assets/js/success.js"></script>
</body>
</html>