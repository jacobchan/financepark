<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include.jsp" %>
<youi:html title="我的地址">
	<youi:body decorator="memcenter"> 
				 
				<div class="w1000">
					<h3 class="per-h3">我的地址</h3>
					<div class="mt30 addressList">
					</div>	
					<a href="#" class="add-box ga-edit"><i class="fa fa-plus mr20"></i>新增地址</a>
					<div class="tcdPageCode fr"></div>
				</div>
				
			</youi:body>
	<!--***bottom end****************************************-->
		<!--***弹窗 start****************************************-->
	<div class="bg-tanc m1">
		<div class="tanc-con" style="top:50%;margin-top:-225px;">
			<a href="javascript:;" class="tc-close"></a>
			<h3 class="mb10"><b>新增地址</b></h3>
			<table class="line-table cic-l-t wybx-tanc">
				<colgroup>
					<col width="110"></col>
					<col></col>
				</colgroup>
				<tr class="label">
					<td><b>地址类型</b></td>
					<td>
						<label><input type="radio" name="address" class="mr5" checked="checked" value="0">园区地址</label>
						<label class="ml30"><input type="radio" name="address" class="mr5" value="1">非园区地址</label>
					</td>
				</tr>
				<tr>
					<td><b>姓名</b></td>
					<td><input type="text" id="addressName"></td>
				</tr>
				<tr>
					<td><b>电话</b></td>
					<td><input type="text" id="addressPhone"></td>
				</tr>
				<tr class="show1">
					<td><b>园区地址</b></td>
					<td>
						<div class="tct-select fl mr20 bbmbud" style="width:160px">
							
						</div>
						<div class="tct-select fl bbmfloor" style="width:160px">
						<div class="ic-select">
								<p id="floorNo"></p>
							</div>
							
						</div>
						<div class="tct-select fl bbmfloor" style="margin-left: 20px;">
							<input type="text" id="ad1" style="width:160px;height: 29px;">
						</div>
					</td>
				</tr>
				<tr class="show2 undis">
					<td><b>地址信息</b></td>
					<td><input type="text" style="width:450px;" id="ad2"></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><a href="javascript:;" onclick="javascript:saveadd();" class="ib-btn" style="width:120px;text-align:center;margin-top:10px;">保存</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="bg-tanc m2">
		<div class="tanc-con" style="top:50%;margin-top:-225px;width:550px;padding:40px 30px;">
			<a href="javascript:;" class="tc-close"></a>
			<div class="w70 tc mt40" style="margin-left:15%">
				<table>
					<tr>
						<td><img src="<%=request.getContextPath()%>/styles/images/grzx/check.png" class="mr40 mb20" border="0"></td>
						<td >
							<h4 class="f24 fl c-333"> 您已预约成功！</h4>
							<p class="f14 c-o fl mt20 mb20">如有问题，请拨打：0571-86508888</p>
						</td>
					<tr/>
				</table>
			</div>
		</div>
	</div>
	<div class="toast">
        <div class="toast-con clearfix">
            <div class="close-toast fr"></div>
            <p class="tc mt25 f18" style="color:#ff6715">修改成功！</p>
        </div> 
        
    </div>
	<!--***弹窗 end****************************************-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/laydate/laydate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/page/jquery.page.js"></script>
	<script type="text/javascript">
	var pageSize=4;
	var pageCount=1;
	var currentIndex = 1;
	var serviceURL = baseUrl+'memberadrAddressManager/getPagergetPagerAddress.json';
	$(function () {
		
		//分页页码显示
		 $.ajax({
			url:serviceURL, 
			success:function(results){	
							pageCount=Math.ceil(results.totalCount/pageSize);//页数
							
							 refreshData(1,pageSize);
								$(".tcdPageCode").createPage({
								    pageCount:pageCount,
								    current:1,
								    backFn:function(p){
								    	currentIndex = p;
								       this.pageCount=pageCount;
								        refreshData(p,pageSize);
								    }
								});			
			/* 	if(result&&result.records){
					_parseRecords(result.records);
				} */
			}
		}); 			
	});	
	
	
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
			/* $.ajax({
				url:baseUrl+'memberadrAddressManager/getMemberadrAddresssByUser.json', 
				success:function(result){
					//console.log(result);
					if(result&&result.records){
						_parseRecords(result.records);
					}
				}
			}); */
			
			$(".ga-edit").click(function(){
				$("#addressName").val('');	
				$("#addressPhone").val('');
				$(".bg-tanc.m1").show();
				$(".bbmbud").empty();
				$("#floorNo").empty();
				getbbmbud();
				getbbmfloor();
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
							"<a onclick='javascript:removeAddress(this)'>删除</a>"+
							"</div>"+
							"<em class='s-a-select'>默认</em>"+
							"</div>"
				}

			}
			$(".addressList").append(html);
		};
		//删除地址
		function removeAddress(obj){
			var me=obj.parentNode.parentNode;
		 	$.youi.ajaxUtils.ajax({
				url:baseUrl+'memberadrAddressManager/removeMemberadrAddress.json',
				data:'addressId='+me.id,
				success:function(result){
					me.remove();
					close("删除成功");
				}
			});
		}
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
					$(".bg-tanc.m1")[0].setAttribute("value",me.id);
					$("#addressName").val(result.record.addressName);	
					$("#addressPhone").val(result.record.addressPhone);
					$(".bg-tanc.m1").show();
					$(".bbmbud").empty();
					$("#floorNo").empty();
					getbbmbud();
					getbbmfloor();
				}
			});
		}
	</script>

	<!--拼接新增地址-->
	<script type="text/javascript">
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
				"<p id='buildingNo' value='"+record[0].buildingId+"'>"+record[0].buildingNo+"</p>"+
				"</div>"+
				"<ul style='display: none;' class='select-nav'>";
				for(var i=0;i<record.length;i++){
					html =html +"<li value='"+record[i].buildingId+"'>"+record[i].buildingNo+"</li>"
				}
				html =html +"</ul>";
				
				$(".bbmbud").append(html);
				liclick();
			};
			//初始化楼层地址
			function getbbmfloor(){
				 var html ="";
				 html = html +"<ul style='display: none;' class='select-nav' id='floo'>"+
				"</ul>";
				
				$(".bbmfloor").append(html);
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

							$("#floorNo").text(result.records[0].floorNo);	
							var html = "";
							$("#floo").empty();
							for(var i=0;i<result.records.length;i++){
								html =html +"<li>"+result.records[i].floorNo+"</li>"
							}
							$("#floo").append(html);
							 floorclick();
						}
					}
				});
			}	
			//保存地址
			
			function saveadd(){
				var bool = $('input[name="address"]:checked').val();
				var addressName=$("#addressName").val();	
				var addressPhone=$("#addressPhone").val();
				var addressDetail ="";
				var addressId = "";
				var Id = $(".bg-tanc.m1")[0].getAttribute("value");
				if(Id!=''&&Id!=null){
					addressId = Id;
				}
				if(bool=='0'){
					 var a1 = $("#buildingNo").text();
					 var a2 = $("#floorNo").text();
					 var a3 = $("#ad1").val();
					 addressDetail = a1+"栋"+a2+"室"+a3;
				}else if(bool=='1'){
					addressDetail = $("#ad2").val();
				}
				if(!isMobil(addressPhone)){
					$(".f24.fl.c-333").text("手机号格式不正确！");
					$(".bg-tanc.m2").show();
					return false;
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
							$(".f24.fl.c-333").text("保存成功!");
							$(".bg-tanc.m2").show();
							//location.reload();
							setTimeout(function(){$(".bg-tanc.m1").hide(); },100);
							setTimeout(function(){$(".bg-tanc.m2").hide(); },1000);
							refreshData(currentIndex,pageSize);
						}
					}
				});
			};
	</script>
	<script type="text/javascript">
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
					var lival = $(this)[0].getAttribute("value");
					var params = ['buildingId='+lival];
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
					});
					//$(this).parents(".tct-select").find(".ic-select p").text(add);
					as.parents(".tct-select").find(".ic-select p")[0].setAttribute("value",lival);
					getfloor(lival);
					as.parent().hide();	
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
	</script>
</youi:html>