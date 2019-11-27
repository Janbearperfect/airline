 $(function(){   
	 
	 $(".mark").on("click",function(){				
		var pageNum=$(this).html()
			$(this).css("color","red")
  	 location.href="http://localhost:8888/airline/selljknticket/"+pageNum	
		})	
		
 })
 

