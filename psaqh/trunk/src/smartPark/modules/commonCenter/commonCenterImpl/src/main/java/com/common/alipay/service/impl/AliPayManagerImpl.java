/**
 * @author Aaron Tan
 * 支付宝支付所需接口
 */
package com.common.alipay.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.OrderManager.entity.OrdermanagerUserorder;
import com.common.OrderManager.service.OrdermanagerUserorderManager;
import com.common.alipay.common.AlipayConfig;
import com.common.alipay.common.AlipaySubmit;
import com.common.alipay.service.AliPayManager;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.ServiceParam;

@Service("aliPayManager")
@Transactional
public class AliPayManagerImpl extends BaseManagerImpl implements AliPayManager{
	@Autowired
	private OrdermanagerUserorderManager ordermanagerUserorderManager;
	/**
	 * 根据订单号返回支付宝签名字符串
	 * @param id
	 * @return
	 * @throws BusException
	 */
    @EsbServiceMapping
    @Override
    public String getAlipaySignStr(@ServiceParam(name="userorderCode") String userorderCode)  throws BusException{
    	OrdermanagerUserorder order = ordermanagerUserorderManager.getOrderByCode(userorderCode);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = order.getUserorderCode();
        String subject = order.getUserorderCode();
        String total_fee = order.getUserorderAmount().toString();
        //商品描述，可空
        String body = "";
        //把请求参数打包成数组
  		Map<String, String> sParaTemp = new HashMap<String, String>();
  		sParaTemp.put("service", AlipayConfig.service);
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_id", AlipayConfig.seller_id);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
  		sParaTemp.put("payment_type", AlipayConfig.payment_type);
  		sParaTemp.put("notify_url", AlipayConfig.notify_url);
  		sParaTemp.put("return_url", AlipayConfig.return_url);
  		sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
  		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
  		sParaTemp.put("out_trade_no", out_trade_no);
  		sParaTemp.put("subject", subject);
  		sParaTemp.put("total_fee", total_fee);
  		sParaTemp.put("body", body);
  		String signStr = AlipaySubmit.buildRequestMysign(sParaTemp);
    	return signStr;
    }
}
