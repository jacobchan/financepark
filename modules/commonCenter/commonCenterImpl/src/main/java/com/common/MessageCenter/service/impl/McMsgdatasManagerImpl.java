/**
 * 代码声明
 */
package com.common.MessageCenter.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.gsoft.common.util.SMSUtil;
import com.gsoft.entity.ReferenceMap;
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
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.agt.entity.User;
import com.gsoft.framework.security.agt.service.UserManager;
import com.gsoft.framework.security.fuc.entity.Role;
import com.gsoft.framework.security.fuc.service.RoleManager;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.utils.HttpSenderMsg;

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
	@Autowired
	private UserManager userManager;
	@Autowired
	private RoleManager roleManager;

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
	@EsbServiceMapping(pubConditions={@PubCondition(pubProperty="createUser", property = "userId")})
	public McMsgdatas saveMcMsgdatas(McMsgdatas o) throws BusException {
		// String mcMsgdatasId = o.getMcMsgdatasId();
		// boolean isUpdate = StringUtils.isNotEmpty(mcMsgdatasId);
		// if(isUpdate){//修改
		//
		// }else{//新增
		//
		// }
		o.setSendDate(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
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


	public String buildMessageContent(McMsgdatas mcMsgdatas, String[] params)
			throws BusException {
		McMsgtempalate msgTempalate = mcMsgdatas.getMcMsgtempalate();// 消息引用的模板
		// 模板内容转换成消息内容
		return com.gsoft.common.util.StringUtils.replaceChar(
				msgTempalate.getMsgTempalateContent(), '#', params);
	}

	
	public String buildMessageContent(McMsgtempalate msgtempalate,
			Map<String, String> replaceMap) throws BusException {
		if(replaceMap instanceof ReferenceMap)
			return com.gsoft.common.util.StringUtils.replaceAllString(
				msgtempalate.getMsgTempalateContent(),MessageUtils.placeholders, replaceMap);
		else
			return com.gsoft.common.util.StringUtils.replaceAllString(
					msgtempalate.getMsgTempalateContent(), replaceMap);
	}

	@EsbServiceMapping
	public McMsgdatas buildMsgData(
			@ServiceParam(name = "uniqueCode") String uniqueCode,
			Map<String, String> replaceMap) throws BusException {
		McMsgdatas mcMsgdatas = new McMsgdatas();
		McMsgtempalate msgTempalate = msgtempalateManager
				.getMsgTempalate(uniqueCode);
		if(msgTempalate!=null){
			mcMsgdatas.setMsgCaption(msgTempalate.getMsgTempalateCaption());//消息内容标题
			mcMsgdatas.setMcMsgtempalate(msgTempalate);//引用模板
			mcMsgdatas.setMsgContent(buildMessageContent(msgTempalate, replaceMap));//内容
		}	
		mcMsgdatas.setSendStatus("00");// 初始发送状态默认值
		return mcMsgdatas;
	}
	
	public void sendMessage(McMsgdatas mcMsgdatas,String id,int type) throws BusException{
		String[] phones = null;
		if(StringUtils.isEmpty(id)){
			McMsgtempalate tempalate = mcMsgdatas.getMcMsgtempalate();
			String receiver = tempalate.getMsgReceiver();//模板中定义
			if("ROLE_MEMBER".equals(receiver)){
				//会员表--获取对应phones
				List<MemberInformation> members = memberInformationManager.getMemberInformations();
				if(members!=null&&members.size()>0){
					List<String> phoneLists = new ArrayList<String>();
					for(MemberInformation member:members){
						phoneLists.add(member.getMemberPhoneNumber());
					}
					phones = phoneLists.toArray(new String[phoneLists.size()]);
				}
			}else{
				//用户表--获取对应phones
				phones = baseUserManager.getPhonesByRole(id);
			}
		}else{
			phones = getPhonesByType(type, id);

		}
		if (messagePostProcessor != null) {
			messagePostProcessor.send(mcMsgdatas, phones);
		}
	}
	
	private String[] getPhonesByType(int type,String id){
		String[] phones = null;
		switch (type) {
		case 0://普通用户
			User user = userManager.getUser(id);
			phones = new String[]{user==null?"":user.getPrincipalConfig().get("phone")};
			break;
		case 1://会员用户
			MemberInformation member = memberInformationManager.getMemberInformation(id);
			phones = new String[]{member==null?"":member.getMemberPhoneNumber()};
			break;
		case 2://用户角色
			phones = baseUserManager.getPhonesByRole(id);
			break;
		case 3://会员角色
			List<MemberInformation> members = memberInformationManager.getMembersByRole(id);
			if(members!=null&&members.size()>0){
				List<String> temPhones = new ArrayList<String>();
				for(MemberInformation member_:members){
					temPhones.add(member_.getMemberPhoneNumber());
				}
				phones = temPhones.toArray(new String[temPhones.size()]);
			}
			break;
		case 4:
			Collection<Condition> conditions = new ArrayList<Condition>();
			conditions.add(ConditionUtils.getCondition("roleType", Condition.EQUALS, ""+id));
			List<Role> roles = roleManager.getRoles(conditions, null);
			if(roles!=null&&roles.size()>0){
				List<String> tempPhones = new ArrayList<String>();
				for(Role role:roles){
					String[] phones_ = getPhonesByType(2,role.getRoleId());
					tempPhones.addAll(Arrays.asList(phones_));
				}
				phones = tempPhones.toArray(new String[tempPhones.size()]);
			}
			break;
		default:
			phones = new String[]{};
			break;
		}
		
		return phones;
	}
	
	//发送消息
	@Override
	public Boolean smsSend(String code, Map<String, Object> params,
			String recUser, String phone) {
		Boolean success = true;
		McMsgtempalate mmt = msgtempalateManager.getMsgTempalate(code);
		if(mmt != null){
			String content = mmt.getMsgTempalateContent();
			for (Entry<String, Object> entry : params.entrySet()) {
				content = content.replace("@"+entry.getKey(), entry.getValue().toString());
			}
			McMsgdatas mmd = new McMsgdatas();
			String status = "";
			try{
//				String result = HttpSenderMsg.sendMsg(phone, content);
				String rcode = HttpSenderMsg.sendwithCode(content,
						new String[] { phone });
				if (StringUtils.isEmpty(rcode) || !"0".equals(rcode)) {
					status = "01";// 发送失败
					success = false;
				} else {
					status = "02";// 发送成功
				}
			}catch (Exception e) {
				success =  false;
			}
			mmd.setReceive(phone);
			mmd.setMsgCaption(mmt.getMsgTempalateCaption());
			mmd.setMsgContent(content);
			mmd.setMsgType(mmt.getMcMsgtype().getMsgTypeCaption());
			mmd.setSendStatus(status);//02-发送成功
			mmd.setCreateUser(recUser);
			mmd.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			mmd.setUpdateUser(recUser);
			mmd.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			mcMsgdatasDao.save(mmd);
			return success;
		}else{
			return false;
		}
	}

	@Override
	public String sendToBackadmin(McMsgdatas mcMsgdatas,String roleType) throws BusException {
		mcMsgdatas.setMsgType("2");//多人
		sendMessage(mcMsgdatas, roleType, SMSUtil.SEND_ROLEGROUP);
		return null;
	}

	@Override
	public String sendToEntadmin(McMsgdatas mcMsgdatas) throws BusException {
		String roleId = "ROLE_QY_ADMIN";//企业管理员
		mcMsgdatas.setMsgType("2");//多人
		sendMessage(mcMsgdatas, roleId, SMSUtil.SEND_MEMBERROLE);
		return null;
	}

	@Override
	public String sendToUser(McMsgdatas mcMsgdatas,String memberId) throws BusException {
		if(!StringUtils.isEmpty(memberId)){
			mcMsgdatas.setMsgType("1");//1人
			sendMessage(mcMsgdatas, memberId, SMSUtil.SEND_MEMBER);
		}
		return null;
	}

	@Override
	public String sendSelected(McMsgdatas mcMsgdatas) throws BusException {
		if (messagePostProcessor != null) {
			messagePostProcessor.send(mcMsgdatas, new String[]{ mcMsgdatas.getReceive()});
		}
		return null;
	}

}
