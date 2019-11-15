window.onload=function(){
	$(".btn-primary").click(function(){
		var value = $(this).parent().parent().attr("attr");
		$(".branchId").val(value);
		$(".branchNumber").val($(this).parent().parent().children()[1].innerText);
		$(".branchPassword").val($(this).parent().parent().children()[2].innerText);
		$(".branchName").val($(this).parent().parent().children()[3].innerText);
		$(".branchAddress").val($(this).parent().parent().children()[4].innerText);
		$(".branchTele").val($(this).parent().parent().children()[5].innerText);
		$(".BranchPro").val($(this).parent().parent().children()[6].innerText);
	})
	
	
    $(".delete").click(function(){
    	var value = $(this).parent().parent().attr("attr");
        $(".dl").click(function(){
        	$.ajax({
        		url:"delete/"+value,
        		success:function(data){
        			location.href="branch";
        		}
        	})
        })
    	
    })
	
}