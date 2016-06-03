package com.gsoft.framework.upload.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.gsoft.common.util.XlsUtils;
import com.gsoft.entity.EmployeConstant;
import com.gsoft.entity.EntConstant;
import com.gsoft.framework.codemap.entity.Codeitem;
import com.gsoft.framework.codemap.service.CodeitemManager;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.DateUtils;
import com.gsoft.framework.util.PropertyUtils;
import com.manage.EmployeeManager.entity.EnterpriseEmployees;
import com.manage.EmployeeManager.service.EnterpriseEmployeesManager;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;
import com.manage.EnterpriseManager.entity.InformationLegal;
import com.manage.EnterpriseManager.service.InformationLegalManager;
import com.manage.PropertyServiceManager.entity.PropertyservicemanagerEntrec;

@Controller
@RequestMapping("/fileExport")
public class FileExportController {
	@Autowired
	private EnterbusinessmanagerRzManager enterbusinessmanagerRzManager;
	@Autowired
	private InformationLegalManager informationLegalManager;
	@Autowired
	private EnterpriseEmployeesManager enterpriseEmployeesManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private CodeitemManager codeitemManager;
	
	public static final String TEMPLATE_ENT = "entinfo.xlsx";
	public static final String TEMPLATE_USER = "userinfo.xlsx";

	@RequestMapping("/entexport.json")
	public void exportEnts(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException, IOException{
		List<String> header = EntConstant.header;
		List<Record> records = getEntDatas(header);
		String fileName = "企业信息"+DateUtils.getToday("yyyyMMddHHmmss")+".xlsx";
		if(request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0){
			fileName = new String(fileName.getBytes("utf-8"),"ISO8859-1");
		}
		response.addHeader("Content-Disposition","attachment; filename="+fileName);
		response.setContentType("application/msexcel");
		OutputStream out = response.getOutputStream();
		String basepath = request.getServletContext().getRealPath("/");
		System.out.println("----"+basepath);
		XlsUtils.buildWorkbook(out,records, header , new File(basepath +"template/"+TEMPLATE_ENT));
		out.flush();
		out.close();
	}
	
	/**构建企业信息
	 * @param header
	 * @return
	 */
	private List<Record> getEntDatas(List<String> header){
		List<EnterbusinessmanagerRz> ents = enterbusinessmanagerRzManager.getEnterbusinessmanagerRzs();
		List<Record> records = new ArrayList<Record>();
		if(ents!=null){
			for(EnterbusinessmanagerRz ent:ents){
				InformationLegal legal = informationLegalManager.getObjectByUniqueProperty("legalRe", ent.getRzId());
				Record record = new Record();
				for(String head:header){
					Object value;
					if(EntConstant.isLegal(head)){
						value = PropertyUtils.getPropertyValue(legal, head);
					}else{
						value = PropertyUtils.getPropertyValue(ent, head);
					}
					//实体，代码集转换
					if(value instanceof String){
						if("rzProperty".equals(head)){
							value = codeConvert("rzProperty", value.toString());
						}
						if("rzType".equals(head)){
							value = codeConvert("rzType", value.toString());
						}
					}else{
						if("enTypeId".equals(head)){
							PropertyservicemanagerEntrec entType = ent.getEntrecId();
							value = codeConvert("enTypeId", entType==null?null:entType.getEnteringName());
						}
					}
					record.put(head, value);
				}
				records.add(record);
			}
		}
		return records;
	}
	
	@RequestMapping("/userexport.json")
	public void exportUsers(HttpServletRequest request,
			HttpServletResponse response) throws FileNotFoundException, IOException{
		List<String> header = EmployeConstant.header;
		List<Record> records = getUserDatas(header);
		String fileName = "企业员工信息"+DateUtils.getToday("yyyyMMddHHmmss")+".xlsx";
		if(request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0){
			fileName = new String(fileName.getBytes("utf-8"),"ISO8859-1");
		}
		response.addHeader("Content-Disposition","attachment; filename="+fileName);
		response.setContentType("application/msexcel");
		OutputStream out = response.getOutputStream();
		String basepath = request.getServletContext().getRealPath("/");
		XlsUtils.buildWorkbook(out,records, header , new File(basepath+"template/"+TEMPLATE_USER));
		out.flush();
		out.close();
	}
	
	/**构建企业员工数据
	 * @param header
	 * @return
	 */
	public List<Record> getUserDatas(List<String> header){
		List<EnterpriseEmployees> employees = enterpriseEmployeesManager.getEnterpriseEmployeess();
		List<Record> records = new ArrayList<Record>();
		if(employees!=null){
			for(EnterpriseEmployees employe:employees){
				MemberInformation member = employe.getMember();
				EnterbusinessmanagerRz ent = employe.getRz();
				member.setCompanyId(ent.getRzName());
				Record record = new Record();
				for(String head:header){
					Object value;
					if(EmployeConstant.isEmploye(head)){
						value = PropertyUtils.getPropertyValue(employe, head);
					}else{
						value = PropertyUtils.getPropertyValue(member, head);
					}
					//实体，代码集转换
					if(value instanceof String){
						
					}
					record.put(head, value);
				}
				records.add(record);
			}
		}
		return records;
	}
	
	/**代码集转换
	 * @param codeValue
	 * @param itemValue
	 * @return
	 */
	public String codeConvert(String codeValue,String itemValue){
		Collection<Condition> conditions = new ArrayList<Condition>();
		conditions.add(ConditionUtils.getCondition("codemap.code", Condition.EQUALS, codeValue));
		List<Codeitem> codeItems = codeitemManager.getCodeitems(conditions, null);
		if(codeItems!=null){
			for(Codeitem codeitem:codeItems){
				if(itemValue.equals(codeitem.getItemValue())){
					return codeitem.getItemCaption();
				}
			}
		}
		return "";
	}
}
