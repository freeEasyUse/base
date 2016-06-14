package org.base.timer.quartz;

import java.util.Arrays;

import org.base.email.EmailType;
import org.base.email.EmailUtil;
import org.base.email.MailInfo;
import org.base.util.common.CommonUtil;
import org.base.webservice.CurrentWeather;
import org.base.webservice.WebServiceClientFactory;
import org.base.webservice.cxf.client.cnweather.ArrayOfString;
import org.base.webservice.cxf.client.cnweather.WeatherWSSoap;
import org.base.webservice.cxf.client.weather.GlobalWeatherSoap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>Title:SendWeatherJob</p>
 * <p>description:定时发送天气邮件</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月13日
 *
 */
@Component("weatherJob")
public class SendWeatherJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		//调用天气webservice接口
		GlobalWeatherSoap soap = (GlobalWeatherSoap)WebServiceClientFactory.getWebServiceClient("http://www.webservicex.net/globalweather.asmx", GlobalWeatherSoap.class);
		String weatherxml = soap.getWeather("ShangHai", "China");
		CurrentWeather weatherInfo = new CurrentWeather();
		try {
			weatherInfo = CommonUtil.xmlToBean(weatherxml, weatherInfo);
			MailInfo mailInfo = new MailInfo();
			mailInfo.setEmailType(EmailType.SIMPLE);
			mailInfo.setContent("gel提醒您天气状况"+"\n"+"天气:"+weatherInfo.getSkyConditions()+";"+"温度:"+weatherInfo.getTemperature());
			mailInfo.setSendEmails(Arrays.asList("geyueliang_89@163.com"));
			//发送邮件
			EmailUtil.sendMail(mailInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
