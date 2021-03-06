package com.manage.EnterBusinessManager.service.impl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.BuildingBaseManager.dao.BbmBuildingDao;
import com.common.BuildingBaseManager.dao.BbmFloorDao;
import com.common.BuildingBaseManager.entity.BbmBuilding;
import com.common.BuildingBaseManager.entity.BbmFloor;
import com.common.BuildingBaseManager.entity.BbmPark;
import com.common.BuildingBaseManager.entity.BbmRoom;
import com.common.BuildingBaseManager.service.BbmParkManager;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.common.EnterpriceTypeManager.service.EtypeEnterprisetypeManager;
import com.common.MemberManager.dao.MemberInformationDao;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.excel.ExcelColumn;
import com.common.excel.ExcelHead;
import com.common.excel.ExcelHelper;
import com.gsoft.common.util.XlsUtils;
import com.gsoft.entity.TempDemo;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.esb.annotation.ConditionCollection;
import com.gsoft.framework.esb.annotation.EsbServiceMapping;
import com.gsoft.framework.esb.annotation.OrderCollection;
import com.gsoft.framework.esb.annotation.PubCondition;
import com.gsoft.framework.esb.annotation.ServiceParam;
import com.gsoft.framework.security.fuc.service.RoleManager;
import com.gsoft.framework.upload.entity.FileStore;
import com.gsoft.framework.upload.service.FileStoreManager;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PasswordUtils;
import com.gsoft.framework.util.PropertyUtils;
import com.gsoft.framework.util.StringUtils;
import com.manage.EmployeeManager.dao.EnterpriseEmployeesDao;
import com.manage.EmployeeManager.dao.EnterpriseRoleDao;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.entity.EnterpriseRole;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EmployeeManager.service.EnterpriseRoleManager;
import com.manage.EnterBusinessManager.dao.EnterbusinessmanagerRzDao;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterBusinessManager.entity.EnterpriseInfomation;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;
import com.manage.EnterpriseManager.entity.InformationLegal;
import com.manage.EnterpriseManager.service.InformationLegalManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;
import com.manage.PropertyServiceManager.service.PropertyservicemanagerEntrecManager;
@Service("enterbusinessmanagerRzManager")
@Transactional
public class EnterbusinessmanagerRzManagerImpl extends BaseManagerImpl implements EnterbusinessmanagerRzManager{
	@Value("#{configProperties['file.root.path']}")
	private String root;
	@Autowired
	private EnterbusinessmanagerRzDao enterbusinessmanagerRzDao;
	@Autowired
	private BbmBuildingDao bbmBuildingDao;
	@Autowired
	private BbmFloorDao bbmFloorDao;
	@Autowired
	private PropertyservicemanagerEntrecManager propertyservicemanagerEntrecManager;
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager;
	@Autowired
	private EnterpriseRoleManager enterpriseRoleManager;
	@Autowired
	private BbmRoomManager bbmRoomManager;
	@Autowired
	private RoleManager roleManager;	
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private EtypeEnterprisetypeManager etypeEnterprisetypeManager;
	@Autowired
	private InformationLegalManager informationLegalManager;
	@Autowired
	private BbmParkManager bbmParkManager;
	@Autowired
	private FileStoreManager fileStoreManager;
	@Autowired
	private EnterpriseEmployeesDao enterpriseEmployeesDao;
	@Autowired
	private EnterpriseRoleDao enterpriseRoleDao;
	@Autowired
	private MemberInformationDao memberInformationDao;
	
