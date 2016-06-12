package org.base.webservice.cxf.client.weather;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.base.util.common.DateUtil;

/**
 * 
 * <p>Title:DateConvent</p>
 * <p>description:xml转换为java 时间类型转换</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月12日
 *
 */
public class DateConvent extends XmlAdapter<String, Date> {

	@Override
	public Date unmarshal(String str) throws Exception {
		//Jun 12, 2016 - 01:30 AM EDT / 2016.06.12 0530 UTC
		String[] strs = str.split("/");
		Date d = null;
		if(strs!=null&&strs.length>0){
			String s = strs[1].trim().split(" ")[0];
			d = DateUtil.strToDate(s, "yyyy.MM.dd");
		}
		return d;
	}

	@Override
	public String marshal(Date date) throws Exception {
		return null;
	}

}
