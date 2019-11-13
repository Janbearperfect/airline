<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/airline/assets/css/base.css">
    <link rel="stylesheet" href="/airline/assets/css/index.css">
    <link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
  
  
</head>
<body>
<!--头部信息-->
<header>
    <div class="container-xj">
        <div class="header-row-xj">
            <a href="" class="header-row-a-xj">
                <span class="header-row-login-xj">登录</span>
            </a>
            <a href="header-row-a-xj">
                <span class="header-row-register-xj">注册</span>
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
<!--主要信息-->
<main>
    <div class="main-img-box-xj">
        <div class="main-img-container-xj">
            <div class="img-container-xj"></div>
            <div class="img-container-xj"></div>

        </div>
    </div>
    <div class="search-xj">
        <div class="search-header-xj">
            <div class="search-header-li-xj">
                <span>查找航班</span>
            </div>
            <div class="search-header-li-xj">
                <span>我的行程</span>
            </div>
            <div class="search-header-li-xj">
                <span>航班状况</span>
            </div>
        </div>
        <div class="search-bottom-box-xj">
             <div class="search-bottom-xj" >
                 <div class="oneWay-xj">单程</div>
                 <form action="commitChooseView">

                     <div class="form-group type-xj" style="margin-bottom: 30px;margin-left: 10px">
                         <label for="exampleInputName2">从</label>
                         <input type="text" class="form-control" id="exampleInputName2" placeholder="城市或机场" name="fromCity">
                     </div>

                     <div class="form-group type-xj" style="margin-bottom: 30px">
                         <label for="exampleInputEmail2">前往</label>
                         <input type="text" class="form-control" id="exampleInputEmail2" placeholder="城市或机场" name="toCity">
                     </div>

                     <div class="form-group type-xj" style="margin-bottom: 30px">
                         <label for="exampleInputEmail2">成人（12+）</label>
                         <select class="form-control" name="adult">
                             <option>1</option>
                             <option>2</option>
                             <option>3</option>
                             <option>4</option>
                             <option>5</option>
                         </select>
                     </div>

                     <div class="form-group type-xj" style="margin-bottom: 30px;margin-left: 10px">
                         <label for="exampleInputName2">出发日期</label>
                         <input type="date" class="form-control" id="exampleInputName4"  name="goDate">
                     </div>

                     <div class="form-group type-xj" style="margin-bottom: 30px">
                         <label for="exampleInputEmail2">婴儿（1-24月）</label>
                         <select class="form-control" name ="baby">
                             <option>0</option>
                             <option>1</option>
                             <option>2</option>
                             <option>3</option>
                             <option>4</option>

                         </select>
                     </div>

                     <div class="form-group type-xj" style="margin-bottom: 30px">
                         <label for="exampleInputEmail2">儿童（2-11）</label>
                         <select class="form-control" name="child">
                             <option>0</option>
                             <option>1</option>
                             <option>2</option>
                             <option>3</option>
                             <option>4</option>
                         </select>
                     </div>
                     <button type="submit" class="btn btn-info button-search">搜索</button>
                 </form>
             </div>
             <div class="search-bottom-xj">
                 <h3 class="search-book-xj">确认预定</h3>
                 <form action="">
                     <div class="form-group type-xj" style="margin:20px 0 30px 50px">
                         <label for="exampleInputName2">乘客名字</label>
                         <input type="text" class="form-control" id="exampleInputName1" placeholder="城市或机场">
                     </div>

                     <div class="form-group type-xj" style="margin:20px 0 30px 30px">
                         <label for="exampleInputEmail2">身份证号码</label>
                         <input type="text" class="form-control" id="exampleInputEmail4" placeholder="城市或机场">
                     </div>
                     <button type="submit" class="btn button-book">查找预定</button>

                 </form>
             </div>
             <div class="search-bottom-xj">
                 <form action="">
                     <div class="form-group type-xj" style="margin:20px 0 30px 50px">
                         <label for="exampleInputName2">从</label>
                         <input type="text" class="form-control" id="exampleInputName3" placeholder="城市或机场">
                     </div>

                     <div class="form-group type-xj" style="margin:20px 0 30px 30px">
                         <label for="exampleInputEmail2">前往</label>
                         <input type="text" class="form-control" id="exampleInputEmail5" placeholder="城市或机场">
                     </div>
                     <div class="form-group type-xj" style="margin-top: 17px;margin-left: 20px">
                         <label for="exampleInputName2">日期</label>
                         <input type="date" class="form-control" id="exampleInputName5" >
                     </div>
                     <button type="submit" class="btn button-book">查找航班</button>

                 </form>
             </div>
        </div>
    </div>
</main>
<!--新闻特惠-->
<section class="section-one-xj">
    <div class="section-feature-xj">
        <h2 class="section-news-xj">新闻与特惠</h2>
        <ul class="section-line-xj">
            <li>通过国泰航空在线预定奖励航行》</li>
            <li>基础经济舱行李变更</li>
            <li>前往墨西哥和南美洲的全新航线</li>
        </ul>
    </div>
    <div class="section-feature-xj">
        <h3 class="section-plan-xj">加入AAdvantage计划</h3>
        <div class="section-img1-xj">
            <img src="/airline/assets/img/section1.jpg" alt="" width="150" height="90">
        </div>
        <span class="section-text1-xj">将里程变为美好回忆</span>
        <span class="section-text2-xj">立即加入</span>
    </div>
    <div class="section-feature-xj">
        <h3 class="section-wait-xj">世界在等待</h3>
        <div class="section-img2-xj">
            <img src="/airline/assets/img/section2.jpg" alt="" width="150" height="100">
        </div>

        <span class="section-text3-xj">前往全球1,000多个目的地</span>
        <span class="section-text4-xj">oneworld</span>
    </div>
</section>
<section class="section-two-xj">
    <h2>体验美国航空</h2>
    <div class="section2-feature-xj">
        <div class="section2-img-xj">
            <img src="/airline/assets/img/section3.jpg" alt="">
        </div>
        <h3 class="section2-line-xj">探索更多从亚洲出发的航线</h3>
        <span class="/airline/assets/section2-text1-xj">现在即可在AAdvantage®新伙伴中国南方航空赚取和兑换里程</span>
    </div>
    <div class="section2-feature-xj">
        <div class="section2-img-xj">
            <img src="/airline/assets/img/section4.jpg" alt="">
        </div>
        <h3 class="section2-line-xj">令您称心如意的服务</h3>
        <span class="section2-text1-xj">飞行途中享受直播电视、高速 Wi-Fi 等机舱服务</span>
    </div>
    <div class="section2-feature-xj">
        <div class="section2-img-xj">
            <img src="/airline/assets/img/section5.jpg" alt="">
        </div>
        <h3 class="section2-line-xj">On Business</h3>
        <span class="section2-text1-xj">优化您的差旅预算</span>
    </div>
</section>
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
</body>
<script type="text/javascript" src="/airline/assets/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/airline/assets/js/index.js"></script>
</html>