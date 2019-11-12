<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航空计划表</title>
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/queryflight.css">
<link rel="stylesheet" href="/airline/assets/css/base.css">
</head>
<body>
 <header>航班信息查询</header>
<div class="box">
     <form class="form-inline query" action="queryResult"> 
        <div class="form-group">
            <label for="exampleInputName2">出发地</label>
            <input type="text" class="form-control from" id="start-city" placeholder="出发地" name="from">
            <label for="example">——</label>
            <input type="text" class="form-control to" id="end-city" placeholder="目的地" name="to">
        </div>
        <div class="form-group">
            <label for="date">出发时间</label>
            <input type="date" class="form-control startdate" id="start-date"  name="date">

        </div>

        <button type="submit" class="btn btn-info">查询航班</button>
     </form> 
</div>
    
     <script src="/airline/assets/js/jquery-1.9.1.js"></script>
    <script src="/airline/assets/js/bootstrap.js"></script>
    <script src="/airline/assets/js/queryflight.js"></script>
</body>
</html>