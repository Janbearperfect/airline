<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.io.*,java.util.*,java.sql.*,airsystem.entity.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>航班查询</title>
    
    <link rel="stylesheet" href="/airline/assets/css/flight.css">
    <link rel="stylesheet" href="/airline/assets/css/base.css">
    <style type="text/css">
    
    </style>
</head>
<body>
    <!--导航栏-->
    <header>
        <div class="title-content-zst">
            <div class="title-header-zst">
                <a href="index.html">首页</a>
            </div>
            <div class="title-main-zst">
           
                <div class="title-name-zst">太原航空<img  src="/airline/assets/img/airplane.jpg" ></div>
           
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
        <div class="main-select-zst">选择航班</div>
        <div class="main-info-zst">
            <span class="info-depart-zst">出发</span>
            <i class="info-place-zst">${flights[0].fromCity}</i>
            <span class="info-arrive-zst">到</span>
            <i class="info-place-zst">${flights[0].toCity}</i>
        </div>
        <div class="main-date-zst">
            <i class="date-year-zst">${dateyear}</i>
            <span>年</span>
            <i class="date-month-zst">${datemoth}</i>
            <span>月</span>
            <i class="date-day-zst">${dateday}</i>
            <span>日</span>
        </div>
        <div class="main-list-zst">
            <div class="main-list-title-zst">
                <span class="p-info" style=" cursor: pointer;">乘客</span>
                <ul>
                    <li class="title-hxt">经济舱</li>
                    <li class="title-hxt">商务舱</li>
                    
                    <li class="title-hxt">头等舱</li>
                </ul>
            </div>
            
            <!-- 隐藏 -->
             <div class="show-info-h">
             	<div style="font-size:20px;text-align:center;">信息</div><br>
             	<div style="margin:10px"><span style="font-size:20px;" id="baby"><%out.print(request.getAttribute("baby")); %></span>婴儿</div>
             	<div style="margin:10px"><span style="font-size:20px;" id="child"><%out.print(request.getAttribute("child")); %></span>儿童</div>
             	<div style="margin:10px"><span style="font-size:20px;" id="adult"><%out.print(request.getAttribute("adult")); %></span>成人</div>
             </div>
             
             
            <div class="hidden-htx" style="display:none">
            <div class="priceSpan-hxt">票价比较</div>
            <div class="hidden-c-hxt">
            <div class="hidden-c-l">
	            <div class="l-1">主舱（经济舱）</div>
                <ul class="l-2">
                    <li class="a">付费托运行李</li>
                    <li class="a">选择座位（可能需要付费）</li>
                    <li class="a">有资格在美国航空航班上升舱</li>
                    <li class="a">允许改签（需要付费）</li>
                    <li class="a">正常登机</li>
                </ul>
            </div>
            
            <div class="hidden-c-r">
              <div class="r-1">头等舱</div>
                <ul class="r-2">
                    <li class="b">座位最大、最舒适</li>
                    <li class="b">免费托运 2 件行李*</li>
                    <li class="b">优先办理安检和登机</li>
                    <li class="b">允许改签当日航班和候补航班（只要美国航空航班上有座位）</li>
                    <li class="b-1"><span class="b-span">*如果您是 AAdvantage Executive Platinum（行政白金卡）会员，或乘坐三舱位机型，可额外托运 1 件行李</span></li>
                </ul>
             </div>
         
            </div>
            </div>
           
         
                  <!-- 航班部分 -->
                  <c:forEach items="${flights}" var="flight">
	            <div class="planeinfo">
		            <div class="info-left-hxt">
		            	<div><span class="hxt-s">${fn:substring(flight.departureTime,10,16)}---->${fn:substring(flight.arrivalTime,10,16)}</span></div>
		            	<div class="hxt-ss">
		            	    <span>(${fromCity})</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		            	    <span>(${toCity})</span><br><br><br><br>
		            		<span >航班编号:${flight.flightNumber}</span><br><br>
		            		<span>型号:${flight.airplane}</span><br><br>
		            		<span>到达日期:${date}</span>
		            	</div>
		            	    <input type='hidden' name='ticketId' class="ticketId" value="${ticketId}">
		            </div>
		            <div class="in-right-hxt" attr="${flight.flightNumber}">
		            <div class="info-right-hxt" attr="经济舱" style="margin-left:75px;"><span class="hxt-s-1">${flight.price}</span></div>
		            <div class="info-right-hxt" attr="商务舱"><span class="hxt-s-1">${flight.price*1.5}</span></div>
		            <div class="info-right-hxt" attr="头等舱"><span class="hxt-s-1">${flight.price*2}</span></div>
		            </div>
	             </div>
	             </c:forEach>
         <button  class="confirm">确定</button>
    </div>
       
   
       
<!--底部-->
    <div class="end-zst" style="float:left;">
    
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
<script src="/airline/assets/js/flightHtx.js"></script>
<script type="text/javascript" src="/airline/assets/js/againchooseflight.js"></script>
</html>