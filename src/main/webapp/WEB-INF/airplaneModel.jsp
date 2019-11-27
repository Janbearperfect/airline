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
<header>飞机管理表</header>
<div class="box">
	<button type="button" class="btn  btn-lg add"data-toggle="modal" data-target="#myModal">添加</button>
	<table class="table table-bordered">
	<tr>
		<th>飞机编号</th>
		<th>机型</th>
		<th>最大航程</th>
		<th>头等舱座位数</th>
		<th>商务舱座位数</th>
		<th>经济舱座位数</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${ams}" var="ams">
				<tr attr="${ams.airplane}">
						<td>${ams.airplane}</td>				
						<td>${ams.model}</td>				
						<td>${ams.max_sail_length}</td>				
						<td>${ams.first_class_seats}</td>				
						<td>${ams.business_class_seats}</td>				
						<td>${ams.economy_class_seats}</td>				
				
				<td >
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">编辑</button>
					<button type="button" class="btn btn-danger delete"data-toggle="modal" data-target=".bs-example-modal-md">删除</button>
				</td>
				</tr>
			</c:forEach>
	</table>
	</div>
	
	
	
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    		
			<div class="formbox">
			  <form action="airplaneUpdate">
			      <div class="form-group">
			   		<label for="exampleInputEmail1">飞机编号</label>
			    	<input type="text" class="form-control airplane" id="exampleInputEmail1" name="airplane"  readOnly>
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">机型</label>
				    <input type="text" class="form-control model" id="exampleInputPassword1"  name="model">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">最大航程</label>
				    <input type="text" class="form-control max_sail_length" id="exampleInputPassword1"  name="max_sail_length">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">头等舱座位数</label>
				    <input type="text" class="form-control first_class_seats" id="exampleInputPassword1" name="first_class_seats">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">商务舱座位数</label>
				    <input type="text" class="form-control business_class_seats" id="exampleInputPassword1" name="business_class_seats">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">经济舱座位数</label>
				    <input type="text" class="form-control economy_class_seats" id="exampleInputPassword1" name="economy_class_seats">
				  </div>
				  <button type="submit" class="btn btn-success">保存</button>
			  </form>
		  </div>
    </div>
  </div>
</div>
	

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
			<div class="formbox">
			<div class="ad"><span>添加机型</span></div>
			  <form action="airplaneSave">
			  
				 <div class="form-group">
			   		<label for="exampleInputEmail1">飞机编号</label>
			    	<input type="text" class="form-control airplane" id="exampleInputEmail1" name="airplane" >
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">机型</label>
				    <input type="text" class="form-control model" id="exampleInputPassword1"  name="model">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">最大航程</label>
				    <input type="text" class="form-control max_sail_length" id="exampleInputPassword1"  name="max_sail_length">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">头等舱座位数</label>
				    <input type="text" class="form-control first_class_seats" id="exampleInputPassword1" name="first_class_seats">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">商务舱座位数</label>
				    <input type="text" class="form-control business_class_seats" id="exampleInputPassword1" name="business_class_seats">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">经济舱座位数</label>
				    <input type="text" class="form-control economy_class_seats" id="exampleInputPassword1" name="economy_class_seats">
				  </div>
				  <button type="submit" class="btn btn-success">保存</button>
			  </form>
		  </div>
    </div>
  </div>
</div>



<div class="modal fade bs-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content" id="smallmodal">
			
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
				<button type="button" class="btn btn-danger btn-lg confirmdelete dl">
					确定
				</button>
			</div>
		</div>
    </div>
  </div>
</div>

</body>
<script type="text/javascript" src="/airline/assets/js/jquery-1.9.1.js"></script>
<script src="/airline/assets/js/bootstrap.js"></script>
<script type="text/javascript" src="/airline/assets/js/airplaneModel.js"></script>
</html>