package org.gl.util.webUtil;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateEditor extends PropertyEditorSupport {



	@Override
	public void setAsText(String text) {
		//声明日期转化格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String value = text.trim();
		Date date = null;
		if (StringUtils.isNotBlank(value)) {
			try {
				if (value.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
					date = dateFormat.parse(value);
				} else if (value.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
					date = dateTimeFormat.parse(value);
				} else {
					throw new IllegalArgumentException("日期格式错误：" + value);
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("日期格式转化失败：" + value);
			}
		}
		// 设置日期
		setValue(date);
	}

}
