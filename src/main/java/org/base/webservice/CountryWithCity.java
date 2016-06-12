package org.base.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * <p>Title:CountryWithCity</p>
 * <p>description:城市 国家</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月12日
 *
 */
@XmlRootElement(name = "Table")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryWithCity {

	@XmlElement(name = "Country")
	private String country;
	
	@XmlElement(name = "City")
	private String city;
	
}
