package org.base.test.aop;

import org.base.aop.LogicService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

/**
 * 
 * <p>Title:AopTest</p>
 * <p>description:AOP测试</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
public class AopTest extends BaseTest {

	@Autowired
	private LogicService logicService;
	
	@Test
	public void testAop(){
		logicService.sayHello();
	}
	
}
