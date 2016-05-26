package org.base.aop;

import org.springframework.stereotype.Service;

/**
 * 
 * <p>Title:LogicServiceImpl</p>
 * <p>description:演示aop实现</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
@Service
public class LogicServiceImpl implements LogicService {

	@Override
	public void sayHello() {
		System.out.println("hello world");
	}

}