    /**
     * 查询列表
     */
    //@EsbServiceMapping
    public List<EnterbusinessmanagerRz> getEnterbusinessmanagerRzs() throws BusException{
    	return enterbusinessmanagerRzDao.getAll();
    }
     /**
     * 条件查询列表
     */
    @EsbServiceMapping
    public List<EnterbusinessmanagerRz> getEnterbusinessmanagerRzs(
    	@ConditionCollection(domainClazz=EnterbusinessmanagerRz.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return enterbusinessmanagerRzDao.commonQuery(conditions, orders);
    }
    /**
     * 根据主键查询
     */
    @EsbServiceMapping
    public EnterbusinessmanagerRz getEnterbusinessmanagerRz(@ServiceParam(name="rzId") String id)  throws BusException{
    	return enterbusinessmanagerRzDao.get(id);
    }
	
	@EsbServiceMapping
	public PagerRecords getPagerEnterbusinessmanagerRzs(Pager pager,//分页条件
			@ConditionCollection(domainClazz=EnterbusinessmanagerRz.class) Collection<Condition> conditions,//查询条件
			@OrderCollection Collection<Order> orders)  throws BusException{
		orders.add(ConditionUtils.getOrder("rzDate", false));
		PagerRecords pagerRecords = enterbusinessmanagerRzDao.findByPager(pager, conditions, orders);
		@SuppressWarnings("unchecked")
		List<EnterbusinessmanagerRz> enterList = pagerRecords.getRecords();
		for(EnterbusinessmanagerRz enter:enterList){
			InformationLegal legal = informationLegalManager.getObjectByUniqueProperty("legalRe",enter.getRzId());
			enter.setLegal(legal);
		}
		return pagerRecords;
	}
    /**
     * 保存对象
     */
	@EsbServiceMapping(pubConditions = {@PubCondition(property = "updateUser", pubProperty = "userId")})
    public EnterbusinessmanagerRz saveEnterbusinessmanagerRz(EnterbusinessmanagerRz o) throws BusException{
    	String enterbusinessmanagerRzId = o.getRzId();
    	boolean isUpdate = StringUtils.isNotEmpty(enterbusinessmanagerRzId);
    	if(isUpdate){//修改
    		EnterbusinessmanagerRz rz = enterbusinessmanagerRzDao.get(enterbusinessmanagerRzId);
    		if(rz.getRoomId() != null){
    			if(!o.getRoomId().getRoomId().equals(rz.getRoomId().getRoomId())){
        			BbmRoom bbmRoom=bbmRoomManager.getBbmRoom(o.getRoomId().getRoomId());
        			
        			rz.setParkId(bbmRoom.getBbmPark().getParkId());
        			rz.setBuildingId(bbmRoom.getBbmBuilding().getBuildingId());
        			rz.setFloorId(bbmRoom.getBbmFloor().getFloorId());
        			//更新单元基础信息企业
//        			bbmRoom.setRzId(enterbusinessmanagerRzId);
//        			bbmRoom.setStatus("02");//已售已招
//        			bbmRoomManager.saveBbmRoom(bbmRoom);
        			bbmRoomManager.setEnterRoomStatus(enterbusinessmanagerRzId,o.getRoomId().getRoomId());//企业入驻占用单元时，设置单元状态
        		}
    		}else{
    			if(o.getRoomId()!=null){
	    			BbmRoom bbmRoom=bbmRoomManager.getBbmRoom(o.getRoomId().getRoomId());
	    			rz.setParkId(bbmRoom.getBbmPark().getParkId());
	    			rz.setBuildingId(bbmRoom.getBbmBuilding().getBuildingId());
	    			rz.setFloorId(bbmRoom.getBbmFloor().getFloorId());
	    			//更新单元基础信息企业
	//    			bbmRoom.setRzId(enterbusinessmanagerRzId);
	//    			bbmRoom.setStatus("02");//已售已招
	//    			bbmRoomManager.saveBbmRoom(bbmRoom);
	    			bbmRoomManager.setEnterRoomStatus(enterbusinessmanagerRzId,o.getRoomId().getRoomId());//企业入驻占用单元时，设置单元状态
    			}
    		}
    		rz.setRoomId(o.getRoomId());
    		rz.setRzManager(o.getRzManager());
    		rz.setRzName(o.getRzName());
    		rz.setRzDate(o.getRzDate());
    		rz.setRzBuss(o.getRzBuss());
    		rz.setEnTypeId(o.getEnTypeId());
    		StringBuffer numberCode = new StringBuffer();
    		BbmBuilding build = null;
        	BbmFloor floor = null;
    		if(null!=rz && !"".equals(rz.getBuildingId()) && null!=rz.getBuildingId()){
        		build = bbmBuildingDao.get(rz.getBuildingId());
        		numberCode.append(build.getBuildingNo());
        	}else{
        		numberCode.append("A1");
        	}
        	if(null!=rz && !"".equals(rz.getFloorId()) && null!=rz.getFloorId()){
        		floor = bbmFloorDao.get(rz.getFloorId());
        		numberCode.append(floor.getFloorNo());
        	}else{
        		numberCode.append("1F");
        	}
        	rz.setRzSign(numberCode.toString().replaceAll("-", "")+random(4));
//    		rz.setRzSign(o.getRzSign());
    		rz.setRzUrl(o.getRzUrl());
    		rz.setRzTelephone(o.getRzTelephone());
    		rz.setRzRemark(o.getRzRemark());
    		rz.setRzType(o.getRzType());
    		rz.setRzProperty(o.getRzProperty());
    		rz.setRzLogo(o.getRzLogo());
    		rz.setRzImages(o.getRzImages());
    		rz.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		rz.setUpdateUser(o.getUpdateUser());
    		rz = enterbusinessmanagerRzDao.save(rz);
    		return rz;
    		
    	}else{//新增
    		o.setCreateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		o.setCreateUser(o.getUpdateUser());
    		o.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
    		if(o.getRoomId()!=null){
	        	BbmRoom bbmRoom=bbmRoomManager.getBbmRoom(o.getRoomId().getRoomId());
	        	bbmRoomManager.setEnterRoomStatus(o.getRzId(),o.getRoomId().getRoomId());//企业入驻占用单元时，设置单元状态
	        	o.setParkId(bbmRoom.getBbmPark().getParkId());
	    		o.setBuildingId(bbmRoom.getBbmBuilding().getBuildingId());
	    		o.setFloorId(bbmRoom.getBbmFloor().getFloorId());
    		}
    		o = enterbusinessmanagerRzDao.save(o);
    		//更新单元基础信息企业
//    		bbmRoom.setRzId(o.getRzId());
//    		bbmRoom.setStatus("02");//已售已招
//    		bbmRoomManager.saveBbmRoom(bbmRoom);
        	
        	return o;
    	}
    	
    }
	//修改企业信息
	@Override
	@EsbServiceMapping
    public EnterbusinessmanagerRz updateEnterbusinessmanagerRz(@ServiceParam(name="userId",pubProperty="userId") String userId,
    		@ServiceParam(name="rzId") String rzId,@ServiceParam(name="rzLogo") String rzLogo,
    		@ServiceParam(name="roomId") String roomId,@ServiceParam(name="rzName") String rzName,
    		@ServiceParam(name="rzRemark") String rzRemark,@ServiceParam(name="rzUrl") String rzUrl,
    		@ServiceParam(name="enTypeId") String enTypeId,@ServiceParam(name="productDiscriptio") String productDiscriptio,
    		@ServiceParam(name="rzImages") String rzImages) throws BusException{
		EnterbusinessmanagerRz r = enterbusinessmanagerRzDao.get(rzId);
		BbmRoom bbmRoom=bbmRoomManager.getBbmRoom(roomId);
		EtypeEnterprisetype enType = etypeEnterprisetypeManager.getEtypeEnterprisetype(enTypeId);
		r.setEnTypeId(enType);
		if(StringUtils.isNotEmpty(rzLogo)){
			r.setRzLogo(rzLogo);
		}
		if(StringUtils.isNotEmpty(rzImages)){
			r.setRzImages(rzImages);
		}
		r.setRzName(rzName);
		r.setRoomId(bbmRoom);
		r.setRzUrl(rzUrl);
		r.setRzRemark(rzRemark);
		r.setProductDiscriptio(productDiscriptio);
		r.setUpdateUser(userId);
		r.setUpdateTime(DateUtils.getToday("yyyy-MM-dd HH:mm:ss"));
		return enterbusinessmanagerRzDao.save(r);
	}

    /**
     * 删除对象
     */
    @EsbServiceMapping
    public void removeEnterbusinessmanagerRz(@ServiceParam(name="rzId") String id) throws BusException{
    	enterbusinessmanagerRzDao.remove(id);
    }
    /**
     * 根据主键集合删除对象
     * @param ids
     */
    public void removeEnterbusinessmanagerRzs(@ServiceParam(name="rzId") String[] ids)  throws BusException{
   		for(String id:ids){
    		removeEnterbusinessmanagerRz(id);
    	}
    }
    
    @EsbServiceMapping
    public boolean exsitEnterbusinessmanagerRz(@ServiceParam(name="rzId") String id)  throws BusException{
		return enterbusinessmanagerRzDao.exists(id);
	}
    
    public boolean exsitEnterbusinessmanagerRz(String propertyName,Object value) throws BusException{
		return enterbusinessmanagerRzDao.exists(propertyName,value);
	}
    
    @EsbServiceMapping
	public void saveEnterbusinessmanagerRzBasicData(@ServiceParam(name="entrecId") String id)
			throws BusException {
    	PropertyservicemanagerEntrec psme=propertyservicemanagerEntrecManager.getPropertyservicemanagerEntrec(id);
    	//根据入驻办理预约记录表数据新增入驻信息基本数据
    	EnterbusinessmanagerRz enterbusinessmanagerRz=new EnterbusinessmanagerRz();
    	enterbusinessmanagerRz.setEntrecId(psme);
    	enterbusinessmanagerRz.setRzManager(psme.getMemberId());
    	EnterbusinessmanagerRz er=enterbusinessmanagerRzDao.save(enterbusinessmanagerRz);
    	//新增企业员工数据
    	EnterpriseEmployees enterpriseEmployees=new EnterpriseEmployees();
    	enterpriseEmployees.setRz(er);
    	enterpriseEmployees.setEmployeesTelephone(er.getRzTelephone());
    	enterpriseEmployees.setMember(er.getRzManager());
    	enterpriseEmployees=enterpriseEmployeesManager.saveEnterpriseEmployees(enterpriseEmployees);
    	//修改用户的企业ID
    	MemberInformation member = memberInformationManager.getMemberInformation(er.getRzManager().getMemberId());
    	member.setCompanyId(er.getRzId());
    	memberInformationManager.saveMemberInformation(member);
    	//企业员工默认为管理员角色
    	EnterpriseRole enterpriseRole=new EnterpriseRole();
    	enterpriseRole.setEmployees(enterpriseEmployees);
    	enterpriseRole.setRole(roleManager.getRole("ROLE_QY_ADMIN"));
    	enterpriseRoleManager.saveEnterpriseRole(enterpriseRole);
	}
    
    @EsbServiceMapping
	public void updateEnteringStatus(@ServiceParam(name="rzId") String id) throws BusException {
    	EnterbusinessmanagerRz enterbusinessmanagerRz=enterbusinessmanagerRzDao.get(id);
		String buildingId=enterbusinessmanagerRz.getBuildingId();
		if(buildingId!=""&&buildingId!=null){
			PropertyservicemanagerEntrec psme=propertyservicemanagerEntrecManager.getPropertyservicemanagerEntrec(enterbusinessmanagerRz.getEntrecId().getEntrecId());
			psme.setEnterrecStatus("06");//更改状态为已入驻
			propertyservicemanagerEntrecManager.savePropertyservicemanagerEntrec(psme);
		}
	}
    
    /**
	 * 根据名称查询企业
	 * @param rzName 入驻企业名称
	 * @return 符合条件的企业对象集合
	 * @throws BusException
	 * @author ZhuYL
	 * @time 2016-03-17
	 */
    @EsbServiceMapping
	public List<EnterbusinessmanagerRz> findEnterbusinessmanagerRzByName(@ServiceParam(name="rzName") String rzName)throws BusException{
    	Collection<Condition> condition = new ArrayList<Condition>();
    	Collection<Order> order = new ArrayList<Order>();
    	condition.add(ConditionUtils.getCondition("rzName", Condition.LIKE, rzName));
    	List<EnterbusinessmanagerRz> list = enterbusinessmanagerRzDao.commonQuery(condition, order);
    	return list;
    }
    
    /**
	 * 根据ID更新企业码
	 * @param rzId 入驻企业Id
	 * @throws BusException
	 * @author ZhuYL
	 * @time 2016-03-31
	 */
    @EsbServiceMapping
	public EnterbusinessmanagerRz updateEnteringSign(@ServiceParam(name="rzId") String rzId) throws BusException{
    	EnterbusinessmanagerRz rz = enterbusinessmanagerRzDao.get(rzId);
    	String rzSign = createSign(rzId);
    	Boolean isExist = findEnterbusinessmanagerRzBySign(rzSign);
    	EnterbusinessmanagerRz eb = null;
    	if(isExist){
    		rzSign = createSign(rzId);
    		rz.setRzSign(rzSign);
        	eb = enterbusinessmanagerRzDao.save(rz);
    	}else{
    		rz.setRzSign(rzSign);
        	eb = enterbusinessmanagerRzDao.save(rz);
    	}
    	return eb;
	}
    
    /**
     * 生成企业码
     * @param rzId
     * @return
     */
    public String createSign(String rzId){
    	EnterbusinessmanagerRz rz = enterbusinessmanagerRzDao.get(rzId);
    	BbmBuilding build = null;
    	BbmFloor floor = null;
    	StringBuffer numberCode = new StringBuffer();
    	String rzSign = "";
    	if(null!=rz && !"".equals(rz.getBuildingId()) && null!=rz.getBuildingId()){
    		build = bbmBuildingDao.get(rz.getBuildingId());
    		numberCode.append(build.getBuildingNo());
    	}else{
    		numberCode.append((char) (Math.random() * 26 + 'A')+random(1));
    	}
    	if(null!=rz && !"".equals(rz.getFloorId()) && null!=rz.getFloorId()){
    		floor = bbmFloorDao.get(rz.getFloorId());
    		numberCode.append(floor.getFloorNo());
    	}else{
    		numberCode.append(random(1)+(char) (Math.random() * 26 + 'A'));
    	}
    	rzSign = numberCode.toString().replaceAll("-", "")+random(4);
    	return rzSign;
    }

    /**
     * 检查企业码是否重复
     * @param rzSign
     * @return
     * @throws BusException
	 * @author ZhuYL
	 * @time 2016-03-17
     */
	public Boolean findEnterbusinessmanagerRzBySign(String rzSign){
    	Collection<Condition> condition = new ArrayList<Condition>();
    	Collection<Order> order = new ArrayList<Order>();
    	condition.add(ConditionUtils.getCondition("rzSign", Condition.EQUALS, rzSign));
    	List<EnterbusinessmanagerRz> list = enterbusinessmanagerRzDao.commonQuery(condition, order);
    	if(list.size()>0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * 获取指定位数不重复随机数
     * @param n
     * @return
     */
    public static String random(int n) {
        if (n < 1 || n > 10) {
            throw new IllegalArgumentException("cannot random " + n + " bit number");
        }
        Random ran = new Random();
        if (n == 1) {
            return String.valueOf(ran.nextInt(10));
        }
        int bitField = 0;
        char[] chs = new char[n];
        for (int i = 0; i < n; i++) {
            while(true) {
                int k = ran.nextInt(10);
                if( (bitField & (1 << k)) == 0) {
                    bitField |= 1 << k;
                    chs[i] = (char)(k + '0');
                    break;
                }
            }
        }
        return new String(chs);
    }
   
    /**
	  * //获取当前用户公司名字
	  * @param userId
	 
	  * @return
	  * @throws BusException
	  */
	 @EsbServiceMapping
	 public EnterbusinessmanagerRz getCompanyIdName(
			    @ServiceParam(name="userId",pubProperty = "userId") String userId) throws BusException {
		    MemberInformation m = memberInformationManager.getMemberInformation(userId);
			String companyId=m.getCompanyId();
			EnterbusinessmanagerRz e=enterbusinessmanagerRzDao.get(companyId);
			return e;
	 }
	 
	 /**
	  * 通过企业id得到企业单元信息
	  * @param rzId 企业入驻ID
	  * @return
	  * @throws BusException
	  */
	@EsbServiceMapping
	public BbmRoom getRoomByRzId(@ServiceParam(name="rzId") String rzId) throws BusException {
		if(StringUtils.isNotEmpty(rzId)){
			EnterbusinessmanagerRz e = enterbusinessmanagerRzDao.get(rzId) ;
			BbmRoom room = e.getRoomId() ;
			if(room != null){
				String roomId = room.getRoomId() ;
				room = bbmRoomManager.getBbmRoom(roomId) ;
				return room ;
			}
		}
		return null;
	}
	/**
	 * 第三方单点登录
	 */
	@Override
	public TempDemo singleLogin(String phone, String password, String parkName,
			String companyName) {
		TempDemo temp = new TempDemo();
		BbmPark bbmPark = bbmParkManager.getBbmParkByParkName(parkName);
		if(bbmPark == null){
			temp.setFlag(false);
			temp.setBuff("园区不存在！");
		}else{
			MemberInformation mem = memberInformationManager.getUserByPhone(phone);
			EnterbusinessmanagerRz enterRZ = enterbusinessmanagerRzDao.getObjectByUniqueProperty("rzName", companyName);
			if(mem == null){
				MemberInformation memberInformation = new MemberInformation();
				memberInformation.setMemberName(phone);
				memberInformation.setMemberPassword(PasswordUtils.md5Password(password));
				memberInformation.setMemberPhoneNumber(phone);
				if(enterRZ != null){
					memberInformation.setCompanyId(enterRZ.getRzId());
				}
				MemberInformation member = memberInformationManager.saveMemberInformation(memberInformation);
				// 添加默认角色
				memberInformationManager.setDefaultRole(member);
			}else{
				if(mem.getCompanyId() == null){
					if(enterRZ != null){
						mem.setCompanyId(enterRZ.getRzId());
					}
				}
//				mem.setMemberPassword(PasswordUtils.md5Password(password));
				memberInformationManager.saveMemberInformation(mem);
			}
			temp.setFlag(true);
		}
		return temp;
	} 
	
	/**
	 * 删除企业通讯录员工与企业关系
	 * @param o
	 * @return
	 * @throws BusException
	 */
	@EsbServiceMapping(pubConditions = { @PubCondition(property = "updateUser", pubProperty = "userId") })
	public String updateMemberInformationOfCompany(MemberInformation o) throws BusException {
		String msg = "";
		if(!"".equals(o.getCompanyId()) && null!=o.getCompanyId()){
			StringBuffer roleIds = new StringBuffer();
			StringBuffer employeesIds = new StringBuffer();
			String[] roleId = new String[1];
			String[] employeesId = new String[1];
			// 获取当前member对象
			MemberInformation m = memberInformationDao.get(o.getMemberId());
			// 根据员工id获取角色
			List<EnterpriseRole> r = null;
			Collection<Condition> conditionRole = new ArrayList<Condition>();
			Collection<Order> orderRole = new ArrayList<Order>();
			// 根据memberId获取员工
			Collection<Condition> conditionEmployees = new ArrayList<Condition>();
			Collection<Order> orderEmployees = new ArrayList<Order>();
			conditionEmployees.add(ConditionUtils.getCondition("member.memberId", Condition.EQUALS, m.getMemberId()));
			List<EnterpriseEmployees> e = enterpriseEmployeesDao.commonQuery(conditionEmployees, orderEmployees);
			if(e.size()>0){
				for (int i = 0; i < e.size(); i++) {
					conditionRole.add(ConditionUtils.getCondition("employees.employeesId", Condition.EQUALS, e.get(i).getEmployeesId()));
					r = enterpriseRoleDao.commonQuery(conditionRole, orderRole);
					employeesIds.append(e.get(i).getEmployeesId()+",");
				}
				if(r.size()>0){
					if(!"ROLE_QY_ADMIN".equals(r.get(0).getRole().getRoleId())){
						for (int n = 0; n < r.size(); n++) {
							roleIds.append(r.get(n).getrId()+",");
						}
						//批量删除角色
						roleId[0] = roleIds.substring(0, roleIds.length()-1);
						enterpriseRoleManager.removeEnterpriseRoles(roleId);
						//删除员工
						employeesId[0] = employeesIds.substring(0, employeesIds.length()-1);
						enterpriseEmployeesManager.removeEnterpriseEmployeess(employeesId);
						
						//置空member的company
						m.setCompanyId("");
						memberInformationDao.save(m);
					}else{
						msg = "企业管理员不能删除！";
					}
				}else{
					msg = "员工角色不存在！";
				}
			}else{
				msg = "企业员工不存在！";
			}
		}else{
			msg = "非企业员工！";
		}
		return msg;
	}
	/**
	 * 企业信息Excel导入
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@EsbServiceMapping(pubConditions = { @PubCondition(property = "updateUser", pubProperty = "userId") })
	public String memberImportExcel(@ServiceParam(name="batchExcel") String batchExcel) throws BusException, ParseException {
		String msg = "企业信息导入成功！";
		File file = new File(new File(root), batchExcel);
		if(!file.exists()){
			msg = "文件不存在！";
			throw new BusException("文件不存在！");
		}
		
		List<ExcelColumn> excelColumns = new ArrayList<ExcelColumn>();
		excelColumns.add(new ExcelColumn(0, "rzName", "企业名称"));
		excelColumns.add(new ExcelColumn(1, "rzSign", "企业码"));
		excelColumns.add(new ExcelColumn(2, "rzDate", "入驻时间"));
		excelColumns.add(new ExcelColumn(3, "enTypeName", "行业类型"));
		excelColumns.add(new ExcelColumn(4, "rzType", "上市类型"));
		excelColumns.add(new ExcelColumn(5, "rzProperty", "企业性质"));
		excelColumns.add(new ExcelColumn(6, "memberName", "企业管理员"));
		excelColumns.add(new ExcelColumn(7, "parkId", "园区"));
		excelColumns.add(new ExcelColumn(8, "buildingId", "楼栋"));
		excelColumns.add(new ExcelColumn(9, "roomId", "单元"));
		excelColumns.add(new ExcelColumn(10, "floorId", "楼层"));
		excelColumns.add(new ExcelColumn(11, "rzLogo", "logo"));
		excelColumns.add(new ExcelColumn(12, "rzUrl", "网址"));
		excelColumns.add(new ExcelColumn(13, "rzRemark", "描述"));

		// 需要特殊转换的单元
		Map<String, Map> excelColumnsConvertMap = new HashMap<String, Map>();
		Map<String, String> rzType = new HashMap<String, String>();
		rzType.put("主板", "01");
		rzType.put("中小板", "02");
		rzType.put("创业板", "03");
		rzType.put("新三板", "04");
		rzType.put("未上市", "05");
		excelColumnsConvertMap.put("rzType", rzType);
		Map<String, String> rzProperty = new HashMap<String, String>();
		rzProperty.put("外资（欧美）", "01");
		rzProperty.put("外资（非欧美）", "02");
		rzProperty.put("合资", "03");
		rzProperty.put("国企", "04");
		rzProperty.put("民营", "05");
		rzProperty.put("政府机关", "06");
		rzProperty.put("事业单位", "07");
		rzProperty.put("非盈利机构", "08");
		excelColumnsConvertMap.put("rzProperty", rzProperty);
		ExcelHead head = new ExcelHead();
		head.setRowCount(2); // 头所占行数
		head.setColumns(excelColumns); // 列的定义
		head.setColumnsConvertMap(excelColumnsConvertMap); // 列的转换

		List<EnterpriseInfomation> rzsList = ExcelHelper.getInstanse().importToObjectList(head, file, EnterpriseInfomation.class);

		//获取数据保存到企业入驻表
		for (EnterpriseInfomation i : rzsList) {
			EnterbusinessmanagerRz r = new EnterbusinessmanagerRz();
			r.setRzName(i.getRzName());
			r.setRzSign(i.getRzSign());
			r.setRzDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(i.getRzDate()));
			r.setEnTypeId(etypeEnterprisetypeManager.getEtypeEnterprisetype(i.getEnTypeName()));
			r.setRzType(i.getRzType());
			r.setRzProperty(i.getRzProperty());
			r.setRzManager(memberInformationManager.getMemberInformation(i.getMemberName()));
			r.setParkId(i.getParkId());
			r.setBuildingId(i.getBuildingId());
			r.setRoomId(bbmRoomManager.getBbmRoom(i.getRoomId()));
			r.setFloorId(i.getFloorId());
			r.setRzLogo(i.getRzLogo());
			r.setRzUrl(i.getRzUrl());
			r.setRzRemark(i.getRzRemark());
			enterbusinessmanagerRzDao.save(r);
		}
		return msg;
	}
	
	
	@EsbServiceMapping
	public void entImport(@ServiceParam(name="filePath") String filePath) throws BusException {
		if(StringUtils.isNotEmpty(filePath)){
			File xlsFile = new File(filePath);
			Map<String,String> properties = new HashMap<String,String>();
			properties.put("rzName", "企业名称");
			properties.put("rzBuss", "企业管理员电话");
			properties.put("enTypeId", "所在行业");
			properties.put("rzProperty", "企业性质"); 
			properties.put("rzType", "上市类型");
			properties.put("rzUrl", "公司网址");
			properties.put("rzRemark", "公司介绍");
			properties.put("productDiscriptio", "产品描述");
			//法人信息
			properties.put("legalName","创世人姓名");
			properties.put("legalBirthday","出生日期");
			properties.put("legalTelephone","联系电话");
			properties.put("legalBusiness","职位");
			properties.put("legalRemark","");
			List<Record> records = XlsUtils.buildRecords(xlsFile, properties);
			if(records!=null&&records.size()>0){
				List<EnterbusinessmanagerRz> ents = new ArrayList<EnterbusinessmanagerRz>();
				for(Record record:records){
					EnterbusinessmanagerRz enter = new EnterbusinessmanagerRz();
					for(Map.Entry<String, String> entry:properties.entrySet()){
						PropertyUtils.setSimplePropertyValue(enter, entry.getKey(), record.get(entry.getKey()));
						
					}
					ents.add(enter);
				}
				enterbusinessmanagerRzDao.save(ents);
			}
			
		}
	}
	
	@EsbServiceMapping
	public FileStore entExport() throws BusException {//通过ajax实现下载，但是下载业务没有实现
		String basepath = this.getClass().getResource("/").getPath();
		List<EnterbusinessmanagerRz> ents = this.getEnterbusinessmanagerRzs();
		List<Record> records = new ArrayList<Record>();
//		records.addAll(ents);
		List<String> header = new ArrayList<String>();
		header.add("rzName");
		header.add("rzTelephone");
		header.add("rzProperty");
		header.add("rzType");
		header.add("rzUrl");
		header.add("productDiscriptio");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		XlsUtils.buildWorkbook(output,records, header , new File(basepath+"template/entinfo.xls"));
		
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		FileStore fileStore = fileStoreManager.storeFile("entinfo.xlsx", input, null, "");
		return fileStore;
	}
	
	public EnterbusinessmanagerRz getEnterbusinessmanagerRzByUniqueProperty(String prop,String value) throws BusException{
		return enterbusinessmanagerRzDao.getObjectByUniqueProperty(prop, value);
	}
	
	public void saveEntAndLegal(EnterbusinessmanagerRz ent,InformationLegal legal) throws BusException{
		EnterbusinessmanagerRz savedEnt = this.saveEnterbusinessmanagerRz(ent);
		legal.setLegalRe(savedEnt.getRzId());
		informationLegalManager.saveInformationLegal(legal);
	}
}