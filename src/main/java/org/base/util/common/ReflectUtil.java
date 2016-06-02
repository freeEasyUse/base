package org.base.util.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.base.constant.UseContent;

/**
 * 
 * <p>
 * Title:ReflectUtil
 * </p>
 * <p>
 * description:反射工具类
 * </p>
 * <p>
 * company:
 * </p>
 * 
 * @author gel
 * @date 2016年6月2日
 * 
 */
public class ReflectUtil {

	/**
	 * 获取类上指定的注解
	 * 
	 * @param t
	 *            指定的类
	 * @param annotaionPlace
	 *            注解声明位置
	 * @param annotaionClass
	 *            指定获取的注解类
	 */
	@SuppressWarnings("all")
	public static <T, M> Map<String, Annotation> getAnotaionInfo(T t, int annotaionPlace, Class annotationClass) {
		Class<T> c = (Class<T>) t.getClass();
		Map<String, Annotation> result = new HashMap<String, Annotation>();
		// 在类级别上的注解
		if (UseContent.ANNOTAION_IN_CLASS == annotaionPlace) {
			Annotation annotation = c.getAnnotation(annotationClass);
			result.put(c.getName(), annotation);
		}
		// 属性级别上的注解
		else if (UseContent.ANNOTAION_IN_FIELD == annotaionPlace) {
			// 获取所有的属性
			Field[] fields = c.getDeclaredFields();
			for (Field f : fields) {
				result.put(f.getName(), f.getAnnotation(annotationClass));
			}
		}
		// 方法级别上的注解
		else {
			// 获取所有的方法
			Method[] methods = c.getDeclaredMethods();
			for (Method m : methods) {
				result.put(m.getName(), m.getAnnotation(annotationClass));
			}
		}
		return result;
	}

}
