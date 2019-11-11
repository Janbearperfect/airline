<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="airsystem.entity.Airport"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航班管理</title>
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/flightview.css">
</head>
<body>
<div class="box">
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>航班编号</th>
			<th>头等舱剩余座位</th>
			<th>商务舱剩余座位</th>
			<th>经济舱剩余座位</th>
			<th>季节折扣</th>
			<th>价格</th>
			<th>操作</th>
		</tr>
	<c:forEach items="${flights}" var="flight">
			<tr id="${flight.flightId}">
				<td>${flight.flightId}</td>
				<td>${flight.flightNumber}</td>
				<td>${flight.firstClassRemainSeats}</td>
				<td>${flight.businessClassRemainSeats}</td>
				<td>${flight.economyClassRemainSeats}</td>
				<td>${flight.seasonDiscount}</td>
				<td>${flight.price}元</td>
				<td>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">编辑</button>	
					<button type="button" class="btn " data-toggle="modal" data-target=".bs-example-modal-sm">查看</button>	
				</td>
			<tr>
		</c:forEach>
	</table>
</div>
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    		<h3>修改折扣和价格</h3>
			<div class="formbox">
			  <form action="">
			       <input type="hidden" class="form-control flightId" id="exampleInputEmail1" >
			      <div class="form-group">
			   		<label for="exampleInputEmail1">季节折扣</label>
			    	<input type="text" class="form-control seasonDiscount" id="exampleInputEmail1" >
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">价格</label>
				    <input type="text" class="form-control price" id="exampleInputPassword1" >
				  </div>				  
				  <button type="submit" class="btn btn-success save">修改</button>
			  </form>
		  </div>
    </div>
  </div>
</div>
<script src="/airline/assets/js/jquery-1.9.1.js"></script>
<script src="/airline/assets/js/bootstrap.js"></script>
<script src="/airline/assets/js/flightview.js"></script>
</body>
</html>