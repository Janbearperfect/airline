<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="airsystem.entity.Airport"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>航班查询</title>
    <link rel="stylesheet" href="/airline/assets/css/base.css">
    <link rel="stylesheet" href="/airline/assets/css/pay.css">
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
        <div class="main-select-zst">查看并付款</div>
    </div>
    <div class="main-info-yzy">
        <div class="main-left">
            <div class="left-pay">
                <h2>您希望以什么方式支付行程费用？</h2>
                <div class="pay">
                    <ul>
                        <li><input type="radio" name="method"><img src="/airline/assets/img/card-alipay.png" alt="" width="113" height="30"></li>
                        <li><input type="radio" name="method"><img src="/airline/assets/img/UnionPay_logo.png" alt="" width="47.5" height="30"></li>
                        <li><input type="radio" name="method"><span class="CDcard">信用卡</span></li>
                    </ul>
                </div>
            </div>
            <div class="wrapper-yzy"></div>
            <div class="packge-yzy">
                <h2>行李</h2>
                <div class="baggage-title">${fromcity}到${tocity}</div>
                <div class="separateor-yzy">
                    <div>
                        <div class="tourism">旅客</div>
                        <div class="baggage-yzy">托运行李</div>
                        <div class="small-bappage-yzy">随身携带行李</div>
                    </div>
                    <div class="baggage-info-main">
                        <div class="tourism-info"><span>Adults and children</span></div>
                        <div class="baggage-info">
                            <p>托运行李,2免费</p>
                            <p>第一件行李:免费(最大为50LB 23KG/62LI 158LCM)</p>
                            <p>第二件行李:免费(最大为50LB 23KG/62LI 158LCM)</p>
                        </div>
                        <div class="small-bappage-info">
                            <div>随身携带行李,2 免费(随身行李 最大为40 LI 101LCM 或 随身行李 最大为 45 LI 115LCM)</div>
                            <div>随身携带行李,2 免费(随身行李 最大为40 LI 101LCM 或 随身行李 最大为 45 LI 115LCM)</div>
                        </div>
                    </div>
                </div>
                <p class="warnning" style="float: left">
                    费用适用于此预订中的每个人。AAdvantage 和 oneworld 精英乘客可获得额外的限额。 </p><a href="">行李</a>
            </div>
            <!--<div class="danger-policy">-->
                <!--<h3>危险品政策</h3>-->
                <!--<div class="danger-policy-content">-->
                    <!--气温或气压的变化可能会导致日常物品泄漏、产生有毒气体或引起飞机火灾。如果您带有危险物品，可能会被罚款或监禁。电子烟和锂电池须放入您的随身行李中。喷雾式上浆剂等物品禁止携带。起飞前，请务必了解危险品政策，特别是有关以下物品的内容：-->
                <!--</div>-->
                <!--<ul>-->
                    <!--<li></li>-->
                <!--</ul>-->
            <!--</div>-->
            <div class="wrapper-yzy"></div>
            <h1>网站使用协议</h1>
            <div class="cancel-refund">
                如您在距离出发日期至少两天以上出票，并且在出票后的24小时之内申请退票，您便可获得全额退款。
            </div>
            <div class="checkbox">
                <div class="top">
                    <p>补票*：允许但有限制 (*查看 <a href="">票件条件</a>）</p>
                    <p>退款：允许但有限制 (*查看 <a href="">票件条件</a>）</p>
                </div>
                <div class="center">
                    请注明您接受本网站的协议。
                </div>
                <div class="bottom">
                    <input type="checkbox" class="check">
                    <p>本人接受<a href="">网站协议</a>，并理解可能会收取<a href="">行李费</a></p>
                    <p>本人已阅读并接受 <a href="">危险品政策</a> 以及液体、喷雾器和凝胶的相关规定。</p>
                </div>
            </div>
        </div>
        <div class="main-right"></div>
    </div>
    <div class="wrapper-yzy last"></div>
    <div class="quickpay">
        <a href="saveTicket"><div class="paybutton"> <span class="payspan">立即支付</span></div></a>
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
    <script type="text/javascript" src="/airline/assets/js/pay.js"></script>
</body>
</html>