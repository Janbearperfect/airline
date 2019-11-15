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
					alert("请输入正确的用户名或密码")
				}
			}
		})
	})
//	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		  $("#form").validate({
		    rules: {
		    	mname:{
		    		required:true,
		    	},
		      password: {
		        required: true,
		        minlength: 2
		      },
		    },
		    messages: {
		    	mname:{
		    		required:"请输入用户名",
		    	},
		      password: {
		        required: "请输入密码",
		        minlength: "密码长度不能小于 3 个字母"
		      },
		    }
		});
	
	
});