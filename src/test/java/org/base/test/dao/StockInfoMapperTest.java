package org.base.test.dao;

import java.util.List;

import org.base.dao.StockInfoMapper;
import org.base.dao.entity.StockInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

public class StockInfoMapperTest extends BaseTest {

	@Autowired
	private StockInfoMapper stockInfoMapper;
	
	@Test
	public void selectAllTest(){
		List<StockInfo> list = stockInfoMapper.selectAll();
		Assert.assertTrue(list!=null);
	}
	
}
