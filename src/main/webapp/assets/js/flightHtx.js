window.onload=function(){
	var flag=false;
	var flag2=false;
	var flightNumber;
	var adultNumber;
	var bady;
	var child;
	var classes;
	var tprice;
	
	$(".title-hxt").click(function(){
		if(!flag){
			$(".hidden-htx").css("display","block");
			flag=true;
		}else{
			$(".hidden-htx").css("display","none");
			flag=false;
		}
		
	})
	
	$(".p-info").click(function(){
		if(!flag){
			$(".show-info-h").css("display","block");
			flag=true;
		}else{
			$(".show-info-h").css("display","none");
			flag=false;
		}
	})
	
	$(".info-right-hxt").click(function(){
		flightNumber=$(this).parent(".in-right-hxt").attr("attr");
		$(".info-right-hxt").css("box-shadow","");
		$(this).css("box-shadow","2px 2px 2px black inset");
		classes=$(this).attr("attr");
		tprice=$(this).text();
		child=$("#child").text();
		bady=$("#baby").text();
		adultNumber=$("#adult").text();
		
	})
	
	$(".continue").click(function(){
		
		if(adultNumber==undefined || bady==undefined || child==undefined ||classes==undefined ||tprice==undefined ||flightNumber==undefined){
			alert("请选择服务");
		}else{
			location.href="yticket/"+adultNumber+"/"+bady+"/"+child+"/"+flightNumber+"/"+classes+"/"+tprice;
		}
		
		
	})
}