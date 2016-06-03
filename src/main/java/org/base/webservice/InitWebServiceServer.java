package org.base.webservice;

import java.util.ResourceBundle;

import javax.xml.ws.Endpoint;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>Title:InitWebServiceServer</p>
 * <p>description:根据配置文件发布java原生的webservice</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月3日
 *
 */
@Component
public class InitWebServiceServer implements InitializingBean,ApplicationContextAware {

	private ApplicationContext content;
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//获取配置文件
		ResourceBundle wbProperties = ResourceBundle.getBundle("config/wb/wbServer");
		for(String key:wbProperties.keySet()){
			//发布配置
			Endpoint.publish(wbProperties.getString(key), this.content.getBean(key));
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.content = applicationContext;
	}

}
