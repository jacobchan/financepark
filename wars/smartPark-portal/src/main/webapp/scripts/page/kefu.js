
$(function(){
	var htmls='';
		htmls+='<div class="commonRight">';
		htmls+='<ul class="comRiglist">';
		htmls+='<li class="comRigli-top" style="display:none"><i class="comRigli-icon"></i></li>';
		htmls+='<li class="comRigli-qq"><a href="http://wpa.qq.com/msgrd?v=3&uin=12345678&site=qq&menu=yes" target="_blank"><i class="comRigli-icon"></i></a></li>';
		htmls+='<li class="comRigli-tel">';
		htmls+='<i class="comRigli-icon"></i>';
		htmls+='<div class="comRighide comRighide-tel">';
		htmls+='<h4>服务中心</h4><p>0571-87192899</p><p>0571-87192869</p><h4>招商中心</h4><p>0571-86508888</p>';
		htmls+='</div></li></ul></div>';
	$("body").append(htmls);
	$(document).on("click",".commonRight .comRigli-top",function(){
		$('body,html').animate({scrollTop:0},800);
	})
    $(window).scroll(function() {    
        if($(window).scrollTop()>100){
            $(".comRigli-top").fadeIn();
        }else{
            $(".comRigli-top").fadeOut();
        }
    });
});