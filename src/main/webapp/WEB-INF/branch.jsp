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
		<th>营业点编号</th>
		<th>密码</th>
		<th>名字</th>
		<th>地址</th>
		<th>电话</th>
		<th>省份</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${brs}" var="brs">
			<tr attr="${brs.id}">
				<td>${brs.id}</td>	
				<td>${brs.bNumber}</td>
				<td>${brs.bPassword}</td>			
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
			  <form class="form-inline" style="margin-left:30px;margin-top: 20px" action="branchUpdate">
                    <div class="form-group">
                        <label for="exampleInputName2" style="width=100px;height=100%">营业点ID</label>
                        <input type="text" class="form-control branchId" id="flightNumber" name="branchId" readOnly>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">营业点编号</label>
                        <input type="text" class="form-control branchNumber" id="airplane" name="branchNumber">
                         <label for="exampleInputEmail2">密码</label>
                        <input type="text" class="form-control branchPassword" id="startDate" name="branchPassword">
                    </div>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">营业点名称</label>
                        <input type="text" class="form-control branchName" id="fromCity" name="branchName">
                    </div>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">营业点地址</label>
                        <input type="text" class="form-control  branchAddress" id="fromAirport"  name="branchAddress">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">电话</label>
                        <input type="datetime_local" class="form-control branchTele" id="departureTime" name="branchTele">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">省份</label>
                        <input type="text" class="form-control BranchPro" id="scheduler" name="BranchPro">
                    </div>

            
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                        <button type="submit" class="btn btn-success" style="margin-left: 460px;margin-bottom: 20px">修改</button>
                </form>

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
			<div class="ad"><span>添加营业点</span></div>
			  <form action="addBranch">
			  
				  <div class="form-group">
				    <label for="exampleInputPassword1">名字</label>
				    <input type="text" class="form-control branchName1" id="exampleInputPassword1"  name="branchName1">
				  </div>
				    <div class="form-group">
				    <label for="exampleInputPassword1">编号</label>
				    <input type="text" class="form-control branchNumber1" id="exampleInputPassword1"  name="branchNumber1">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">地址</label>
				    <input type="text" class="form-control branchAddress1" id="exampleInputPassword1"  name="branchAddress1">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">电话</label>
				    <input type="text" class="form-control branchTele1" id="exampleInputPassword1" name="branchTele1">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">省份</label>
				    <input type="text" class="form-control BranchPro1" id="exampleInputPassword1" name="BranchPro1">
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