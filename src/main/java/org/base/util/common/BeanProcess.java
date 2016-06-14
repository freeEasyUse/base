package org.base.util.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>Title:BeanProcess</p>
 * <p>description:定义bean实例化只有的操作 spring中所有的bean都能进入</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月14日
 *
 */
@Component
public class BeanProcess implements BeanPostProcessor {

	private List<Object> objsb = new ArrayList<Object>();
	
	private List<Object> objsa = new ArrayList<Object>();
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		objsa.add(bean);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		objsb.add(bean);
		return bean;
	}

}
