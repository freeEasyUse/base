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
import org.base.util.webUtil.DateEditor;
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
 * description:controller�������� �κ�controller��������
 * </p>
 * <p>
 * company:esay_use
 * </p>
 * 
 * @author gel
 * @date 2016��5��5��
 * 
 */
public abstract class BaseController {
	protected final Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * ���JSON�ַ�
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
	 * ͳһ�쳣����
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
	 * �Զ����
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// ���ڵ�ת��
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	/**
	 * ֱ�ӽ���Ҫ����ݷ��ظ�ǰ��
	 * 
	 * @param response
	 * @param map
	 */
	public void returnSuccess(HttpServletResponse response, Map<String, Object> map) {
		JSONObject json = new JSONObject();
		// �ж��û���û���Լ���map
		if (map != null && map.keySet().size() > 0) {
			// ѭ��map���ŵ�jsonObject��
			Iterator<String> keys = map.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				json.put(key, map.get(key));
			}
		}
		// ����success����
		json.put("success", true);
		outPrintJson(response, json.toString());
	}

	/**
	 * ����value��session��
	 * 
	 * @param key
	 * @param value
	 */
	public void setValueToSession(String key, Object value, HttpServletRequest request) {
		request.getSession().setAttribute(key, value);
	}

	/**
	 * ��session�л�ȡֵ
	 * 
	 * @param key
	 * @param request
	 * @return
	 */
	public Object getValueFromSession(String key, HttpServletRequest request) {
		return request.getSession().getAttribute(key);
	}
}
