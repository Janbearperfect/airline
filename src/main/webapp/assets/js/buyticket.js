$(function(){
//$().ready(function() {
//		// 在键盘按下并释放及提交后验证提交表单
//		  $("#form").validate({
//		    rules: {
//		      name: "required",
//		      IDnumber: {
//		        required: true,
//			    remote: {
//			        url: "personalInfo",     //后台处理程序
//			        type: "post",               //数据发送方式
//			        dataType: "json",           //接受数据格式   
//			        data: {                     //要传递的数据
//			            ID: function() {
//			                return $("#idcard").val();
//			                
//			            }
//			        }
//			    }
//		      },
//		      
//		    },
//		    messages: {
//		      name: "&nbsp; !!!",
//		      ID: {
//		        required: "&nbsp; !!!",
//		        remote:"&nbsp; !!!"
//		      }
//		    },
//		    })
//		});
//舱位等级
$("form").on("change","input",function(){
	var type=$(this).val();
	var tprice=$(".price").val();
	if(type=="2"){
		$(".price").attr("value",tprice*0.8);
	}else if(type=="3"){
		$(".price").attr("value",tprice*0.5);
	}else if(type=="1"){
		$(".price").attr("value",tprice);
	}
})


$("form").on("change","select",function(){
	var flightId=$(".flightId").val();
	var classes=$(this).val();
	var price=$(".price").val();
	if(classes=="2"){
		$(".price").attr("value",price*0.75);
	}else if(classes=="3"){
		$(".price").attr("value",price*0.5);
	}else if(classes=="1"){
		$(".price").attr("value",price);
	}	
});

//$(".list-submit").click(function(){
//	var flightId=$(".flightId").val();
//	$.ajax({
//		type:"post",
//		url:"salesTicketSubmit",
//		data:{flightId:flightId},
//	})
//	
//})


})