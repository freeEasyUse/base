package org.base.test.logic;

import org.base.dao.entity.StockInfo;
import org.base.dao.entity_t.Person;
import org.base.service.logic.DealTwoDdService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

public class DealTwoDbServiceTest extends BaseTest{

	@Autowired
	private DealTwoDdService dealTwoDdService;
	
	
	@Test
	public void insertTwo() throws Exception{
		Person p = new Person();
		p.setName("1235");
		p.setAge(16);
		
		StockInfo stockInfo = new StockInfo();
		stockInfo.setBusinessType("1245");
		stockInfo.setStockCode("code");
		stockInfo.setCompanyCode("com");
		stockInfo.setStockShort("stockshot");
		
		dealTwoDdService.addTwoRecord(p, stockInfo);
	}
	
	
}
