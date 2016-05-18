package org.base.test.logic;

import java.util.List;
import java.util.Map;

import org.base.dao.entity.StockInfo;
import org.base.service.logic.StockInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

public class StockInfoServiceTest extends BaseTest {

	@Autowired
	private StockInfoService stockInfoService;
	
	
	@Test
	public void selectByPage(){
		StockInfo infp = new StockInfo();
		Map<String, Object> result = stockInfoService.getListWithPage(1, 20, infp);
		List<StockInfo> list = (List<StockInfo>) result.get("list");
		Assert.assertNotNull(list);
		Assert.assertNotNull(result);
	}
	
}
