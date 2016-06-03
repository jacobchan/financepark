package com.gsoft.framework.upload.web;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.common.EnterpriceTypeManager.dao.EtypeEnterprisetypeDao;
import com.common.EnterpriceTypeManager.entity.EtypeEnterprisetype;
import com.common.MemberManager.entity.MemberInformation;
import com.gsoft.common.util.XlsUtils;
import com.gsoft.entity.EmployeConstant;
import com.gsoft.entity.EntConstant;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.codemap.service.CodeitemManager;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.PropertyUtils;
import com.gsoft.framework.util.StringUtils;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;
import com.manage.EnterpriseManager.entity.InformationLegal;

@Controller
@RequestMapping("/fileImport")
public class FileImportController {
	@Autowired
	private EnterbusinessmanagerRzManager enterbusinessmanagerRzManager;//企业信息
	@Autowired
	private EtypeEnterprisetypeDao enterprisetypeDao;//企业行业
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager;//企业员工
	@Autowired
	private CodeitemManager codeitemManager;

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/entimport.json")
	public DataModelAndView importEnts(HttpServletRequest request,
			HttpServletResponse response) {
//		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//		MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
		MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = mulRequest.getFile("entfile");
		String filename = file.getOriginalFilename();
		if(StringUtils.isNotEmpty(filename)&&isExcel(filename)){
			try{
				InputStream input = file.getInputStream();
				//如果写到公共方法出现 stream close异常，需要处理
				Workbook workBook;
				try {
					workBook = new XSSFWorkbook(input);
				} catch (Exception e) {
					workBook = new HSSFWorkbook(input);
				}
				Map<String,String> properties = EntConstant.properties;
		//		List<Record> records = buildRecords(input, properties);
				List<Record> records = new ArrayList<Record>();
				XlsUtils.parseWorkbook(workBook, records, properties);
				if(records!=null&&records.size()>0){
					for(Record record:records){
						EnterbusinessmanagerRz enter = new EnterbusinessmanagerRz();
						InformationLegal legal = new InformationLegal();
						for(Map.Entry<String, String> entry:properties.entrySet()){
							if("enTypeId".equals(entry.getKey())){//所在行业
								String enTypeName = record.get("enTypeId").toString();
								EtypeEnterprisetype entType = enterprisetypeDao.getObjectByUniqueProperty("enTypeName", enTypeName);
								record.put("enTypeId", entType);
							}
							if("rzProperty".equals(entry.getKey())){//企业性质
								record.put("rzProperty", codeConvert("rzProperty", record.get("rzProperty").toString()));
							}
							if("rzType".equals(entry.getKey())){//上市类型
								record.put("rzType", codeConvert("rzType", record.get("rzType").toString()));
							}
							if(!EntConstant.isLegal(entry.getKey()))
								PropertyUtils.setSimplePropertyValue(enter, entry.getKey(), record.get(entry.getKey()));
							else{
								PropertyUtils.setPropertyValue(legal, entry.getKey(), record.get(entry.getKey()));
							}
						}
//						EnterbusinessmanagerRz savedEnt = enterbusinessmanagerRzManager.saveEnterbusinessmanagerRz(enter);
//						legal.setLegalRe(savedEnt.getRzId());
//						informationLegalManager.saveInformationLegal(legal);
						enterbusinessmanagerRzManager.saveEntAndLegal(enter,legal);
					}
				}
			}catch(Exception e){
				return new DataModelAndView(new Message("999999", "导入失败！") );
			}
		}
		return new DataModelAndView(new Message("000000", "导入成功！") );
	}
	
	@RequestMapping("/userimport.json")
	public DataModelAndView importUsers(HttpServletRequest request,
			HttpServletResponse response) {
		//org.apache.shiro.web.servlet.ShiroHttpServletRequest
		//org.springframework.web.multipart.MultipartHttpServletRequest
		
		MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = mulRequest.getFile("userfile");
		String filename = file.getOriginalFilename();
		if(StringUtils.isNotEmpty(filename)&&isExcel(filename)){
			try{
				InputStream input = file.getInputStream();
				Workbook workBook;
				try {
					workBook = new XSSFWorkbook(input);
				} catch (Exception e) {
					workBook = new HSSFWorkbook(input);
				}
				Map<String,String> properties = EmployeConstant.properties;
				List<Record> records = new ArrayList<Record>();
				XlsUtils.parseWorkbook(workBook, records, properties);
				if(records!=null&&records.size()>0){
					for(Record record:records){
						MemberInformation member = new MemberInformation();
						EnterpriseEmployees employe = new EnterpriseEmployees();
						for(Map.Entry<String, String> entry:properties.entrySet()){
	//						if("employeesDepartment".equals(entry.getKey())){//部门
	//							record.put("employeesDepartment", codeConvert("", record.get("employeesDepartment").toString()));
	//						}
							if(!EmployeConstant.isEmploye(entry.getKey()))
								PropertyUtils.setPropertyValue(member, entry.getKey(), record.get(entry.getKey()));
							else{
								PropertyUtils.setPropertyValue(employe, entry.getKey(), record.get(entry.getKey()));
							}
						}	
//						member.setMemberPassword(passwordService.hashPassword("123456").toHex());
//						MemberInformation savedMemeber = memberInformationManager.saveMemberInformation(member);
//						String phone = savedMemeber.getMemberPhoneNumber();
//						EnterbusinessmanagerRz ent = enterbusinessmanagerRzManager.getEnterbusinessmanagerRzByUniqueProperty("rzName", savedMemeber.getCompanyId());
//						employe.setEmployeesName(savedMemeber.getMemberName());
//						employe.setEmployeesTelephone(phone);
//						employe.setRz(ent);
//						employe.setMember(savedMemeber);
//						EnterpriseEmployees savedEmploye = enterpriseEmployeesManager.saveEnterpriseEmployees(employe);
//						if(phone.equals(ent.getRzBuss())){//管理员
//							EnterpriseRole entRole = new EnterpriseRole();
//							entRole.setEmployees(savedEmploye);
//							entRole.setRole(roleManager.getRole("ROLE_QY_ADMIN"));
//							//如果有则修改
//							enterpriseRoleManager.saveEnterpriseRole(entRole );
//						}
						enterpriseEmployeesManager.saveMemberAndEmploye(member,employe);
					}
				}
			}catch(Exception e){
				return new DataModelAndView(new Message("999999", "导入失败！") );
			}
		}
		return new DataModelAndView(new Message("000000", "导入成功！") );
	}
	
	/**代码集描述转换值
	 * @param codeValue
	 * @param itemCaption
	 * @return
	 */
	public String codeConvert(String codeValue,String itemCaption){
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS, codeValue));
		List<Codeitem> codeItems = codeitemManager.getCodeitems(conditions, null);
		if(codeItems!=null){
			for(Codeitem codeitem:codeItems){
				if(itemCaption.equals(codeitem.getItemCaption())){
					return codeitem.getItemValue();
				}
			}
		}
		return "";
	}
	
	public boolean isExcel(String fileName){
		if(StringUtils.isNotEmpty(fileName)&&(fileName.lastIndexOf(".xls")>0||fileName.lastIndexOf(".xlsx")>0)){
			return true;
		}else{
			throw new BusException("请选择*.xls、*.xlsx文件");
		}
	}
}
