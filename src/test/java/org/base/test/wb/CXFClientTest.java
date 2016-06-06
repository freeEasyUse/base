package org.base.test.wb;

import org.base.webservice.WebServiceClientFactory;
import org.base.webservice.cxf.wb.WebServiceServerWithCXF;
import org.junit.Test;

import base.BaseTest;


public class CXFClientTest extends BaseTest {
	
	@Test
	public void testCxfTest(){
		WebServiceServerWithCXF wb = (WebServiceServerWithCXF) WebServiceClientFactory.getWebServiceClient("http://localhost:8088/base/ws//webServiceServerWithCXFImplService", WebServiceServerWithCXF.class);
		String result = wb.sayHello("this is useCXFCLIENT");
		System.out.println(result);
	}
}
