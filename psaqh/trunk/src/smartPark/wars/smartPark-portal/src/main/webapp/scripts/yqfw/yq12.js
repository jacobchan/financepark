 var lb_two_index = 0;
	    var n=$(".lb-two ul li").length-2;
	    var m=$(".lt-circle a").length;
	    function lb_two_right(){
	        lb_two_index++;
	        if(lb_two_index > n){
	            lb_two_index = 0;
	        }
	        lb_two_show(lb_two_index);
	    }
	    function lb_two_left(){
	        lb_two_index--;
	        if(lb_two_index < 0){
	            lb_two_index = n;
	        }
	       lb_two_show(lb_two_index);
	    }
	    function lb_two_show(j){
	    	$(".lt-circle a").removeClass('current');
	    	var index = -(j*403);
	        $(".lb-two ul").animate({left: index+'px'},400);
	        
	        if(j<2){
	    		$(".lt-circle a").eq(0).addClass('current');
	    	}else if(j % 2 == 0 && j >1){
	    		var i=j/2;
	    		$(".lt-circle a").eq(i).addClass('current');
	    	}else{
	    		if(j==n ){
	    			$(".lt-circle a").eq(m-1).addClass('current');
	    		}else{
	    			var i=(j-1)/2;
	    			$(".lt-circle a").eq(i).addClass('current');
	    		}
	    		
	    	}
	    }
	    function lb_two_show1(i){
	    	if(i!= n/2 && i==m-1){
	    	 var index = -((i-1)*806 + 403);
	    	}else{
	    		var index = -(i*806);
	    	}
	        $(".lb-two ul").animate({left: index+'px'},400);
	        $(".lt-circle a").removeClass('current');
	        $(".lt-circle a").eq(i).addClass('current');
	    }
	    
	    $(".lt-circle a").click(function(){
	        var index = $(".lt-circle a").index($(this));
	        lb_two_show1(index);
	        if(index == m-1){
	        	lb_two_index=n;
	        }else if(index < m){
	        	lb_two_index = index*2;
	        }
	    });
	    $(".lt-page .lp-right").click(function(){
	        lb_two_right();
	    });
	    $(".lt-page .lp-left").click(function(){
	        lb_two_left();
	    });