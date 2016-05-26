$(function(){
	var on=true;
	$("#more").click(function(){
		$(this).siblings().slideToggle();
        if(on){
            $(this).find('.down-icon img').attr('src','../styles/images/qiye/angle-down.png');
            on=false;
        }else {
            $(this).find('.down-icon img').attr('src','../styles/images/qiye/angle-up.png');
            on=true;
        }
	});
});