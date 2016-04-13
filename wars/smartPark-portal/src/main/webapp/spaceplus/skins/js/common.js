
$(function(){

	var w_w,w_h;
		w_w = $(window).width();
		w_h = $(window).height();
		
	$(".indexBox").css({width:w_w+"px",height:w_w*(1080/1920)+"px"});	
	
	$(window).resize(function(){
		w_w = $(window).width();	
		$(".indexBox").css({width:w_w+"px",height:w_w*(1080/1920)+"px"});	
		
	});

	
});














