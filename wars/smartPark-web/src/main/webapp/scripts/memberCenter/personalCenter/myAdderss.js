var pageSize=4;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'memberadrAddressManager/getPagergetPagerAddress.json';
	function pageget(){
		
		//分页页码显示
		 $.ajax({
			url:baseUrl+'memberadrAddressManager/getTotalCount.json',			
				success : function(results) {
					var totalCount=results.records[0].totalCount;
					pageCount = Math.ceil(totalCount / pageSize);//页数							
					refreshData(1,pageSize);
					$(".tcdPageCode").empty();
					if(totalCount>0){
						 $(".tcdPageCode").createPage({
								    pageCount:pageCount,
								    current:1,
								    backFn:function(p){
								    	currentIndex = p;
								       this.pageCount=pageCount;
								        refreshData(p,pageSize);
								    }
								});			
			
					}
			}
		}); 			
	};			
	//分页列表
	function refreshData(pageIndex,pageSize){
		var params = ['pager:pageIndex='+pageIndex,'pager:pageSize='+pageSize];
		$.ajax({
			url:serviceURL,
			data:params.join('&'),
			success:function(results){
				if(results&&results.records){
					 _parseRecords(results.records);
				}
			}
		});
	}
	$(function(){		
		//初始化 
		pageget();
			/* $.ajax({
				url:baseUrl+'memberadrAddressManager/getMemberadrAddresssByUser.json', 
				success:function(result){
					//console.log(result);
					if(result&&result.records){
						_parseRecords(result.records);
					}
				}
			}); */
			//新增地址
			$(".ga-edit.address").click(function(){
				$("#addressName").val('');	
				$("#addressPhone").val('');
				$("#ad2").val('');
				$(".bg-tanc.m1").show();
				/* $(".bbmbud").empty();
				$("#floorNo").empty();
				$("#roomNo").empty();
				getbbmbud();//获取楼栋
				getbbmfloor();//初始化楼层
				getbbmroom();//初始化单元 */
			});
		});
		
		//拼接地址列表
	function _parseRecords(record){		
		$(".addressList").empty();
		//	$("ab").empty();			
		var html="";
		for(var i=0;i<record.length;i++){				
			if(record[i].addressStatus==0){			
				 html+="<div class='gr-address active' id="+record[i].addressId+">"+
						"<div class='clearfix pl40 pr40'><span>姓名："+record[i].addressName+"</span><span class='fr'>手机号码："+record[i].addressPhone+"</span></div>"+
							"<div class='pl40 pr40 mt5 mb10'>园区地址："+record[i].addressDetail+"</div>"+
							"<div class='pl20 pr20 lh35 tr f12' style='border-top:1px solid #ebecec'>"+
							"<a href='javascript:;' class='mr10 ga-edit' onclick='javascript:editAdd(this)'>编辑</a>"+
							/* "<a href='javascript:remove();''>删除</a>"+ */
							"</div>"+
							"<em class='s-a-select'>默认</em>"+
							"</div>"
				}else{
					  html+="<div class='gr-address' id="+record[i].addressId+">"+
							"<div class='clearfix pl40 pr40'><span>姓名："+record[i].addressName+"</span><span class='fr'>手机号码："+record[i].addressPhone+"</span></div>"+
							"<div class='pl40 pr40 mt5 mb10'>园区地址："+record[i].addressDetail+"</div>"+
							"<div class='pl20 pr20 lh35 tr f12' style='border-top:1px solid #ebecec'>"+
							"<a href='javascript:;' class='mr10' onclick='javascript:setDefault(this)'>设为默认</a>"+
							"<a href='javascript:;' class='mr10 ga-edit' onclick='javascript:editAdd(this)'>编辑</a>"+
							"<a href='javascript:;' class='mr10' onclick='javascript:removeAddress(\""+record[i].addressId+"\")'>删除</a>"+
							"</div>"+
							"<em class='s-a-select'>默认</em>"+
							"</div>"
				}

			}
			$(".addressList").append(html);
		};
		//确认删除地址弹窗
		function removeAddress(id){
			//$(".moverec").html(aplaypNo);//给弹窗插入订单号
			$(".moverec")[0].setAttribute("id",id);//给弹窗设置id
			$(".bg-tanc.a1").show();
		};
		//删除操作
		$(".hhf-submit.confirm").click(function(){	
		    $(".bg-tanc.a1").hide();
			var id=$(".moverec")[0].getAttribute("id");	
			var params = [ 'addressId=' + id ];
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'memberadrAddressManager/removeMemberadrAddress.json',
				data : params.join('&'),
				success : function(results) {
					
					close("删除成功");
				}
			});
		});
		/*function removeAddress(obj){
			var me=obj.parentNode.parentNode;
		 	$.youi.ajaxUtils.ajax({
				url:baseUrl+'memberadrAddressManager/removeMemberadrAddress.json',
				data:'addressId='+me.id,
				success:function(result){
					//me.remove();
					close("删除成功");
					pageget();
				}
			});
		}*/
		//设为默认地址
		function setDefault(obj){
			var me=obj.parentNode.parentNode;
			var params =['addressId='+me.id,'addressStatus=0'];
		 	$.youi.ajaxUtils.ajax({
				url:baseUrl+'memberadrAddressManager/saveMemberadrAddress.json',
				data:params.join('&'),
				success:function(result){
					if(result&&result.record){
						close("设置成功");
					}
				}
			}); 
		}
		
		//编辑地址
		function editAdd(obj){
			var me=obj.parentNode.parentNode;
			$.youi.ajaxUtils.ajax({
				url:baseUrl+'memberadrAddressManager/getMemberadrAddress.json',
				data:'addressId='+me.id,
				success:function(result){
					$(".bg-tanc.m3")[0].setAttribute("value",me.id);
					$("#editaddressName").val(result.record.addressName);	
					$("#editaddressPhone").val(result.record.addressPhone);
					$("#editad2").val(result.record.addressDetail);
					$(".bg-tanc.m3").show();
				}
			});
		}

		function getbbmbud(){
				//获取楼栋
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"bbmBuildingManager/getBbmBuildings.json", 
					success:function(result){
						if(result&&result.records){
							bbmBuild(result.records);
						}
					}
				});
			};
		
			function bbmBuild(record){
				var html="";
				html=html+"<div class='ic-select'>"+
				"<p id='buildingNo' value='"+record[0].buildingId+"'>"+record[0].buildingName+"</p>"+
				"</div>"+
				"<ul style='display: none;' class='select-nav'>";
				for(var i=0;i<record.length;i++){
					html =html +"<li value='"+record[i].buildingId+"'>"+record[i].buildingName+"</li>"
				}
				html =html +"</ul>";
				
				$(".bbmbud").append(html);
				liclick();
			};
			//初始化楼层地址
			function getbbmfloor(){
				$(".bbmfloor").empty();
				 var html ="";
				 html = html +"<div class='ic-select'><p id='floorNo'></p></div>"+
				 "<ul style='display: none;' class='select-nav' id='floo'>"+
				"</ul>";
				
				$(".bbmfloor").append(html);
			};
			//初始化单元
			function getbbmroom(){
				$(".bbmroom").empty();
				 var html ="";
				 html = html +"<div class='ic-select'><p id='roomNo'></p></div>"+
				 "<ul style='display: none;' class='select-nav' id='room'>"+
				"</ul>";
				
				$(".bbmroom").append(html);
			};
			//根据所选楼栋查询楼层信息
			function getfloor(id){
				var buildingId = id;
				var params = ['buildingId='+buildingId];
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"bbmFloorManager/getBbmFloorByBuildingId.json", 
					data:params.join('&'),
					success:function(result){
						if(result&&result.records){
							if(result.records.length>0){
								$("#floorNo").text(result.records[0].floorNo);	
								var html = "";
								$("#floo").empty();
								for(var i=0;i<result.records.length;i++){
									html =html +"<li value='"+result.records[i].floorId+"'>"+result.records[i].floorNo+"</li>"
								}
								$("#floo").append(html);
								 floorclick();
							}
						}
					}
				});
			}	
			
			//根据楼栋id查询单元信息
			function getroom(id){
				var roomId = id;
				var params = ['bbmFloor.floorId='+roomId];
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"bbmRoomManager/getBbmRooms.json", 
					data:params.join('&'),
					success:function(result){
						if(result&&result.records){
							if(result.records.length>0){
								$("#roomNo").text(result.records[0].roomNo);	
								$("#roomNo").attr("value",result.records[0].roomAddress);
								var html = "";
								$("#room").empty();
								for(var i=0;i<result.records.length;i++){
									html =html +"<li value='"+result.records[i].roomAddress+"'>"+result.records[i].roomNo+"</li>"
								}
								$("#room").append(html);
								 roomclick();
							}
						}
					}
				});
			}
			
			
			//保存新增地址
			function saveadd(){	
				var addressName="";	
				var addressPhone="";
				var addressDetail ="";
				/* 	var bool = $('input[name="address"]:checked').val();
					if(bool=='0'){
						 var a1 = $("#buildingNo").text();
						 var a2 = $("#floorNo").text();
						 var a3 = $("#ad1").val(); 
						addressDetail = $("#roomNo").attr("value");
					}else if(bool=='1'){ */
					addressDetail = $("#ad2").val();
					addressName=$("#addressName").val();	
					addressPhone=$("#addressPhone").val();
					if(addressPhone!=''&&addressPhone!=null){
						if(!isMobil(addressPhone)){
							showMessagem1("手机号格式不正确!");
							return false;
						}
					}else{
						showMessagem1("请输入手机号!");
						return false;
					}
					if(addressDetail==''||addressDetail==null){
						showMessagem1("请填写地址!");
						return false;
					}
				var params = ['addressName='+addressName,
								'addressPhone='+addressPhone,
								'addressDetail='+addressDetail];
				var serviceURL = baseUrl+"memberadrAddressManager/saveMemberadrAddress.json";
				
				//公共方法
				$.youi.ajaxUtils.ajax({
					url:serviceURL,
					data:params.join('&'),
					success:function(results){
						if(results&&results.record){
							close("保存成功!");
							setTimeout(function(){$(".bg-tanc.m1").hide(); },1000);
							//refreshData(currentIndex,pageSize);
							pageget();
						}
					}
				});
			};
			//保存编辑地址
			function editadd(){	
				var addressName="";	
				var addressPhone="";
				var addressDetail ="";
				var addressId = "";
				var message ="";
				var Id = $(".bg-tanc.m3")[0].getAttribute("value");
				if(Id!=''&&Id!=null){//获取编辑地址信息
					addressId = Id;
					addressName=$("#editaddressName").val();	
					addressPhone=$("#editaddressPhone").val();
					addressDetail=$("#editad2").val();
					if(addressPhone!=''&&addressPhone!=null){
						if(!isMobil(addressPhone)){
							showMessagem3("手机号格式不正确!");
							return false;
						}
					}else{
						showMessagem3("请输入手机号!");
						return false;
					}
					if(addressDetail==''||addressDetail==null){
						showMessagem3("请填写地址!");
						return false;
					}
					message="修改成功!";
				}
				var params = ['addressId='+addressId,'addressName='+addressName,
								'addressPhone='+addressPhone,
								'addressDetail='+addressDetail];
				var serviceURL = baseUrl+"memberadrAddressManager/saveMemberadrAddress.json";
				
				//公共方法
				$.youi.ajaxUtils.ajax({
					url:serviceURL,
					data:params.join('&'),
					success:function(results){
						if(results&&results.record){
							close(message);
							setTimeout(function(){$(".bg-tanc.m3").hide(); },1000);
							$(".bg-tanc.m3").attr("value",'');
							refreshData(currentIndex,pageSize);
						}
					}
				});
			};
			function liclick(){
				$(".ic-select").click(function(e){
					$(".select-nav").hide();
				    $(this).next(".select-nav").show();
				    e.stopPropagation();//阻止冒泡
				});
				$("body").click(function(){
				     $(".select-nav").hide();
				});
				$(".select-nav li").click(function(){
					$(this).parents(".tct-select").find(".ic-select p").text($(this).text()) ;
					var lival = $(this)[0].getAttribute("value");
					/* var params = ['buildingId='+lival];
					var as =$(this);
					$.ajax({
						url:baseUrl +"bbmBuildingManager/getBbmBuilding.json", 
						data:params.join('&'),
						success:function(result){
							if(result&&result.record){
									var  a = result.record.bbmPark.address;
									var na = result.record.bbmPark.parkName;
									var budingNo = result.record.buildingNo;
									var add =a+na+budingNo;	
									as.parents(".tct-select").find(".ic-select p").text(add);
								}
							}
					}); */
					//$(this).parents(".tct-select").find(".ic-select p").text(add);
					$(this).parents(".tct-select").find(".ic-select p")[0].setAttribute("value",lival);
					getfloor(lival);
					$("#roomNo").empty();
					$(this).parent().hide();	
				});
			};
			function floorclick(){
				$(".ic-select").click(function(e){
					$(".select-nav").hide();
				    $(this).next(".select-nav").show();
				    e.stopPropagation();//阻止冒泡
				});
				$("body").click(function(){
				     $(".select-nav").hide();
				});
				$(".select-nav li").click(function(){
					$(this).parents(".tct-select").find(".ic-select p").text($(this).text()) ;
					var fool = $(this)[0].getAttribute("value");
					$(this).parents(".tct-select").find(".ic-select p")[0].setAttribute("value",fool);
					getroom(fool);
					$(this).parent().hide();
				});
			};
			function roomclick(){
				$(".ic-select").click(function(e){
						$(".select-nav").hide();
					    $(this).next(".select-nav").show();
					    e.stopPropagation();//阻止冒泡
					});
				$("body").click(function(){
				     $(".select-nav").hide();
				});
				$(".select-nav li").click(function(){
					$(this).parents(".tct-select").find(".ic-select p").text($(this).text()) ;
					var roomadd= $(this)[0].getAttribute("value");
					$(this).parents(".tct-select").find(".ic-select p")[0].setAttribute("value",roomadd);
					$(this).parent().hide();
				});		
			};
			//校验手机号格式
			function isMobil(s) {
			    var patrn = /^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
			    if (!patrn.exec(s)){ return false;}
			    else{return true;}
			};
			function close(content){		        
		        $(".tc.mt25.f18").empty() ;
		        $(".tc.mt25.f18").append(content) ;
		        $(".toast").show();		      		        		       				
				setTimeout(function(){$(".toast").hide(); },1000);
				refreshData(currentIndex,pageSize);
	      }

		//toast弹窗出来后，一秒自动关闭,请再调用弹窗toast的时候调用该方法
		 var pltime,timer;
		 function closeTanc(){
		     if(pltime>1){
		         pltime--;
		     }else{
		         $(".toast").hide();
		     }       
		 };
		 //关闭toast
	        $(".close-toast").click(function(){
	            $(".toast").hide();
	        });
		 //调用方法如下，哪里调用就放哪里
		 /**
		     clearInterval(timer);
		     $(".toast").show();
		     pltime=1;
		     timer=setInterval("closeTanc()",1000);
		 */
		 
		  function showMessagem1(message){
		     	$(".error-toast.m1").animate({top:"20px",opacity:"1"});
		     	$(".error-toast.m1 p").html(message);
		 		setTimeout(function(){$(".error-toast").animate({top:"-40px",opacity:"0"})},2000);
		     }
		 function showMessagem3(message){
		     	$(".error-toast.m3").animate({top:"20px",opacity:"1"});
		     	$(".error-toast.m3 p").html(message);
		 		setTimeout(function(){$(".error-toast").animate({top:"-40px",opacity:"0"})},2000);
		     }
