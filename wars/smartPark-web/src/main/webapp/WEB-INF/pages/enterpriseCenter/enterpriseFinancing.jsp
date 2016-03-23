<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>企業融资</title>
		<%@ include file="/WEB-INF/pages/common/enterpriseScriptAddCss.jsp"%>
	</head>
	<body class="page-header-fixed" style=" background-image:none">
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_head.jsp"%>
		<%@ include file="/WEB-INF/pages/enterpriseCenter/common/ec_left.jsp"%>
		<div id="youi_page_header" class="youi-page-header clearfix"></div>
		<div class="main">
	    	<div id="youi_page_left" class="fl clearfix"></div>
			<div class="main-wrapper">
	    		<div class="main-wrapper-right mb40">
	        		<div class="main-title"><span>融资信息</span></div>
	            	<div class="xiangxi_xinxi mt40">
						<div class="qiye_address">
	                    	<div class="qiye_word">融资轮次</div>
                            <div class="tct-select fl mr20" style="width:290px">
								<div class="ic-select" >
									<p class="c-b1">天使轮</p>
								</div>
								<ul style="display: none;" class="select-nav">
									<li>天使轮1</li>
									<li>天使轮2</li>
									<li>天使轮3</li>
								</ul>
							</div>
                        </div>
		                <div class="rongzi_je">
		                    <div class="qiye_rzje">融资金额</div>
		                    <div class="web_input"><input type="text"></div>
		                </div>
		                <div class="rongzi_gz">
		                    <div class="qiye_rzgz">融资估值</div>
		                    <div class="web_input"><input type="text"></div>
		                </div>
		                <div class="kechi_gf">
		                    <div class="qiye_kcgf">可持股份</div>
		                    <div class="web_input"><input type="text"></div>
		                </div>
		                <div class="rongzi_time">
		                	<div class="qiye_rzsj">融资时间</div>
		                    <div class="rongzi_chose">
		                    	<div class="time_input"><input type="text"></div>
		                        <span class="time_to">到</span>
		                        <div class="time_input"><input type="text"></div>
		                        <div class="search_time"><a href="javascript:void(0);">搜索</a></div>
		                    </div>
		                </div>
		                <div class="rongzi_js ">
		                    <div class="qiye_word">融资介绍</div>
		                    <div class="word_input">
		                        <textarea></textarea>
		                        <div class="font_xianzhi">字数限制：0/200</div>
		                    </div>
		                </div>
		                <div class="meiti_save_btn"><input type="submit" value="保存" class="hhf-submit" style="height:40px;" /></div>
		            </div>
					<div class="rozi_main">
						<div class="clearfix yin-group undis">
							<div class="yg-group-box">
								<div class="yg-time">
									<div class="yt-pa"><span>进行中</span></div>
									<em class="em-pa_active"></em>
									<div class="clearfix active">
										<span>Pre-A</span><span>融资金额：<em class="c-o">500万元</em></span><span>融资估值：<em class="c-o">5000万元</em></span><span>可持股份：<em class="c-o">10%</em></span>
									</div>
									<p>通过整合香港、深圳、广州、台湾各机场的航空资源和与DHL、FedEx、UPS、TNT、EMS各种形式深层次的合作，一直服务于业内货代同行，合作货代商遍布全国，共计有五千余家。</p>
                                    <p class="mt10"><a href="javascript:;">编辑</a>&nbsp;丨&nbsp;<a href="javascript:;">删除</a></p>
								</div>
								<div class="yg-time history_time">
									<div class="yt-pa"><span>2015年10月</span></div>
									<em class="em-pa"></em>
									<div class="clearfix">
										<span>A轮</span><span>融资金额：<em class="c-o">100万元</em></span><span>投资主体：<em class="c-o">保密</em></span>
									</div>
									<p>在"争做第一"企业愿景的指引下，宝贝王集团始终坚持"同心多元化"的发展战略，秉承"以市场为龙头，坚持客户至上的原则，实现集团和员工共同成长"的核心价值观，发扬"创新、务实、忠诚。</p>
                                    <p class="mt10"><a href="javascript:;">编辑</a>&nbsp;丨&nbsp;<a href="javascript:;">删除</a></p>
								</div>
                                <div class="yg-time history_time">
									<div class="yt-pa"><span>2014年10月</span></div>
									<em class="em-pa"></em>
									<div class="clearfix">
										<span>天使轮</span><span>融资金额：<em class="c-o">100万元</em></span><span>投资主体：<em class="c-o">保密</em></span>
									</div>
									<p>在"争做第一"企业愿景的指引下，宝贝王集团始终坚持"同心多元化"的发展战略，秉承"以市场为龙头，坚持客户至上的原则，实现集团和员工共同成长"的核心价值观，发扬"创新、务实、忠诚。</p>
                                    <p class="mt10"><a href="javascript:;">编辑</a>&nbsp;丨&nbsp;<a href="javascript:;">删除</a></p>
								</div>
							</div>
						</div>
		            </div>
		        </div>    
		    </div>
		</div>
	</body>
</html>