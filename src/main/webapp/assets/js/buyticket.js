	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		  $("#form").validate({
		    rules: {
		      name: "required",
		      ID: {
		        required: true,
		      }
		    },
		    messages: {
		      name: "!",
		  
		      ID: {
		        required: "!",
		      }
		    },
		    })
		});