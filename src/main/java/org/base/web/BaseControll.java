package org.base.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gl.util.webUtil.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <p>
 * Title:BaseControll
 * </p>
 * <p>
 * description:controller层基础抽象类
 * </p>
 * <p>
 * company:esay_use
 * </p>
 * 
 * @author gel
 * @date 2016年5月5日
 * 
 */
public abstract class BaseControll {
	protected final Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * 输出JSON字符串
	 * 
	 * @param response
	 * @param obj
	 */
	public void outPrintJson(HttpServletResponse response, Object obj) {
		response.setCharacterEncoding("UTF-8");
		response.addHeader("CacheControl", "no-cache");
		response.addHeader("Content-Type", "application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String jsonStr = JSON.toJSONString(obj);
			out.print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * 统一异常处理
	 * 
	 * @param request
	 * @param e
	 * @return
	 * @return
	 */
	@ExceptionHandler
	public void exception(HttpServletRequest request, HttpServletResponse response, Exception e) {
		outPrintJson(response, e);
	}

	/**
	 * 自定义绑定
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 日期的转换
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	/**
	 * 直接将需要的数据返回给前端
	 * 
	 * @param response
	 * @param map
	 */
	public void returnSuccess(HttpServletResponse response, Map<String, Object> map) {
		JSONObject json = new JSONObject();
		// 判断用户有没有自己的map
		if (map != null && map.keySet().size() > 0) {
			// 循环map，放到jsonObject中
			Iterator<String> keys = map.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				json.put(key, map.get(key));
			}
		}
		// 增加success属性
		json.put("success", true);
		outPrintJson(response, json.toString());
	}

	/**
	 * 设置value到session中
	 * 
	 * @param key
	 * @param value
	 */
	public void setValueToSession(String key, Object value, HttpServletRequest request) {
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 从session中获取值
	 * 
	 * @param key
	 * @param request
	 * @return
	 */
	public Object getValueFromSession(String key, HttpServletRequest request) {
		return request.getSession().getAttribute(key);
	}
}
