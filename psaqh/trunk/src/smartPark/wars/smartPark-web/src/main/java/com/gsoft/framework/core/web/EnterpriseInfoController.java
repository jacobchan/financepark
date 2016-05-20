package com.gsoft.framework.core.web;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.common.EnterpriceTypeManager.service.EtypeEnterprisetypeManager;
import com.common.MemberManager.entity.MemberInformation;
import com.common.MemberManager.service.MemberInformationManager;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.util.SecurityUtils;
import com.gsoft.utils.ExportExcel;
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
		ExportExcel<MemberInformation> mi = new ExportExcel<MemberInformation>();
		String[] headers = { "图像", "姓名", "联系方式", "描述" };
		List<MemberInformation> ml = memberInformationManager.getMemberInformations();
		try {
          response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
          response.addHeader(  
                  "Content-Disposition",  
                  "attachment;filename=" + new String(("项目数据查询.xls").getBytes("UTF-8"), "ISO-8859-1"));
          OutputStream os = response.getOutputStream();
          mi.exportExcel(headers, ml, os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}