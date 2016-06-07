package org.base.test.wb;

import org.base.webservice.WebServiceClientFactory;
import org.base.webservice.cxf.client.weather.GlobalWeatherSoap;
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
	
	@Test
	public void testWeather(){
		GlobalWeatherSoap soap = (GlobalWeatherSoap)WebServiceClientFactory.getWebServiceClient("http://www.webservicex.net/globalweather.asmx", GlobalWeatherSoap.class);
		soap.getCitiesByCountry("china");
		String weather = soap.getWeather("ShangHai", "China");
	}
}
