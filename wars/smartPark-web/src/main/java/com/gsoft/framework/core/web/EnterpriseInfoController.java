package com.gsoft.framework.core.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.common.BuildingBaseManager.service.BbmRoomManager;
import com.common.EnterpriceTypeManager.service.EtypeEnterprisetypeManager;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.common.excel.ExportExcel;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.SecurityUtils;
import com.manage.EnterBusinessManager.entity.EnterbusinessmanagerRz;
import com.manage.EnterBusinessManager.service.EnterbusinessmanagerRzManager;
@Controller
@RequestMapping("/enterprise")
public class EnterpriseInfoController {
	@Autowired
	private EtypeEnterprisetypeManager etypeEnterprisetypeManager;
	@Autowired
	private MemberInformationManager memberInformationManager;
	@Autowired
	private EnterbusinessmanagerRzManager enterbusinessmanagerRzManager;
	@Autowired
	private BbmRoomManager bbmRoomManager;
	
	/**
	 * 企业信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/info.html")
	public ModelAndView enterpriseInfo(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseInfo");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 企业融资
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/financing.html")
	public ModelAndView enterpriseFinancing(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseFinancing");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 专利，知识产权
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/knowledge.html")
	public ModelAndView enterpriseKnowledge(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseKnowledge");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 法定代表人
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/legal.html")
	public ModelAndView enterpriseLegal(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseLegal");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 媒体报道
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/media.html")
	public ModelAndView enterpriseMedia(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseMedia");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 企业通讯录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/book.html")
	public ModelAndView enterpriseBook(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseBook");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 企业码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/code.html")
	public ModelAndView enterpriseCode(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseCode");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 企业订单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/order.html")
	public ModelAndView enterpriseOrder(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseOrder");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	
	/**
	 * 企业评论
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reply.html")
	public ModelAndView enterpriseReply(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseReply");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	/**
	 * 企业评论
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/industry.html")
	public ModelAndView enterpriseIndustry(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("enterpriseCenter/enterpriseChanye");
		AccountPrincipal account = SecurityUtils.getAccount();
		model.addObject("user", account);
		return model;
	}
	/**
	 * 导出Excel
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/memberExportExcel.html", method = { RequestMethod.POST, RequestMethod.GET })
	public void memberExportExcel(HttpServletRequest request, HttpServletResponse response, String rzId){
		Collection<Condition> condition = new ArrayList<Condition>();
    	Collection<Order> order = new ArrayList<Order>();
    	condition.add(ConditionUtils.getCondition("companyId", Condition.EQUALS, rzId));
		
		ExportExcel<MemberInformation> mi = new ExportExcel<MemberInformation>();
		String[] headers = { "图像", "姓名", "联系方式", "描述" };
		List<MemberInformation> ml = memberInformationManager.getMemberInformations(condition, order);
		EnterbusinessmanagerRz r = enterbusinessmanagerRzManager.getEnterbusinessmanagerRz(rzId);
		try {
          response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
          response.addHeader(  
                  "Content-Disposition",  
                  "attachment;filename=" + new String(("企业通讯录-"+System.currentTimeMillis()+".xls").getBytes("UTF-8"), "ISO-8859-1"));
          OutputStream os = response.getOutputStream();
          mi.exportExcel(headers, ml, os, r.getRzName()+"通讯录");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 下载企业导入模板
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/downloadTemplate.html", method = { RequestMethod.POST, RequestMethod.GET })
	public void downloadTemplate(HttpServletRequest request, HttpServletResponse response){
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(("企业模板-"+System.currentTimeMillis()+".xlsx").getBytes("UTF-8"), "ISO-8859-1"));
			String path = request.getSession().getServletContext().getRealPath("/") + "exceltemplate";
            InputStream inputStream = new FileInputStream(new File(path + File.separator + "template.xlsx"));
            byte[] b = new byte[2048];
            int length = 0;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
			os.flush();
			inputStream.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}