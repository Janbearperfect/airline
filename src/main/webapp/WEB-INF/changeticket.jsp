<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="airsystem.util.*,airsystem.entity.TicketBo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/airline/assets/js/ticket.js"></script>
<link rel="stylesheet" href="/airline/assets/css/ticket.css">
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<title></title>
</head>
<body>
 <div class="container">
 <table class="table table-bordered">
		 <tr>
		     <th>航班号</th>
		     <th>订票人</th>
		     <th>订票日期</th>
		     <th>仓位等级</th>
		     <th>乘客类型</th>
		     <th>票价</th>
		 </tr>
		 
		 <c:forEach items="${ticket}" var="ticket">
		     <tr>
		          <td>${ticket.flightNumber}</td>
		          <td>${ticket.name}</td>
		          <td>${ticket.orderDate}</td>
		        
		          <td>
		                <c:if test="${ticket.classes==1}">头等舱</c:if>
		                <c:if test="${ticket.classes==2}">公务舱</c:if>
		                <c:if test="${ticket.classes==3}">经济舱</c:if>
		          </td>
		          <td>
		                 <c:if test="${ticket.passengerType==1}">成人票</c:if>
		                <c:if test="${ticket.passengerType==2}">儿童票</c:if>
		                <c:if test="${ticket.passengerType==3}">婴儿票</c:if>
		          </td>
		          <td>${ticket.tPrice}元</td>		     
		     </tr>
		      </c:forEach>
</table>		     
		
         
      
 
 
 </table>
 
 </div> 



</body>
</html>