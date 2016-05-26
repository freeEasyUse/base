package org.base.thread;

import java.util.concurrent.Callable;
/**
 * 
 * <p>Title:BaseCallable</p>
 * <p>description:执行带有返回值的多线程</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
public class BaseCallable implements Callable<Object> {

	private String callableName;
	
	public BaseCallable(){
		
	}
	
	public BaseCallable(String callableName){
		this.callableName = callableName;
	}
	
	
	@Override
	public Object call() throws Exception {
		System.out.println("this is"+callableName+"start");
		Thread.sleep(1000);
		System.out.println("this is"+callableName+"end");
		return this.callableName;
	}
}
