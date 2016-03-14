$(function () {
	/*左右移动*/
	 var sbysf_index = 0;
	    var n=$(".space-centent ul li").length-3;
	    function sbysf_scroll_up(){
	        sbysf_index++;
	        if(sbysf_index > n){
	            sbysf_index = 0;
	        }
	        sbysf_show(sbysf_index);
	    }
	    function sbysf_scroll_down(){
	        sbysf_index--;
	        if(sbysf_index < 0){
	            sbysf_index = n;
	        }
	        sbysf_show(sbysf_index);
	    }
	    function sbysf_show(j){
	        var index = -(j*375);
	        $(".space-centent ul").animate({left: index+'px'},200);
	    }
	    $(".space-centent .arrow-right").click(function(){
	        sbysf_scroll_up();
	    });
	    $(".space-centent .arrow-left").click(function(){
	        sbysf_scroll_down();
	    });
	    
	/*弹出模态框*/
	$(".sc-yy").click(function(){
		$(".bg-tanc.m1").show();
	});
	$(".tc-close").click(function(){
		$(".bg-tanc").hide();
	});
})