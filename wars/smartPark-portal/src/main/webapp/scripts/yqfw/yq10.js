$(function(){
			$(".submit1").click(function(){
				if(!isLogin){
					clearInterval(timer);
		           	$(".toast").show();
		           	pltime=1;
		           	timer=setInterval("closeTanc()",1000);
				} 
				//判断是否是企业员工
				$.youi.ajaxUtils.ajax({
				url:baseUrl+"enterpriseEmployeesManager/getEnterEmployforpage.json", 
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(result){
					if(result&&result.record){
							var addressId = $(".select-address.active").attr("id");
							var time = $('#timer').val(); 
						
							 if(time=="" || time.length==0){
								clearInterval(timer);
								$(".tc.mt25").text("请输入预约时间!");
					           	$(".toast").show();
					           	pltime=1;
					           	timer=setInterval("closeTanc()",1000);
								return false;
							 }
							 if(addressId=="" || addressId==null){
									clearInterval(timer);
									$(".tc.mt25").text("请选择地址!");
						           	$(".toast").show();
						           	pltime=1;
						           	timer=setInterval("closeTanc()",1000);
									return false;
								 }
							 
							$(".submit1").addClass("undis") ;
							$(".submit2").removeClass("undis") ;
							 
							var params = [//'ocComp='+$("#ocComp").val(),
										'ocDate='+time,
										//'ocWay=00',
										//'ocStatus=00',
										'ocAddree.addressId='+addressId,
										'ocRemark='+$("#ocRemark").val()];
						
							var serviceURL = baseUrl+"propertyservicemanagerOcManager/savePropertyservicemanagerOc.json";
						
							//公共方法
							$.youi.ajaxUtils.ajax({
								url:serviceURL,
								data:params.join('&'),
								jsonp:'data:jsonp',
								dataType:'jsonp',
								success:function(results){
									$(".submit1").removeClass("undis") ;
									$(".submit2").addClass("undis") ;
									if(results&&results.record){
										$(".bg-tanc.m2").show();
										countdown(3);
									}
								},error:function(XMLHttpRequest, textStatus, errorThrown){
									$(".submit1").removeClass("undis") ;
									$(".submit2").addClass("undis") ;
								}
							});
						}else{
							clearInterval(timer);
							$(".tc.mt25").text("您不是企业用户,暂时无法申请!");
				           	$(".toast").show();
				           	pltime=1;
				           	timer=setInterval("closeTanc()",1000);
							return false;
						}
					}
				});
			});
		});
	
		$(function(){		
			load();
		});
				function load(){
					$.youi.ajaxUtils.ajax({
					url:baseUrl +"memberadrAddressManager/getMemAddforpage.json", 
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(result){
						if(result&&result.records){
							_parseRecords(result.records);
						}
					}
				});
	
				//拼接地址
					function _parseRecords(record){
						$(".addressList").empty();
						var html="";
						for(var i=0;i<record.length;i++){
							if(record[i].addressStatus==0){	
							 html+="<div class='select-address active' id="+record[i].addressId+">"+
								"<p><span>联系人："+record[i].addressName+"</span><span class='ml20'>联系电话："+record[i].addressPhone+"</span></p>"+
								"<p>园区地址："+record[i].addressDetail+"</p>"+
								"<em class='s-a-select'></em>"+
								"</div>"
							}else{
								 html+="<div class='select-address' id="+record[i].addressId+">"+
									"<p><span>联系人："+record[i].addressName+"</span><span class='ml20'>联系电话："+record[i].addressPhone+"</span></p>"+
									"<p>园区地址："+record[i].addressDetail+"</p>"+
									"<em class='s-a-select'></em>"+
									"</div>"
							}
						}
						html+="<a href='javascript:;' class='fl open-tanc'><i class='fa fa-plus-circle mr5'></i>新增地址</a>";
						$(".addressList").append(html);
						activeclick();
					};
				}

	
		function getbbmbud(){
				//获取楼栋
				$.youi.ajaxUtils.ajax({
					url:baseUrl +"bbmBuildingManager/getBbmBuildings.json", 
					jsonp:'data:jsonp',
					dataType:'jsonp',
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
					jsonp:'data:jsonp',
					dataType:'jsonp',
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
					jsonp:'data:jsonp',
					dataType:'jsonp',
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
			//保存地址
			
			$("#save1").click(function(){
				//var bool = $('input[name="address"]:checked').val();
				var addressName=$("#addressName").val();	
				var addressPhone=$("#addressPhone").val();
				var addressDetail ="";
				/* if(bool=='0'){
					 var a1 = $("#buildingNo").text();
					 var a2 = $("#floorNo").text();
					 var a3 = $("#ad1").val();
					 addressDetail = a1+"栋"+a2+"室"+a3; 
					addressDetail = $("#roomNo").attr("value");
				}else if(bool=='1'){*/
				addressDetail = $("#ad2").val();
			
				if(!isMobil(addressPhone)){
					clearInterval(timer);
					$(".tc.mt25").text("手机号格式不正确!");
		           	$(".toast").show();
		           	pltime=1;
		           	timer=setInterval("closeTanc()",1000);
					return false;
				}
				if(addressDetail==''||addressDetail==null){
					clearInterval(timer);
					$(".tc.mt25").text("请填写地址!");
		           	$(".toast").show();
		           	pltime=1;
		           	timer=setInterval("closeTanc()",1000);
					return false;
				}
				var params = ['addressName='+addressName,
								'addressPhone='+addressPhone,
								'addressDetail='+addressDetail];
				var serviceURL = baseUrl+"memberadrAddressManager/saveMemberadrAddress.json";
				$("#save1").addClass("undis") ;
				$("#save2").removeClass("undis") ;
				//公共方法
				$.youi.ajaxUtils.ajax({
					url:serviceURL,
					data:params.join('&'),
					jsonp:'data:jsonp',
					dataType:'jsonp',
					success:function(results){
						$("#save2").addClass("undis") ;
						$("#save1").removeClass("undis") ;
						if(results&&results.record){
							clearInterval(timer);
							$(".tc.mt25").text("保存成功!");
				           	$(".toast").show();
				           	pltime=1;
				           	timer=setInterval("closeTanc()",1000);
							load();
							setTimeout(function(){$(".bg-tanc.m1").hide(); },1000);
						}
					},error:function(XMLHttpRequest, textStatus, errorThrown){
						$("#save2").addClass("undis") ;
						$("#save1").removeClass("undis") ;
					}
				});
			});
	
		function activeclick(){
			$(".select-address").click(function(){
				$(this).parent().find(".select-address").removeClass("active");
				$(this).addClass("active");
			});
			$(".open-tanc").click(function(){
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
		    if (!patrn.exec(s)) return false
		    return true
		};
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
			//定时跳转
			 function countdown(i){
			 	$("#ti-m1").text(i);
			     i = i - 1;
			     if(i > 0) {
			         setTimeout("countdown("+i+")", 1000);
			     }else{
			     	jump();
			     }
			 }
			 //跳转一卡通
			 function jump(){
			 	window.location.href=cenUrl+"member/memberCenter/propertyService/propertyManageOc.html";
			 }
			 //跳转个人中心
			 function jumpPerson(){
			 	window.location.href=cenUrl+"member/memberCenter/personalCenter/personInfo.html";
			 }
			 //跳转首页
			 function jumpIndex(){
			 	window.location.href=cenUrl;
			 }