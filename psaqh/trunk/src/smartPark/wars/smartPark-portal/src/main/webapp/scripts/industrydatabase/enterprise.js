var pageSize=4;
var pageCount=1;
var serviceURL = baseUrl+"enterbusinessmanagerRzManager/getPagerEnterbusinessmanagerRzs.json";
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
function refreshData(pageIndex,pageSize){
	var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
	$.youi.ajaxUtils.ajax({
		url:serviceURL,
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		data:params.join('&'),
		success:function(results){
			if(results&&results.records){
				_parseRecords(results.records);
			}
		}
	});
}
function _parseRecords(records){
	if(records.length>0){
		$("#enterprise").empty();
		for(var i=0;i<records.length;i++){
			var memberName = records[i].rzManager.memberName;
			if(memberName.length > 3){
				memberName = memberName.substr(0,3);
			}
			var enTypeName = records[i].enTypeId.enTypeName;
			if(enTypeName.length > 3){
				enTypeName = enTypeName.substr(0,3);
			}
			var rzRemark = records[i].rzRemark;
			if(rzRemark == null){
				rzRemark = "";
			}
			var a = (stringLen(records[i].rzName)>20)?stringCut(records[i].rzName, 20):records[i].rzName;
			var enterDiv = '<div class="yqfu-com-centent">'+
			'<div class="ycc-con"><img src="../styles/images/yqfw/comp1.png" width="106" height="106"></div>'+
			'<a href="industry.html?id='+records[i].rzId+'"><p class="p-bottom">'+rzRemark+'</p></a>'+
			'<div class="clearfix c-bottom lh24">'+
			'<a href="industry.html?id='+records[i].rzId+'"><font class="c-o f14">'+a+'</font></a>'+
			'<a href="javascript:;" class="yc-gz fr"><font class="f14">+</font>关注</a>'+
			'<div class="clearfix c-p mt10">'+
				'<span><img src="../styles/images/yqfw/map.png" class="mr5">武汉市</span>'+
				'<span style="margin: 0px 33px;">'+
				'<img src="../styles/images/yqfw/user.png" class="mr5">'+memberName+'</span>'+
				'<span><img src="../styles/images/yqfw/ticket.png" class="mr5">'+enTypeName+'</span>'+
			'</div></div></div>';
			$("#enterprise").append(enterDiv);
		}
	}else{
		//无记录隐藏分页条
		$(".tcdPageCode").hide();
	}
}
function findEnterpriseTree(pId){
	
	$.youi.ajaxUtils.ajax({
		url : baseUrl+'/etypeEnterprisetypeManager/findEnterpriseTypeTree.json',
		data : ['pId='+pId].join('&'),
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success:function(result){
			var json = eval("[" + result.record.html + "]");
			var enterpriseTypeDiv ='<dd>';
			for(var i=0; i<json.length; i++){
				enterpriseTypeDiv+=json[i].name+"<span>|</span>";
			}
			var lastJson = enterpriseTypeDiv.substring(0, enterpriseTypeDiv.lastIndexOf("<span>|</span>", enterpriseTypeDiv.length));
			$("#enterpriseTypeDiv").append(lastJson+'</dd><div class="sub-bottom"><i class="fa fa-angle-down"></i></div>');
		}
	});
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
		var params = ['rzName='+txtName];
		var serviceURL = baseUrl+"enterbusinessmanagerRzManager/findEnterbusinessmanagerRzByName.json";
		if(txtName=='' || txtName.length==0){
			alert("请输入企业名称");
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
					var records = results.records;
					for(var i=0; i<records.length; i++){
						var a = (stringLen(records[i].rzName)>20)?stringCut(records[i].rzName, 20):records[i].rzName;
						var enterDiv = '<div class="yqfu-com-centent">'+
						'<div class="ycc-con"><img src="../styles/images/yqfw/comp1.png"></div>'+
						'<a href="industry.html?id='+records[i].rzId+'"><p class="p-bottom">'+records[i].rzRemark+'</p></a>'+
						'<div class="clearfix c-bottom lh24">'+
						'<a href="industry.html?id='+records[i].rzId+'"><font class="c-o f14">'+a+'</font></a>'+
						'<a href="javascript:;" class="yc-gz fr"><font class="f14">+</font>关注</a>'+
						'<div class="clearfix c-p mt10">'+
							'<span><img src="../styles/images/yqfw/map.png" class="mr5">武汉市</span>'+
							'<span style="margin: 0px 33px;">'+
							'<img src="../styles/images/yqfw/user.png" class="mr5">'+records[i].rzManager.memberName+'</span>'+
							'<span><img src="../styles/images/yqfw/ticket.png" class="mr5">'+records[i].enTypeId.enTypeName+'</span>'+
						'</div></div></div>';
						$("#enterprise").empty();
						$("#enterprise").append(enterDiv);
					}
				}else{
					$("#enterprise").empty();
					$("#enterprise").append('<div class="tc" style="background:#f6f6f6;height:600px;"><img src="../styles/images/none1.png" border="0" style="margin-top:200px;" /></div>');
				}
			}
		});
	});
	
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
	
	//企业列表
	//获取所有企业信息
	/*$("#enterprise").empty();
	var serviceURL = baseUrl+"enterbusinessmanagerRzManager/getEnterbusinessmanagerRzs.json";
	$.youi.ajaxUtils.ajax({
		url : serviceURL,
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success : function(results) {
			if (results && results.records) {
				var records = results.records;
				for(var i=0; i<records.length; i++){
					var a = (stringLen(records[i].rzName)>20)?stringCut(records[i].rzName, 20):records[i].rzName;
					var enterDiv = '<div class="yqfu-com-centent">'+
					'<div class="ycc-con"><img src="/filestore/'+records[i].rzLogo+'" width="106" height="106"></div>'+
					'<a href="industry.html?id='+records[i].rzId+'"><p class="p-bottom">'+records[i].rzRemark+'</p></a>'+
					'<div class="clearfix c-bottom lh24">'+
					'<a href="industry.html?id='+records[i].rzId+'"><font class="c-o f14">'+a+'</font></a>'+
					'<a href="javascript:;" class="yc-gz fr"><font class="f14">+</font>关注</a>'+
					'<div class="clearfix c-p mt10">'+
						'<span><img src="../styles/images/yqfw/map.png" class="mr5">武汉市</span>'+
						'<span style="margin: 0px 33px;">'+
						'<img src="../styles/images/yqfw/user.png" class="mr5">'+records[i].rzManager.memberName+'</span>'+
						'<span><img src="../styles/images/yqfw/ticket.png" class="mr5">'+records[i].enTypeId.enTypeName+'</span>'+
					'</div></div></div>'
					$("#enterprise").append(enterDiv);
				}
			}
		}
	});*/
	//行业类型
	$.youi.ajaxUtils.ajax({
		url : baseUrl+'/etypeEnterprisetypeManager/getParentEnterpriseType.json',
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success:function(result){
			$("#enterpriseTypeDiv").empty();
			var record = result.records;
			for(var i=0; i<record.length; i++){
				findEnterpriseTree(record[i].enTypeId);
			}
		}
	});
	
	//上市类型
	$.youi.ajaxUtils.ajax({
		url : baseUrl+'/informationFinancingManager/findCodeitem.json?code=rzType',
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success:function(result){
			if(result&&result.records){
				var records = result.records;
				$("#belistedDiv").empty();
				for(var i=0; i<records.length; i++){
					$("#belistedDiv").append("<dd data-id='"+records[i].itemId+"' data-val='"+records[i].itemValue+"'>"+records[i].itemCaption+"</dd>");
				}
			}
		}
	});
	
	//公司性质
	$.youi.ajaxUtils.ajax({
		url : baseUrl+'/informationFinancingManager/findCodeitem.json?code=rzProperty',
		jsonp : 'data:jsonp',
		dataType : 'jsonp',
		async : false,
		success:function(result){
			if(result&&result.records){
				var records = result.records;
				$("#enterpriseNatureDiv").empty();
				for(var i=0; i<records.length; i++){
					$("#enterpriseNatureDiv").append("<dd data-id='"+records[i].itemId+"' data-val='"+records[i].itemValue+"'>"+records[i].itemCaption+"</dd>");
				}
			}
		}
	});
});