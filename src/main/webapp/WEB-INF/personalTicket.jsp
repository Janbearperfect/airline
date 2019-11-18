<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,airsystem.entity.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>票务查询</title>
    <link rel="stylesheet" href="/airline/assets/css/personalTicket.css">
    <link rel="stylesheet" href="/airline/assets/css/base.css">
    <link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
</head>
<body>
  <!--头部-->
    <!--头部信息-->
    <header>
        <div class="container-xj">
            <div class="header-row-xj">
                <div class="name-zst">赵胜涛</div>
                <a href="index" class="header-row-a-xj">
                    首页
                </a>
            </div>
            <div class="header-main-xj">
                <h1>
                    <a href="javascript:;">
                        <img src="/airline/assets/img/aa-logo.png" alt="" width="321px" height="50px">
                    </a>
                </h1>
                <ul>
                    <li>旅行预定</li>
                    <li>旅行信息</li>
                    <li>AAdvatage</li>
                </ul>
                <a href="javascript:;" class="header-main-logo-xj">
                    <img src="/airline/assets/img/oneworld.png" alt="">
                </a>

            </div>
        </div>
    </header>
    <!--内容-->
    <div class="ticketInfo-zst">
        <div class="ticketInfo-title">
            <div class="title-name" style="background: #75b1d0d6"><a href="#" style="text-decoration: none">您的行程</a></div>
            <div class="title-name"><a href="#" style="text-decoration: none">往期行程</a></div>
        </div>
        <div class="ticketInfo-list">
        	<input type="hidden" name="IdNumber" value="${IdNumber}" class="IdNumber">	
        </div>
        <div class="ticketInfo-list" style="display: none">

        </div>

    </div>

    <!--底部-->
    <div style="clear: both"></div>
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
</body>
<script src="/airline/assets/js/jquery-1.9.1.js"></script>
<script src="/airline/assets/js/personalTicket.js"></script>
</html>