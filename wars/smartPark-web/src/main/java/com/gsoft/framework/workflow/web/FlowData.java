package com.gsoft.framework.workflow.web;

import com.gsoft.framework.core.web.annotation.DataInfo;
import com.gsoft.framework.core.web.controller.BaseDataController;
import com.gsoft.framework.core.web.controller.DataIn;
import com.gsoft.framework.core.web.view.DataModelAndView;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.util.RequestUtils;
import com.gsoft.framework.workflow.entity.Flow;
import com.gsoft.framework.workflow.service.FlowDesignerManager;
import com.gsoft.framework.workflow.service.FlowManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/workflow/flow"})
public class FlowData extends BaseDataController
{

  @Autowired
  private FlowManager flowManager;
  @Autowired
  private FlowDesignerManager flowDesignerManager;

  @RequestMapping
  @DataInfo(functionId="93010101", text="主键查询流程")
  public DataModelAndView getFlow(HttpServletRequest request, HttpServletResponse response, @RequestParam("flowId") String flowId)
  {
    return new DataModelAndView(this.flowManager.getFlow(flowId));
  }

  @RequestMapping
  @DataInfo(functionId="93010102", text="通用流程查询")
  public DataModelAndView getFlows(HttpServletRequest request, HttpServletResponse response, DataIn<Flow> dataIn, @ModelAttribute Flow flow, BindingResult result)
  {
    return new DataModelAndView(this.flowManager.getFlows(
      dataIn.getConditions(flow, result), 
      dataIn.getOrders()));
  }

  @RequestMapping
  @DataInfo(functionId="93010103", text="分页查询流程")
  public DataModelAndView getPagerFlows(HttpServletRequest request, HttpServletResponse response, DataIn<Flow> dataIn, @ModelAttribute Flow flow, BindingResult result)
  {
    return new DataModelAndView(this.flowManager.getPagerFlows(
      dataIn.getPager(), 
      dataIn.getConditions(flow, result), 
      dataIn.getOrders()), new String[] { "content" });
  }

  @RequestMapping
  @DataInfo(functionId="93010104", text="保存流程", log=true)
  public DataModelAndView saveFlow(HttpServletRequest request, HttpServletResponse response, DataIn<Flow> dataIn, @ModelAttribute Flow flow, BindingResult result)
  {
    Flow webFlow = (Flow)dataIn.getDomain(flow, result);
    Flow saveFlow = null;
    if (webFlow != null) {
      saveFlow = this.flowManager.saveFlow(webFlow);
    }
    return new DataModelAndView(saveFlow);
  }

  @RequestMapping
  @DataInfo(functionId="93010105", text="主键删除流程", log=true)
  public DataModelAndView removeFlow(HttpServletRequest request, HttpServletResponse response, @RequestParam("flowId") String flowId)
  {
    this.flowManager.removeFlow(flowId);
    return new DataModelAndView(new Message("000000", "删除成功"));
  }

  @RequestMapping
  @DataInfo(functionId="93010106", text="主键集合删除流程", log=true)
  public DataModelAndView removeFlows(HttpServletRequest request, HttpServletResponse response)
  {
    this.flowManager.removeFlows(request.getParameterValues("flowId"));
    return new DataModelAndView(new Message("000000", "集合删除成功"));
  }

  @RequestMapping
  @DataInfo(functionId="93010107", text="流程部署", log=true)
  public DataModelAndView deploy(HttpServletRequest request, HttpServletResponse response, DataIn<Flow> dataIn, @ModelAttribute Flow flow, BindingResult result)
  {
    String deployType = dataIn.getPropertyValue("deployType");
    String messageInfo;
    if ("1".equals(deployType))
    {
      this.flowManager.deploy(flow, null);
      messageInfo = "流程";
    }
    else
    {
      if ("2".equals(deployType))
      {
        this.flowManager.deployForm(flow, getFormJspDir(request));
        messageInfo = "表单";
      }
      else {
        this.flowManager.deploy(flow, getFormJspDir(request));
        messageInfo = "流程和表单";
      }
    }
    return new DataModelAndView(new Message("000000", messageInfo + "部署成功"));
  }
  @RequestMapping
  @DataInfo(functionId="93010107", text="流程部署", log=true)
  public DataModelAndView uploadFlow(HttpServletRequest request, HttpServletResponse response, DataIn<Flow> dataIn, @ModelAttribute Flow flow, BindingResult result)
  {
    String flowId = dataIn.getPropertyValue("flowId");
    byte[] byteProperty = dataIn.getByteProperty("contentFile");
    this.flowDesignerManager.uploadFlow(flowId, byteProperty);
    return new DataModelAndView(new Message("000000", "文件上传成功"));
  }

  @RequestMapping
  @DataInfo(functionId="93010112", text="流程发布", log=true)
  public DataModelAndView deployForm(HttpServletRequest request, HttpServletResponse response, DataIn<Flow> dataIn, @ModelAttribute Flow flow, BindingResult result)
  {
    this.flowManager.deployForm(flow, getFormJspDir(request));
    return new DataModelAndView(new Message("000000", "表单发布成功"));
  }

  private String getFormJspDir(HttpServletRequest request)
  {
    String runDirLocation = "/WEB-INF/pages/workflow/run";
    String realPath = RequestUtils.getRealPath(request, runDirLocation);
    return realPath;
  }
}