package org.base.test.thread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.base.thread.BaseCallable;
import org.base.thread.BaseRunnable;
import org.base.util.common.CommonUtil;
import org.junit.Test;

import base.BaseTest;
/**
 * 
 * <p>Title:ThreadTest</p>
 * <p>description:多线程测试类</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
public class ThreadTest extends BaseTest{

	@Test
	public void testNoReturn(){
		BaseRunnable r1 = new BaseRunnable("r1");
		BaseRunnable r2 = new BaseRunnable("r2");
		CommonUtil.execRunnable(r1,r2);
	}
	
	
	
	@Test
	public void testWithReturn() throws InterruptedException, ExecutionException{
		BaseCallable c1 = new BaseCallable("c1");
		BaseCallable c2 = new BaseCallable("c2");
		BaseCallable c3 = new BaseCallable("c3");
		BaseCallable c4 = new BaseCallable("c4");
		BaseCallable c5 = new BaseCallable("c5");
		BaseCallable c6 = new BaseCallable("c6");
		//线程内部是无序的
		List<Future<Object>> callResult = CommonUtil.execCallable(c1,c2,c3,c4,c5,c6);
		System.out.println("out thread");
		System.out.println(callResult.size());
		//输出线程返回结果 结果只有当线程都结束后才能获取到
		for(Future<Object> f:callResult){
			System.out.println("result:"+f.get().toString());
		}
		//最后执行
		System.out.println("this is main end");
	}
	
}
