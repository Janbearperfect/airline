<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写信息</title>
<link rel="stylesheet" href="/airline/assets/css/buyticket.css">
<link rel="stylesheet" href="/airline/assets/css/base.css">
</head>
<body>
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
    <div class="ticket-main-zst">
        <div class="ticket-main-title-zst">
            <div class="ticket-main-title-first-zst"><span style="margin-left: 5px">选择航班</span></div>
            <ul>
                <li class="title-fare-zst">乘客</li>
                <li>查看并付款</li>
                <li>完成</li>
            </ul>
        </div>
        <div class="ticket-main-fare-zst">乘客</div>
        <div class="ticket-main-hint-zst">
            <div class="ticket-hint-zst">
                <span>请按照政府发行的带照片身份证上显示的姓名，输入所有乘客的姓名。</span>
                <a href="">隐私声明</a>
                <a href="">太原航空隐私政策</a>
            </div>
            <div class="ticket-main-write-zst">（必填）</div>
        </div>
        <div class="ticket-main-form-zst">
            <div class="form-title-zst">您的行程</div>
            <div class="form-type-zst">乘客</div>
            <div class="form-number-zst">
                <span>${numbers.adultNumber}</span>&nbsp;成人&nbsp;&nbsp;&nbsp;
                <span>${numbers.childNumber}</span>&nbsp;儿童&nbsp;&nbsp;&nbsp;
                <span>${numbers.badyNumber}</span> &nbsp;婴儿
            </div>
            <div class="form-info-zst">
                <ul>
                    <li></li>
                </ul>

            </div>
        </div>
        <div class="ticket-main-list-zst">
            <form action="pushTicket" id="form">
            <!--成人  -->
             	<c:forEach   begin="1" end="${numbers.adultNumber}" var="i" >
                <div>
                    <div class="main-people-zst" id="people">
                        <div class="list-first-zst" >
                            <div class="first-type-zst">
                                成人<input type="radio" name="type${i}" value="1" checked>
                                儿童<input type="radio" name="type${i}" value="2" >
                                婴儿<input type="radio" name="type${i}" value="3" >

                            </div>
                            <div class="first-name-zst">
                                姓名<input type="text" name="name" size="10" autocomplete="off" class="name-zst">
                            </div>
                               <div class="first-name-zst">
                                航班编号 <input type="text" name="flightId" size="10" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.flightNumber}">
                            </div>
                        </div>
                        <div class="list-two-zst">
                            <div class="first-card-zst">
                                <select name="uek" size="1">
                                    <option value="idcard" selected="selected">身份证</option>
                                    <option value="ui">护照</option>
                                    <option value="php">临时身份证</option>
                                </select>

                            </div>
                            <div class="first-id-zst">
                                证件号码<input type="text" name="ID" size="20" autocomplete="off" id="idcard">
                            </div>
                            <div class="first-classes-zst">
                                舱位等级<input type="text" name="classes" size="10" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.classes}">
                            </div>
                              <div class="first-price-zst">
                             	<input class="price" type="text" name="price" size="2" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.price}">
                            	<span>￥</span>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
               <!-- 儿童 -->
                 <c:forEach   begin="1" end="${numbers.childNumber}" var="i" >
                <div>
                    <div class="main-people-zst" id="people">
                        <div class="list-first-zst" >
                            <div class="first-type-zst">
                                成人<input type="radio" name="type${i+numbers.adultNumber}" value="1" >
                                儿童<input type="radio" name="type${i+numbers.adultNumber}" value="2" checked>
                                婴儿<input type="radio" name="type${i+numbers.adultNumber}" value="3" >

                            </div>
                            <div class="first-name-zst">
                                姓名<input type="text" name="name" size="10" autocomplete="off" class="name-zst">
                            </div>
                               <div class="first-name-zst">
                                航班编号 <input type="text" name="flightId" size="10" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.flightNumber}">
                            </div>
                        </div>
                        <div class="list-two-zst">
                            <div class="first-card-zst">
                                <select name="uek" size="1">
                                    <option value="idcard" selected="selected">身份证</option>
                                    <option value="ui">护照</option>
                                    <option value="php">临时身份证</option>
                                </select>

                            </div>
                            <div class="first-id-zst">
                                证件号码<input type="text" name="ID" size="20" autocomplete="off"  id="idcard">
                            </div>
                            <div class="first-classes-zst">
                                舱位等级<input type="text" name="classes" size="10" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.classes}">
                            </div>
                             <div class="first-price-zst">
                             	<input class="price" type="text" name="price" size="2" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.price*0.8}">
                            	<span>￥</span>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <!-- 婴儿 -->
                <c:forEach   begin="1" end="${numbers.badyNumber}" var="i" >
                <div>
                    <div class="main-people-zst" id="people">
                        <div class="list-first-zst" >
                            <div class="first-type-zst">
                                成人<input type="radio" name="type${i+numbers.adultNumber+numbers.childNumber}" value="1" >
                                儿童<input type="radio" name="type${i+numbers.adultNumber+numbers.childNumber}" value="2" >
                                婴儿<input type="radio" name="type${i+numbers.adultNumber+numbers.childNumber}" value="3" checked>
                            </div>
                            <div class="first-name-zst">
                                姓名<input type="text" name="name" size="10" autocomplete="off" class="name-zst">
                            </div>
                               <div class="first-name-zst">
                                航班编号 <input type="text" name="flightId" size="10" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.flightNumber}">
                            </div>
                        </div>
                        <div class="list-two-zst">
                            <div class="first-card-zst">
                                <select name="uek" size="1">
                                    <option value="idcard" selected="selected">身份证</option>
                                    <option value="ui">护照</option>
                                    <option value="php">临时身份证</option>
                                </select>

                            </div>
                            <div class="first-id-zst">
                                证件号码<input type="text" name="ID" size="20" autocomplete="off"  id="idcard">
                            </div>
                            <div class="first-classes-zst">
                                舱位等级<input type="text" name="classes" size="10" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.classes}">
                            </div>
							<div class="first-price-zst">
                             	<input class="price" type="text" name="price" size="2" autocomplete="off" class="name-zst" readonly="readonly" value="${numbers.price*0.5}">
                            	<span>￥</span>
                           </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <div class="list-button-zst">
                    <div style="float: right">
                        <input type="submit" value="提交" class="list-add-zst list-submit">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div style="clear:both"></div>

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
     <script src="/airline/assets/js/jquery.validate.js"></script>
    <script src="/airline/assets/js/buyticket.js"></script>
</body>
</html>