$(function(){
$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		  $("#form").validate({
		    rules: {
		      name: "required",
		      ID: {
		        required: true,
			    remote: {
			        url: "personalInfo",     //后台处理程序
			        type: "post",               //数据发送方式
			        dataType: "json",           //接受数据格式   
			        data: {                     //要传递的数据
			            ID: function() {
			                return $("#idcard").val();
			                
			            }
			        }
			    }
		      },
		      
		    },
		    messages: {
		      name: "&nbsp; !!!",
		      ID: {
		        required: "&nbsp; !!!",
		        remote:"&nbsp; !!!"
		      }
		    },
		    })
		});
})