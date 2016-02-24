package com.gsoft.common.util;

/**  
 * 短信发送工具类  
 * 中国网建
 * @author   
 *  
 */  
public class SMSUtil {  
    /**  
     * Get方式发送短信  
     * @param mobile 发送号码  
     * @param content 发送内容  
     * @return 返回响应编码  
     * @throws Exception   
     */  
	
 /*   public static int GetSMSSend(String mobile,String content) throws Exception{  
        //创建HttpClient对象  
        HttpClient httpClient=new HttpClient();  
        //请求URL  
        String url="http://utf8.sms.webchinese.cn/?Uid="+Constant.UID+"&Key="+Constant.KEY+"&smsMob="+mobile+"&smsText="+content;  
        //创建Get请求  
        GetMethod getMethod=new GetMethod(url);  
        //在请求头中设置转码  
        getMethod.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");  
        // 使用系统提供的默认恢复策略  
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultMethodRetryHandler());  
        //获取头信息数组  
        Header[] header=getMethod.getRequestHeaders();  
        //执行GEt请求  
        httpClient.executeMethod(getMethod);  
        //获取响应码  
        int stateCode=getMethod.getStatusCode();  
        if(stateCode!=HttpStatus.SC_OK){  
            System.out.println("Method fai");  
        }  
        //循环打印出头信息  
        for (Header h : header) {  
            System.out.println(h.toString());  
        }  
        String result=new String(getMethod.getResponseBodyAsString().getBytes("utf-8"));  
        System.out.println(result);  
        return stateCode;  
    } */ 
    /**  
     * Post请求发送  
     * @param mobile 发送手机号码  
     * @param content 发送内容  
     * @return 返回响应码  
     */  
/*    public static int PostSMSSend(String mobile,String content) throws Exception{  
        //创建HttpClient对象  
        HttpClient httpClient=new HttpClient();  
        //请求URL  
        String url="http://utf8.sms.webchinese.cn";  
        //创建POSt请求  
        PostMethod post=new PostMethod(url);  
        //设置请求头信息  
        post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");  
        //创建参数  
        NameValuePair value1=new NameValuePair("Uid", Constant.UID);  
        NameValuePair value2=new NameValuePair("Key", Constant.KEY);  
        NameValuePair value3=new NameValuePair("smsMob", mobile);  
        NameValuePair value4=new NameValuePair("smsText", content);  
        NameValuePair[] parametersBody={value1,value2,value3,value4};//将参数放入数组  
        post.setRequestBody(parametersBody);//设置POST请求参数  
        //使用系统提供的默认回复策略  
        post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultMethodRetryHandler());  
        //执行POST方法  
        httpClient.executeMethod(post);  
        //获取响应编码  
        int stateCode=post.getStatusCode();  
        //获取请求头参数信息  
        Header[] header=post.getResponseHeaders();  
        for(Header h:header){  
            System.out.println(h.toString());  
        }  
        String result=new String(post.getResponseBodyAsString().getBytes("UTF-8"));  
        System.out.println(result);  
        return stateCode;  
    }*/  
}  
