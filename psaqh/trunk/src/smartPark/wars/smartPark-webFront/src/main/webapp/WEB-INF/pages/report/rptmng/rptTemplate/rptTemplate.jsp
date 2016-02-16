<%@ include file="/WEB-INF/pages/include.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<style>
	.youi-reporting{
		border:1px solid silver;
		height:500px;
		padding:5px;
		overflow:auto;
	}
	
	.youi-reporting .pub{
	    border-left: 1px solid #d9d9d9;
	    border-top: 1px solid #d9d9d9;
    }
    
	.youi-reporting table{
		background:#DFDFDF;
		border-spacing: 1px;
		border-collapse: inherit;
	}
	
	.youi-reporting table td{
		background:#f9f9f9;
		text-align:center;
		padding:2px;
		min-width:60px;
		height: 25px;
	}
	
	.youi-reporting table td.dc{
		background:white;
	}
	
	
	.youi-reporting .reporting-part{
		padding:0px;
		margin:0px;
		overflow:hidden;
	}
	
</style>
<youi:page>
	<!-- 页面描述： -->
	<!--**********************************子页面**********************************-->
	
	<!--**********************************子页面**********************************-->
	
	<!--**********************************页面内容********************************-->
	
	<div id="reporting"></div>
	<!--**********************************页面内容********************************-->
	
	<!--**********************************页面函数********************************-->
	
	<youi:func name="init">
		$('#reporting').reporting({
			colGroups:[{
				id:"group001",
				title:"",
				//插入位置 -1 表示在最前面插入，空或者0在最后插入，数字则在当前位置
				stats:[{type:'cal',text:'同比',expression:'sum()/next(2)',pos:-1},{type:'sum',text:'合计',pos:-1}],//当前实现列计算，行计算TODO
				children:[
				          {id:'00',text:'年前案件',type:'custom'},
						  {id:'01',text:'主要几类案件',
										//stats:[{type:'sum',text:'小计'},{type:'avg',text:'平均值'}],//生成统计列  sum 求和，avg 求平均，max 最大值, min 最小值
										children:[
										{id:'0101',text:'防火'},
										{id:'0102',text:'爆炸'},
										{id:'0103',text:'劫持'},
										{id:'0104',text:'杀人'},
										{id:'0105',text:'伤害'},{id:'0102',text:'强奸'},{id:'0102',text:'绑架'},{id:'0102',text:'抢劫'}]},
				          {id:'0201',text:'盗窃'},
				          {id:'0302',text:'抢夺'},
				          {id:'0303',text:'诈骗'},
				          {id:'0304',text:'经济犯罪'},
				          {id:'0305',text:'毒品犯罪'},
				          {id:'0306',text:'其它'}
				        ]
			}],
			rowGroups:[{id:'group002',children:[
					{id:"01",text:'城关'},
					{id:"02",text:'七里河'},
					{id:"03",text:'西固'},
					{id:"04",text:'安宁'},
					{id:"05",text:'红古'},
					{id:"06",text:'永登'},
					{id:"07",text:'皋兰'},
					{id:"08",text:'榆中'},
					{id:"09",text:'新区'},
					{id:"10",text:'交通治安'},
					{id:"11",text:'森林'}]
				},
				{id:'group004',children:[{id:"01",text:'立案'},{id:"02",text:'破案'}]}
			],
			datas:[['','','112'],['','','15'],['','','122'],['','','112'],['','','212'],['','','122'],['','','121'],['','','152']]
		});
	</youi:func>
	<!--**********************************页面函数********************************-->
</youi:page>