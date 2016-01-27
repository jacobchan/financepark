
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
            String tablePrefix = "witpart";
            Document doc = Dom4jUtils.saxParse("E:\\pdm\\witpart.pdm");
            // TODO Auto-generated method stub
            Pdm2ModelXml pdm2ModelXml = new Pdm2ModelXml(doc,tablePrefix);
            Document modelXml = pdm2ModelXml.getModelDoc();
             
            ModelFactory.getInstance().registerModels(modelXml);
            
            GenerateEngine generateEngine = new GenerateEngine();
            
            GenerateConfig config = new GenerateConfig();
            config.setSourceHome("E:\\workspace\\witpark\\smartPark\\wars\\smartPark-webdev");
            config.setPackagePrefix("com.smartPark.operationCenter");
            generateEngine.generate("pur", config);
    }

}