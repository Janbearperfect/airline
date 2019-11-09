<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="airsystem.entity.Airport"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>机场管理</title>
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/airport.css">
</head>
<body>
<div class="box">
	<button type="button" class="btn btn-primary btn-lg add"data-toggle="modal" data-target="#myModal">添加</button>
	<table class="table table-bordered">
		<tr>
			<th>机场编号</th>
			<th>城市</th>
			<th>机场名</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${airports}" var="airport">
			<tr id="${airport.airportCode}">
				<td>${airport.airportCode}</td>
				<td>${airport.city}</td>
				<td>${airport.airportName}</td>
				<td>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">编辑</button>
					<button type="button" class="btn btn-danger delete"data-toggle="modal" data-target=".bs-example-modal-md">删除</button>
				</td>
			<tr>
		</c:forEach>
	</table>
</div>
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content">
    		<h3>修改机场</h3>
			<div class="formbox">
			  <form action="">
			      <div class="form-group">
			   		<label for="exampleInputEmail1">机场编号</label>
			    	<input type="text" class="form-control airportCode" id="exampleInputEmail1" >
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">城市</label>
				    <input type="text" class="form-control city" id="exampleInputPassword1" >
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">机场名字</label>
				    <input type="text" class="form-control airportName" id="exampleInputPassword1" >
				  </div>
				  <button type="submit" class="btn btn-success save">修改</button>
			  </form>
		  </div>
    </div>
  </div>
</div>
<div class="modal fade bs-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content" id="smallmodal">
			<h2>删除机场</h2>
			<div class="formbox">
			  <div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					确定要删除？
				</h4>
			</div>
			<input type="hidden" class="putid">
			<div class="modal-footer">
				<button type="button" class="btn btn-success btn-lg" 
						data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-danger btn-lg confirmdelete">
					确定
				</button>
			</div>
		</div>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <h3>添加机场</h3>
			<div class="formbox">
			  <form action="">
			      <div class="form-group">
			   		<label for="exampleInputEmail1">机场编号</label>
			    	<input type="text" class="form-control" id="exampleInputEmail1" name="">
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">城市</label>
				    <input type="text" class="form-control" id="exampleInputPassword1" >
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">机场名字</label>
				    <input type="text" class="form-control" id="exampleInputPassword1" >
				  </div>
				  <button type="submit" class="btn btn-success save">保存</button>
			  </form>
		  </div>
    </div>
  </div>
</div>
<script src="/airline/assets/js/jquery-1.9.1.js"></script>
<script src="/airline/assets/js/bootstrap.js"></script>
<script src="/airline/assets/js/airport.js"></script>
</body>
</html>