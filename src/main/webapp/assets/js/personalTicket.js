window.onload=function(){
	//选项卡
	   var links = document.querySelectorAll(".title-name")
	    var list = document.querySelectorAll(".ticketInfo-list")
	    for(let i=0;i<links.length;i++){
	        links[i].onclick=function () {
	            for(let j=0;j<list.length;j++){
	                list[j].style.display="none"
	                links[j].style.background=""
	            }
	            list[i].style.display="block"
	            this.style.background="#75b1d0d6";
	        }
	    }
	   //时间戳转换为时间
		function timestampToTime(timestamp) {
		    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		    var Y = date.getFullYear() + '-';
		    var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		    var D = date.getDate() + ' ';
		    var h = date.getHours() + ':';
		    var m = date.getMinutes() + ':';
		    var s = date.getSeconds();
		    return Y + M + D + h + m + s;
		}
		 var IDNumber=$(".IdNumber").val();
		 //游客查实时机票
		 $.post(
		   "personalTicketInfo",
		   {IDNumber:$(".IdNumber").val()},
		   function(e){
			   console.log(e);
			   for(var i=0;i<e.length;i++){
				   var a="";
				   if(e[i].status!="退票"){
					 a= "<div class='info-button'>"+
                       "<button type='button' class='btn btn-info ticketchange'>改签</button>"+
                       "<button type='button' class='btn btn-warning ticketout'>退票</button>"+
                   "</div>"
				   }
				   $(".ticketInfo-list:eq(0)").append("<div class='list-info'>"+
	                "<div class='listInfo-title'>"+
	                    "<span class='listInfo-first'>"+e[i].flightNumber+"</span>"+
	                    "<span class='listInfo-first'>"+e[i].name+"</span>"+
	                    "<span class='listInfo-first-card'>"+e[i].idNumber+"</span>"+
	                    "<span class='listInfo-first'>"+e[i].classes+"</span>"+
	                    "<span class='listInfo-first'>"+e[i].passengerType+"</span>"+
	                    "<span class='listInfo-first'>"+e[i].id+"</span>"+
	                    "<span class='listInfo-first-date'>"+timestampToTime(e[i].orderDate) +"<span>出票</span></span>"+
	                    "<span class='listInfo-first-date' style='margin-left: 20px;color: #597936;font-size: 16px'>"+e[i].status+"</span>"+
	                "</div>"+
	                "<div class='listInfo-info'>"+
	                    "<div class='info-city'>"+e[i].fromCity+"</div>"+
	                    "<div class='info-date-zst'>"+
	                        "<div class='info-date-first'>"+
	                        timestampToTime(e[i].departureTime)
	                        +"</div>"+
	                        "<div style='width:250px;height: 1px; background: #1a2129;'></div>"+
	                        "<div class='info-date-second'>"+
	                        timestampToTime(e[i].arrivalTime)
	                        +"</div>"+
	                    "</div>"+
	                    "<div class='info-city'>"+e[i].toCity+"</div>"+
	                    "<div class='info-length'>"+e[i].sailLength+"&nbsp;<span>KM</span></div>"+
	                    "<div class='info-length' style='color: #ffb000;font-size: 16px'>"+e[i].tPrice+"&nbsp;<span>￥</span></div>"+
	                    a+"</div></div>")
				  
			   }
			   
			   
		   })
		   //游客查往期机票
		   $(".title-name:eq(1)").click(function(){
			   $.post(
					   "personalTicketInfoBefore",
					   {IDNumber:$(".IdNumber").val()},
					   function(e){
						   for(var i=0;i<e.length;i++){
							   $(".ticketInfo-list:eq(1)").append("<div class='list-info'>"+
				                "<div class='listInfo-title'>"+
				                    "<span class='listInfo-first'>"+e[i].flightNumber+"</span>"+
				                    "<span class='listInfo-first'>"+e[i].name+"</span>"+
				                    "<span class='listInfo-first-card'>"+e[i].idNumber+"</span>"+
				                    "<span class='listInfo-first'>"+e[i].classes+"</span>"+
				                    "<span class='listInfo-first'>"+e[i].passengerType+"</span>"+
				                    "<span class='listInfo-first'>"+e[i].id+"</span>"+
				                    "<span class='listInfo-first-date'>"+timestampToTime(e[i].orderDate) +"<span>出票</span></span>"+
				                    "<span class='listInfo-first-date' style='margin-left: 20px;color: #597936;font-size: 16px'>"+e[i].status+"</span>"+
				                "</div>"+
				                "<div class='listInfo-info'>"+
				                    "<div class='info-city'>"+e[i].fromCity+"</div>"+
				                    "<div class='info-date-zst'>"+
				                        "<div class='info-date-first'>"+
				                        timestampToTime(e[i].departureTime)
				                        +"</div>"+
				                        "<div style='width:250px;height: 1px; background: #1a2129;'></div>"+
				                        "<div class='info-date-second'>"+
				                        timestampToTime(e[i].arrivalTime)
				                        +"</div>"+
				                    "</div>"+
				                    "<div class='info-city'>"+e[i].toCity+"</div>"+
				                    "<div class='info-length'>"+e[i].sailLength+"&nbsp;<span>KM</span></div>"+
				                    "<div class='info-length' style='color: #ffb000;font-size: 16px'>"+e[i].tPrice+"&nbsp;<span>￥</span></div>"+
				                    "</div></div>")
						   }	   	   
					   })
		   })
		   			   //用户查询机票
		
		 $.post(
		   "personalTicketInfoUser",
		   function(e){
			   console.log(e);
			   for(var i=0;i<e.length;i++){
				   var a="";
				   if(e[i].status!="退票"){
						 a= "<div class='info-button'>"+
	                       "<button type='button' class='btn btn-info ticketchange'>改签</button>"+
	                       "<button type='button' class='btn btn-warning ticketout'>退票</button>"+
	                   "</div>"
					   }
				   $(".ticketInfo-list:eq(0)").append("<div class='list-info'>"+
	                "<div class='listInfo-title'>"+
	                    "<span class='listInfo-first'>"+e[i].flightNumber+"</span>"+
	                    "<span class='listInfo-first'>"+e[i].name+"</span>"+
	                    "<span class='listInfo-first-card'>"+e[i].idNumber+"</span>"+
	                    "<span class='listInfo-first'>"+e[i].classes+"</span>"+
	                    "<span class='listInfo-first'>"+e[i].passengerType+"</span>"+
	                    "<span class='listInfo-first'>"+e[i].id+"</span>"+
	                    "<span class='listInfo-first-date'>"+timestampToTime(e[i].orderDate) +"<span>出票</span></span>"+
	                    "<span class='listInfo-first-date' style='margin-left: 20px;color: #597936;font-size: 16px'>"+e[i].status+"</span>"+
	                "</div>"+
	                "<div class='listInfo-info'>"+
	                    "<div class='info-city'>"+e[i].fromCity+"</div>"+
	                    "<div class='info-date-zst'>"+
	                        "<div class='info-date-first'>"+
	                        timestampToTime(e[i].departureTime)
	                        +"</div>"+
	                        "<div style='width:250px;height: 1px; background: #1a2129;'></div>"+
	                        "<div class='info-date-second'>"+
	                        timestampToTime(e[i].arrivalTime)
	                        +"</div>"+
	                    "</div>"+
	                    "<div class='info-city'>"+e[i].toCity+"</div>"+
	                    "<div class='info-length'>"+e[i].sailLength+"&nbsp;<span>KM</span></div>"+
	                    "<div class='info-length' style='color: #ffb000;font-size: 16px'>"+e[i].tPrice+"&nbsp;<span>￥</span></div>"+
	                   a+"</div></div>")
			   }
			   
		   })
		   //用户查往期机票
		   $(".title-name:eq(1)").click(function(){
			   $.post(
					   "personalTicketInfoBeforeUser",
					   function(e){
			
						   for(var i=0;i<e.length;i++){
							   $(".ticketInfo-list:eq(1)").append("<div class='list-info'>"+
				                "<div class='listInfo-title'>"+
				                    "<span class='listInfo-first'>"+e[i].flightNumber+"</span>"+
				                    "<span class='listInfo-first'>"+e[i].name+"</span>"+
				                    "<span class='listInfo-first-card'>"+e[i].idNumber+"</span>"+
				                    "<span class='listInfo-first'>"+e[i].classes+"</span>"+
				                    "<span class='listInfo-first'>"+e[i].passengerType+"</span>"+
				                    "<span class='listInfo-first'>"+e[i].id+"</span>"+
				                    "<span class='listInfo-first-date'>"+timestampToTime(e[i].orderDate) +"<span>出票</span></span>"+
				                    "<span class='listInfo-first-date' style='margin-left: 20px;color: #597936;font-size: 16px'>"+e[i].status+"</span>"+
				                "</div>"+
				                "<div class='listInfo-info'>"+
				                    "<div class='info-city'>"+e[i].fromCity+"</div>"+
				                    "<div class='info-date-zst'>"+
				                        "<div class='info-date-first'>"+
				                        timestampToTime(e[i].departureTime)
				                        +"</div>"+
				                        "<div style='width:250px;height: 1px; background: #1a2129;'></div>"+
				                        "<div class='info-date-second'>"+
				                        timestampToTime(e[i].arrivalTime)
				                        +"</div>"+
				                    "</div>"+
				                    "<div class='info-city'>"+e[i].toCity+"</div>"+
				                    "<div class='info-length'>"+e[i].sailLength+"&nbsp;<span>KM</span></div>"+
				                    "<div class='info-length' style='color: #ffb000;font-size: 16px'>"+e[i].tPrice+"&nbsp;<span>￥</span></div>"+
				                    "</div></div>")
						   }	   	   
					   })
 
		   })
		   //退票
		   $("body").on("click",".ticketout",function(){
			   
			   var id=$(this).parents().parents().parents().children(".listInfo-title").children("span:eq(5)").html();
			   if(confirm("确定要退票吗")){
				   $.get(
						   "returnTicket/"+id,
						   function(e){
							   if(e=="success"){
								   alert("退票成功");
								   
							   } 
						   }
	  	  
			);
			   }
			   
		   })
		   //改签
			$("body").on("click",".ticketchange",function(){
				var id=$(this).parents().parents().parents().children(".listInfo-title").children("span:eq(5)").html();
			})		   
			   
		
}