package org.base.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;




/**
 * 
 * <p>Title:SayHello</p>
 * <p>description:定义一个切面 sayhello需要做的事情</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
@Aspect
@Component
public class SayHelloAspect {

	public SayHelloAspect(){}
	
	//定义切点 在那个方法上执行
	@Pointcut("execution(* org.base.aop..*.sayHello(..))")
	public void point() {
	}
	
	//定义运行是通知
	@Before(value="point()")  
    public void beforeSayHello(){
        System.out.println("打招呼前 露出微笑");
    }
    
    
    //定义运行时通知
	@AfterReturning(value="point()")
    public void afterSayHello(){
        System.out.println("打招呼结束后 挥挥手");
    }

}
