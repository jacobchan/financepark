$(function () {
	$(".index-fr-nav li").click(function(){
		$(".index-fr-nav li").removeClass("active");
		$(this).addClass("active");
		$(".ifn-group ul").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
	});
	$(".check-btn label").click(function(){
		if($(this).children('input[type="checkbox"]').prop("checked")){
			$(this).parent().next(".ib-btn").removeClass("bg-h");
		}else{
			$(this).parent().next(".ib-btn").addClass("bg-h");
		}
	})
	$(".ht-table td>a.em1").click(function(){
		$(".ht-table td>a.em1").removeClass("active");
		$(this).toggleClass("active");
	})
	$(".sex-group span").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
	})
	$(".index-fr-nav li").click(function(){
		$(".index-fr-nav li").removeClass("active");
		$(this).addClass("active");
		$(".ifn-group ul").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
	});
	$(".wybx-tanc .label label").click(function(){
		if($(this).children('input[type="radio"]').prop("checked")){
			if($(this).index()==0){
				$(".wybx-tanc .show1").removeClass("undis");
				$(".wybx-tanc .show2").addClass("undis");
			}else{
				$(".wybx-tanc .show1").addClass("undis");
				$(".wybx-tanc .show2").removeClass("undis");
			}
		}
	})	
	$(".tc-close").click(function(){
		$(".bg-tanc").hide();
	});
	$(".select-address").click(function(){
		$(this).parent().find(".select-address").removeClass("active");
		$(this).addClass("active");
	})
	$(".ic-select").click(function(e){
		$(".select-nav").hide();
	    $(this).next(".select-nav").show();
	    e.stopPropagation();//闃绘�鍐掓场
	});
	$("body").click(function(){
	     $(".select-nav").hide();
	})
	$(".select-nav li").click(function(){
		$(this).parents(".tct-select").find(".ic-select p").text($(this).text()) ;
		$(this).parent().hide();
	})
	$(".open-tanc").click(function(){
		$(".bg-tanc").show();
	});
	$(".set-file").hover(function(){
		$(this).prev(".set-file1").css("background","#17e155");
	},function(){
		$(this).prev(".set-file1").css("background","#35c461");
	})
	$(".setting-table label").click(function(){
		if($(this).children('input[name="yesNo"]').prop("checked")){
			if($(this).index()==0){
				$(this).parents("table").find(".yn-show").show();
			}else{
				$(this).parents("table").find(".yn-show").hide();
			}
		}
	});
	$(".yc-gz").click(function(){
		$(this).toggleClass("active");
	});
	$(".sub-bottom").click(function(){
		if($(this).children("i").hasClass("fa-angle-down")){
			$(this).children("i").removeClass("fa-angle-down").addClass("fa-angle-up")
			$(this).parents("dl").css("height","auto");
			$(this).parent(".w860").addClass("w860-bg");
		}else{
			$(this).children("i").removeClass("fa-angle-up").addClass("fa-angle-down")
			$(this).parents("dl").css("height","44px");
			$(this).parent(".w860").removeClass("w860-bg");
		}
	})
	$(".w860 dd").click(function(){
		$(this).toggleClass("active");
		var m=$(this).parent().find("dd").size();
		var n=0;
		$(this).parent().find("dd").each(function(){
	      if($(this).hasClass("active")){
	      	n++;
	      }else{
	      	n=n;
	      }
	    });
	    if(m == n){
	    	$(this).parents("dl").find("dd input[type='checkbox']").prop("checked",true);
	    }else{
	    	$(this).parents("dl").find("dd input[type='checkbox']").prop("checked",false);
	    }
	});
	$(".yqfw-com-list dd input[type='checkbox']").click(function(){
	   if($(this).prop("checked")){
			$(this).parents("dl").find(".w860 dd").addClass("active");
		}else{
			$(this).parents("dl").find(".w860 dd").removeClass("active");
		}
	});

	$(".yqfw-intro-nav li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
		$(".yin-group").eq($(this).index()).removeClass("undis").siblings().addClass("undis");
	});
	$(".yci-bottom").click(function(){
		if($(this).children("i").hasClass("fa-angle-down")){
			$(this).children("i").removeClass("fa-angle-down").addClass("fa-angle-up")
			$(this).prev("p").css("height","auto");
		}else{
			$(this).children("i").removeClass("fa-angle-up").addClass("fa-angle-down")
			$(this).prev("p").css("height","96px");
		}
	})
	$(".order-show").click(function(){
		$(this).find("ul").show();
	})

	
})