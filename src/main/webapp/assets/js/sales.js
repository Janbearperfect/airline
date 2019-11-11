$(function(){
	$(".btn-primary").click(function(){
		var value = $(this).parents("tr").attr("id");
		$(".saleId").val(value);
		$.get("getSale/"+value,function(e){
			$(".number").val(e.number);
			$(".name").val(e.saleName);
			$(".password").val(e.password);
//			var opts;
//			for(var i=0;i<branchs.length();i++){
//				if(branchs[i].province==e.province){
//					opts="<select><option selected>"+e.province+"</option>"
//				}
//			}
//			$(".province").append("<select><option></option></select>")
			$(".province").val(e.name);
		},"json")
	})
	$(".save").click(function(){
		console.log($(".province").val());
		$.get("updateSale/"+$(".saleId").val()+"/"+$(".number").val()+"/"+$(".password").val()+"/"+$(".name").val()+"/"+$(".province").val(),function(e){
//			if("success".equals(e)){
				location.href="sales";
//				}
		})
	})
	$(".delete").click(function(){
		var value = $(this).parents("tr").attr("id");
		$(".putid").val(value);
	})
	$(".confirmdelete").click(function(){
		$.get("deleteSale/"+$(".putid").val(),function(e){
			if("success".equals(e)){
				location.href="sales";
			}
		})
	})
	$(".add").click(function(){
		$.get("saleBranch",function(e){
			console.log(e);
			var opts;
			for(var i=0;i<e.length;i++){
				opts+="<option>"+e[i].name+"</option>";
			}
			$("select").append(opts);
		})
	})
	$(".ok").click(function(){
		$.get("saveSale/"+$(".number1").val()+"/"+$(".name1").val()+"/"+$(".password1").val()+"/"+$("select").val(),function(e){
			location.href="sales";
		})
	})
	
});