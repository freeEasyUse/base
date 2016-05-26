package org.base.test.redis;


import org.base.redis.RedisClientTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

public class RedisClientTest extends BaseTest {

	@Autowired
	private RedisClientTemplate clientTemplate;
	
	
	@Test
	public void setValueTest(){
		String result = clientTemplate.set("key", "value");
		Assert.assertNotNull(result);
	}

	@Test
	public void getByKet(){
		String value = clientTemplate.get("key");
		Assert.assertEquals("value", value);
	}
}
