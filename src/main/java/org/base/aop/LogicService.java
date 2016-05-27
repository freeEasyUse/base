package org.base.aop;

/**
 * 
 * <p>Title:LogicService</p>
 * <p>description:演示aop的接口</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
public interface LogicService {

	void sayHello();
	
	String sayHelloWithContent(String content) throws Exception;
	
}
