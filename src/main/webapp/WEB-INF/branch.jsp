<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/branch.css">
<style>
  
</style>
</head>
<body>
	<table class="table">
	<tr>
		<th>ID</th>
		<th>名字</th>
		<th>地址</th>
		<th>电话</th>
		<th>省份</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${brs}" var="brs">
				<tr>
						<td>${brs.id}</td>				
						<td>${brs.name}</td>				
						<td>${brs.address}</td>				
						<td>${brs.telephone}</td>				
						<td>${brs.province}</td>			
						<td><button>编辑</button><button>删除</button></td>	
				</tr>
			</c:forEach>
	</table>
</body>
<script type="text/javascript" src=""></script>
</html>