<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="airsystem.util.*,airsystem.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/airline/assets/css/ticket.css">
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<title>用户</title>
</head>
<body>
	 <div class="container">
 <table class="table table-bordered">
		 <tr>
		     <th>ID</th>		     
		     <th>联系电话</th>
		     <th>姓名</th>
		     <th>性别</th>
		     <th>年龄</th>
		     <th>地址</th>
		 </tr>
		 
		 <c:forEach items="${users}" var="user">
		     <tr>
		          <td>${user.id}</td>
		          <td>${user.phone}</td>
		          <td>${user.uname}</td>
		        
		          <td>
		                ${user.sex}
		              
		          </td>
		          <td>
		                 ${user.age}
		              
		          </td>
		          <td>${user.address}</td>		     
		     </tr>
		      </c:forEach>
</table>		     
		
         
      
 
 
 </table>
</body>
</html>