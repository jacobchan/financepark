package com.common.wxpay.protocol;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一下单API返回参数
 */
public class UnifiedOrderResData {

	//状态参数
	private String return_code;
	private String return_msg;
	private String result_code;
	private String prepay_id;
	private String code_url;
	
    //每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String nonce_str = "";
    private String sign = "";
    private String body = "";
    private String detail = "";
    private String attach = "";
    private String out_trade_no = "";
    private int total_fee = 1;
    private String spbill_create_ip = "";
    private String time_start = "";
    private String time_expire = "";
    private String goods_tag = "";
    private String notify_url = "";
    private String trade_type = "";
    private String product_id = "";
    private String limit_pay = "";
    private String openid = "";
    private String device_info = "";

  
    public String getAppid() {
		return appid;
	}


	public void setAppid(String appid) {
		this.appid = appid;
	}


	public String getMch_id() {
		return mch_id;
	}


	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}


	public String getDevice_info() {
		return device_info;
	}


	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}


	public String getNonce_str() {
		return nonce_str;
	}


	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}


	public String getSign() {
		return sign;
	}


	public void setSign(String sign) {
		this.sign = sign;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getAttach() {
		return attach;
	}


	public void setAttach(String attach) {
		this.attach = attach;
	}


	public String getOut_trade_no() {
		return out_trade_no;
	}


	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}


	public int getTotal_fee() {
		return total_fee;
	}


	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}


	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}


	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}


	public String getTime_start() {
		return time_start;
	}


	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}


	public String getTime_expire() {
		return time_expire;
	}


	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}


	public String getGoods_tag() {
		return goods_tag;
	}


	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}


	public String getNotify_url() {
		return notify_url;
	}


	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}


	public String getTrade_type() {
		return trade_type;
	}


	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getLimit_pay() {
		return limit_pay;
	}


	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}
	

	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}
	

	public String getReturn_code() {
		return return_code;
	}


	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}


	public String getReturn_msg() {
		return return_msg;
	}


	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}


	public String getResult_code() {
		return result_code;
	}


	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}


	public String getPrepay_id() {
		return prepay_id;
	}


	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}


	public String getCode_url() {
		return code_url;
	}


	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}


	public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
	
	
}
