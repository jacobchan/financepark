$(function(){
			$(".yih-btn-search").click(function(){
				var obj={
				fkcodeComp:$("#rzName").val()
				};
				var str=JSON.stringify(obj);
				alert(str);
			})
		})