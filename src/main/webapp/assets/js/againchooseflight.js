$(function(){
	var flag=false;
	var flag2=false;
	var flightId;
	var classes;
	var price;
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
	$(".in-right-hxt").on("click" , ".info-right-hxt" ,function(){
		price = $(this).children().html();
		classes = $(this).attr("attr");
		flightId = $(this).parent().attr("attr");
	})
	$(".confirm").click(function(){
		var Id=$(".ticketId").val();
		if(classes==undefined ||price==undefined ||flightId==undefined){
			alert("请选择服务");
		}else{
			$.post(
				"changeTicket",
				{classes:classes,price:price,flightId:flightId,Id:Id},
				function(e){
					if(e=="success"){
						if(confirm("改签成功")){
								location.href="personalTicket";
						}
					
					}
				}
			)
		}
	})
})