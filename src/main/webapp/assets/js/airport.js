$(function(){
	
	$(".btn-primary").click(function(){
		console.log("a");
		var value = $(this).parents("tr").attr("id");
		$.get("getAirport/"+value,function(e){
			console.log(e.airportCode);
		})
	})
});