package org.base.webservice;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * <p>Title:ReturnCitys</p>
 * <p>description:获取返回的所有城市信息</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月12日
 *
 */
@XmlRootElement(name = "NewDataSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReturnCitys {
	
	private List<CountryWithCity> citys;

	public List<CountryWithCity> getCitys() {
		return citys;
	}

	public void setCitys(List<CountryWithCity> citys) {
		this.citys = citys;
	}
	
	
	
}
