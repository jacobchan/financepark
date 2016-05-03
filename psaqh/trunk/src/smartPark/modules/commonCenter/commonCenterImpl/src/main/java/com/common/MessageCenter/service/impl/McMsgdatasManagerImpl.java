/**
 * 代码声明
 */
package com.common.MessageCenter.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.MessageCenter.dao.McMsgdatasDao;
import com.common.MessageCenter.entity.Code;
import com.common.MessageCenter.entity.McMsgdatas;
import com.common.MessageCenter.entity.McMsgtempalate;
import com.common.MessageCenter.service.McMsgdatasManager;
import com.common.MessageCenter.service.McMsgtempalateManager;
import com.common.MessageCenter.service.MessagePostProcessor;
import com.gsoft.common.service.BaseUserManager;
import com.gsoft.common.util.MessageUtils;
import com.gsoft.common.util.SMSUtil;
import com.gsoft.entity.MsgParam;
import com.gsoft.entity.ReferenceMap;
import com.gsoft.entity.TempDemo;
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
import com.gsoft.framework.security.agt.entity.UserConfigItem;
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
		orders.add(ConditionUtils.getOrder("sendDate", false));
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
		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		if(StringUtils.isEmpty(o.getSendDate())){
			o.setSendDate(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		}
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
		List<MsgParam> msgParams = null;
		if(StringUtils.isEmpty(id)){
			msgParams = new ArrayList<MsgParam>();
			McMsgtempalate tempalate = mcMsgdatas.getMcMsgtempalate();
			String receiver = tempalate.getMsgReceiver();//模板中定义
			if("ROLE_MEMBER".equals(receiver)){
				//会员表
				List<MemberInformation> members = memberInformationManager.getMemberInformations();
				if(members!=null&&members.size()>0){
					for(MemberInformation member:members){
						msgParams.addAll( getPhonesByType(1,member.getMemberId()));
					}
				}
			}else{
				//后台用户表
				msgParams.addAll( getPhonesByType(2,receiver));
			}
		}else{
			msgParams = getPhonesByType(type, id);

		}
		if (messagePostProcessor != null) {
			messagePostProcessor.send(mcMsgdatas, msgParams);
		}
	}
	
	private List<MsgParam> getPhonesByType(int type,String id){
		List<MsgParam> msgParams = new ArrayList<MsgParam>();
//		String[] phones = null;
		switch (type) {
		case 0://普通用户
			User user = userManager.getUser(id);
			if(user!=null){
				List<UserConfigItem> userConfigs = baseUserManager.getUserConfigItems(user.getUserId());
				String phone = null;
				String username = null;
				for(UserConfigItem userConfigItem : userConfigs){
					if("phone".equals(userConfigItem.getName()))
						phone = userConfigItem.getValue();
					if("username".equals(userConfigItem.getName()))
						username = userConfigItem.getValue();
						
				}
				if(phone!=null)
					msgParams.add(new MsgParam(phone, username));
			}	
			break;
		case 1://会员用户
			MemberInformation member = memberInformationManager.getMemberInformation(id);
			String phone1 = member==null?"":member.getMemberPhoneNumber();
			String username1 = member==null?"":member.getMemberName();
			msgParams.add(new MsgParam(phone1, username1));
			break;
		case 2://用户角色
			List<User> users = baseUserManager.getUsersByRoles(new String[]{id});
			if(users !=null&&users.size()>0){
				for(User user_:users){
					msgParams.addAll( getPhonesByType(0,user_.getUserId()));
				}
			}
			break;
		case 3://会员角色
			List<MemberInformation> members = memberInformationManager.getMembersByRole(id);
			if(members!=null&&members.size()>0){
				for(MemberInformation member_:members){
					msgParams.addAll( getPhonesByType(1,member_.getMemberId()));
				}
			}
			break;
		case 4://后台角色类型
			Collection<Condition> conditions = new ArrayList<Condition>();
			conditions.add(ConditionUtils.getCondition("roleType", Condition.EQUALS, ""+id));
			List<Role> roles = roleManager.getRoles(conditions, null);
			if(roles!=null&&roles.size()>0){
				for(Role role:roles){
					msgParams.addAll( getPhonesByType(2,role.getRoleId()) );
				}
			}
			break;
		case 5://匿名
			msgParams.add(new MsgParam(id, ""));
		default:
			break;
		}
		
		return msgParams;
	}
	//发送手机验证码
	@Override
	@EsbServiceMapping
	public TempDemo getMobileCaptcha(@RequestParam("phone") String phone){
		TempDemo temp = new TempDemo();
		//根据手机号码获取用户
		MemberInformation mb = memberInformationManager.getUserByPhone(phone);
		if(mb != null){
			temp.setFlag(false);
			temp.setBuff("该用户已存在");
			return temp;
		}else{
			Map<String,Object> map = new HashMap<String, Object>();
			Random random = new Random(new Date().getTime());
			Long code = Math.abs(random.nextLong() % 999999);
			String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');
			map.put("#code", captcha);
			Boolean success = smsSend("1010", map, null, phone);
			if(success){
				temp.setFlag(true);
				temp.setBuff("发送成功");
			}else{
				temp.setFlag(false);
				temp.setBuff("发送失败");
			}
			return temp;
		}
	}
	//找回密码发送手机验证码
	@Override
	@EsbServiceMapping
	public TempDemo findPhoneCaptcha(@RequestParam("phone") String phone){
		TempDemo temp = new TempDemo();
		//根据手机号码获取用户
		MemberInformation mb = memberInformationManager.getUserByPhone(phone);
		if(mb == null){
			temp.setFlag(false);
			temp.setBuff("手机号不存在");
			return temp;
		}else{
			Map<String,Object> map = new HashMap<String, Object>();
			Random random = new Random(new Date().getTime());
			Long code = Math.abs(random.nextLong() % 999999);
			String captcha = org.apache.commons.lang.StringUtils.leftPad(code.toString(), 6, '0');
			map.put("#code", captcha);
			Boolean success = smsSend("1011", map, null, phone);
			if(success){
				temp.setFlag(true);
				temp.setBuff("发送成功");
			}else{
				temp.setFlag(false);
				temp.setBuff("发送失败");
			}
			return temp;
		}
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
				content = content.replace(entry.getKey(), entry.getValue().toString());
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
			mmd.setSendDate(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			mmd.setReceive(phone);
			mmd.setMsgCaption(mmt.getMsgTempalateCaption());
			mmd.setMsgContent(content);
			mmd.setMsgType("0");
			mmd.setSendStatus(status);//02-发送成功
			mmd.setCreateUser(recUser);
			mmd.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
//			mmd.setUpdateUser(recUser);
//			mmd.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
			mcMsgdatasDao.save(mmd);
			return success;
		}else{
			return false;
		}
	}

	@Override
	public String sendToBackadmin(McMsgdatas mcMsgdatas,String roleType) throws BusException {
		mcMsgdatas.setMsgType("1");
		sendMessage(mcMsgdatas, roleType, SMSUtil.SEND_ROLEGROUP);
		return null;
	}

	@Override
	public String sendToEntadmin(McMsgdatas mcMsgdatas) throws BusException {
		String roleId = "ROLE_QY_ADMIN";//企业管理员
		mcMsgdatas.setMsgType("2");
		sendMessage(mcMsgdatas, roleId, SMSUtil.SEND_MEMBERROLE);
		return null;
	}

	@Override
	public String sendToUser(McMsgdatas mcMsgdatas,String memberId) throws BusException {
		if(!StringUtils.isEmpty(memberId)){
			mcMsgdatas.setMsgType("3");
			sendMessage(mcMsgdatas, memberId, SMSUtil.SEND_MEMBER);
		}
		return null;
	}

	@Override
	public String sendSelected(McMsgdatas mcMsgdatas) throws BusException {
		if (messagePostProcessor != null) {
			messagePostProcessor.send(mcMsgdatas, Arrays.asList(new MsgParam[]{new MsgParam(mcMsgdatas.getReceive(), "")}));
		}
		return null;
	}
	//验证手机验证码
	@Override
	public TempDemo checkPhoneCode(String phone, String codeStr) throws BusException {
		TempDemo temp = new TempDemo();
		Code code = mcMsgdatasDao.getNewCode(phone);
		if(code != null){
			String eCode = code.getCode();
			String sendTime = code.getSendTime();
			if(StringUtils.isEmpty(eCode)||StringUtils.isEmpty(sendTime)){
				temp.setFlag(false);
				temp.setBuff("请先获取短信验证码");
				return temp;
			}
			String currentTime = DateUtils.getToday("yyyy-MM-dd hh:mm:ss");
			if(differenceSecond(currentTime,sendTime)>5000){
				temp.setFlag(false);
				temp.setBuff("请先获取短信验证码");
				return temp;
			}else{
				if(!codeStr.equals(com.gsoft.common.util.StringUtils.extractCode(eCode))){
					temp.setFlag(false);
					temp.setBuff("手机验证码不正确");
					return temp;
				}else{
					temp.setFlag(true);
					temp.setBuff("000000");
					return temp;
				}
			}
		}else{
			temp.setFlag(false);
			temp.setBuff("请先获取短信验证码");
			return temp;
		}
	}
	
	@Override
	public boolean checkCode(String phone, String codeStr) throws BusException {
		Code code = mcMsgdatasDao.getNewCode(phone);
		if(code != null){
			String eCode = code.getCode();
			String sendTime = code.getSendTime();
			if(StringUtils.isEmpty(eCode)||StringUtils.isEmpty(sendTime)){
				throw new BusException("系统不存在有效验证码");
			}
			String currentTime = DateUtils.getToday("yyyy-MM-dd hh:mm:ss");
			if(differenceSecond(currentTime,sendTime)>5000){
				throw new BusException("手机验证码超时！");
			}else{
				if(!codeStr.equals(com.gsoft.common.util.StringUtils.extractCode(eCode))){
					throw new BusException("输入验证码不匹配");
				}else{
					return true;
				}
			}
		}
		return false;
	}
	
	/**thisTime - ohterTime
	 * @param thisTime
	 * @param ohterTime
	 * @return
	 */
	public static long differenceSecond(String thisTime ,String ohterTime){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			long thisMillisecond = sdf.parse(thisTime).getTime();
			long otherMillisecond = sdf.parse(ohterTime).getTime();
			return (long) ((thisMillisecond - otherMillisecond)/(1000));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
