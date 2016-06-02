package org.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:AnotationInFile</p>
 * <p>description:自定义在属性上的注解</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月2日
 *
 */
@Target(ElementType.FIELD) //申名注解使用地方
@Retention(RetentionPolicy.RUNTIME) //保存信息级别
public @interface AnotationInFile {
	
	public String aliName();
	 
}
