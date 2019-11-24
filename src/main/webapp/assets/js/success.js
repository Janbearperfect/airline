$(function(){
	var num = $(".num").html();
	setInterval(function() {
		$(".num").html(--num);
		if(num==0){
			location.href="index";
		}
		
	}, 1000);
})