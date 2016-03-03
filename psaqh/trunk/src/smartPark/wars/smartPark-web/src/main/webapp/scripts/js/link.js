
$(function(){
		/*file:///E:/park/index.html*/
		var str=window.location;
		var reg=new RegExp("/park/","g");
		if(reg.test(str)){
			linkhead=RegExp.leftContext+"/park/";
		}
		
		$(".head-top a").attr("href",linkhead+"login.html");
		$(".logo").find("a").attr("href",linkhead+"index.html");
		$(".party-change").find("a").attr("href",linkhead+"zscenter/zs1.html");
		$(".index-head-nav li").eq(0).find("a").attr("href",linkhead+"index.html");
		$(".index-head-nav li").eq(1).find("a").eq(1).attr("href",linkhead+"zscenter/zs1.html");
		$(".index-head-nav li").eq(1).find("a").eq(2).attr("href",linkhead+"zscenter/zs2.html");
		$(".index-head-nav li").eq(1).find("a").eq(3).attr("href",linkhead+"zscenter/zs5.html");
		$(".index-head-nav li").eq(1).find("a").eq(4).attr("href",linkhead+"zscenter/zs3.html");
		$(".index-head-nav li").eq(1).find("a").eq(5).attr("href",linkhead+"zscenter/zs4.html");
		$(".index-head-nav li").eq(1).find("a").eq(6).attr("href",linkhead+"zscenter/zs6.html");
		
		$(".index-head-nav li").eq(2).find("a").eq(1).attr("href",linkhead+"wisdompark/office.html");
		$(".index-head-nav li").eq(2).find("a").eq(2).attr("href",linkhead+"wisdompark/business.html");
		$(".index-head-nav li").eq(2).find("a").eq(3).attr("href",linkhead+"wisdompark/safa.html");
		$(".index-head-nav li").eq(2).find("a").eq(4).attr("href",linkhead+"cg30/index.html");
		
		$(".index-head-nav li").eq(3).find("a").eq(1).attr("href",linkhead+"yqfw/yq13.html");
		$(".index-head-nav li").eq(3).find("a").eq(2).attr("href",linkhead+"yqfw/yq7.html");
		$(".index-head-nav li").eq(3).find("a").eq(3).attr("href",linkhead+"companyservice/carLease.html");
		$(".index-head-nav li").eq(3).find("a").eq(4).attr("href",linkhead+"yqfw/yq11.html");

		$(".index-head-nav li").eq(4).find("a").attr("href",linkhead+"companyservice/ITserver.html");
		
		$(".index-head-nav li").eq(5).find("a").eq(0).attr("href",linkhead+"czh/czh1.html");
		$(".index-head-nav li").eq(5).find("a").eq(1).attr("href",linkhead+"czh/czh2.html");
		$(".index-head-nav li").eq(5).find("a").eq(2).attr("href",linkhead+"czh/czh4.html");
		$(".index-head-nav li").eq(5).find("a").eq(3).attr("href",linkhead+"czh/czh5.html");
		$(".index-head-nav li").eq(5).find("a").eq(4).attr("href",linkhead+"cg30/store.html");
		
		var dh=$(".per-center-box > .fr").outerHeight()+"px";
		var bh=$(".bg-ff.clearfix.fl").outerHeight()+"px";
		$(".bg-f6").css("height",bh);
		$(".per-center-box .w200").css("height",dh);
		$(".per-center-box .w100p").css("height",dh);
	});