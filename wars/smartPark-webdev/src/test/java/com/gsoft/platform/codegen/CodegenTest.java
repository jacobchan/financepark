
package com.gsoft.platform.codegen;

import org.dom4j.Document;

import com.gsoft.framework.util.Dom4jUtils;
import com.gsoft.platform.codegen.model.ModelFactory;
import com.gsoft.platform.codegen.pdm.Pdm2ModelXml;

/**
 * @author zhyi_12
 *
 */
public class CodegenTest {

    public static void main(String[] args) {
            String tablePrefix = "sp";
            //配置PDM路径
            Document doc = Dom4jUtils.saxParse("/Users/jack/Project/SVNReponstory/psaqh/trunk/doc/02_设计/PDM/SmartPark_PDM.pdm");
            // TODO Auto-generated method stub
            Pdm2ModelXml pdm2ModelXml = new Pdm2ModelXml(doc,tablePrefix);
            Document modelXml = pdm2ModelXml.getModelDoc();
             
            ModelFactory.getInstance().registerModels(modelXml);
            
            GenerateEngine generateEngine = new GenerateEngine();
            
            
            GenerateConfig config = new GenerateConfig();
            
            //设置生产代码保存路径
            config.setSourceHome("/Users/jack/Project/SVNReponstory/psaqh/trunk/doc/generatorCode/smartPark");
            
            String[] commonBuff = new String[]{"BuildingBaseManager",
            		"MessageCenter","purchasingManager","OrderManager",
            		"NewsManager","MemberManager","PayManager","EnterpriceTypeManager"};
            for(int i = 0;i<commonBuff.length;i++){
            	config.setPackagePrefix("com.common");
            	generateEngine.generate(commonBuff[i], config);
            }
            
            String[] manageBuff = new String[]{"EnterBusinessManager",
            		"PropertyServiceManager","PublicUtilitiesManager","EmployeeManager",
            		"EnterpriseManager","EnterpriseMessageManager","ActivityManager",
            		"PolicyManager","ReserveManager"};
            for(int i = 0;i<manageBuff.length;i++){
            	config.setPackagePrefix("com.manage");
            	generateEngine.generate(manageBuff[i], config);
            }
            
            String[] memberBuff = new String[]{"MemberAdrManager",
            		"MemberCommentManager","shoppingCarManager","FavoritsManage"};
            for(int i = 0;i<memberBuff.length;i++){
            	config.setPackagePrefix("com.member");
            	generateEngine.generate(memberBuff[i], config);
            }
    }

}