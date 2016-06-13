package org.base.webservice;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.base.webservice.cxf.client.weather.DateConvent;


/**
 * 
 * <p>Title:CurrentWeather</p>
 * <p>description:返回天气信息xml转换类</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月12日
 *
 */
@XmlRootElement(name="CurrentWeather")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrentWeather {

	@XmlElement(name="Location")
	private String location;	//位置
		
	@XmlElement(name="Time")
	@XmlJavaTypeAdapter(value=DateConvent.class) 
	private Date time;			//时间
	
	@XmlElement(name="Wind")
	private String wind;		//风力
	
	@XmlElement(name="Visibility")
	private String visibility;	//能见度
	
	@XmlElement(name="Temperature")
	private String temperature;	//温度
	
	@XmlElement(name="DewPoint")
	private String dewPoint;		//露点
	
	@XmlElement(name="RelativeHumidity")
	private String relativeHumidity;	//湿度
	
	@XmlElement(name="Pressure")
	private String pressure;		//大气压
	
	@XmlElement(name="Status")
	private String status;		//状态
	
	@XmlElement(name = "SkyConditions")
	private String skyConditions;	//天气情况

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(String dewPoint) {
		this.dewPoint = dewPoint;
	}

	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSkyConditions() {
		return skyConditions;
	}

	public void setSkyConditions(String skyConditions) {
		this.skyConditions = skyConditions;
	}
	
	
}
