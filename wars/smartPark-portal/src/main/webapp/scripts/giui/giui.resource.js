/*!
 * youi JavaScript Library v3.0.0
 * 
 *
 * Copyright 2016-2020, zhyi_12
 * Dual licensed under the MIT or GPL Version 2 licenses.
 *
 * Date: 2016-1-5
 */
require("./giui.core.js");

(function( $, undefined ) {
	if($.youi&&$.youi.resource){
		$.extend($.youi.resource,{
			'loading':'数据读取中，请稍候...',
			'urlNotFound':$.youi.getMessage('地址【{0}】访问异常!'),//访问地址没有找到
			'close':'关闭',
			/************************ grid resource************************/
			'grid.submit':'查询',
			'grid.reset':'重置',
			'grid.add':'新增',
			'grid.notFound':'未找到记录.',
			'grid.edit':'修改',
			'grid.remove':'删除',
			'grid.pagestat':$.youi.getMessage('{0}/{1}页,{2}条,显示{3}-{4}.'),//分页信息
			'grid.confirm.remove':$.youi.getMessage('确认删除选中的{0}条记录?'),
			'grid.noSelectMsg':'请选择一条记录',
			'grid.confirm.reload.notSubmit':'刷新表格会丢失未提交的数据,是否继续?',
			'grid.records.notFount':'未找到记录!',
			'grid.editor.errorMessage':$.youi.getMessage('第{0}行，第{1}列：{2}.'),
			/************************ tabs resource************************/
			'tabs.maxOpenTab':$.youi.getMessage('最大允许打开{0}个标签.'),
			'tabs.close':'关闭页面',
			/************************ form resource************************/
			'form.invalid':$.youi.getMessage('校验提示：{0}.'),
			
			'error':'异常',
			
			'field.notNull': "不能为空.",
			'field.remote': "Please fix this field.",
			'field.email': "请输入正确的邮箱地址.",
			'field.url': "请输入正确的URL地址.",
			'field.date': "请输入正确的日期格式.",
			'field.dateISO': "Please enter a valid date ( ISO ).",
			'field.number': "请输入数字.",
			'field.digits': "请输入正整数.",
			'field.creditcard': "Please enter a valid credit card number.",
			'field.equalTo': "Please enter the same value again.",
			'field.maxlength': $.youi.getMessage( "Please enter no more than {0} characters." ),
			'field.minlength': $.youi.getMessage( "Please enter at least {0} characters." ),
			'field.rangelength': $.youi.getMessage( "Please enter a value between {0} and {1} characters long." ),
			'field.range': $.youi.getMessage( "Please enter a value between {0} and {1}." ),
			'field.max': $.youi.getMessage( "Please enter a value less than or equal to {0}." ),
			'field.min': $.youi.getMessage( "Please enter a value greater than or equal to {0}." )
		});
	}
})(jQuery);