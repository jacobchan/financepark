package com.gsoft.framework.workflow.service;

import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.security.AccountPrincipal;
import com.gsoft.framework.workflow.entity.TaskForm;
import java.util.Collection;
import java.util.Map;

public abstract interface FlowRunManager extends BaseManager
{
  public abstract Record getStartFormData(String paramString)
    throws BusException;

  public abstract TaskForm getTaskFormData(String paramString)
    throws BusException;

  public abstract String start(String paramString1, String paramString2, Map<String, Object> paramMap)
    throws BusException;

  public abstract PagerRecords getPagerTasks(Pager paramPager, Collection<Condition> paramCollection, Collection<Order> paramCollection1)
    throws BusException;

  public abstract PagerRecords getUserPagerTasks(String paramString, Pager paramPager, Collection<Condition> paramCollection, Collection<Order> paramCollection1)
    throws BusException;

  public abstract PagerRecords getGroupPagerTasks(AccountPrincipal paramAccountPrincipal, Pager paramPager, Collection<Condition> paramCollection, Collection<Order> paramCollection1)
    throws BusException;

  public abstract void completeTask(String paramString, Map<String, Object> paramMap)
    throws BusException;

  public abstract String getProcessXml(String paramString)
    throws BusException;
}