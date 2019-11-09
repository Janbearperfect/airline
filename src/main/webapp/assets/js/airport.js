$(function(){
	$(".btn-primary").click(function(){
		var value = $(this).parents("tr").attr("id");
		$.get("getAirport/"+value,function(e){
			$(".airportCode").val(e.airportCode);
			$(".city").val(e.city);
			$(".airportName").val(e.airportName);
		},"json")
	})
	$(".save").click(function(){
		$.get("updateAirport/"+$(".airportCode").val()+"/"+$(".city").val()+"/"+$(".airportName").val(),function(e){
			if("success".equals(e)){
				}
		})
	})
	$(".delete").click(function(){
		var value = $(this).parents("tr").attr("id");
		$(".putid").val(value);
	})
	$(".confirmdelete").click(function(){
		$.get("deleteAirport/"+$(".putid").val(),function(e){
			if("success".equals(e)){
				location.href="airport";
			}
		})
	})
	$(".add").click(function(){
		alert(a);
	})
	
	
	
	
	
});