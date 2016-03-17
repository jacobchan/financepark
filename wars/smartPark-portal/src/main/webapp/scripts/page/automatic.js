$(function() {
	// 自动补全
	var maxcount = 0;// 表示他最大的值
	var thisCount = 0;// 初始化他框的位置
	$("body").prepend("<div style='width:275px; z-index:100000; vertical-align:middle; display:none; background:#ffffff; position: absolute; border: 1px solid #509f50;' id='autoTxt'></div>");
	//高亮显示
	jQuery.fn.highLight = function(hightext) {
		return "<font color='#ff007f'>"+hightext+"</font>";
	};
	//文本框失去焦点
	$("#rzName").keyup(function(even) {
		var v = even.which;
		// 当点击上下键或者确定键时阻止他传送数据
		if (v == 38 || v == 40 || v == 13) {
			return;
		}
		var txt = $("#rzName").val();// 这里是取得他的输入框的值
		if (txt != "") {
			var params = ['rzName='+$("#rzName").val()];
			var serviceURL = baseUrl+"enterbusinessmanagerRzManager/findEnterbusinessmanagerRzByName.json";
			// 拼装数据
			$.youi.ajaxUtils.ajax({
				url : serviceURL,
				data:params.join('&'),
				jsonp : 'data:jsonp',
				dataType : 'jsonp',
				async : false,
				success : function(results) {
					var offset = $("#rzName").offset();
					$("#autoTxt").show();
					$("#autoTxt").css("top", (offset.top + 52) + "px");
					$("#autoTxt").css("left", offset.left + "px");
					var Candidate = "<ul style='padding:0; margin:0;'>";
					// 高亮对象
					var normaltext = $("#rzName").val();
					var highttext = $('body').highLight(normaltext);
					maxcount = 0;// 再重新得值
					if(results.records.length>0){
						$.each(results.records, function(k, v) {
							var name = v.rzName;
							Candidate += "<li id='" + maxcount + "'>" + name.replace(normaltext, highttext) + "</li>";
							maxcount++;
						});
					}else{
						Candidate += "<li id='" + maxcount + "'>关键字" + highttext + "查无结果！</li>";
					}
					Candidate += "</ul>";
					$("#autoTxt").html(Candidate);
					$("#autoTxt li").css("height", "28px");
					$("#autoTxt li").css("margin", "2px 2px");
					$("#autoTxt li").css("line-height", "26px");
					even.preventDefault();
					// 当单击某个ＬＩ时反映
					$("#autoTxt li").click(function() {
						$("#rzName").val($("#autoTxt li:eq(" + this.id + ")").text());
						$("#autoTxt").html("");
						$("#autoTxt").hide();
					});
					// 移动对象
					$("#autoTxt li").hover(function() {
						$("#autoTxt li").css("background", "#ffffff");
						$("#autoTxt li:eq(" + this.id + ")").css("color", "#ffffff");
						$("#autoTxt li").css("padding-left", "2px");
						$("#autoTxt li:eq(" + this.id + ")").css("background", "#3385ff");
						thisCount = this.id;
					},
					function() {
						$("#autoTxt li").css("background", "#ffffff");
						$("#autoTxt li").css("color", "");
						$("#autoTxt li").css("padding-left", "0px");
					});
				},
				error : function() {
					$("#autoTxt").html("");
					$("#autoTxt").hide();
					maxcount = 0;
				}
			});
		} else {
			$("#autoTxt").hide();
			maxcount = 0;
		}
	});
	// 当单击ＢＯＤＹ时则隐藏搜索值
	$("body").click(function() {
		$("#autoTxt").html("");
		$("#autoTxt").hide();
		thisCount = 0;
	});
	// 写移动事件//上键３８ 下键４０ 确定键 １３
	$("body").keyup(function(even) {
		var v = even.which;
		// 按上键时
		if (v == 38) {
			if (thisCount != 0) {// 等于零时则证明不能上了。所以获得焦点
				$("#rzName").blur();
				if (thisCount > 0)
					--thisCount;
				else
					thisCount = 0;
				$("#autoTxt li").css("background", "#ffffff");
				$("#autoTxt li").css("color", "");
				$("#autoTxt li:eq(" + thisCount + ")").css("color", "#ffffff");
				$("#autoTxt li").css("padding-left", "2px");
				$("#autoTxt li:eq(" + thisCount + ")").css("background", "#3385ff");
			} else {
				$("#rzName").focus();
			}
		} else if (v == 40) {// 按下键时
			if (thisCount < maxcount - 1) {
				$("#rzName").blur();
				++thisCount;
				$("#autoTxt li").css("background", "#ffffff");
				$("#autoTxt li").css("color", "");
				$("#autoTxt li:eq(" + thisCount + ")").css("color", "#ffffff");
				$("#autoTxt li").css("padding-left", "2px");
				$("#autoTxt li:eq(" + thisCount + ")").css("background", "#3385ff");
			}
		} else if (v == 13) {// 按确认键时
			var tt = $("#" + thisCount).text();
			if (tt != "") {
				$("#rzName").val(tt);
				$("#autoTxt").html("");
				$("#autoTxt").hide();
			}
		} else {
			if ($("#autoTxt").html() != "") {
				$("#rzName").focus();
				thisCount = 0;
			}
		}
	});
});