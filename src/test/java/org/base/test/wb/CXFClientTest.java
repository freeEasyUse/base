package org.base.test.wb;


import org.base.timer.quartz.SendWeatherJob;
import org.base.util.common.CommonUtil;
import org.base.webservice.CurrentWeather;
import org.base.webservice.ReturnCitys;
import org.base.webservice.WebServiceClientFactory;
import org.base.webservice.cxf.client.cnweather.ArrayOfString;
import org.base.webservice.cxf.client.cnweather.WeatherWSSoap;
import org.base.webservice.cxf.client.weather.GlobalWeatherSoap;
import org.base.webservice.cxf.wb.WebServiceServerWithCXF;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
		String countryCities = soap.getCitiesByCountry("china");
		ReturnCitys returnCitys = new ReturnCitys();
		returnCitys = CommonUtil.xmlToBean(countryCities, returnCitys);
		System.out.println(returnCitys);
		
		String weatherxml = soap.getWeather("ShangHai", "China");
		CurrentWeather weatherInfo = new CurrentWeather();
		weatherInfo = CommonUtil.xmlToBean(weatherxml, weatherInfo);
		System.out.println(weatherInfo);
	}
	
	@Test
	public void cnweatherTest(){
		WeatherWSSoap weatherWSsoap = (WeatherWSSoap) WebServiceClientFactory.getWebServiceClient("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl", WeatherWSSoap.class);
		ArrayOfString result = weatherWSsoap.getWeather("上海", "55663647b5004b01b5536bafd9465d46");
		System.out.println(result);
	}
}
