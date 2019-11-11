$(function(){
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
	//查看
    $(".see").click(function(){
        var value = $(this).parents("tr").attr("id");
        $.get("getplanflight/"+value,function(e){
        	$(".flightId").val(value);
            $(".flightNumber").val(e.flightNumber);
            $(".airplane").val(e.airplane);
            $(".startDate").val(e.startDate);
            $(".endDate").val(e.endDate);
            $(".fromCity").val(e.fromCity);
            $(".toCity").val(e.toCity);
            $(".fromAirport").val(e.airportName);  
            $(".toAirport").val(e.toAirport);
            $(".departureTime").val(timestampToTime(e.departureTime));
            $(".arrivalTime").val(timestampToTime(e.arrivalTime));
            $(".scheduler").val(e.scheduler);
            $(".sailLength").val(e.sailLength);
        })
    })
    //删除
    $(".delete").click(function(){
    	 var value = $(this).parents("tr").attr("id");
    	$(".putid").val(value);
    })
      $(".deleteconfirm").click(function(){
    	    	$.get("deleteplanflight/"+$(".putid").val(),function(e){
    	    			if(e=="success"){
    	    				location.href="planflight";
    	    			}
    	    	})
    	    })
    //添加
    $(".sumbit").click(function(){
    	$('#sumbitform').reset();
    })
});