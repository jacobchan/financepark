/**
 * 代码声明
 */
package com.common.purchasingManager.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.common.purchasingManager.entity.PurchasingmanagerMerchant;
import com.common.purchasingManager.entity.PurchasingmanagerMerchantAddress;

/**
 * 商户地址新增修改测试
 * @author maogf
 *
 */
@ContextConfiguration(locations={"classpath:applicationContext-test-mgf.xml"})
public class PurchasingmanagerMerchantAddressManagerTest extends AbstractJUnit4SpringContextTests{
	private PurchasingmanagerMerchantAddressManager purchasingmanagerMerchantAddressManager;
	
	@Autowired
	public void setPurchasingmanagerMerchantAddressManager(PurchasingmanagerMerchantAddressManager purchasingmanagerMerchantAddressManager){
		this.purchasingmanagerMerchantAddressManager = purchasingmanagerMerchantAddressManager;
	}
    /**
     * 保存商户地址
     */
	@Test
    public void testSavePurchasingmanagerMerchantAddress(){
		PurchasingmanagerMerchantAddress pma = new PurchasingmanagerMerchantAddress();
		pma.setMerchantAddressLinkman("汤姆");
		pma.setMerchantAddressPhone("13811112222");
		pma.setMerchantAddressAddress("纳斯达克");
		PurchasingmanagerMerchant purchasingmanagerMerchant = new PurchasingmanagerMerchant();
		purchasingmanagerMerchant.setMerchantId("40285e815320b277015320b27ae70001");
		pma.setPurchasingmanagerMerchant(purchasingmanagerMerchant);
    	purchasingmanagerMerchantAddressManager.savePurchasingmanagerMerchantAddress(pma);
    }

}