$(function() {
	// 自动补全
	var maxcount = 0;// 表示他最大的值
	var thisCount = 0;// 初始化他框的位置
	$("body").prepend("<div style='width:450px; z-index:100000; vertical-align:middle; display:none; background:#ffffff; position: absolute; border: 1px solid #509f50;' id='autoTxt_head'></div>");
	//高亮显示
	jQuery.fn.highLight = function(hightext) {
		return "<font color='#ff007f'>"+hightext+"</font>";
	};
	//文本框失去焦点
	$("#ad2").keyup(function(even) {
		var v = even.which;
		// 当点击上下键或者确定键时阻止他传送数据
		if (v == 38 || v == 40 || v == 13) {
			return;
		}
		var txt = $("#ad2").val();// 这里是取得他的输入框的值
		if (txt != "") {
			var params = ['roomAddress='+$("#ad2").val(),'operator:roomAddress=LIKE'];
			var serviceURL = baseUrl+"bbmRoomManager/getBbmRooms.json";
			// 拼装数据
			$.youi.ajaxUtils.ajax({
				url : serviceURL,
				data:params.join('&'),
				jsonp : 'data:jsonp',
				dataType : 'jsonp',
				async : false,
				success : function(results) {
					var offset = $("#ad2").offset();
					$("#autoTxt_head").show();
					$("#autoTxt_head").css("top", (offset.top + 52) + "px");
					$("#autoTxt_head").css("left", offset.left + "px");
					var Candidate = "<ul style='padding:0; margin:0;'>";
					// 高亮对象
					var normaltext = $("#ad2").val();
					var highttext = $('body').highLight(normaltext);
					maxcount = 0;// 再重新得值
					if(results.records.length>0){
						$.each(results.records, function(k, v) {
							var name = v.roomAddress;
							Candidate += "<li style='cursor:pointer;' id='" + maxcount + "' data_id='"+v.roomId+"'>" + name.replace(normaltext, highttext) + "</li>";
							maxcount++;
						});
					}else{
						Candidate += "<li style='cursor:pointer;' id='" + maxcount + "' data_id='' >关键字" + highttext + "查无结果！</li>";
					}
					Candidate += "</ul>";
					$("#autoTxt_head").html(Candidate);
					$("#autoTxt_head li").css("height", "28px");
					$("#autoTxt_head li").css("margin", "2px 2px");
					$("#autoTxt_head li").css("line-height", "26px");
					even.preventDefault();
					// 当单击某个ＬＩ时反映
					$("#autoTxt_head li").click(function() {
						var id = $("#autoTxt_head li:eq(" + this.id + ")").attr('data_id');
						$("#ad2").val($("#autoTxt_head li:eq(" + this.id + ")").text());
						$("#autoTxt_head").html("");
						$("#autoTxt_head").hide();
						//window.location.href = "/industrydatabase/industry.html?id="+id;
					});
					// 移动对象
					$("#autoTxt_head li").hover(function() {
						$("#autoTxt_head li").css("background", "#ffffff");
						$("#autoTxt_head li:eq(" + this.id + ")").css("color", "#ffffff");
						$("#autoTxt_head li").css("padding-left", "2px");
						$("#autoTxt_head li:eq(" + this.id + ")").css("background", "#3385ff");
						thisCount = this.id;
					},
					function() {
						$("#autoTxt_head li").css("background", "#ffffff");
						$("#autoTxt_head li").css("color", "");
						$("#autoTxt_head li").css("padding-left", "0px");
					});
				},
				error : function() {
					$("#autoTxt_head").html("");
					$("#autoTxt_head").hide();
					maxcount = 0;
				}
			});
		} else {
			$("#autoTxt_head").hide();
			maxcount = 0;
		}
	});
	// 当单击ＢＯＤＹ时则隐藏搜索值
	$("body").click(function() {
		$("#autoTxt_head").html("");
		$("#autoTxt_head").hide();
		thisCount = 0;
	});
	// 写移动事件//上键３８ 下键４０ 确定键 １３
	$("body").keyup(function(even) {
		var v = even.which;
		// 按上键时
		if (v == 38) {
			if (thisCount != 0) {// 等于零时则证明不能上了。所以获得焦点
				$("#ad2").blur();
				if (thisCount > 0)
					--thisCount;
				else
					thisCount = 0;
				$("#autoTxt_head li").css("background", "#ffffff");
				$("#autoTxt_head li").css("color", "");
				$("#autoTxt_head li:eq(" + thisCount + ")").css("color", "#ffffff");
				$("#autoTxt_head li").css("padding-left", "2px");
				$("#autoTxt_head li:eq(" + thisCount + ")").css("background", "#3385ff");
			} else {
				$("#rzName_head").focus();
			}
		} else if (v == 40) {// 按下键时
			if (thisCount < maxcount - 1) {
				$("#ad2").blur();
				++thisCount;
				$("#autoTxt_head li").css("background", "#ffffff");
				$("#autoTxt_head li").css("color", "");
				$("#autoTxt_head li:eq(" + thisCount + ")").css("color", "#ffffff");
				$("#autoTxt_head li").css("padding-left", "2px");
				$("#autoTxt_head li:eq(" + thisCount + ")").css("background", "#3385ff");
			}
		} else if (v == 13) {// 按确认键时
			var tt = $("#" + thisCount).text();
			var id = $("#" + thisCount).attr('data_id');
			if (tt != "") {
				$("#ad2").val(tt);
				$("#autoTxt_head").html("");
				$("#autoTxt_head").hide();
				//window.location.href = "/industrydatabase/industry.html?id="+id;
			}
		} else {
			if ($("#autoTxt_head").html() != "") {
				$("#ad2").focus();
				thisCount = 0;
			}
		}
	});
});