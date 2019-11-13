<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="airsystem.util.*,airsystem.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/dailyfinancial.css">
<title>每日财报</title>
</head>
<body>
<div id="viewone" ></div>
<div id="viewtwo" ></div>
 <div class="container">
 <table class="table table-bordered">
		 <tr>
		     <th>成人票</th>		     
		     <th>儿童票</th>
		     <th>婴儿票</th>
		     <th>总计</th>
		    
		 </tr>
		  <tr>
		 <c:forEach items="${type}" var="type">
		    
		          <td>${type.price}元</td>
		        
		          	     
		      </c:forEach>
		        <td>${num}元</td> 
		      </tr>
</table>
  <div class="container mark-two" style="margin-left:-15px">
 <table class="table table-bordered">
		 <tr>
		     <th>头等舱</th>		     
		     <th>商务舱</th>
		     <th>经济舱</th>
		     <th>总计</th>
		    
		 </tr>
		  <tr>
		 <c:forEach items="${classes}" var="classes">
		    
		          <td>${classes.price}元</td>
		          	     
		      </c:forEach>
		       <td>${num}元</td> 
		      </tr>
</table> 
		 
</body>
<script src="/airline/assets/js/jquery-1.9.1.js"></script>

<script src="http://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.highcharts.com.cn/highcharts/modules/exporting.js"></script>
<script src="/airline/assets/js/dailyfinancial.js"></script>


</html>