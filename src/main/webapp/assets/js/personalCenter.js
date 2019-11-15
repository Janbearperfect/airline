$("#but").click(function(){
	$(".userName").val($(".name1").text());
	$(".age").val($(".age1").text());
	var sex = $(".sex1").text();
	if(sex=="男"){
		$(".boy").attr("checked","checked");
	}else if(sex=="女"){
		$(".girl").attr("checked","checked");
	}
	$(".address").val($(".address1").text());
})