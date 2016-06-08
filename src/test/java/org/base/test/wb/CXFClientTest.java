package org.base.test.wb;


import javax.xml.bind.JAXBElement;

import org.base.util.common.CommonUtil;
import org.base.webservice.CurrentWeather;
import org.base.webservice.WebServiceClientFactory;
import org.base.webservice.cxf.client.weather.GlobalWeatherSoap;
import org.base.webservice.cxf.client.weather.ObjectFactory;
import org.base.webservice.cxf.wb.WebServiceServerWithCXF;
import org.junit.Test;

import base.BaseTest;


public class CXFClientTest extends BaseTest {
	
	@Test
	public void testCxfTest(){
		WebServiceServerWithCXF wb = (WebServiceServerWithCXF) WebServiceClientFactory.getWebServiceClient("http://localhost:8088/base/ws//webServiceServerWithCXFImplService", WebServiceServerWithCXF.class);
		String result = wb.sayHello("this is useCXFCLIENT");
	}
	
	@Test
	public void testWeather() throws Exception{
		GlobalWeatherSoap soap = (GlobalWeatherSoap)WebServiceClientFactory.getWebServiceClient("http://www.webservicex.net/globalweather.asmx", GlobalWeatherSoap.class);
		//String countryCities = soap.getCitiesByCountry("china");
		String weatherxml = soap.getWeather("ShangHai", "China");
		//String head = "<COUNTRY xmlns=\"http:\\www.w3dchools.com\">";
		//weatherxml = head+"\r\n"+weatherxml;
		CurrentWeather weatherInfo = new CurrentWeather();
		weatherInfo = CommonUtil.xmlToBean(weatherxml, weatherInfo);
		System.out.println(weatherInfo);
	}
}
