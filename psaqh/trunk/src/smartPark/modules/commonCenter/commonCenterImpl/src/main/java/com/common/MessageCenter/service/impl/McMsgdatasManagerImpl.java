/**
 * 代码声明
 */
package com.common.MessageCenter.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.dao.McMsgdatasDao;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.entity.McMsgtempalate;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.common.MessageCenter.service.McMsgtempalateManager;
import com.common.MessageCenter.service.MessagePostProcessor;
import com.gsoft.common.service.BaseUserManager;
import com.gsoft.common.util.MessageUtils;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
//import com.gsoft.framework.core.orm.ConditionFactory;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.PrincipalConfig;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.util.DateUtils;

@Service("mcMsgdatasManager")
@Transactional
public class McMsgdatasManagerImpl extends BaseManagerImpl implements
		McMsgdatasManager {
	@Autowired
	private McMsgdatasDao mcMsgdatasDao;
	@Autowired
	private McMsgtempalateManager msgtempalateManager;
	@Autowired(required = false)
	private MessagePostProcessor messagePostProcessor;
	@Autowired
	private BaseUserManager baseUserManager;
	@Autowired
	private MemberInformationManager memberInformationManager;

	/**
	 * 查询列表
	 */
	// @EsbServiceMapping
	public List<McMsgdatas> getMcMsgdatass() throws BusException {
		return mcMsgdatasDao.getAll();
	}

	/**
	 * 条件查询列表
	 */
	@EsbServiceMapping
	public List<McMsgdatas> getMcMsgdatass(
			@ConditionCollection(domainClazz = McMsgdatas.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		return mcMsgdatasDao.commonQuery(conditions, orders);
	}

	/**
	 * 根据主键查询
	 */
	@EsbServiceMapping
	public McMsgdatas getMcMsgdatas(@ServiceParam(name = "msgId") String id)
			throws BusException {
		return mcMsgdatasDao.get(id);
	}

	@EsbServiceMapping
	public PagerRecords getPagerMcMsgdatass(
			Pager pager,// 分页条件
			@ConditionCollection(domainClazz = McMsgdatas.class) Collection<Condition> conditions,// 查询条件
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = mcMsgdatasDao.findByPager(pager,
				conditions, orders);
		return pagerRecords;
	}

	/**
	 * 保存对象
	 */
	@EsbServiceMapping
	public McMsgdatas saveMcMsgdatas(McMsgdatas o) throws BusException {
		// String mcMsgdatasId = o.getMcMsgdatasId();
		// boolean isUpdate = StringUtils.isNotEmpty(mcMsgdatasId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		o.setSendDate(DateUtils.getToday("yyyy-MM-dd"));
		return mcMsgdatasDao.save(o);
	}

	/**
	 * 删除对象
	 */
	@EsbServiceMapping
	public void removeMcMsgdatas(@ServiceParam(name = "msgId") String id)
			throws BusException {
		mcMsgdatasDao.remove(id);
	}

	/**
	 * 根据主键集合删除对象
	 * 
	 * @param ids
	 */
	public void removeMcMsgdatass(@ServiceParam(name = "msgId") String[] ids)
			throws BusException {
		for (String id : ids) {
			removeMcMsgdatas(id);
		}
	}

	@EsbServiceMapping
	public boolean exsitMcMsgdatas(@ServiceParam(name = "msgId") String id)
			throws BusException {
		return mcMsgdatasDao.exists(id);
	}

	public boolean exsitMcMsgdatas(String propertyName, Object value)
			throws BusException {
		return mcMsgdatasDao.exists(propertyName, value);
	}

	@EsbServiceMapping
	public String buildMessageContent(McMsgdatas mcMsgdatas, String[] params)
			throws BusException {
		McMsgtempalate msgTempalate = mcMsgdatas.getMcMsgtempalate();// 消息引用的模板
		// 模板内容转换成消息内容
		return com.gsoft.common.util.StringUtils.replaceChar(
				msgTempalate.getMsgTempalateContent(), '#', params);
	}

	@EsbServiceMapping
	public String buildMsgContent(McMsgtempalate msgtempalate,
			Map<String, String> replaceMap) throws BusException {
		return com.gsoft.common.util.StringUtils.replaceAllString(
				msgtempalate.getMsgTempalateContent(),
				MessageUtils.placeholders, replaceMap);
	}

	@Override
	public void sendMessage(McMsgdatas mcMsgdatas) throws BusException {
		McMsgtempalate tempalate = mcMsgdatas.getMcMsgtempalate();
		String receiver = tempalate.getMsgReceiver();// 接收对象 ROLE_ID
		// 用户属性表中 手机属性必须为phone
		List<String> phones = new ArrayList<String>();
		// 如果角色属于会员用户，则从会员表里（MemberInformation）查询，否则从User里取
		if ("企业管理员角色ID".equals(receiver)) {
			// 查出所有角色为企业管理员的用户,管理员所在企业和用户企业相同

		} else {
			List<User> users = baseUserManager
					.getUsersByRoles(new String[] { receiver });// 后台用户
			for (User user : users) {
				PrincipalConfig principalConfig = user.getPrincipalConfig();
				if (principalConfig.get("phone") != null) {
					phones.add(principalConfig.get("phone"));
				}
			}
		}
		if (messagePostProcessor != null) {
			messagePostProcessor.send(mcMsgdatas,
					phones.toArray(new String[phones.size()]));
		}

	}

	@Override
	public void sendMessageSingle(McMsgdatas mcMsgdatas, String userId)
			throws BusException {
		// 发送给会员用户 ROLE_MEMBER
		String msgContent = mcMsgdatas.getMsgContent();
		MemberInformation member = memberInformationManager
				.getMemberInformation(userId);
		if (msgContent.contains("@user")) {
			String userCaption = member.getMemberName();
			String phone = member.getMemberPhoneNumber();
			msgContent = msgContent.replace("@user", userCaption);
			mcMsgdatas.setMsgContent(msgContent);
			if (messagePostProcessor != null) {
				messagePostProcessor.send(mcMsgdatas, new String[] { phone });
			}
		}
	}
	
	@Override
	public void sendMessageEnt(McMsgdatas mcMsgdatas, String entId)
			throws BusException {
		// 发送给会员用户 ROLE_MEMBER
		String msgContent = mcMsgdatas.getMsgContent();
		//通过企业id查找企业管理员
		String userId = "";//企业管理员属于会员，且只有一个
		sendMessageSingle(mcMsgdatas,userId);
	}

	@EsbServiceMapping
	public McMsgdatas buildMsgData(
			@ServiceParam(name = "uniqueCode") String uniqueCode,
			Map<String, String> replaceMap) throws BusException {
		McMsgdatas mcMsgdatas = new McMsgdatas();
		McMsgtempalate msgTempalate = msgtempalateManager
				.getMsgTempalate(uniqueCode);
		if(msgTempalate!=null){
			mcMsgdatas.setMsgCaption(msgTempalate.getMsgTempalateCaption());
			mcMsgdatas.setMcMsgtempalate(msgTempalate);
			mcMsgdatas.setMsgContent(buildMsgContent(msgTempalate, replaceMap));
		}	
		mcMsgdatas.setSendStatus("0");// 初始发送状态默认值
		return mcMsgdatas;
	}

}
