<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/managerLogin.css">
</head>
<body>
<div class="container">
<form action="" id="form">
  <div class="form-group">
    <label for="exampleInputEmail1">用户名</label>
    <input type="text" class="form-control name" id="exampleInputEmail1" placeholder="请输入用户名或工号"  name="mname">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码</label>
    <input type="password" class="form-control password" id="exampleInputPassword1" placeholder="请输入密码" name="password">
  </div>
      管理员：<input type="radio" name="type" value="1">
      营业点：<input type="radio" name="type" value="2">
      营业员：<input type="radio" name="type" value="3">
  <button type="button" class="btn btn-default login">登录</button>
</form>
</div>
<script type="text/javascript" src="/airline/assets/js/jquery-1.9.1.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="/airline/assets/js/managerLogin.js"></script>
</body>
</html>