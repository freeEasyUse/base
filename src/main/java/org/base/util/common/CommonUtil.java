package org.base.util.common;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Float;

/**
 * 
 * <p>Title:CommonUtil</p>
 * <p>description:公用工具类</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月11日
 *
 */
public class CommonUtil {

	/**
	 * 将String转换为对应的类型
	 * 适用基础类型
	 * @return
	 */
	public static Object changeStrByType(String str,String type){
		Object result = null;
		//int Integer类型
		switch (type) {
		//int
		case "int":
		case "java.lang.Integer":
			result = Integer.parseInt(str);
			break;
		//double
		case "double":
		case "java.lang.Double":
			result = Double.parseDouble(str);
			break;
		//float
		case "float":
		case "java.lang.Float":
			result = Float.parseFloat(str);
			break;

		default:
			result = str;
			break;
		}
		return result;
	}
	
	
	
}
