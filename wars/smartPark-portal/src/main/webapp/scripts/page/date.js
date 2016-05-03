// JavaScript Document
//Gulf 2016.4.5
(function(){
  var date = new Date(),next_opt,month=month =  date.getMonth()+1; 
  $.fn.dateplug=function(options){
		var opt = $.extend({},$.fn.dateplug.defaults,options);
        return this.each(function(){
			 var $this = $(this); 
		     $this.html(createHtml(opt));
			 if(!opt.showBtn){
				$this.find(".next-mon,.prev-mon").hide();
			 }else{
				$this.on("click",".next-mon,.prev-mon",function(){
				   next_opt = opt;
				   if($(this).hasClass("next-mon")){
					  if(next_opt.month == 12){
						  next_opt.month = 1;
						  next_opt.year  = next_opt.year+1;  
					  }else{
						  next_opt.month =  next_opt.month+1;
					  }
					  
				   }else{
					  if(next_opt.month==1){
						  next_opt.month = 12;
						  next_opt.year = next_opt.year-1;  
					  }else{
						  next_opt.month = next_opt.month-1;  
					  }
				   }
				   opt.price = $.fn.dateplug.monthajax($(this));
				   $this.html(createHtml(next_opt));
				}) 
			 }
			 $this.on("click","#pick-up",function(){
				 $this.slideUp();
				 });
		     $this.on("click","tbody td",function(){
				  if($(this).hasClass("ago")||$(this).html().length==0){
					 return;  
				  }else{
					 $(this).parent().parent().find("td").removeClass("current");
					 $(this).addClass("current");
					 $.fn.dateplug.ajax();  
				  }
				 })
	    })  
  }
  $.fn.dateplug.defaults = {
			 year:date.getFullYear(),
			 month:date.getMonth()+1,
			 day:date.getDate(),
			 showBtn:true,
			 price:[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
  };
  $.fn.dateplug.ajax = function(){}
  $.fn.dateplug.monthajax =  function(){
	  alert("写个方法获取这个月的数据")
  }
  function createHtml(opt){
	  var html = '<table class="kalendar-table" border="0" cellpadding="0" cellspacing="0"><thead><tr><td colspan="7"><a href="javascript:;" class="pull-left prev-mon"><</a><span id="kalendar_year">'
	             +opt.year+'</span>年<span id="kalendar_month">'+opt.month+'</span>月<a href="javascript:;" class="pull-right next-mon">></a><div class="border"></div> </td></tr></thead><tbody>';
	  var date_month = new Date();
	      date_month.setFullYear(opt.year,opt.month,0),
		  days = date_month.getDate();//这个月一共多少天
		  date_month.setDate(1);
		  first_day =(date_month.getDay()==0?7:date_month.getDay())-1;//月初第一天是星期几
		  day_now = opt.day;
	  var len = Math.ceil((days+first_day)/7);
		  for(var i= 0;i<len;i++){
			 for(var j=0;j<7;j++){
				 if(j==0){
				   html+='<tr>';
			     }
				 var now = i*7+j+1,now_num = now-first_day,price = !opt.price[now_num-1]?"&nbsp;":("￥"+opt.price[now_num-1]);
				 if(first_day<now&&now<=days+first_day){
					if(opt.month>month || opt.month==month && now_num>=day_now){
						html+='<td><p>'+now_num+'</p><p class="price">'+price+'</p></td>'; 
					}else{
					    html+='<td class="ago"><p>'+now_num+'</p><p class="price">'+price+'</p></td>'; 
					}
				 }else{
					html+="<td></td>" 
				 }
				 if(j==6){
					html+='</tr>'; 
				 }
			 }
		  }
		  html+='</tbody></table><a id="pick-up" class="pick-up" href="javascript:void(0);"><i></i>收起特价日历</a>';
		  return html;
  }
})(jQuery)