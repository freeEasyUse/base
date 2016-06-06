package org.base.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * 
 * <p>Title:WebServiceClientFactory</p>
 * <p>description:创建webservice client工厂</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月6日
 *
 */
public class WebServiceClientFactory {
	
	/**
	 * 使用cxf工厂返回客户端
	 * @param url
	 * @param serviceClass
	 * @return
	 */
	public static Object getWebServiceClient(String url,Class serviceClass){
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress(url);
		factoryBean.setServiceClass(serviceClass);
		return factoryBean.create();
	}
	
}
