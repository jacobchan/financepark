// 中文字符判断
function getStrLength(str) { 
	var len = str.length; 
    var reLen = 0; 
    for (var i = 0; i < len; i++) {        
        if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) { 
            // 全角    
            reLen += 2; 
        } else { 
            reLen++; 
        } 
    } 
    return reLen;    
}
var zNodes = "";
var roomNodes = "";
var setting = {
	check: {
		enable: true,
		chkStyle: "radio",
		radioType: "all"
	},
	view: {
		dblClickExpand: false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: onClick,
		onCheck: onCheck
	}
};
var rooms = {
	check: {
		enable: true,
		chkStyle: "radio",
		radioType: "all"
	},
	view: {
		dblClickExpand: false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: roomClick,
		onCheck: roomCheck
	}
};
function onClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}
function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = zTree.getCheckedNodes(true);
	var v = "";
	var m = "";
	for (var i=0, l=nodes.length; i<l; i++) {
		v += nodes[i].id + ",";
		m += nodes[i].name + ",";
	}
	if (v.length > 0 ) v = v.substring(0, v.length-1);
	if (m.length > 0 ) m = m.substring(0, m.length-1);
	$("#enTypeId").val(v);
	$("#enTypeName").val(m);
}
function roomClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeRoom");
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}
function roomCheck(e, treeId, treeNode) {
	var roomTree = $.fn.zTree.getZTreeObj("treeRoom");
	var nodesRoom = roomTree.getCheckedNodes(true);
	var k = "";
	var n = "";
	for (var j=0, l=nodesRoom.length; j<l; j++) {
		k += nodesRoom[j].id + ",";
		n += nodesRoom[j].name + ",";
	}
	if (k.length > 0 ) k = k.substring(0, k.length-1);
	if (n.length > 0 ) n = n.substring(0, n.length-1);
	$("#roomId").val(k);
	$("#roomAddress").val(n);
}
function showMenu() {
	var cityObj = $("#enTypeName");
	var cityOffset = $("#enTypeName").offset();
	$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown);
}
function showRoom() {
	var roomObj = $("#roomAddress");
	var roomOffset = $("#roomAddress").offset();
	$("#roomContent").css({left:roomOffset.left + "px", top:roomOffset.top + roomObj.outerHeight() + "px"}).slideDown("fast");
	$("body").bind("mousedown", onBodyRoom);
}
function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}
function hideRoom() {
	$("#roomContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyRoom);
}
/*function dataJson(data) {
	zNodes = eval("[" + data + "]");
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
}*/
/*function roomJson(data) {
	roomNodes = eval("[" + data + "]");
	$.fn.zTree.init($("#treeRoom"), rooms, roomNodes);
}*/
function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "enTypeName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
		hideMenu();
	}
}
function onBodyRoom(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "roomAddress" || event.target.id == "roomContent" || $(event.target).parents("#roomContent").length>0)) {
		hideRoom();
	}
}
$(function() {
	/*$.ajax({
		url:baseUrl+'/etypeEnterprisetypeManager/findEnterpriseTypeTree.json',
		success:function(result){
			dataJson(result.record.html);
		}
	});	*/
  	var editor = CKEDITOR.replace('editorproductDiscriptio');
  	editor.updateElement();
	$("#rzRemark").on('keyup', function() {
	    var len = getStrLength(this.value);
	    $("#currentCount").html(len);
	});
  	/*$.ajax({
		url:baseUrl+'/memberInformationManager/getMemberInformationByLoginUser.json',
		success:function(result){
			if(result&&result.record){
				$("#financingRe").html(result.record.companyId);
				$.ajax({
					url:baseUrl+'/enterbusinessmanagerRzManager/getEnterbusinessmanagerRz.json',
					data : ['rzId='+result.record.companyId].join('&'),
					success:function(result){
						if(result&&result.record){
							//$("#rzLogo").attr("src","http://localhost:9088/filestore/"+result.record.rzLogo);
							$("#financingRe").html(result.record.rzId);
							$("#rzName").val(result.record.rzName);
	    					$("#rzUrl").val(result.record.rzUrl);
	    					$("#rzRemark").val(result.record.rzRemark);
	    					$("#enTypeId").val(result.record.enTypeId.enTypeId);
	    					$("#enTypeName").val(result.record.enTypeId.enTypeName);
	    					$("#roomId").val(result.record.roomId.roomId);
	    					$("#roomAddress").val(result.record.roomId.roomAddress);
	    					$("#editorproductDiscriptio").val(result.record.productDiscriptio);
	    					editor.setData(result.record.productDiscriptio);
	    					$("#currentCount").html(getStrLength(result.record.rzRemark));
	    					
	    					$.ajax({
								url:baseUrl+'/bbmRoomManager/getRoomByRzId.json',
								data : ['rzId='+$("#financingRe").html()].join('&'),
								success:function(result){
									if(result&&result.record){
										roomJson(result.record.html);
									}
								}
	    					});
						}
					}
				});
			}
		}
	});*/
  	$.ajax({
		url:baseUrl+'/bbmRoomManager/getBbmRooms.json',
		success:function(results){
			if (results && results.records) {
				var records = results.records;
				$("#roomId").find("option").remove();
				for(var i=0; i<records.length; i++){
					$("#roomId").append("<li value='"+records[i].roomId+"'>"+records[i].roomAdr+"</li>");
				}
			}
		}
	});
  	$(".save_btn").click(function(){
  		var rzId=$("#financingRe").html();
  		var imgUpload=$("#headImg").attr("src");
  		var roomId=$("#roomId").val();
  		var rzName=$("#rzName").val();
		var rzUrl=$("#rzUrl").val();
		var enTypeId=$("#enTypeId").val();
		var rzRemark=$("#rzRemark").val();
		var rzLogo = $("#rzLogo").attr("src");
		var productDiscriptio=editor.getData();
		var params = ['rzId='+rzId+'','rzLogo='+rzLogo+'','roomId.roomId='+roomId+'','rzName='+rzName+'','rzRemark='+rzRemark+'','rzUrl='+rzUrl+'','enTypeId.enTypeId='+enTypeId+'','productDiscriptio='+productDiscriptio+'','rzLogo='+imgUpload+''];
		//url正则表达式
		var urlRegex = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
		if(rzName=="" || rzName.trim().length==0){
			alert("企业名称不能为空！");
			return false;
		}
		if(roomId=="" || roomId.trim().length==0){
			alert("地址不能为空！");
			return false;
		}
		if(rzUrl=="" || !urlRegex.test(rzUrl)){
			alert("网址输入错误！");
			return false;
		}
		if(enTypeId=="" || enTypeId.trim().length==0){
			alert("行业类型不能为空！");
			return false;
		}
		if(rzRemark=="" || rzRemark.trim().length==0){
			alert("公司介绍不能为空！");
			return false;
		}
		if(productDiscriptio=="" || productDiscriptio.trim().length==0){
			alert("产品描述不能为空！");
			return false;
		}
		$.youi.ajaxUtils.ajax({
			url:baseUrl+'/enterbusinessmanagerRzManager/updateEnterbusinessmanagerRz.json',
			data:params.join('&'),
			success:function(result){
				if(result && result.record){
					alert("保存成功");
					location.reload();
				}
			}
		});
	});
  	$("#moreul").slideDown("slow");
  	$("#moreul > li:eq(0)").addClass("active");
});
