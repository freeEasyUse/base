package org.base.webservice.server;

import javax.jws.WebService;


/**
 * 
 * <p>Title:WebServiceServer</p>
 * <p>description:调用java自带的webservice</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月3日
 *
 */
@WebService
public interface WebServiceServer {
	
	public String sayHello(String name);
	
/*	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9001/service/serviceHello", new WebServiceServer());
	}*/
	
}
