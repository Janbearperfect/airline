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
<div class="box">
	<table class="table table-bordered">
		<tr>
		<th>营业点ID</th>
		<th>名字</th>
		<th>地址</th>
		<th>电话</th>
		<th>省份</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${brs}" var="brs">
			<tr attr="${brs.id}">
				<td>${brs.id}</td>				
				<td>${brs.name}</td>				
				<td>${brs.address}</td>				
				<td>${brs.telephone}</td>				
				<td>${brs.province}</td>
				<td >
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">编辑</button>
					<button type="button" class="btn btn-danger delete"data-toggle="modal" data-target=".bs-example-modal-md">删除</button>
				</td>
			<tr>
		</c:forEach>
	</table>
<button type="button" class="btn  btn-lg add"data-toggle="modal" data-target="#myModal">添加</button>
</div>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    		
			<div class="formbox">
			  <form action="branchUpdate">
			      <div class="form-group">
			   		<label for="exampleInputEmail1">营业点ID</label>
			    	<input type="text" class="form-control branchId" id="exampleInputEmail1" name="branchId" readOnly>
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">名字</label>
				    <input type="text" class="form-control branchName" id="exampleInputPassword1"  name="branchName">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">地址</label>
				    <input type="text" class="form-control branchAddress" id="exampleInputPassword1"  name="branchAddress">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">电话</label>
				    <input type="text" class="form-control branchTele" id="exampleInputPassword1" name="branchTele">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">省份</label>
				    <input type="text" class="form-control BranchPro" id="exampleInputPassword1" name="BranchPro">
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


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
			<div class="formbox">
			<div class="ad"><span>添加机场</span></div>
			  <form action="addBranch">
			  
				  <div class="form-group">
				    <label for="exampleInputPassword1">名字</label>
				    <input type="text" class="form-control branchName" id="exampleInputPassword1"  name="branchName">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">地址</label>
				    <input type="text" class="form-control branchAddress" id="exampleInputPassword1"  name="branchAddress">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">电话</label>
				    <input type="text" class="form-control branchTele" id="exampleInputPassword1" name="branchTele">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">省份</label>
				    <input type="text" class="form-control BranchPro" id="exampleInputPassword1" name="BranchPro">
				  </div>
				  <button type="submit" class="btn btn-success">保存</button>
			  </form>
		  </div>
    </div>
  </div>
</div>

</body>

<script src="/airline/assets/js/jquery-1.9.1.js"></script>
<script src="/airline/assets/js/bootstrap.js"></script>
<script src="/airline/assets/js/branch.js"></script>
</html>