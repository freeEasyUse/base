package org.base.util.common;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

/**
 * 
 * <p>Title:CommonUtil</p>
 * <p>description:公用工具类</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月11日
 *
 */
public class CommonUtil {

	/**
	 * 将String转换为对应的类型
	 * 适用基础类型
	 * @return
	 */
	public static Object changeStrByType(String str,String type){
		Object result = null;
		//int Integer类型
		switch (type) {
		//int
		case "int":
		case "java.lang.Integer":
			result = Integer.parseInt(str);
			break;
		//double
		case "double":
		case "java.lang.Double":
			result = Double.parseDouble(str);
			break;
		//float
		case "float":
		case "java.lang.Float":
			result = Float.parseFloat(str);
			break;

		default:
			result = str;
			break;
		}
		return result;
	}
	
	
	/**
	 * 执行多线程工具类 没有返回值
	 * @param runnables 实现runnable接口的
	 */
	public static void execRunnable(Runnable ...runnables){
		//获取executorService
		ExecutorService exectorPool = Executors.newFixedThreadPool(runnables.length);
		for(Runnable runnable:runnables){
			exectorPool.execute(runnable);
		}
		exectorPool.shutdown();
	}
	
	/**
	 * 执行带有返回值的多线程工具类
	 * @param futures
	 * @param callables
	 */
	@SafeVarargs
	public static List<Future<Object>> execCallable(Callable<Object> ...callables){
		List<Future<Object>> futures = new ArrayList<Future<Object>>();
		//获取executorService
		ExecutorService exectorPool = Executors.newFixedThreadPool(callables.length);
		for(Callable<Object> callable:callables){
			Future<Object> future = exectorPool.submit(callable);
			futures.add(future);
		}
		return futures;
	}
	
	/**
	 * 根据给定的map 设置bean中对应的属性值
	 * @param obj
	 * @param props
	 */
	public static void setBeanProp(Object obj,Map<String, Object> props){
		for(String p:props.keySet()){
			PropertyDescriptor[] properdes = BeanUtils.getPropertyDescriptors(obj.getClass());
			for(PropertyDescriptor proper:properdes){
				if(StringUtils.endsWithIgnoreCase(proper.getName(), p)){
					Method m = proper.getWriteMethod();
					try {
						m.invoke(obj, props.get(p));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}
