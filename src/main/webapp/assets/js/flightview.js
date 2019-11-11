$(function(){
	$(".btn-primary").click(function(){
		var value = $(this).parents("tr").attr("id");
		$.get("getFlightView/"+value,function(e){
			$(".seasonDiscount").val(e.seasonDiscount);
			$(".price").val(e.price);
			$(".flightId").val(e.flightId);
			
		},"json")
	})
	$(".save").click(function(){		
		$.get("updateFlightView/"+$(".seasonDiscount").val()+"/"+$(".price").val()+"/"+$(".flightId").val(),function(e){
			location.href="flightview";
		})
	})
});