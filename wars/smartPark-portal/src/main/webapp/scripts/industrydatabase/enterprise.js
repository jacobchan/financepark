var pageSize=12;
var pageCount=1;
var serviceURL = baseUrl+"enterbusinessmanagerRzManager/getPagerEnterbusinessmanagerRzs.json";
function findabouttype(obj){
	var typeId = $("#"+obj).attr("data");
	var params = ['enTypeId.etypeEnterprisetype.enTypeId='+typeId];
	$.youi.ajaxUtils.ajax({
		url : serviceURL,
		data:params.join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(result){
			pageCount=Math.ceil(result.totalCount/pageSize);
			refreshData(1,pageSize,typeId);
			$(".tcdPageCode").createPage({
				pageCount:pageCount,
				current:1,
				backFn:function(p){
				   	this.pageCount=pageCount;
				    refreshData(p,pageSize,typeId);
				}
			});
		}
	});
	//根据企业名称搜索企业信息
//	$.youi.ajaxUtils.ajax({
//		url : serviceURL,
//		data:params.join('&'),
//		jsonp : 'data:jsonp',
//		dataType : 'jsonp',
//		async : false,
//		success : function(results) {
//			if (results && results.records) {
//				$("#enterprise").empty();
//				var records = results.records;
//				for(var i=0; i<records.length; i++){
//					var a = (stringLen(records[i].rzName)>20)?stringCut(records[i].rzName, 20):records[i].rzName;
//					var memberName = (stringLen(records[i].rzManager.memberName)>3)?stringCut(records[i].rzManager.memberName, 3):records[i].rzManager.memberName;
//					var enterDiv = '<div class="yqfu-com-centent">'+
//					'<div class="ycc-con"><img src="../styles/images/yqfw/comp1.png"></div>'+
//					'<a href="industry.html?id='+records[i].rzId+'"><p class="p-bottom">'+records[i].rzRemark+'</p></a>'+
//					'<div class="clearfix c-bottom lh24">'+
//					'<a href="industry.html?id='+records[i].rzId+'"><font class="c-o f14">'+a+'</font></a>'+
//					'<a href="javascript:;" class="yc-gz fr"><font class="f14">+</font>关注</a>'+
//					'<div class="clearfix c-p mt10">'+
//						'<span><img src="../styles/images/yqfw/map.png" class="mr5">武汉市</span>'+
//						'<span style="margin: 0px 33px;">'+
//						'<img src="../styles/images/yqfw/user.png" class="mr5">'+memberName+'</span>'+
//						'<span><img src="../styles/images/yqfw/ticket.png" class="mr5">'+records[i].enTypeId.enTypeName+'</span>'+
//					'</div></div></div>';
//					$("#enterprise").append(enterDiv);
//				}
//			}else{
//				$("#enterprise").empty();
//				$("#enterprise").append('<div class="tc" style="background:#f6f6f6;height:600px;"><img src="../styles/images/none1.png" border="0" style="margin-top:200px;" /></div>');
//			}
//		}
//	});
}
//获取字符串长度（中文2，英文1）
function stringLen(str) {
    var realLength = 0;
    var len = str != null ? str.length:0;
    var charCode = -1;
    for (var i = 0; i < len; i++) {
        charCode = str.charCodeAt(i);
        if (charCode >= 0 && charCode <= 128) realLength += 1;
        else realLength += 2;
    }
    return realLength;
}
//截取超过长度的字符
function stringCut(str, len) {
    var str_length = 0;
    var str_len = 0;
    str_cut = new String();
    str_len = str.length;
    for (var i = 0; i < str_len; i++) {
        a = str.charAt(i);
        str_length++;
        if (escape(a).length > 4) {
            //中文字符的长度经编码之后大于4  
            str_length++;
        }
        str_cut = str_cut.concat(a);
        if (str_length >= len) {
            str_cut = str_cut.concat("...");
            return str_cut;
        }
    }
    //如果给定字符串小于指定长度，则返回源字符串；  
    if (str_length < len) {
        return str;
    }
}
function refreshData(pageIndex,pageSize,typeId){
	$("#tp_7").removeClass("undis");
	var params = "";
	if(typeId!="" && typeId!=null){
		params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize,'enTypeId.etypeEnterprisetype.enTypeId='+typeId];
	}else{
		params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
	}
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		data:params.join('&'),
		success:function(results){
			if(results&&results.records){
				$("#tp_7").addClass("undis");
				_parseRecords(results.records);
			}
		}
	});
}
function _parseRecords(records){
	if(records.length>0){
		$("#enterprise").empty();
		for(var i=0;i<records.length;i++){
			var rzRemark = records[i].rzRemark;
			if(rzRemark == null){
				rzRemark = "";
			}
			var rzName = "--";
			if(records[i].rzName!="" && records[i].rzName!=null){
				rzName = (stringLen(records[i].rzName)>20)?stringCut(records[i].rzName, 20):records[i].rzName;
			}
			var memberName = "--";
			if(records[i].rzManager!=null){
				memberName = (stringLen(records[i].rzManager.memberName)>3)?stringCut(records[i].rzManager.memberName, 3):records[i].rzManager.memberName;
			}
			
			var enTypeName = "";
			if(records[i].enTypeId!=null){
				enTypeName = (stringLen(records[i].enTypeId.enTypeName)>3)?stringCut(records[i].enTypeId.enTypeName, 3):records[i].enTypeId.enTypeName;
			}
			var ioc = "../styles/images/yqfw/comp1.png";
			if(records[i].rzLogo!=null){
				ioc = cenUrl+"common/uploadImage.html?repository=/swfupload&path="+records[i].rzLogo+"&method=show";
			}
			var enterDiv = '<div class="yqfu-com-centent">'+
			'<a href="industry.html?id='+records[i].rzId+'"><div class="ycc-con"><img src="'+ioc+'" width="106" height="106"></div></a>'+
			'<a href="industry.html?id='+records[i].rzId+'"><p class="p-bottom">'+rzRemark+'</p></a>'+
			'<div class="clearfix c-bottom lh24">'+
			'<a href="industry.html?id='+records[i].rzId+'"><font class="c-o f14">'+rzName+'</font></a>'+
			'<a href="javascript:;" class="yc-gz fr"><font class="f14">+</font>关注</a>'+
			'<div class="clearfix c-p mt10">'+
				'<span><img src="../styles/images/yqfw/map.png" class="mr5">杭州市</span>'+
				'<span style="margin: 0px 33px;">'+
				'<img src="../styles/images/yqfw/user.png" class="mr5">'+memberName+'</span>'+
				'<span><img src="../styles/images/yqfw/ticket.png" class="mr5">'+enTypeName+'</span>'+
			'</div></div></div>';
			$("#enterprise").append(enterDiv);
			$(".tcdPageCode").show();
		}
	}else{
		$("#enterprise").empty();
		//无记录隐藏分页条
		$(".tcdPageCode").hide();
	}
}
function findEnterpriseTree(pId,y){
	$("#enterdd"+y).attr("data", pId);
	$.youi.ajaxUtils.ajax({
		url : baseUrl+'/etypeEnterprisetypeManager/findEnterpriseTypeTree.json',
		data : ['pId='+pId].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success:function(result){
			var json = eval("[" + result.record.html + "]");
			var enterpriseTypeDiv ='';
			for(var i=0; i<json.length; i++){
				enterpriseTypeDiv+=json[i].name+"<span>|</span>";
			}
			var lastJson = enterpriseTypeDiv.substring(0, enterpriseTypeDiv.lastIndexOf("<span>|</span>", enterpriseTypeDiv.length));
			$("#enterdd"+y).append(lastJson);
		}
	});
};
function search(txtName){
	var params = ['rzName='+txtName];
	var serviceURL = baseUrl+"enterbusinessmanagerRzManager/findEnterbusinessmanagerRzByName.json";
	if(txtName=='' || txtName.length==0){
		$('#toast_text').html('请输入企业名称！');
		$(".toast").show();
        setTimeout('$(".toast").hide();',3000);//1秒=1000
		return false;
	}
	//根据企业名称搜索企业信息
	$.youi.ajaxUtils.ajax({
		url : serviceURL,
		data:params.join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(results) {
			if (results && results.records) {
				$("#enterprise").empty();
				var records = results.records;
				for(var i=0; i<records.length; i++){
					var a = (stringLen(records[i].rzName)>20)?stringCut(records[i].rzName, 20):records[i].rzName;
					var memberName = (stringLen(records[i].rzManager.memberName)>3)?stringCut(records[i].rzManager.memberName, 3):records[i].rzManager.memberName;
					var enterDiv = '<div class="yqfu-com-centent">'+
					'<div class="ycc-con"><img src="../styles/images/yqfw/comp1.png"></div>'+
					'<a href="industry.html?id='+records[i].rzId+'"><p class="p-bottom">'+records[i].rzRemark+'</p></a>'+
					'<div class="clearfix c-bottom lh24">'+
					'<a href="industry.html?id='+records[i].rzId+'"><font class="c-o f14">'+a+'</font></a>'+
					'<a href="javascript:;" class="yc-gz fr"><font class="f14">+</font>关注</a>'+
					'<div class="clearfix c-p mt10">'+
						'<span><img src="../styles/images/yqfw/map.png" class="mr5">武汉市</span>'+
						'<span style="margin: 0px 33px;">'+
						'<img src="../styles/images/yqfw/user.png" class="mr5">'+memberName+'</span>'+
						'<span><img src="../styles/images/yqfw/ticket.png" class="mr5">'+records[i].enTypeId.enTypeName+'</span>'+
					'</div></div></div>';
					$("#enterprise").append(enterDiv);
				}
			}else{
				$("#enterprise").empty();
				$("#enterprise").append('<div class="tc" style="background:#f6f6f6;height:600px;"><img src="../styles/images/none1.png" border="0" style="margin-top:200px;" /></div>');
			}
		}
	});
};
function GetRequest() {
   var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      }
   }
   return theRequest;
}
$(function() {
	$(document).on("click",".w860 dd",function(){
		$(this).parent(".w860").prev(".dl-all").removeClass("active");
		$(this).addClass("active").siblings("dd").removeClass("active");
	});
	$(document).on("click",".yqfw-com-list .dl-all",function(){
		$(this).addClass("active");
		$(this).next(".w860").find("dd").removeClass("active");
	});
	$(document).on("click",".sub-bottom",function(){
		if($(this).children("i").hasClass("fa-angle-down")){
			$(this).addClass("active");
			$(this).children("i").removeClass("fa-angle-down").addClass("fa-angle-up");
			$(this).parents("dl").css("height","auto");
			$(this).parent(".w860").addClass("w860-bg");
		}else{
			$(this).removeClass("active");
			$(this).children("i").removeClass("fa-angle-up").addClass("fa-angle-down");
			$(this).parents("dl").css("height","44px");
			$(this).parent(".w860").removeClass("w860-bg");
		}
	});
	//按名称搜索企业
	$(".yih-btn-search").click(function() {
		var txtName = $("#rzName").val();
		search(txtName);
	});
	
	var Request = new Object();
	Request = GetRequest();
	var rzName = Request['rzName'];
	if(rzName == null || rzName == ""){
		$.youi.ajaxUtils.ajax({
			url : serviceURL,
			jsonp : 'data:jsonp',
			dataType : 'jsonp',
			success : function(result){
				pageCount=Math.ceil(result.totalCount/pageSize);
				refreshData(1,pageSize);
				$(".tcdPageCode").createPage({
					pageCount:pageCount,
					current:1,
					backFn:function(p){
					   	this.pageCount=pageCount;
					    refreshData(p,pageSize);
					}
				});
			}
		});
	}else{
		search(rzName);
	}
	
	//行业类型
	$("#tp_4").removeClass("undis") ;
	$.youi.ajaxUtils.ajax({
		url : baseUrl+'/etypeEnterprisetypeManager/getParentEnterpriseType.json',
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success:function(result){
			$("#tp_4").addClass("undis") ;
			$("#enterpriseTypeDiv").empty();
			var record = result.records;
			for(var i=0; i<record.length; i++){
				$("#enterpriseTypeDiv").append('<dd id="enterdd'+i+'" onclick="javascript:findabouttype(this.id);"></dd>');
				findEnterpriseTree(record[i].enTypeId,i);
			}
			$("#enterpriseTypeDiv").append('<div class="sub-bottom"><i class="fa fa-angle-down"></i></div>');
		}
	});
	
	//上市类型
	$("#tp_5").removeClass("undis") ;
	$.youi.ajaxUtils.ajax({
		url : baseUrl+'/informationFinancingManager/findCodeitem.json?code=rzType',
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success:function(result){
			if(result&&result.records){
				$("#tp_5").addClass("undis") ;
				var records = result.records;
				$("#belistedDiv").empty();
				for(var i=0; i<records.length; i++){
					$("#belistedDiv").append("<dd data-id='"+records[i].itemId+"' data-val='"+records[i].itemValue+"'>"+records[i].itemCaption+"</dd>");
				}
			}
		}
	});
	
	//公司性质
	$("#tp_6").removeClass("undis") ;
	$.youi.ajaxUtils.ajax({
		url : baseUrl+'/informationFinancingManager/findCodeitem.json?code=rzProperty',
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success:function(result){
			if(result&&result.records){
				$("#tp_6").addClass("undis") ;
				var records = result.records;
				$("#enterpriseNatureDiv").empty();
				for(var i=0; i<records.length; i++){
					$("#enterpriseNatureDiv").append("<dd data-id='"+records[i].itemId+"' data-val='"+records[i].itemValue+"'>"+records[i].itemCaption+"</dd>");
				}
			}
		}
	});
});