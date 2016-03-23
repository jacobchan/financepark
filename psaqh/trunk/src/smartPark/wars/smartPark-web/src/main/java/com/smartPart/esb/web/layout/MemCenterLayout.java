/**
 * 
 */
package com.smartPart.esb.web.layout;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;

import com.gsoft.framework.taglib.layout.AbstractLayout;




/**
 * @author zhyi_12
 * 
 */
public class MemCenterLayout extends AbstractLayout {
	
	private final static Log logger = LogFactory.getLog(MemCenterLayout.class);

    public MemCenterLayout(String decorator, Document document) {
        super(decorator, document);
    }
    
	@Override
	public String getStartHtml(PageContext pagecontext) {
		StringBuffer htmls = new StringBuffer();
		
		htmls.append(appendJsp(pagecontext,"header.jsp"));
		
		//构建菜单
		htmls.append("<div class=\"layout-content\"><div class=\"container\"><div class=\"static-html\">");
		htmls.append(appendJsp(pagecontext,"left.jsp"));
		//构建内容开始
		htmls.append("<div class=\"right\">");
		
		return htmls.toString();
	}

	@Override
	public String getEndHtml(PageContext pagecontext) {
		StringBuffer htmls = new StringBuffer();
		htmls.append("</div></div></div></div>");
		htmls.append(appendJsp(pagecontext,"footer.jsp"));
		return htmls.toString();
	}
	
	private String appendJsp(PageContext pageContext,String jspName) {
        String basePath = "/decorators/"+decorator+"/";
        try {
            return acquireString(pageContext, null, basePath+jspName);
        } catch (IOException e) {
            logger.error(jspName+"读取错误:"+e.getMessage());
        } catch (JspException e) {
            logger.error(jspName+"解析错误:"+e.getMessage());
        }
        return null;
    }
	
}