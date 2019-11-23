<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航空计划表</title>
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/queryResult.css">
<link rel="stylesheet" href="/airline/assets/css/base.css">
</head>
<body>
<a href="queryflight" style="color:#333333">《 返回</a>
 <header>航班信息查询</header>
<div class="main-list-zst">
    <div class="main-list-title-zst">
        <span>排序依据</span>
        <ul>
            <li>头等舱</li>
            <li>商务务舱</li>
            <li>经济舱</li>
        </ul>
    </div>
    <div class="list">
        <ul>
        <c:forEach items="${queryflights}" var="queryflight">
            <li>
                <div class="list-name">东方航空
                    <span class="name-airplane">${queryflight.airplane}</span>
                    <div class="list-model">${queryflight.model}</div>
                </div>

                <div class="list-date">
                    <div class="date">
                        <span class="date-start">${queryflight.departureTime}</span>——<span class="date-end"> ${queryflight.arrivalTime}</span>
                    </div>
                    <div class="city">

                        <span class="date-from">${queryflight.fromCity}</span>——<span class="date-to">${queryflight.toCity}</span>
                    </div>
                </div>
                <div class="list-length">
                    <span class="length-number">${queryflight.sailLength}</span><span class="length-km">km</span>
                </div>

                <div class="list-first">
                    <div class="first-count">
                        剩余座位：<span>${queryflight.firstClassRemainSeats}</span>
                    </div>
                    <div class="first-price">${queryflight.price*queryflight.seasonDiscount*2}￥</div>
                </div>
                <div class="list-first">
                    <div class="first-count">
                        剩余座位：<span>${queryflight.businessClassRemainSeats}</span>
                    </div>
                    <div class="first-price">${queryflight.price*queryflight.seasonDiscount*1.5}￥</div>
                </div>
                <div class="list-first">
                    <div class="first-count">
                        剩余座位：<span>${queryflight.economyClassRemainSeats}</span>
                    </div>
                    <div class="first-price">${queryflight.price*queryflight.seasonDiscount}￥</div>
                </div>
                <div class="list-book"><button class="btn btn-info">预订</button></div>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>
    
     <script src="/airline/assets/js/jquery-1.9.1.js"></script>
    <script src="/airline/assets/js/bootstrap.js"></script>
    <script src="/airline/assets/js/queryflight.js"></script>
</body>
</html>