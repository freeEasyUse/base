package org.base.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>
 * Title:SayHelloWithContentAspect
 * </p>
 * <p>
 * description:拦截带有内容的切面
 * </p>
 * <p>
 * company:
 * </p>
 * 
 * @author gel
 * @date 2016年5月27日
 * 
 */
@Component
@Aspect
public class SayHelloWithContentAspect {

	/**
	 * 定义切点
	 */
	@Pointcut("execution(* org.base.aop..*.sayHelloWithContent(..))")
	public void sayHelloWithContent() {

	}

	/**
	 * Before 在核心业务执行前执行，不能阻止核心业务的调用。
	 * 
	 * @param joinPoint
	 */
	@Before("sayHelloWithContent()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("-----beforeAdvice().invoke-----");
		System.out.println(" 此处意在执行核心业务逻辑前，做一些安全性的判断等等");
		System.out.println(" 可通过joinPoint来获取所需要的内容");
		System.out.println("-----End of beforeAdvice()------");
	}

	/**
	 * After 核心业务逻辑退出后（包括正常执行结束和异常退出），执行此Advice
	 * 
	 * @param joinPoint
	 */
	@After(value = "sayHelloWithContent()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("-----afterAdvice().invoke-----");
		System.out.println(" 此处意在执行核心业务逻辑之后，做一些日志记录操作等等");
		System.out.println(" 可通过joinPoint来获取所需要的内容");
		System.out.println("-----End of afterAdvice()------");
	}

	/**
	 * Around 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
	 * 相当于 before 和 after 的结合
	 * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice 执行完AfterAdvice，再转到ThrowingAdvice
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "sayHelloWithContent()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-----aroundAdvice().invoke-----");
		System.out.println(" 此处可以做类似于Before Advice的事情");

		// 调用核心逻辑
		System.err.println("开始执行 核心");
		Object retVal = pjp.proceed();
		//此处如果有异常 就不再执行了
		System.out.println(" 此处可以做类似于After Advice的事情");
		System.out.println("-----End of aroundAdvice()------");
		return retVal;
	}

	/**
	 * AfterReturning 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice
	 * 正常退出 会执行 若是异常则不执行
	 * @param joinPoint
	 */
	@AfterReturning(value = "sayHelloWithContent()", returning = "retVal")
	public void afterReturningAdvice(JoinPoint joinPoint, String retVal) {
		System.out.println("-----afterReturningAdvice().invoke-----");
		System.out.println("Return Value: " + retVal);
		System.out.println(" 此处可以对返回值做进一步处理");
		System.out.println(" 可通过joinPoint来获取所需要的内容");
		System.out.println("-----End of afterReturningAdvice()------");
	}

	/**
	 * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息
	 * 
	 * 注意：执行顺序在Around Advice之后
	 * 
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value = "sayHelloWithContent()", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		System.out.println("-----afterThrowingAdvice().invoke-----");
		System.out.println(" 错误信息：" + ex.getMessage());
		System.out.println(" 此处意在执行核心业务逻辑出错时，捕获异常，并可做一些日志记录操作等等");
		System.out.println(" 可通过joinPoint来获取所需要的内容");
		System.out.println("-----End of afterThrowingAdvice()------");
	}
}
