$(function(){
	$(".loginout").click(function(){
		if(confirm("确定要退出？")){
			$.ajax({
				url:"removeSession",
				success:function(e){
					if(e=="success"){
						location.href="managerLogin";
					}
				}
			})
//			location.href="removeSession";
		}
	})
})