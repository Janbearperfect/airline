window.onload=function(){
	$(".btn-primary").click(function(){
		
		var value = $(this).parent().parent().attr("attr");
		$(".branchId").val(value);
		$(".branchName").val($(this).parent().parent().children()[1].innerText);
		$(".branchAddress").val($(this).parent().parent().children()[2].innerText);
		$(".branchTele").val($(this).parent().parent().children()[3].innerText);
		$(".BranchPro").val($(this).parent().parent().children()[4].innerText);
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