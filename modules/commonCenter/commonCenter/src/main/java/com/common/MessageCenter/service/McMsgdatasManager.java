/**
 * 代码声明
 */
package com.common.MessageCenter.service;

import java.util.List;
import java.util.Collection;
import java.util.Map;

import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.entity.McMsgtempalate;

public interface McMsgdatasManager extends BaseManager{

    /**
     * 查询列表
     */
    public List<McMsgdatas> getMcMsgdatass() throws BusException;
    
    /**
     * 条件查询列表
     */
    public List<McMsgdatas> getMcMsgdatass(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    /**
     * 根据主键查询
     */
    public McMsgdatas getMcMsgdatas(String id) throws BusException;
	/**
	 * 分页查询用户
	 * @return 分页对象
	 */
	public PagerRecords getPagerMcMsgdatass(Pager pager,//分页条件
			Collection<Condition> conditions,//查询条件
			Collection<Order> orders) throws BusException;
    /**
     * 保存并返回对象
     */
    public McMsgdatas saveMcMsgdatas(McMsgdatas o) throws BusException;

    /**
     * 删除对象
     */
    public void removeMcMsgdatas(String id) throws BusException;
    
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeMcMsgdatass(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param ids
     */
    public boolean exsitMcMsgdatas(String id) throws BusException;
	/**
     * 属性值是否已经使用
     * @param ids
     */
	public boolean exsitMcMsgdatas(String propertyName,Object value) throws BusException;
	
	/**
	 * 通过#与数组替换
	 * @param mcMsgdatas #占位符
	 * @param params 
	 * @return
	 * @throws BusException
	 */
	public String buildMessageContent(McMsgdatas mcMsgdatas,String[] params) throws BusException;
	
	/**
	 * 根据消息模板获取消息内容
	 * @param msgtempalate 模板
	 * @param replaceMap 置换的map
	 * @return
	 * @throws BusException
	 */
	public String buildMessageContent(McMsgtempalate msgtempalate,Map<String,String> replaceMap) throws BusException;
	
	/**发送消息统一处理，id为空读取模板的发送人，否则根据type判断id的类型确定发送人
	 * @param mcMsgdatas 消息内容
	 * @param id 用户/会员/用户角色/会员角色/用户角色组/匿名（phone）	 id
	 * @param type 用户/会员/角色/角色组/匿名 	 类型（0,1,2,3,4,5）
	 * @throws BusException
	 */
	public void sendMessage(McMsgdatas mcMsgdatas,String id,int type) throws BusException;
	
	
	/**构建消息内容对象
	 * @param uniqueCode 消息模板唯一码
	 * @param replaceMap 参数map
	 * @return
	 * @throws BusException
	 */
	public McMsgdatas buildMsgData(String uniqueCode,Map<String,String> replaceMap) throws BusException;
	/**
	 * 发送消息
	 * @param code 模板代码 
	 * @param params 模板中需要替换的参数
	 * @param recUser 
	 * @param phone 机号码
	 * @return
	 */
	public Boolean smsSend(String code, Map<String, Object> params,
			String recUser, String phone);
	
	/**发送给后台管理员
	 * @param mcMsgdatas
	 * @param roleType 角色分类
	 * @return
	 * @throws BusException
	 */
	public String sendToBackadmin(McMsgdatas mcMsgdatas,String roleType)throws BusException;
	
	/**发送给企业管理员
	 * @param mcMsgdatas
	 * @return
	 * @throws BusException
	 */
	public String sendToEntadmin(McMsgdatas mcMsgdatas)throws BusException;
	
	/**发送给会员用户
	 * @param mcMsgdatas
	 * @param memberId
	 * @return
	 * @throws BusException
	 */
	public String sendToUser(McMsgdatas mcMsgdatas,String memberId)throws BusException;
	
	
	/**
	 * 选择消息内容发送
	 * @param mcMsgdatas
	 * @return
	 * @throws BusException
	 */
	public String sendSelected(McMsgdatas mcMsgdatas)throws BusException;
	
	/**
	 * 校验验证码有效性
	 * @param phone
	 * @param code
	 * @return
	 * @throws BusException
	 */
	public boolean checkCode(String phone,String code) throws BusException;
	/**
	 * 验证手机验证码
	 * @param phone
	 * @param codeStr
	 * @return
	 * @throws BusException
	 */
	public TempDemo checkPhoneCode(String phone, String codeStr) throws BusException;
	/**
	 * 发送手机验证码
	 * @param phone
	 * @return
	 */
	public TempDemo getMobileCaptcha(String phone);
	/**
	 * 找回密码发送手机验证码
	 * @param phone
	 * @return
	 */
	public TempDemo findPhoneCaptcha(String phone);
	/**
   	 * 前台个人中心  获取全部消息的条数totalCount    chenye
   	 * @param conditions
   	 * @return
   	 * @throws BusException
   	 */
     public List<Record> getTotalCount(Collection<Condition> conditions,String userId)  throws BusException;
     /**
 	 * 前台个人中心   根据当前用户分页查询    chenye
 	 * @param pager
 	 * @param conditions
 	 * @param orders
 	 * @return
 	 * @throws BusException
 	 */
 	public PagerRecords getPager(Pager pager,//分页条件
 			 Collection<Condition> conditions,//查询条件
 			 Collection<Order> orders,String userId)throws BusException;
 	/**
   	 * 前台个人中心  获取未读消息的条数totalCount    chenye
   	 * @param conditions
   	 * @return
   	 * @throws BusException
   	 */
     public List<Record> getTotalCountread(Collection<Condition> conditions,String userId)  throws BusException;
}
