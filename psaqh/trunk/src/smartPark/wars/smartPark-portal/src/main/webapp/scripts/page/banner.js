  var w=parseInt($(window).width());
	$(".banner-nav li").css("width",w+"px");
	var n=0;
  $(".slideBox .banner-nav").animate({marginLeft:0},0);
  $(".pagtion div").removeClass("pt1").eq(n).addClass("pt1");
  var m=$(".banner-nav li").length;
   function run(){
    if(n<m-1){
      n++;
      $(".slideBox .banner-nav").animate({marginLeft:-w*n},500);
      $(".pagtion div").removeClass("pt1").eq(n).addClass("pt1");
    }else if(n == m - 1){ 
      n=0;
      $(".slideBox .banner-nav").animate({marginLeft:0},500);
      $(".pagtion div").removeClass("pt1").eq(n).addClass("pt1");
    }
  }
  var timer = setInterval(run,3000);
  $(".pagtion div").hover(function(){
      clearInterval(timer);
    	n=$(this).index();
    	$(this).addClass("pt1").siblings().removeClass("pt1");
    	$(".slideBox .banner-nav").animate({marginLeft:-w*(n)},500);
  },function(){ timer = setInterval(run,3000)})

