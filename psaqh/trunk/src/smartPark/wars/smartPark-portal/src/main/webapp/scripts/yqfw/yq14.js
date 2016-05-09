$(".check-btn label").click(function(){
		if($(this).children('input[type="checkbox"]').prop("checked")){
			$(this).parent().next(".ib-btn").removeClass("bg-h");
			$(this).parent().next(".ib-btn").attr("href","yq2.html?enteringType=05");
		}else{
			$(this).parent().next(".ib-btn").addClass("bg-h");
			$(this).parent().next(".ib-btn").attr("href","javascript:;");
		}

	});