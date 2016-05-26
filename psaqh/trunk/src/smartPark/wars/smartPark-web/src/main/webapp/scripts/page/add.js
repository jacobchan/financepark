$(document).ready( function() {
	$("#moreul").slideDown("slow");
	var $submenu = $('.sidebar-menu-mainul2');
	var $mainmenu = $('.sidebar-menu-mainul');
	var $actmenu = $('.activmenu');
    var on=true;
	$submenu.hide();
	$actmenu.show();
	$mainmenu.on('click', 'li', function() {
		$(this).siblings().find('.sidebar-menu-mainul2').slideUp();
		$(this).find('.sidebar-menu-mainul2').slideToggle();
        if(on){
            $(this).find('.down-icon img').attr('src','../styles/images/qiye/angle-down.png');
            on=false;
        }else {
            $(this).find('.down-icon img').attr('src','../styles/images/qiye/angle-up.png');
            on=true;
        }
	});
});