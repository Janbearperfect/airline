<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,airsystem.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
 <link rel="stylesheet" href="/airline/assets/css/personalCenter.css">
</head>
<body>
<%
    UserL user =(UserL)session.getAttribute("user");
%>
<div class="contain">
<div class="info" style="width:100%;text-align:center;">个人资料</div>
<div class="info">昵称:<span class="name1"><%out.print(user.getUname());%></span></div>
<div class="info">手机号:<span class="phone1"><%out.print(user.getPhone());%></span></div>
<div class="info">性别:<span class="sex1"><%out.print(user.getSex());%><span></span></div>
<div class="info">年龄:<span class="age1"><%out.print(user.getAge());%></span></div>
<div class="info">地址:<span class="address1"><%out.print(user.getAddress());%></span></div>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm" id="but">编辑</button>
</div>


<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    		
			<div class="formbox">
			  <form action="updatePersonal" style="margin-left: 300px;">
			      <div class="form-group" style="margin-top:20px;">
			   		<label for="exampleInputEmail1">昵称</label>
			    	<input type="text"  name="userName" class="userName">
			  	  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">性别</label>
				     男<input type="radio"  name="sex" value="男" class="boy">
				    女<input type="radio"  name="sex" value="女" class="girl">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">年龄</label>
				    <input type="date"  name="age" class="age">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">地址</label>
				    <input type="text"  name="address" class="address">
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
<script src="/airline/assets/js/personalCenter.js"></script>
</html>