/**
 * 代码声明
 */
package com.common.purchasingManager.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.common.purchasingManager.entity.PurchasingmanagerGenre;
import com.common.purchasingManager.entity.PurchasingmanagerMerchant;
/**
 * 商户新增修改测试
 * @author maogf
 *
 */
@ContextConfiguration(locations={"classpath:applicationContext-test-mgf.xml"})
public class PurchasingmanagerMerchantManagerTest extends AbstractJUnit4SpringContextTests{
	private PurchasingmanagerMerchantManager purchasingmanagerMerchantManager;
	
	@Autowired
	public void setPurchasingmanagerMerchantManager(PurchasingmanagerMerchantManager purchasingmanagerMerchantManager){
		this.purchasingmanagerMerchantManager = purchasingmanagerMerchantManager;
	}
	/**
     * 保存商户
     */
    @Test
    public void testSavePurchasingmanagerMerchant(){
    	PurchasingmanagerMerchant pm = new PurchasingmanagerMerchant();
    	pm.setMerchantName("肯德基");
    	pm.setMerchantEnterpriseName("肯德基餐饮连锁公司");
    	PurchasingmanagerGenre pg = new PurchasingmanagerGenre();
    	pg.setGenreId("02");
//    	pm.setMerchantType(pg);
    	pm.setMerchantLinkman("迈克尔");
    	pm.setMerchantLinkmanPhone("18812345678");
    	pm.setMerchantSendAddress("美国拉斯维加斯");
    	pm.setMerchantReturnAddress("美国纽约");
    	purchasingmanagerMerchantManager.savePurchasingmanagerMerchant(pm);
    }

}
