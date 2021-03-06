/*!
 * youi JavaScript Library v3.0.0
 * 
 *
 * Copyright 2016-2020, zhyi_12
 * Dual licensed under the MIT or GPL Version 2 licenses.
 *
 * Date: 2016-1-4
 */

require("./giui.core.js");

(function($) {
//	var _log = $.youi.log;
	/**
	 *  page组件
	 * @author  zhouyi
	 * @version 1.0.0
	 */
	 var count=0;
	$.widget("youi.plist",$.youi.abstractWidget,$.extend({},{
		options:{
			bindResize:true
		},
		
		_initWidget:function(){
			//jsonp
			var that = this;
			$.youi.ajaxUtils.ajax({
				//url:'http://192.168.80.1:8088/gsoft-web/esb/web/userManager/getPagerUsers.json',
				//url:'http://localhost:9088/jsonp/data.jsp?data:file=users.json',
				url:this.options.jsonpSrc,
				jsonp:'data:jsonp',
				dataType:'jsonp',
				success:function(results){
					if(results&&results.records){
						that._parseRecords(results.records);
					}
				}
			});
		},
		
		_parseRecords:function(records){
			var htmls = [];
				
				var template = ''+this.options.template+'';
				
				$(records).eq(count).each(function(){
					htmls.push($.youi.recordUtils.replaceByRecord(template,this));
				});
				count++;
				this.element.html(htmls.join(''));
		},
		
		_destroy:function(){
			//调用页面销毁函数
			this._callGloablFunc('destroy');
		}
	}));
	
})(jQuery);