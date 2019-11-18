<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="airsystem.entity.Airport"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>机场管理</title>
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/sales.css">
</head>

<%String type=session.getAttribute("type").toString(); %>
<body>
<div class="box">
	<button type="button" class="btn btn-lg add"data-toggle="modal" data-target="#myModal">添加</button>
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>工号</th>
			<th>姓名</th>
			<th>密码</th>
			<%if(type.equals(1)) {%>
			<th>归属</th>
			<%} else{%>
			<%} %>
			<th>操作</th>
		</tr>
		<%int i=1; %>
		<c:forEach items="${sales}" var="sale">
			<tr id="${sale.id}">
				<td><%=i++ %></td>
				<td>${sale.number}</td>
				<td>${sale.saleName}</td>
				<td>${sale.password}</td>
				<%if(type.equals(1)) {%>
				<td>${sale.name}</td>
				<%} else{%>
				<%} %>
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
    		<h3>修改信息</h3>
			<div class="formbox">
			  <form action="">
			  <input type="hidden" class="saleId">
			      <div class="form-group">
			   		<label for="exampleInputEmail1">工号</label>
			    	<input type="text" class="form-control number" readonly id="exampleInputEmail1" >
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">姓名</label>
				    <input type="text" class="form-control name" id="" >
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">密码</label>
				    <input type="text" class="form-control password" id="exampleInputPassword1" >
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">归属</label>
				   <input type="text" class="form-control province" id="exampleInputPassword1" >
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
			<h2>删除营业员</h2>
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
      <h3>添加营业员</h3>
			<div class="formbox">
			  <form action="saveSale">
			      <div class="form-group">
			   		<label for="exampleInputEmail1">工号</label>
			    	<input type="text" class="form-control number1" id="exampleInputEmail1" name="number">
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">姓名</label>
				    <input type="text" class="form-control name1" id="exampleInputPassword1" name="name">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">密码</label>
				    <input type="text" class="form-control password1" id="exampleInputPassword1" name="password" >
				  </div>
				   <div class="form-group">
				    <label for="exampleInputPassword1">归属</label>
				   <!--  <input type="text" class="form-control" id="exampleInputPassword1" name="provice" > -->
				    <select> 
				    </select>
				  </div>
				  <button type="submit" class="btn btn-success ok">保存</button>
			  </form>
		  </div>
    </div>
  </div>
</div>
<script src="/airline/assets/js/jquery-1.9.1.js"></script>
<script src="/airline/assets/js/bootstrap.js"></script>
<script src="/airline/assets/js/sales.js"></script>
</body>
</html>