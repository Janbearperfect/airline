var e =null;
var chart = null; // 定义全局变量
$(document).ready(function() {

 $.ajax({
	    url: '/airline/dailyfinancialdata',
	    success: function(point) {
	    	e = JSON.parse(JSON.stringify(point));
	    	view(e);
	  }
  })
	function view(e){
		chart = Highcharts.chart('viewone', {
			chart: {
				plotBackgroundColor: null,
				plotBorderWidth: null,
				plotShadow: false,
				type: 'pie',
//				events: {
//			        load: requestData // 图表加载完毕后执行的回调函数
//			      }
			},
			title: {
				text: '每日财务报表-舱位等级'
			},
			tooltip: {
				pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			},
			plotOptions: {
				pie: {
					allowPointSelect: true,
					cursor: 'pointer',
					dataLabels: {
						enabled: true,
						format: '<b>{point.name}</b>: {point.percentage:.1f} %',
						style: {
							color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
						}
					}
				}
			},

			series: [{
				name: 'Brands',
				colorByPoint: true,
				data: e
			}]
		});
	
	}
});	
$(document).ready(function() {

	 $.ajax({
		    url: '/airline/dailyfinancialdata2',
		    success: function(point) {
		    	e = JSON.parse(JSON.stringify(point))
		    	view(e)
		  }
	  })
		function view(e){
			chart = Highcharts.chart('viewtwo', {
				chart: {
					plotBackgroundColor: null,
					plotBorderWidth: null,
					plotShadow: false,
					type: 'pie',
//					events: {
//				        load: requestData // 图表加载完毕后执行的回调函数
//				      }
				},
				title: {
					text: '每日财务报表-乘客类型'
				},
				tooltip: {
					pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				},
				plotOptions: {
					pie: {
						allowPointSelect: true,
						cursor: 'pointer',
						dataLabels: {
							enabled: true,
							format: '<b>{point.name}</b>: {point.percentage:.1f} %',
							style: {
								color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
							}
						}
					}
				},

				series: [{
					name: 'Brands',
					colorByPoint: true,
					data: e
				}]
			});
		
		}
	});