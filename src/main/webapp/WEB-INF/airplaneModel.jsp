<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/airplaneModel.css">
<style>

</style>
</head>
<body>
	<table class="table">
	<tr>
		<th>飞机编号</th>
		<th>机型</th>
		<th>最大航程</th>
		<th>头等舱座位数</th>
		<th>商务舱座位数</th>
		<th>经济舱座位数</th>
	</tr>
	<c:forEach items="${ams}" var="ams">
				<tr>
						<td>${ams.airplane}</td>				
						<td>${ams.model}</td>				
						<td>${ams.max_sail_length}</td>				
						<td>${ams.first_class_seats}</td>				
						<td>${ams.business_class_seats}</td>				
						<td>${ams.economy_class_seats}</td>				
				</tr>
			</c:forEach>
	</table>
</body>
<script type="text/javascript" src="/airline/assets/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/airline/assets/js/branch.js"></script>
</html>