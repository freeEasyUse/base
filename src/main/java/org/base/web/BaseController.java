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
import org.base.exception.BaseException;
import org.base.util.webUtil.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <p>Title:BaseController</p>
 * <p>description:controller层基础类</p>
 * <p>company:easyuse</p>
 * @author gel
 * @date 2016年5月6日
 *
 */
public abstract class BaseController {
	protected final Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * 锟斤拷锟絁SON锟街凤拷
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
	 * 统一锟届常锟斤拷锟斤拷
	 * 
	 * @param request
	 * @param e
	 * @return
	 * @return
	 */
	@ExceptionHandler
	public void exception(HttpServletRequest request, HttpServletResponse response, Exception e) {
		BaseException ex = new BaseException();
		ex.setError(true);
		ex.setReason(e.getMessage());
		outPrintJson(response, ex);
	}

	/**
	 * 锟皆讹拷锟斤拷锟�
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 锟斤拷锟节碉拷转锟斤拷
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	/**
	 * 直锟接斤拷锟斤拷要锟斤拷锟斤拷莘锟斤拷馗锟角帮拷锟�
	 * 
	 * @param response
	 * @param map
	 */
	public void returnSuccess(HttpServletResponse response, Map<String, Object> map) {
		JSONObject json = new JSONObject();
		// 锟叫讹拷锟矫伙拷锟斤拷没锟斤拷锟皆硷拷锟斤拷map
		if (map != null && map.keySet().size() > 0) {
			// 循锟斤拷map锟斤拷锟脚碉拷jsonObject锟斤拷
			Iterator<String> keys = map.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				json.put(key, map.get(key));
			}
		}
		// 锟斤拷锟斤拷success锟斤拷锟斤拷
		json.put("success", true);
		outPrintJson(response, json.toString());
	}

	/**
	 * 锟斤拷锟斤拷value锟斤拷session锟斤拷
	 * 
	 * @param key
	 * @param value
	 */
	public void setValueToSession(String key, Object value, HttpServletRequest request) {
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 锟斤拷session锟叫伙拷取值
	 * 
	 * @param key
	 * @param request
	 * @return
	 */
	public Object getValueFromSession(String key, HttpServletRequest request) {
		return request.getSession().getAttribute(key);
	}
}
