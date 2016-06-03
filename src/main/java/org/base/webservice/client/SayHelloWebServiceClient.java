package org.base.webservice.client;
/**
 * 
 * <p>Title:SayHelloWebServiceClient</p>
 * <p>description:通过wsimport 命令生成客户端代码使用</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月3日
 *
 */
public class SayHelloWebServiceClient {
	public static void main(String[] args) {
		WebServiceServer webServiceServer = new WebServiceServerService().getWebServiceServerPort();
		System.out.println(webServiceServer.sayHello("world"));
	}
}
