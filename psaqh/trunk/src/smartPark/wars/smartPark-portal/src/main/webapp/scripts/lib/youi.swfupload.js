/**
 * fieldSwfupload组件
 * Copyright (c) 2013 zhouyang
 * licenses
 * doc 
 */
(function($) {
    var errorMessage={};
    errorMessage[''+SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED] = '文件个数超限';
    errorMessage[''+SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT] = '文件大小超限';
    errorMessage[''+SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE] = ',不能上传空文件';
    errorMessage[''+SWFUpload.QUEUE_ERROR.INVALID_FILETYPE] = ',不能上传该类型文件';
    errorMessage[''+SWFUpload.UPLOAD_ERROR.HTTP_ERROR] = '无法访问上传地址';
    errorMessage[''+SWFUpload.UPLOAD_ERROR.MISSING_UPLOAD_URL] = '无效的上传地址';
    errorMessage[''+SWFUpload.UPLOAD_ERROR.IO_ERROR] = '无法上传文件';
    errorMessage[''+SWFUpload.UPLOAD_ERROR.SECURITY_ERROR] = '上传被拒绝';
    errorMessage[''+SWFUpload.UPLOAD_ERROR.FILE_CANCELLED] = '上传被中止';
    errorMessage[''+SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED] = '上传文件类型被拒绝';

	var _log = $.youi.log;
	/**
	 * fieldText组件
	 * 
	 */
	$.widget("youi.fieldSwfupload",$.extend({},$.youi.field,{
		_initField:function(){
			/*var limit = this.options.fileSizeLimit/1024;*/
			this._dlg = $('<div class="modal hide" style="width:610px;" data-backdrop="static">'
			 		+ '<div class="modal-header-upload"><a class="close" data-dismiss="modal" style="margin-left: 592px; font-size: 25px;">×</a>'
			        + '<h5 style="margin-top: 0px; margin-left: 10px; margin-bottom: 10px;">文件上传管理<br>(文件上传格式：'+this.options.fileTypes+';上传的文件最大不能超过'+((this.options.fileSizeLimit!=null?this.options.fileSizeLimit:5120)/1024)+'M)</h3></div><div class="modal-body swfupload" style="height:200px;"><ul class="swfFileList"></ul>'
					+ '</div><div class="modal-footer">'
					+ (!this.options.readonly?'<a class="btn select-files" style="padding:0px;"><span></span></a>':'')
					+ '<a class="btn btn-primary btn-submit">'
					+ (!this.options.readonly?'上传':'关闭') + '</a></div></div>');

			$('body').append(this._dlg);
			//this.element.after(this._dlg);
			this._dlg.modal({show:false});
			this._dlg.on('hide',$.proxy(function(){
				this._dlg.find('.swf-fileItem:not(.success)').remove();
			},this));
/*			this._dlg.on('hide',function(){
				$(this).css('left',-9999);
				$('body>.modal-backdrop').remove();
				return false;
			}).on('show',function(){
				$(this).css('left','50%');
				$(this).css('display','block');
				$('body').append('<div class="modal-backdrop in"></div>');
				return false;
			});*/
			if(!this.options.readonly) this._initSwfupload();
			this._addEvent();
		},	
		files:[],
		_initSwfupload:function(){
			this._dlg.find('a.select-files>span').attr('id',this.options.id + '_holder');
		    this._dlg.find('.select-files').swfupload({
		        // Backend Settings
		        upload_url: this.options.uploadUrl, 
		        
		        // File Upload Settings
		        file_size_limit : this.options.fileSizeLimit, // 100MB
		        file_types : this.options.fileTypes,
		        file_types_description : this.options.fileTypesDescription,
		        file_upload_limit : 0,//this.options.fileUploadLimit + '',
		        file_queue_limit : 0,//this.options.fileQueueLimit + '',
		    
		        // Button Settings
		        //button_image_url : "<%= request.getContextPath() %>/decorators/ahead/images/XPButtonNoText_61x22.png", // Relative to the SWF file
		        button_placeholder_id : this.options.id + '_holder',
		        button_width: 120,
		        button_height: 33,
		        button_text_left_padding: 25,
		        button_text_top_padding: 3,
		        button_text:'<span class="button-text">添加文件<span>',
		        button_text_style:'.button-text{font-weight:bold;color:#ffffff;font-size: 17pt;font-family:微软雅黑;}',
		        button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
		        button_cursor: SWFUpload.CURSOR.HAND,
		        // Flash Settings
		        flash_url : this.options.flashUrl
		    });
		},
		_addEvent:function(){
			var self = this;
			this.element.find('.field-swf-open-button').click(function(){
				self._dlg.modal('show');
			});
			this._dlg.find('.btn-submit').click(function(){
				if(self.options.readonly){
					self._dlg.modal('hide');
				}
				else{
					self._dlg.find('.select-files').swfupload('startUpload');
				}
			});
			this._dlg.find('.modal-body').click(function(event){
				if($(event.target).is('button.close')){
					self._deleteFile($(event.target).closest('.swf-fileItem'));
				}
			});
			this._addSwfEvent();
		},
		_deleteFile:function(fileItem){
			var fileIdx = this._dlg.find('div.modal-body .swf-fileItem').index(fileItem);
			var fileId = fileItem.data('fileId');
			if(fileId){
				this._dlg.find('.select-files').swfupload('cancelUpload',fileId, false);
			}
			if(fileItem.hasClass('success')){
				if(this.options.removeUrl){
					$.get(this.options.removeUrl,{path:this.files[fileIdx]});
				}
				this.files.splice(fileIdx, 1);
				this.element.find('input.value').val(this.files.join(','));
				this._setCount();
			}
			fileItem.remove();
		},
		_addSwfEvent:function(){
			var self = this;
			this._dlg.find('.select-files')
	        .bind('fileQueued', function(event, file){
	        	if(self.options.fileUploadLimit > 0 && self._dlg.find('div.modal-body .swf-fileItem').length >= self.options.fileUploadLimit){
					self._dlg.find('.select-files').swfupload('cancelUpload',file.id, false);
					self._dlg.find('div.modal-body')
	        			.prepend('<div class="alert alert-error fade in"><strong>最多只能上传' 
	        				+ self.options.fileUploadLimit + '个文件</strong></div>')
	        				.find('.alert').defAlert(2000);
					return false;
	        	}
	        	self._createFileHtml(self._dlg.find('div.modal-body .swf-fileItem').length, file.name, false, file.id);
	        })
	        .bind('uploadComplete', function(event, file){
	            // start the upload (if more queued) once an upload is complete
	        	// SWFUpload.FILE_STATUS
	        	if(file.filestatus == SWFUpload.FILE_STATUS.COMPLETE){
		        	var stat = $.swfupload.getInstance(this).getStats();
		        	if(stat.files_queued > 0 ){
		        		$(this).swfupload('startUpload');
		        	}
		        	else{
		        		self._endUpload(stat);
		        	}
	        	}
	        })
	        .bind('uploadSuccess',function(event,file,data){
	        	self._addFile(data,file);
	        })
	        .bind('uploadProgress',function(event,file,complate,total){
	        	self._dlg.find('.swf-fileItem[data-file-id="' + file.id + '"] .processbar')
	        	 //$('#' + self.options.id + '_' + file.index + ' .processbar')
	        		.css('height',(100 - complate/total*100).toFixed(0)+'%');
	        })
	        .bind('fileQueueError',function(event,file, errorCode, message){
	        	var extMsg = '';
	        	if(errorCode == SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT){
	        		extMsg = ',文件大小不能超过' + self.options.fileSizeLimit + "KB";
	        	}
	        	self._dlg.find('div.modal-body')
	        		.prepend('<div class="alert alert-error fade in"><strong>' 
	        				+ file.name + errorMessage[''+errorCode] + extMsg + '</strong></div>')
	        		.find('.alert').defAlert(3000);
	        })
	        .bind('uploadStart',function(event,file){
	        	//$('#' + self.options.id + '_' + file.id + ' .progress-btn').addClass('btn-info');
        	
	        })
	        .bind('uploadError',function(event,file,errorCode, message){
	        	self._dlg.find('div.modal-body')
        		.prepend('<div class="alert alert-error fade in"><strong>' 
        				+ file.name + errorMessage[''+errorCode] + '</strong></div>')
        		.find('.alert').defAlert(2000);
	        })
	        .bind('swfuploadLoaded',function(){
	        	self.flashReady = true;
	        });
		},
		_endUpload:function(stat){
			var self = this;
			this._dlg.find('div.modal-body')
    		.prepend('<div class="alert alert-success fade in"><strong>已完成完成上传，成功上传' 
    				+ this._dlg.find('.swf-fileItem.success').length + '个文件</strong></div>')
    		.find('.alert').defAlert(1500).done(function(){
    			self._dlg.modal('hide');
    		});
		},
		_addFile:function(path,file){
			this.files.push(path);
			var type = this._getFileType(path);
			var fileItem = this._dlg.find('.swf-fileItem[data-file-id="' + file.id + '"]');
			if(type == 'image'){
				fileItem.find('>.body>.content').html(this._createImageHtml(path));
			}
			else{
				fileItem.find('>.body>.content').text('上传成功');
			}
			fileItem.find('>.title>div').html(this._createLinkHtml(path,true));
			fileItem.addClass('success');
			fileItem.find('>.body .processbar').css('height','0px');
			this.element.find('input.value').val(this.files.join(','));
			this._setCount();
		},
		_defaultHtmls:function(){
			var htmls = this._fieldHtmls(),
					styles = ['youi-field',this.widgetName];
				if(this.options.notNull==true){
					styles.push('notNull');
				}
				this.element
						.attr('id',this.options.id)
						.addClass(styles.join(' '))
						.html(htmls);
		},
		_fieldHtmls:function(){
			var htmls = [];
			//var inputWidth = this.options.width - 17;
			var buttonText = '上传管理';
			if(this.options.readonly){
				buttonText = '查看附件';
			}
			htmls.push('<button type="button" class="field-swf-open-button btn button small orange">'
					+ '<span>' + buttonText + '(</span><span class="file-count">0</span><span>)</span></button>');
			htmls.push('<div class=\"field-invalid\"></div><input type="hidden" class="value"/>');
			return htmls.join('');
		},
		_setCount:function(){
			this.element.find('.file-count').text(this.files.length);
		},
		reset:function(){
			this.clear();
			if(this.options.defaultValue) this.setValue(this.options.defaultValue);
		},
		clear:function(){
			this.element.find('input.value').val('');
			this.files = [];
			if(self.flashReady){
				var file = this._dlg.find('.select-files').swfupload('getFile');
				while(file){
					this._dlg.find('.select-files').swfupload('cancelUpload',file.id, false);
				}
			}
			this._dlg.find('.swf-fileItem').remove();
			this._setCount();
		},
		setValue:function(value){
			this.element.find('input.value').val(value);
			this.files = value.split(',');
//			if(value.trim().length==0) this.files = [];
			if($.trim(value).length==0) this.files = [];
			var self = this;
			var html = '';
			self._dlg.find('div.modal-body>ul').empty();
			$(this.files).each(function(i,val){
				self._createFileHtml(i,val,true);
			});
			this._setCount();
		},
		_createFileHtml:function(idx,fileName,uploaded,fileId){
			var extName = this._getExtFilename(fileName);
			this._dlg.find('div.modal-body>ul').append(
			'<li class="swf-fileItem' + (uploaded?' success':'') + '" id="' + this.options.id + '_' + idx + '" name="' + idx 
			+ (fileId?'" data-file-id="' + fileId + '"':'"') + '>'
			+ '<div class="title"><div>' + this._createLinkHtml(fileName,uploaded) + '</div>'
			+ (!this.options.readonly?'<button class="close">&times;</button>':'') + '</div>'
			+ '<div class="body">' + this._createFileContent(fileName,uploaded) + '</div>'
            + '<div class="footer"><div class="file-type-' + extName + '">' + extName.toUpperCase() + '</div></div></li>');
		},
		_createLinkHtml:function(fileName,uploaded){
			if(uploaded){
				return '<a target="_blank" href="' + this.options.uploadUrl 
				+ (this.options.uploadUrl.indexOf('?') > 0 ? '&':'?') 
	            + 'path=' + fileName + '&method=show">下载</a>';
			}
			return '<a href="#">&nbsp;</a>';
		},
		_getFileType:function(fileName){
			var fileType = this._getExtFilename(fileName);
			var typeMap = {'jpg':'image','jpeg':'image','png':'image','word':'doc','pdf':'doc'};
			fileType = typeMap[fileType];
			if(!fileType) fileType = 'unknow';
			return fileType;
		},
		_getExtFilename:function(fileName){
			var fileType = '';
			if(fileName.indexOf('.')){
				fileType = fileName.substring(fileName.lastIndexOf('.')+1);
				fileType = fileType.toLowerCase();
			}
			return fileType;
		},
		/*_getFileIcon:function(filename){
			var fileType = this._getFileType(fileName);
			if(fileType == 'image'){
				return '';
			}
			else if(fileType == 'doc'){
				return '';
			}
			else return '';
		},*/
		_createFileContent:function(fileName,uploaded){
			var html = '<div class="content ';
			if(uploaded){
				html += 'uploaded ';
			}
			var fileType = this._getFileType(fileName);
			html += 'type-' + fileType + '">';
			if(fileType == 'image' && uploaded){
				html += this._createImageHtml(fileName);
			}
			else{
				if(uploaded){
					if(this.options.readonly){
						html += '<span>文件</span><div class="processbar" style="height:0px;"></div>';
					}
					else{
						html += '<span>上传成功</span><div class="processbar" style="height:0px;"></div>';
					}
				}
				else {
					html += '<span>准备上传</span><div class="processbar"></div>';
				}
			}
			html += '</div>';
			return html;
		},
		_createImageHtml:function(fileName){
			return '<img src="' + this.options.uploadUrl + (this.options.uploadUrl.indexOf('?') > 0 ? '&':'?') 
            + 'path=' + fileName + '&method=show"/>';
		},
		getValue:function(){
			return this.element.find('input.value').val();
		}
	}));
	
	$.extend($.youi.fieldSwfupload,{
		defaults:$.extend({},$.youi.fieldDefaults,{
			fileSizeLimit: 1024 * 100,
			fileTypesDescription: '所有文件',
			fileTypes:'*.*',
			fileQueueLimit:0,
			fileUploadLimit:10
		})
	});
})(jQuery);

$.fn.defAlert = function(mills){
		var dtd = $.Deferred(); //在函数内部，新建一个Deferred对象
		$(this).alert();
		var self = this;
	setTimeout(function(){
		$(self).alert('close');
		setTimeout(function(){
			dtd.resolve(self);
		},200);
	},mills-200);
	return dtd.promise(); // 返回promise对象
};
