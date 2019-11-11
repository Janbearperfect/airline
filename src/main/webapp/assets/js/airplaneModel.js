window.onload=function(){
$(".btn-primary").click(function(){
		
		var value = $(this).parent().parent().attr("attr");
		$(".airplane").val(value);
		$(".model").val($(this).parent().parent().children()[1].innerText);
		$(".max_sail_length").val($(this).parent().parent().children()[2].innerText);
		$(".first_class_seats").val($(this).parent().parent().children()[3].innerText);
		$(".business_class_seats").val($(this).parent().parent().children()[4].innerText);
		$(".economy_class_seats").val($(this).parent().parent().children()[5].innerText);
	})
	
	 $(".delete").click(function(){
	    	var value = $(this).parent().parent().attr("attr");
	        $(".dl").click(function(){
	        	$.ajax({
	        		url:"airplaneDelete/"+value,
	        		success:function(data){
	        			location.href="airplaneModel";
	        		}
	        	})
	        })
	    	
	    })
		
}