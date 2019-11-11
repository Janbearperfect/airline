window.onload=function(){
	var flag=false;
	$(".title-hxt").click(function(){
		if(!flag){
			$(".hidden-htx").css("display","block");
			flag=true;
		}else{
			$(".hidden-htx").css("display","none");
			flag=false;
		}
		
	})
}