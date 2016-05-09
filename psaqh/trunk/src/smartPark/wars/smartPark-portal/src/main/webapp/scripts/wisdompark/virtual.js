$(function(){
		$(document).on("mouseover mouseout",".zzul .b1",function(){
			$(".b-o .build").toggle();
		});
		$(document).on("mouseover mouseout",".zzul .b1 li",function(){
			var index = $(this).index() + 2 ;
			$(".b-o .build div").eq(index).find("img").toggle();
		});
		$(document).on("mouseover mouseout",".zzul .b2",function(){
			$(".b-t .build").toggle();
		});
		$(document).on("mouseover mouseout",".zzul .b2 li",function(){
			var index = $(this).index() + 2 ;
			$(".b-t .build div").eq(index).find("img").toggle();
		});
		$(document).on("mouseover mouseout",".build div:not(.bof)",function(){
				$(this).find("img").toggle();
		});
	});
$(function(){
	$.youi.ajaxUtils.ajax({
		url:baseUrl +"bbmParkManager/getBbmParks.json",//得到所有的园区
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			if(result.records.length > 0){
				var park = result.records[0] ;//获取第一个园区
				var parkId = park.parkId ;//得到园区ID
				var params = ["parkId="+parkId];
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"bbmBuildingManager/getAllBuildingByParkId.json",//通过园区ID来获取该园区所有楼栋
					data:params.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						 if(result&&result.records){
							_parseRecords(result.records) ;
						} 
					}
				});
			}
		} 
	});
});
function _parseRecords(record){//record为楼栋的list
	for(var i=0;i<record.length;i++){
		var obj = record[i] ;
		var index = i+1;
		var t = "b"+index ;
		var	html = "<li class="+ t +" id="+obj.buildingId+"><a class='y1' href='#'>"+obj.buildingName+"</a><ul class='subul'></ul></li>"
		$(".oh.fl.zzul").append(html);
	}
	for(var j=0;j<record.length;j++){
		var obj = record[j] ;
		findFloorList(obj.buildingId) ;
	}
	$("#loading").addClass("undis") ;
	$(".zznav").show() ;
}

function findFloorList(buildingId){
	var params = ["buildingId="+buildingId];
	$.youi.ajaxUtils.ajax({
		url:baseUrl +"bbmFloorManager/getBbmFloorByBuildingId.json",
		data:params.join('&'),
		jsonp:'data:jsonp',
		dataType:'jsonp',
		success:function(result){
			if(result&&result.records){
				var html = appendHtml(result.records) ;
				$("#"+buildingId).find(".subul").empty();
				$("#"+buildingId).find(".subul").append(html) ;
			}
		}
	});
}
function appendHtml(record){
	var html = "";
	for(var i=0;i<record.length;i++){
		var obj = record[i] ;
		var num = obj.floorNo ;
		if(num == "1F" || num == "2F"){
			
		}else{
			html += "<li id="+obj.floorId+"><a href='wp_login.html?floorId="+obj.floorId+"'>"+obj.floorNo+"</a></li>" ;
		}
	}
	return html ;
}