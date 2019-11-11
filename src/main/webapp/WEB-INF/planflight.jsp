<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航空计划表</title>
<link rel="stylesheet" href="/airline/assets/css/bootstrap.css">
<link rel="stylesheet" href="/airline/assets/css/planflight.css">
</head>
<body>
 <header>航班计划表</header>
    <div class="box">
        <div class="reminder">
            <div class="count"><i></i>&nbsp;&nbsp;条</div>
            <button class="add btn btn-default" data-toggle="modal" data-target=".bs-example-modal-sv">添加</button>
        </div>
        <table class="table table-bordered">
            <tr>
                <th style="text-align: center">ID</th>
                <th style="text-align: center">航班编号</th>
                <th style="text-align: center">出发机场</th>
                <th style="text-align: center">出发时间</th>
                <th style="text-align: center">飞机编号</th>
                <th style="text-align: center">操作</th>
            </tr>
            <%int i=1; %>
            <c:forEach items="${flightSchedulers}" var="flightScheduler">
			<tr id="${flightScheduler.id}">
				 <td><%=i++%></td> 
				<td class="number">${flightScheduler.flightNumber}</td>
				<td>${flightScheduler.airportName}</td>
				<td>${flightScheduler.startDate}</td>
				<td>${flightScheduler.airplane}</td>
				<td>
					  <button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">查看</button>
                    <button class="btn btn-danger delete" data-toggle="modal" data-target=".bs-example-modal-md">删除</button>
				</td>
			<tr>
		</c:forEach>

        </table>
    </div>
    <!--查看  -->
    <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <form class="form-inline" style="margin-left:160px;margin-top: 20px" action="updateplanflight">
                        <input type="hidden" class="form-control flightId" id="flightId" name="flightId">
                  
                    <div class="form-group">
                        <label for="exampleInputName2">航班编号</label>
                        <input type="text" class="form-control flightNumber" id="flightNumber" name="flightNumber">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail2">飞机编号</label>
                        <input type="text" class="form-control airplane" id="airplane" name="airplane">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">计划时间</label>
                        <input type="date" class="form-control startDate" id="startDate" name="startDate">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">——</label>
                        <input type="date" class="form-control endDate" id="endDate" name="endDate">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">飞行区间</label>
                        <input type="text" class="form-control fromCity" id="fromCity" name="fromCity">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">——</label>
                        <input type="text" class=" form-control toCity" id="toCity" name="toCity">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">机场区间</label>
                        <input type="text" class="form-control fromAirport" id="fromAirport" readonly>
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">——</label>
                        <input type="text" class="form-control toAirport" id="toAirport" readonly>
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">飞行时间</label>
                        <input type="datetime_local" class="form-control departureTime" id="departureTime" name="departureTime">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">——</label>
                        <input type="datetime_local" class="form-control arrivalTime" id="arrivalTime" name="arrivalTime">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">班期</label>
                        <input type="text" class="form-control scheduler" id="scheduler" name="scheduler">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center" >航程</label>
                        <input type="text" class="form-control sailLength" id="sailLength" name="sailLength">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                        <button type="submit" class="btn btn-success" style="margin-left: 460px;margin-bottom: 20px">修改</button>
                </form>

            </div>
        </div>

    </div>
        <!--添加  -->
    <div class="modal fade bs-example-modal-sv" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <form class="form-inline" style="margin-left:160px;margin-top: 20px" action="saveplanflight">
                        <input type="hidden" class="form-control flightId" id="flightId" name="flightId">
                  
                    <div class="form-group">
                        <label for="exampleInputName2">航班编号</label>
                        <input type="text" class="form-control flightNumber" id="flightNumber" name="flightNumber">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail2">飞机编号</label>
                        <input type="text" class="form-control airplane" id="airplane" name="airplane">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">计划时间</label>
                        <input type="date" class="form-control startDate" id="startDate" name="startDate">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">——</label>
                        <input type="date" class="form-control endDate" id="endDate" name="endDate">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">飞行区间</label>
                        <input type="text" class="form-control fromCity" id="fromCity" name="fromCity">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">——</label>
                        <input type="text" class=" form-control toCity" id="toCity" name="toCity">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">机场区间</label>
                        <input type="text" class="form-control fromAirport" id="fromAirport" readonly>
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">——</label>
                        <input type="text" class="form-control toAirport" id="toAirport" readonly>
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">飞行时间</label>
                        <input type="datetime_local" class="form-control departureTime" id="departureTime" name="departureTime">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">——</label>
                        <input type="datetime_local" class="form-control arrivalTime" id="arrivalTime" name="arrivalTime">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                    <div class="form-group">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center">班期</label>
                        <input type="text" class="form-control scheduler" id="scheduler" name="scheduler">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail2" style="width: 55px;text-align: center" >航程</label>
                        <input type="text" class="form-control sailLength" id="sailLength" name="sailLength">
                    </div>
                    <br>
                    <div style="width: 100%;height: 10px"></div>
                        <button type="submit" class="btn btn-success" style="margin-left: 460px;margin-bottom: 20px">提交</button>
                </form>

            </div>
        </div>

    </div>
    
    <!--  删除-->
    <div class="modal fade bs-example-modal-md" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content" id="smallmodal">
			<h3 style="text-align:center">删除机场</h3>
			<div class="formbox">
			  <div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">
					确定要删除&nbsp;<i class="deletenumber"></i>&nbsp;？
				</h4>
			</div>
			<input type="hidden" class="putid">
			<div class="modal-footer">
				<button type="button" class="btn btn-success " 
						data-dismiss="modal" style="line-height:100%">关闭
				</button>
				<button type="button" class="btn btn-danger  deleteconfirm">
					确定
				</button>
			</div>
		</div>
    </div>
  </div>
</div>
    
    
     <script src="/airline/assets/js/jquery-1.9.1.js"></script>
    <script src="/airline/assets/js/bootstrap.js"></script>
    <script src="/airline/assets/js/planflight.js"></script>
</body>
</html>