$(function(){
	var total=0;
	var info;
	var lists="";
	$(document).queue([function(){
		$.get("airport/list",function(e){
			for(var i = 0 ;i<3;i++){
				$("tbody:eq(1)").append("<tr id="+e[i].airportCode+"><td>"+e[i].airportCode+"</td><td>"+
				e[i].city+"</td><td>"+e[i].airportName+"</td><td>"+
					"<button type='button' class='btn btn-primary get' data-toggle='modal' data-target='.bs-example-modal-sm' style='margin-right:5px'>编辑</button>"+
					"<button type='button' class='btn btn-danger delete'data-toggle='modal' data-target='.bs-example-modal-md'>删除</button></td><tr>")
			}
			 var list="<ul class='nums'><li><<</li>";
			for(var j=0;j<(e.length/3);j++){
				list+="<li class='num'>"+(j+1)+"</li>";
			}
			lists+=list+"<li>>></li></ul>";
			info=e;
			total=e.length;
			$(document).dequeue();
		},"json");
		
	},function(){
		$("table").after(lists);
	}])
	$(".box").on("click",".num",function(){
		$("tbody:eq(1)").empty();
		var num = $(this).html();
		for(var i=((num-1)*3);i<num*3;i++){
			$("tbody:eq(1)").append("<tr id="+info[i].airportCode+"><td>"+info[i].airportCode+"</td><td>"+
					info[i].city+"</td><td>"+info[i].airportName+"</td><td>"+
						"<button type='button' class='btn btn-primary get' data-toggle='modal' data-target='.bs-example-modal-sm' style='margin-right:5px'>编辑</button>"+
						"<button type='button' class='btn btn-danger delete'data-toggle='modal' data-target='.bs-example-modal-md'>删除</button></td><tr>")
		}
	})
	$(".get").click(function(){
		var value = $(this).parents("tr").attr("id");
		$.get("getAirport/"+value,function(e){
			$(".airportCode").val(e.airportCode);
			$(".city").val(e.city);
			$(".airportName").val(e.airportName);
		},"json")
	})
	$(".save").click(function(){
		$.get("updateAirport/"+$(".airportCode").val()+"/"+$(".city").val()+"/"+$(".airportName").val(),function(e){
			if("success"==e){
				location.href="airport";
				}
		})
	})
	$(".delete").click(function(){
		var value = $(this).parents("tr").attr("id");
		$(".putid").val(value);
	})
	$(".confirmdelete").click(function(){
		$.get("deleteAirport/"+$(".putid").val(),function(e){
			if("success"==e){
				location.href="airport";
			}
		})
	})
	$(".addone").click(function(){
		$.get("saveAirport/"+$(".airportCode1").val()+"/"+$(".city1").val()+"/"+$(".airportName1").val(),function(e){
			if("success"==e){
				location.href="airport";
				}
		})
	})
	
	
	
	
});