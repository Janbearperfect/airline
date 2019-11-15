$(function(){
	$(".login").click(function(){
		var val = $('input[name="type"]:checked').val();
		$.ajax({
			url:"checkManagerLogin",
			data:{mname:$(".name").val(),password:$(".password").val(),type:val},
			type:"post",
			dateType:"string",
			success:function(e){
				console.log(e.trim());
				if(e=="success"){
					location.href="main";
				}else{
					alert("请输入正确的密码")
				}
			}
		})
	})
	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		  $("#form").validate({
		    rules: {
		    	name:{
		    		required:true,
		    		 remote:{
		    			 url: "checkManagerNum",     //后台处理程序
		    			    type: "post",               //数据发送方式
		    			    dataType: "json",           //接受数据格式   
		    			    data: {                     //要传递的数据
		    			        username: function() {
		    			            return $("#username").val();
		    			        }
		    			    }
				      },
		    	},
		      password: {
		        required: true,
		        minlength: 6
		      },
		    },
		    messages: {
		    	name:{
		    		required:"请输入用户名",
		    		remote:{
		    			
		    		},
		    	},
		      password: {
		        required: "请输入密码",
		        minlength: "密码长度不能小于 6 个字母"
		      },
		    }
		});
	
	
});